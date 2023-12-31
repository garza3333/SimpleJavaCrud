
package com.mycompany.proyectojavacrud;


import javax.swing.*;

public class MenuReservacion extends JFrame {
    
    public MenuReservacion() {
        setTitle("Menú de Reservación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú de Reservación");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Hacer una reservación de mesa");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Actualizar lista de reservas");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Eliminar una reservación");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        JButton opcion4Button = new JButton("4 - Mostrar lista de reservaciones");
        opcion4Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion4Button);

        JButton opcion5Button = new JButton("5 - Salir");
        opcion5Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion5Button);

        opcion1Button.addActionListener(e -> {
            new RegistroReserva();
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para actualizar lista de reservas
            new ActualizarReserva();
        });

        opcion3Button.addActionListener(e -> {
            new EliminarReserva();
        });

        opcion4Button.addActionListener(e -> {
            new ListaReservas();
        });

        opcion5Button.addActionListener(e -> {
            // Cerrar el menú de reservación y salir
            salirDelMenuReservacion();
        });

        add(panel);
        setVisible(true);
    }

    private void salirDelMenuReservacion() {
        // Cierra la ventana del menú de reservación
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
            new Lobby();
        });
    }

}

