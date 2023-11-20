
package com.mycompany.proyectojavacrud;


import javax.swing.*;

public class MenuPedidos extends JFrame {

    public MenuPedidos() {
        setTitle("Menú de Pedidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú de Pedidos");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Agregar pedido");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Actualizar lista de pedido");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Eliminar un pedido");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        JButton opcion4Button = new JButton("4 - Mostrar productos");
        opcion4Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion4Button);

        JButton opcion5Button = new JButton("5 - Salir");
        opcion5Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion5Button);

        opcion1Button.addActionListener(e -> {
            // Lógica para agregar un pedido
            JOptionPane.showMessageDialog(this, "Seleccionaste: Agregar pedido");
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para actualizar lista de pedidos
            JOptionPane.showMessageDialog(this, "Seleccionaste: Actualizar lista de pedido");
        });

        opcion3Button.addActionListener(e -> {
            // Lógica para eliminar un pedido
            JOptionPane.showMessageDialog(this, "Seleccionaste: Eliminar un pedido");
        });

        opcion4Button.addActionListener(e -> {
            // Lógica para mostrar productos
            JOptionPane.showMessageDialog(this, "Seleccionaste: Mostrar productos");
        });

        opcion5Button.addActionListener(e -> {
            // Cerrar el menú de pedidos y salir
            salirDelMenuPedidos();
        });

        add(panel);
        setVisible(true);
    }

    private void salirDelMenuPedidos() {
        // Cierra la ventana del menú de pedidos
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
            new Lobby();
        });
    }


}
