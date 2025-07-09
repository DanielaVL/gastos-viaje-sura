package com.prueba.analista.model;

import java.util.List;

public class Empleado {
    private int id; // Identificador único (13 registros por ahora)
    private String nombre; // Nombre del empleado
    private List<Gasto> gastos; // Lista de gastos del empleado

    //Constructor
    public Empleado(int id, String nombre, List<Gasto> gastos) {
        this.id = id;
        this.nombre = nombre;
        this.gastos = gastos;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }
    
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    // Método toString para representación en texto
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", gastos=" + gastos +
                '}';
    }
}
