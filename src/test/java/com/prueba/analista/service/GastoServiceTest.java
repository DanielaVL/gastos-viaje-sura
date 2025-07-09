package com.prueba.analista.service;

import com.prueba.analista.dto.GastoTotalDTO;
import com.prueba.analista.model.Empleado;
import com.prueba.analista.model.Gasto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GastoServiceTest {

    private final GastoService gastoService = new GastoService();

    @Test
    // Un empleado con varios gastos distribuidos en meses diferentes
    void testGenerarResumenGastos() {
        Gasto gasto1 = new Gasto(LocalDate.of(2024, 5, 10), new BigDecimal("400000"));
        Gasto gasto2 = new Gasto(LocalDate.of(2024, 5, 15), new BigDecimal("300000"));
        Gasto gasto3 = new Gasto(LocalDate.of(2024, 6, 5), new BigDecimal("200000"));

        Empleado empleado = new Empleado(1, "Carlos Pérez", List.of(gasto1, gasto2, gasto3));

        // Ejecutar el método
        GastoTotalDTO resultado = gastoService.generarResumenGastos(List.of(empleado));

        // Validaciones
        assertNotNull(resultado);
        assertEquals(1, resultado.getEmpleados().size());

        // Total sin IVA esperado: 400000 + 300000 + 200000 = 900000
        assertEquals(new BigDecimal("900000"), resultado.getTotalGeneral());

        // Validar el total del empleado
        assertEquals(new BigDecimal("900000"), resultado.getEmpleados().get(0).getTotalEmpleado());

        // Validar resumen mensual (2 meses)
        assertEquals(2, resultado.getEmpleados().get(0).getResumenMensual().size());

        // Validar IVA y "quien asume"
        resultado.getEmpleados().get(0).getResumenMensual().forEach(resumen -> {
            BigDecimal esperadoConIVA = resumen.getTotalMes().multiply(BigDecimal.valueOf(1.19));
            assertEquals(0, resumen.getTotalConIVA().compareTo(esperadoConIVA));

            String quienAsume = esperadoConIVA.compareTo(new BigDecimal("1000000")) > 0 ? "EMPLEADO" : "SURA";
            assertEquals(quienAsume, resumen.getQuienAsume());
        });
    }

    @Test
    // Una empleada sin gastos
    void testEmpleadoSinGastos() {
        Empleado empleado = new Empleado(2, "Ana Gómez", List.of());

        GastoTotalDTO resultado = gastoService.generarResumenGastos(List.of(empleado));

        assertNotNull(resultado);
        assertEquals(1, resultado.getEmpleados().size());
        assertEquals(BigDecimal.ZERO, resultado.getTotalGeneral());
        assertEquals(BigDecimal.ZERO, resultado.getEmpleados().get(0).getTotalEmpleado());
        assertTrue(resultado.getEmpleados().get(0).getResumenMensual().isEmpty());
    }

    @Test
    // Lista de empleados vacía
    void testSinEmpleados() {
        GastoTotalDTO resultado = gastoService.generarResumenGastos(List.of());

        assertNotNull(resultado);
        assertEquals(BigDecimal.ZERO, resultado.getTotalGeneral());
        assertTrue(resultado.getEmpleados().isEmpty());
    }

}
