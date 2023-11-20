
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaProductos extends JFrame {
    private final JTextArea infoProductos;

    public ListaProductos() {
        setTitle("Lista de Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        infoProductos = new JTextArea(10, 30);
        infoProductos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoProductos);

        JButton mostrarButton = new JButton("Mostrar Productos");
        mostrarButton.addActionListener(e -> mostrarInformacionProductos());

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(mostrarButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void mostrarInformacionProductos() {
        ArrayList<Producto> productos = DataManager.productos;

        infoProductos.setText(""); // Limpiar el texto antes de mostrar los productos

        if (productos.isEmpty()) {
            infoProductos.setText("No hay productos registrados.");
        } else {
            for (Producto producto : productos) {
                infoProductos.append("Código: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() +
                        ", Precio: " + producto.getPrecio() + "\n");
            }
        }
    }

}