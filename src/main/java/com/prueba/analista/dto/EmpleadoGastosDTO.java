package com.prueba.analista.dto;

import java.util.Map;

public class EmpleadoGastosDTO {
    String nombre;
    Map<String, GastoResumenMensualDTO> gastosPorMes;

    public EmpleadoGastosDTO(String nombre, Map<String, GastoResumenMensualDTO> gastosPorMes) {
        this.nombre = nombre;
        this.gastosPorMes = gastosPorMes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, GastoResumenMensualDTO> getGastosPorMes() {
        return gastosPorMes;
    }

    public void setGastosPorMes(Map<String, GastoResumenMensualDTO> gastosPorMes) {
        this.gastosPorMes = gastosPorMes;
    }

    @Override
    public String toString() {
        return "EmpleadoGastosDTO{" +
                "nombre='" + nombre + '\'' +
                ", gastosPorMes=" + gastosPorMes +
                '}';
    }
}
