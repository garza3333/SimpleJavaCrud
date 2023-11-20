
package com.mycompany.proyectojavacrud;

import java.util.Date;


public class Reserva {
    private int id;
    private int numeroPersonas;
    private String nombreReserva;
    private Date fecha;

    public Reserva(int id, int numeroPersonas, String nombreReserva, Date fecha) {
        this.id = id;
        this.numeroPersonas = numeroPersonas;
        this.nombreReserva = nombreReserva;
        this.fecha = fecha;
    }

    // Getters y Setters (métodos para acceder y establecer los atributos)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
