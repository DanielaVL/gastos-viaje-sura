package com.prueba.analista.service;

import com.prueba.analista.model.Empleado;
import com.prueba.analista.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GastoService {

    private final BigDecimal IVA = new BigDecimal("0.19");
    private final BigDecimal LIMITE = new BigDecimal("1000000");

    public List<EmpleadoGastosDTO> obtenerResumenGastos(List<Empleado> empleados) {
        return empleados.stream()
            .sorted(Comparator.comparing(Empleado::getNombre))
            .map(empleado -> {
                Map<String, GastoResumenMensualDTO> resumen = new HashMap<>();
                empleado.getGastos().forEach(gasto -> {
                    String mes = gasto.getFecha().format(DateTimeFormatter.ofPattern("MM/yyyy"));
                    resumen.compute(mes, (k, v) -> {
                        if (v == null) v = new GastoResumenMensualDTO(BigDecimal.ZERO, BigDecimal.ZERO, "");
                        BigDecimal nuevoTotal = v.getTotal().add(gasto.getMonto());
                        BigDecimal totalConIVA = nuevoTotal.add(nuevoTotal.multiply(IVA));
                        String quienAsume = totalConIVA.compareTo(LIMITE) > 0 ? "EMPLEADO" : "SURA";
                        return new GastoResumenMensualDTO(nuevoTotal, totalConIVA, quienAsume);
                    });
                });
                return new EmpleadoGastosDTO(empleado.getNombre(), resumen);
            })
            .collect(Collectors.toList());
    }

}

