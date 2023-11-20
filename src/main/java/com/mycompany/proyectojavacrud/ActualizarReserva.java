
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActualizarReserva extends JFrame {
    private final JTextField idField;
    private final JTextField numPersonasField;
    private final JTextField nombreReservaField;
    private final JTextField fechaField;

    private final JButton actualizarButton;
    private final JButton salirButton;

    public ActualizarReserva() {
        setTitle("Actualizar Reserva");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel datosPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        datosPanel.add(idLabel);
        datosPanel.add(idField);

        JLabel numPersonasLabel = new JLabel("Número de Personas:");
        numPersonasField = new JTextField();
        datosPanel.add(numPersonasLabel);
        datosPanel.add(numPersonasField);

        JLabel nombreReservaLabel = new JLabel("Nombre de la Reserva:");
        nombreReservaField = new JTextField();
        datosPanel.add(nombreReservaLabel);
        datosPanel.add(nombreReservaField);

        JLabel fechaLabel = new JLabel("Fecha (yyyy-MM-dd):");
        fechaField = new JTextField();
        datosPanel.add(fechaLabel);
        datosPanel.add(fechaField);

        actualizarButton = new JButton("Actualizar");
        actualizarButton.addActionListener(e -> actualizarReserva());
        datosPanel.add(new JLabel());
        datosPanel.add(actualizarButton);

        salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());
        datosPanel.add(new JLabel());
        datosPanel.add(salirButton);

        panel.add(datosPanel, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void actualizarReserva() {
        try {
            int id = Integer.parseInt(idField.getText());
            int numPersonas = Integer.parseInt(numPersonasField.getText());
            String nombreReserva = nombreReservaField.getText();
            Date fecha = java.sql.Date.valueOf(fechaField.getText());

            Reserva reservaActualizada = new Reserva(id, numPersonas, nombreReserva, fecha);
            
            DataManager.actualizarReserva(reservaActualizada); // Método para actualizar reserva en tu sistema

            
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos para ID y Número de Personas.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        numPersonasField.setText("");
        nombreReservaField.setText("");
        fechaField.setText("");
    }

    private void cerrarVentanaActual() {
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }


}
