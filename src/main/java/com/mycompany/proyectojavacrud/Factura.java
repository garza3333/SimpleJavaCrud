
package com.mycompany.proyectojavacrud;

import java.util.Date;


public class Factura {
    private int numero;
    private double monto;
    private String nombreCliente;
    private Date fecha;

    public Factura(int numero, double monto, String nombreCliente, Date fecha) {
        this.numero = numero;
        this.monto = monto;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
    }

    // Getters y Setters (métodos para acceder y establecer los atributos)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}