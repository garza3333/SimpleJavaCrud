
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RegistroPedido extends JFrame {
    private final JTextField numeroPedidoField;
    private final JButton agregarProductoButton;
    private final JButton registrarPedidoButton;
    private final JTextArea productosArea;
    private final JComboBox<String> productosComboBox;

    private Pedido pedido;

    public RegistroPedido() {
        setTitle("Registro de Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel datosPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel numeroPedidoLabel = new JLabel("Número de Pedido:");
        numeroPedidoField = new JTextField();
        
        datosPanel.add(numeroPedidoLabel);
        datosPanel.add(numeroPedidoField);

        JLabel productosLabel = new JLabel("Productos:");
        productosArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(productosArea);
        productosArea.setEditable(false);
        datosPanel.add(productosLabel);
        datosPanel.add(scrollPane);

        productosComboBox = new JComboBox<>();
        actualizarProductosComboBox();

        agregarProductoButton = new JButton("Agregar Producto");
        agregarProductoButton.addActionListener(e -> agregarProducto());
        datosPanel.add(productosComboBox);
        datosPanel.add(agregarProductoButton);

        registrarPedidoButton = new JButton("Registrar Pedido");
        registrarPedidoButton.addActionListener(e -> registrarPedido());
        datosPanel.add(new JLabel());
        datosPanel.add(registrarPedidoButton);

        panel.add(datosPanel, BorderLayout.CENTER);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        // Inicializar un nuevo pedido al abrir la ventana de registro
        pedido = new Pedido();
        numeroPedidoField.setText(String.valueOf(pedido.getNumeroPedido()));
    }

    private void agregarProducto() {
        String productoSeleccionado = (String) productosComboBox.getSelectedItem();
        pedido.getProductos().add(DataManager.getProducto(productoSeleccionado)); // Agregar producto al pedido
        actualizarProductosArea();
    }

    private void registrarPedido() {
        DataManager.pedidos.add(pedido); // Agregar pedido a DataManager
        
        limpiarCampos();
    }

    private void actualizarProductosComboBox() {
        // Simulación de productos disponibles (se pueden obtener desde DataManager)
        ArrayList<Producto> productosDisponibles = DataManager.productos;

        if(productosDisponibles == null){
            productosDisponibles = new ArrayList<Producto>();
        }
        productosComboBox.removeAllItems();
        for (Producto producto : productosDisponibles) {
            productosComboBox.addItem(producto.getNombre());
        }
    }

    private void actualizarProductosArea() {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : pedido.getProductos()) {
            sb.append(producto.getNombre()).append("\n");
        }
        productosArea.setText(sb.toString());
    }

    private void limpiarCampos() {
        pedido = new Pedido();
        numeroPedidoField.setText(String.valueOf(pedido.getNumeroPedido()));
        productosArea.setText("");
        actualizarProductosComboBox();
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}

