
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarPedido extends JFrame {
    private final JTextArea pedidosArea;

    public EliminarPedido() {
        setTitle("Eliminar Pedido");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        pedidosArea = new JTextArea(15, 30);
        JScrollPane scrollPane = new JScrollPane(pedidosArea);
        pedidosArea.setEditable(false);

        JButton mostrarPedidosButton = new JButton("Mostrar Pedidos");
        mostrarPedidosButton.addActionListener(e -> mostrarPedidos());

        JButton eliminarPedidoButton = new JButton("Eliminar Pedido");
        eliminarPedidoButton.addActionListener(e -> eliminarPedido());
        
        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mostrarPedidosButton);
        buttonPanel.add(eliminarPedidoButton);
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
                pedidosArea.append("Número de Pedido: " + pedido.getNumeroPedido() + "\n\n");
            }
        }
    }

    private void eliminarPedido() {
        String numeroPedidoEliminar = JOptionPane.showInputDialog(this, "Ingrese el número del pedido a eliminar:");

        if (numeroPedidoEliminar != null && !numeroPedidoEliminar.isEmpty()) {
            int numeroPedido = Integer.parseInt(numeroPedidoEliminar);

            ArrayList<Pedido> pedidos = DataManager.pedidos;
            Pedido pedidoAEliminar = null;

            for (Pedido pedido : pedidos) {
                if (pedido.getNumeroPedido() == numeroPedido) {
                    pedidoAEliminar = pedido;
                    break;
                }
            }

            if (pedidoAEliminar != null) {
                pedidos.remove(pedidoAEliminar);
                
            } else {
                JOptionPane.showMessageDialog(this, "El número de pedido no existe.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un número de pedido válido.");
        }

        mostrarPedidos();
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}
