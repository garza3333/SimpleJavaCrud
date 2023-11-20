
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RegistroReserva extends JFrame {
    private final JTextField idField;
    private final JTextField numPersonasField;
    private final JTextField nombreReservaField;
    private final JTextField fechaField;

    private final JButton registrarButton;

    public RegistroReserva() {
        setTitle("Registrar Reserva");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        panel.add(idLabel);
        panel.add(idField);

        JLabel numPersonasLabel = new JLabel("Número de Personas:");
        numPersonasField = new JTextField();
        panel.add(numPersonasLabel);
        panel.add(numPersonasField);

        JLabel nombreReservaLabel = new JLabel("Nombre de la Reserva:");
        nombreReservaField = new JTextField();
        panel.add(nombreReservaLabel);
        panel.add(nombreReservaField);

        JLabel fechaLabel = new JLabel("Fecha (yyyy-MM-dd):");
        fechaField = new JTextField();
        panel.add(fechaLabel);
        panel.add(fechaField);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(e -> registrarReserva());
        panel.add(new JLabel());
        panel.add(registrarButton);

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());
        panel.add(new JLabel()); // Agrega un espacio vacío para separar el botón de salida
        panel.add(salirButton);

        // Añade el panel al centro del JFrame
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void registrarReserva() {
        try {
            int id = Integer.parseInt(idField.getText());
            int numPersonas = Integer.parseInt(numPersonasField.getText());
            String nombreReserva = nombreReservaField.getText();
            Date fecha = java.sql.Date.valueOf(fechaField.getText());

            Reserva reserva = new Reserva(id, numPersonas, nombreReserva, fecha);
            DataManager.reservas.add(reserva);
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
