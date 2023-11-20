
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActualizarProducto extends JFrame {
    private final JPanel panelProductos;

    public ActualizarProducto() {
        setTitle("Actualizar Producto");
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

                JTextField nombreField = new JTextField(producto.getNombre(), 15);
                JTextField precioField = new JTextField(Double.toString(producto.getPrecio()), 15);

                JButton actualizarButton = new JButton("Actualizar");
                actualizarButton.addActionListener(e -> actualizarProducto(producto, nombreField.getText(), Double.parseDouble(precioField.getText())));

                productoPanel.add(new JLabel("Código: " + producto.getCodigo()));
                productoPanel.add(new JLabel("Nombre:"));
                productoPanel.add(nombreField);
                productoPanel.add(new JLabel("Precio:"));
                productoPanel.add(precioField);
                productoPanel.add(actualizarButton);
                panelProductos.add(productoPanel);
            }
        }

        panelProductos.revalidate(); // Actualizar el panel
        panelProductos.repaint();
    }

    private void actualizarProducto(Producto producto, String nuevoNombre, double nuevoPrecio) {
        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);

        
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }


}
