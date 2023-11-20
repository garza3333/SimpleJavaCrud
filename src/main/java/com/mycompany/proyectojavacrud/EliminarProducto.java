
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarProducto extends JFrame {
    private final JPanel panelProductos;

    public EliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));

        JButton mostrarButton = new JButton("Mostrar Productos");
        mostrarButton.addActionListener(e -> mostrarInformacionProductos());

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mostrarButton);
        buttonPanel.add(salirButton);

        panel.add(panelProductos, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void mostrarInformacionProductos() {
        ArrayList<Producto> productos = DataManager.productos;

        panelProductos.removeAll(); // Limpiar el panel antes de mostrar los productos

        if (productos.isEmpty()) {
            JLabel noProductosLabel = new JLabel("No hay productos registrados.");
            panelProductos.add(noProductosLabel);
        } else {
            for (Producto producto : productos) {
                JPanel productoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JLabel infoLabel = new JLabel("Código: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() +
                        ", Precio: " + producto.getPrecio());

                JButton eliminarButton = new JButton("Eliminar");
                eliminarButton.addActionListener(e -> eliminarProducto(producto));

                productoPanel.add(infoLabel);
                productoPanel.add(eliminarButton);
                panelProductos.add(productoPanel);
            }
        }

        panelProductos.revalidate(); // Actualizar el panel
        panelProductos.repaint();
    }

    private void eliminarProducto(Producto producto) {
        DataManager.eliminarProducto(producto);
        mostrarInformacionProductos(); // Actualizar la información después de eliminar
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }


}