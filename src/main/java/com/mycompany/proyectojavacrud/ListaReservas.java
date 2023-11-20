
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListaReservas extends JFrame {
    private final JTextArea reservasArea;

    public ListaReservas() {
        setTitle("Mostrar Reservas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        reservasArea = new JTextArea(10, 30);
        reservasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservasArea);

        JButton mostrarButton = new JButton("Mostrar Reservas");
        mostrarButton.addActionListener(e -> mostrarReservas());

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(mostrarButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void mostrarReservas() {
        ArrayList<Reserva> reservas = DataManager.reservas;

        if (reservas.isEmpty()) {
            reservasArea.setText("No hay reservas registradas.");
        } else {
            reservasArea.setText("");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (Reserva reserva : reservas) {
                String infoReserva = "ID: " + reserva.getId() + "\n" +
                                     "Número de Personas: " + reserva.getNumeroPersonas() + "\n" +
                                     "Nombre de la Reserva: " + reserva.getNombreReserva() + "\n" +
                                     "Fecha: " + dateFormat.format(reserva.getFecha()) + "\n\n";
                reservasArea.append(infoReserva);
            }
        }
    }

}
