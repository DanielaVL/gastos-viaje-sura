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
        BigDecimal totalGeneral = BigDecimal.ZERO;
        List<EmpleadoResumenDTO> empleadosDTO = new ArrayList<>();

        // Ordenar empleados alfabéticamente
        List<Empleado> empleadosOrdenados = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getNombre))
                .toList();

        for (Empleado empleado : empleadosOrdenados) {
            Map<String, List<BigDecimal>> gastosPorMes = new TreeMap<>();
            BigDecimal totalEmpleado = BigDecimal.ZERO;

            for (Gasto gasto : empleado.getGastos()) {
                YearMonth mes = YearMonth.from(gasto.getFecha());
                String claveMes = mes.format(DateTimeFormatter.ofPattern("MM/yyyy"));

                gastosPorMes.computeIfAbsent(claveMes, k -> new ArrayList<>());
                gastosPorMes.get(claveMes).add(gasto.getMonto());

                totalEmpleado = totalEmpleado.add(gasto.getMonto());
            }

            BigDecimal totalConIVA = totalEmpleado.multiply(BigDecimal.valueOf(1.19));
            String quienAsume = totalConIVA.compareTo(BigDecimal.valueOf(1_000_000)) > 0
                    ? "EMPLEADO"
                    : "SURA";

            totalGeneral = totalGeneral.add(totalEmpleado);

            EmpleadoResumenDTO dto = new EmpleadoResumenDTO();
            dto.setNombre(empleado.getNombre());
            dto.setGastosPorMes(gastosPorMes);
            dto.setTotalEmpleado(totalEmpleado);
            dto.setTotalConIVA(totalConIVA);
            dto.setQuienAsume(quienAsume);

            empleadosDTO.add(dto);
        }

        GastoTotalDTO response = new GastoTotalDTO();
        response.setTotalGeneral(totalGeneral);
        response.setEmpleados(empleadosDTO);
        return response;
    }
}

