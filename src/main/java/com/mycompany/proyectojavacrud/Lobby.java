package com.mycompany.proyectojavacrud;


import javax.swing.*;

public class Lobby extends JFrame {
    
    public Lobby() {
        
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú Principal");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Ingresar inventario");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Añadir pedidos");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Hacer reserva");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        JButton opcion4Button = new JButton("4 - Plantilla de empleados");
        opcion4Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion4Button);

        JButton opcion5Button = new JButton("5 - Generar facturación");
        opcion5Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion5Button);
        
        JButton opcion6Button = new JButton("6 - Salir");
        opcion6Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion6Button);

        opcion1Button.addActionListener(e -> {
            // Lógica para la opción 1 - Ingresar inventario
            this.cerrarVentanaActual();
            new MenuInventario();
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para la opción 2 - Añadir pedidos
            this.cerrarVentanaActual();
            new MenuPedidos();
        });

        opcion3Button.addActionListener(e -> {
            // Lógica para la opción 3 - Hacer reserva
            this.cerrarVentanaActual();
            new MenuReservacion();
        });

        opcion4Button.addActionListener(e -> {
            // Lógica para la opción 4 - Plantilla de empleados
            this.cerrarVentanaActual();
            new MenuEmpleados();
        });

        opcion5Button.addActionListener(e -> {
            // Lógica para la opción 5 - Generar facturación
            this.cerrarVentanaActual();
            new MenuFacturacion();
        });
        
        opcion6Button.addActionListener(e -> {
            // Lógica para la opción 6 - Salir
            this.cerrarVentanaActual();
        });

        add(panel);
        setVisible(true);
    }
    
    private void cerrarVentanaActual() {
        // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}
