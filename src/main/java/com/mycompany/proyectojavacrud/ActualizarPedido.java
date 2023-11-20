
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActualizarPedido extends JFrame {
    private final JTextArea pedidosArea;
    private final JComboBox<Pedido> pedidosComboBox;
    private final JComboBox<Producto> productosComboBox;
    private final JButton agregarProductoButton;
    private final JButton actualizarPedidoButton;

    public ActualizarPedido() {
        setTitle("Actualizar Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel datosPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        pedidosArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(pedidosArea);
        pedidosArea.setEditable(false);
        datosPanel.add(new JLabel("Lista de Pedidos:"));
        datosPanel.add(scrollPane);

        pedidosComboBox = new JComboBox<>();
        actualizarPedidosComboBox();
        datosPanel.add(new JLabel("Seleccionar Pedido:"));
        datosPanel.add(pedidosComboBox);

        productosComboBox = new JComboBox<>();
        actualizarProductosComboBox();
        datosPanel.add(new JLabel("Agregar Producto:"));
        datosPanel.add(productosComboBox);

        agregarProductoButton = new JButton("Agregar Producto");
        agregarProductoButton.addActionListener(e -> agregarProductoAlPedido());
        datosPanel.add(new JLabel());
        datosPanel.add(agregarProductoButton);

        actualizarPedidoButton = new JButton("Actualizar Pedido");
        actualizarPedidoButton.addActionListener(e -> actualizarPedido());
        datosPanel.add(new JLabel());
        datosPanel.add(actualizarPedidoButton);

        panel.add(datosPanel, BorderLayout.CENTER);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void actualizarPedidosComboBox() {
        ArrayList<Pedido> pedidos = DataManager.pedidos;

        pedidosComboBox.removeAllItems();
        for (Pedido pedido : pedidos) {
            pedidosComboBox.addItem(pedido);
        }
    }

    private void actualizarProductosComboBox() {
        ArrayList<Producto> productosDisponibles = DataManager.productos;

        productosComboBox.removeAllItems();
        for (Producto producto : productosDisponibles) {
            productosComboBox.addItem(producto);
        }
    }

    private void agregarProductoAlPedido() {
        Pedido pedidoSeleccionado = (Pedido) pedidosComboBox.getSelectedItem();
        Producto productoSeleccionado = (Producto) productosComboBox.getSelectedItem();

        pedidoSeleccionado.getProductos().add(productoSeleccionado);
        actualizarAreaPedidos();
    }

    private void actualizarPedido() {
        // Aquí puedes implementar la lógica para actualizar los datos del pedido
        JOptionPane.showMessageDialog(this, "Pedido actualizado correctamente.");
        actualizarAreaPedidos();
    }

    private void actualizarAreaPedidos() {
        Pedido pedidoSeleccionado = (Pedido) pedidosComboBox.getSelectedItem();
        ArrayList<Producto> productosPedido = pedidoSeleccionado.getProductos();

        StringBuilder sb = new StringBuilder();
        sb.append("Productos del Pedido:\n");
        for (Producto producto : productosPedido) {
            sb.append("- ").append(producto.getNombre()).append("\n");
        }

        pedidosArea.setText(sb.toString());
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}
