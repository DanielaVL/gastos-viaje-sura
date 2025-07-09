package com.prueba.analista.service;

import com.prueba.analista.model.*;
import com.prueba.analista.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class GastoService {

    public GastoTotalDTO generarResumenGastos(List<Empleado> empleados) {
        BigDecimal totalGeneral = BigDecimal.ZERO; // Acumulador del total general de todos los empleados
        List<EmpleadoResumenDTO> empleadosDTO = new ArrayList<>(); // Lista para la respuesta final por empleado
    
        // Ordenar empleados alfabéticamente
        List<Empleado> empleadosOrdenados = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getNombre))
                .toList();
    
        // REcorrer cada empleado ordenado alfabéticamente
        for (Empleado empleado : empleadosOrdenados) {
            Map<String, List<BigDecimal>> gastosPorMes = new TreeMap<>(); // Agrupación de gastos por mes
            BigDecimal totalEmpleado = BigDecimal.ZERO; // Acumulador de los gastos totales del empleado
    
            // Recorrer todos los gastos del empleado para agruparlos por mes y calcular su total
            for (Gasto gasto : empleado.getGastos()) {
                YearMonth mes = YearMonth.from(gasto.getFecha());
                String claveMes = mes.format(DateTimeFormatter.ofPattern("MM/yyyy"));
    
                // Si la clave no existe aún, se crea la lista; luego se agrega el monto del gasto
                gastosPorMes.computeIfAbsent(claveMes, k -> new ArrayList<>()).add(gasto.getMonto());

                // Acumular el gasto en el total del empleado
                totalEmpleado = totalEmpleado.add(gasto.getMonto());
            }
    
            // Lista con resumen por mes
            List<ResumenMensualDTO> resumenMensualList = new ArrayList<>();
    
            // Recorrer cada mes detectado para calcular totales, IVA y quién asume
            for (Map.Entry<String, List<BigDecimal>> entry : gastosPorMes.entrySet()) {
                String mes = entry.getKey();
                List<BigDecimal> gastos = entry.getValue();
    
                BigDecimal totalMes = gastos.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                BigDecimal totalConIVA = totalMes.multiply(BigDecimal.valueOf(1.19));
                String quienAsume = totalConIVA.compareTo(BigDecimal.valueOf(1_000_000)) > 0 ? "EMPLEADO" : "SURA";
    
                // Crear y poblar el DTO para este mes
                ResumenMensualDTO resumenMes = new ResumenMensualDTO();
                resumenMes.setMes(mes);
                resumenMes.setGastos(gastos);
                resumenMes.setTotalMes(totalMes);
                resumenMes.setTotalConIVA(totalConIVA);
                resumenMes.setQuienAsume(quienAsume);
    
                // Agregar el resumen del mes a la lista del empleado
                resumenMensualList.add(resumenMes);
            }
    
            // Crear DTO del empleado con toda la información reunida
            EmpleadoResumenDTO dto = new EmpleadoResumenDTO();
            dto.setNombre(empleado.getNombre());
            dto.setTotalEmpleado(totalEmpleado);
            dto.setResumenMensual(resumenMensualList);
    
            empleadosDTO.add(dto); // Agregar el resumen del empleado a la lista final
            totalGeneral = totalGeneral.add(totalEmpleado); // Sumar total de este empleado al total general
        }
    
        GastoTotalDTO response = new GastoTotalDTO();
        response.setTotalGeneral(totalGeneral); // Total sin IVA de todos los empleados
        response.setEmpleados(empleadosDTO); // Lista de empleados con sus resúmenes
    
        return response;
    }
}

