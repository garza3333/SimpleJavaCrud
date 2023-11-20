
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarReserva extends JFrame {
    private final JPanel panelReservas;

    public EliminarReserva() {
        setTitle("Eliminar Reserva");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        panelReservas = new JPanel();
        panelReservas.setLayout(new BoxLayout(panelReservas, BoxLayout.Y_AXIS));

        JButton mostrarButton = new JButton("Mostrar Reservas");
        mostrarButton.addActionListener(e -> mostrarInformacionReservas());

        JButton salirButton = new JButton("Salir"); // Botón para salir
        salirButton.addActionListener(e -> cerrarVentanaActual()); // Acción para cerrar la ventana

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mostrarButton);
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(panelReservas, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void mostrarInformacionReservas() {
        ArrayList<Reserva> reservas = DataManager.reservas;

        panelReservas.removeAll(); // Limpiar el panel antes de mostrar las reservas

        if (reservas.isEmpty()) {
            JLabel noReservasLabel = new JLabel("No hay reservas registradas.");
            panelReservas.add(noReservasLabel);
        } else {
            for (Reserva reserva : reservas) {
                JPanel reservaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JLabel infoLabel = new JLabel("ID: " + reserva.getId() + ", Personas: " + reserva.getNumeroPersonas() +
                        ", Nombre: " + reserva.getNombreReserva());

                JButton eliminarButton = new JButton("Eliminar");
                eliminarButton.addActionListener(e -> eliminarReserva(reserva));

                reservaPanel.add(infoLabel);
                reservaPanel.add(eliminarButton);
                panelReservas.add(reservaPanel);
            }
        }

        panelReservas.revalidate(); // Actualizar el panel
        panelReservas.repaint();
    }

    private void eliminarReserva(Reserva reserva) {
        DataManager.eliminarReserva(reserva);
        mostrarInformacionReservas(); // Actualizar la información después de eliminar
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}

