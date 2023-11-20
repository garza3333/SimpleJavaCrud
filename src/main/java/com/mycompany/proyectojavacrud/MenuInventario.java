
package com.mycompany.proyectojavacrud;



import javax.swing.*;

public class MenuInventario extends JFrame {
    public MenuInventario() {
        setTitle("Menú de Inventario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú de Inventario");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Registrar nuevos productos");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Actualizar información de productos existentes");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Eliminar productos del inventario");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        JButton opcion4Button = new JButton("4 - Mostrar productos registrados");
        opcion4Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion4Button);

        JButton opcion5Button = new JButton("5 - Salir al Menú Principal");
        opcion5Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion5Button);

        opcion1Button.addActionListener(e -> {
            // Lógica para registrar nuevos productos
            JOptionPane.showMessageDialog(this, "Seleccionaste: Registrar nuevos productos");
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para actualizar información de productos existentes
            JOptionPane.showMessageDialog(this, "Seleccionaste: Actualizar información de productos existentes");
        });

        opcion3Button.addActionListener(e -> {
            // Lógica para eliminar productos del inventario
            JOptionPane.showMessageDialog(this, "Seleccionaste: Eliminar productos del inventario");
        });

        opcion4Button.addActionListener(e -> {
            // Lógica para mostrar productos registrados
            JOptionPane.showMessageDialog(this, "Seleccionaste: Mostrar productos registrados");
        });

        opcion5Button.addActionListener(e -> {
            // Regresar al Menú Principal
            volverAlMenuPrincipal();
        });

        add(panel);
        setVisible(true);
    }

    private void volverAlMenuPrincipal() {
        // Cierra la ventana actual y vuelve al Menú Principal
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
            new Lobby(); // Abre una nueva ventana del Menú Principal
        });
    }

}

