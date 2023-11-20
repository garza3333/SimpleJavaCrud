
package com.mycompany.proyectojavacrud;

import java.util.ArrayList;


public class Pedido {
    private int numeroPedido;
    private ArrayList<Producto> productos;

    public Pedido() {
        this.numeroPedido = DataManager.pedidos.size()+1;
        this.productos = new ArrayList();
    }

    // Getters y Setters (métodos para acceder y establecer los atributos)
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
