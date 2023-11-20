
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaPedidos extends JFrame {
    private final JTextArea pedidosArea;

    public ListaPedidos() {
        setTitle("Listado de Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        pedidosArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(pedidosArea);
        pedidosArea.setEditable(false);

        JButton mostrarPedidosButton = new JButton("Mostrar Pedidos");
        mostrarPedidosButton.addActionListener(e -> mostrarPedidos());

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mostrarPedidosButton);
        buttonPanel.add(salirButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void mostrarPedidos() {
        pedidosArea.setText(""); // Limpiar el área de texto antes de mostrar los pedidos

        ArrayList<Pedido> pedidos = DataManager.pedidos;

        if (pedidos.isEmpty()) {
            pedidosArea.setText("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                pedidosArea.append("Número de Pedido: " + pedido.getNumeroPedido() + "\n");
                pedidosArea.append("Productos:\n");

                for (Producto producto : pedido.getProductos()) {
                    pedidosArea.append("- " + producto.getNombre() + "\n");
                }

                pedidosArea.append("\n");
            }
        }
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}


