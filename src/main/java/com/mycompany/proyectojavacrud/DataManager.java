
package com.mycompany.proyectojavacrud;

import java.util.ArrayList;


public class DataManager {
    public static ArrayList<Empleado> empleados;
    public static ArrayList<Factura> facturaas;
    public static ArrayList<Producto> productos;
    public static ArrayList<Pedido> pedidos;
    public static ArrayList<Reserva> reservas;
    
    
    public DataManager(){
        
        empleados = new ArrayList();
        facturaas = new ArrayList();
        productos = new ArrayList();
        pedidos = new ArrayList();
        reservas = new ArrayList();
        
    }
    
    
    public static void eliminarEmpleado(Empleado e){
        
        empleados.remove(e);
        
    }
    
    public static void eliminarFactura(Factura f){
        
        facturaas.remove(f);
        
    }
    
    public static void eliminarProducto(Producto p){
        
        productos.remove(p);
        
    }
    
    public static void eliminarPedido(Pedido p){
        
        pedidos.remove(p);
        
    }
    
    public static void eliminarReserva(Reserva r){
        
        reservas.remove(r);
        
    }
    
    public static Producto getProducto(String name) {
        
        for (Producto p : productos) {
            if (p.getNombre().equals(name)) {
                return p;
            }
        }
    return null;
}

    
}
