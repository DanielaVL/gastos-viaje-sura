package com.prueba.analista.controller;

import com.prueba.analista.dto.GastoTotalDTO;
import com.prueba.analista.model.Empleado;
import com.prueba.analista.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping("/resumen")
    public GastoTotalDTO resumenGastos(@RequestBody List<Empleado> empleados) {
        return gastoService.generarResumenGastos(empleados);
    }

}
