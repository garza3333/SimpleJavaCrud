
package com.mycompany.proyectojavacrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistroEmpleado extends JFrame {
    private final JTextField nombreField;
    private final JTextField cargoField;
    private final JTextField cedulaField;
    private final JButton registrarButton;

    public RegistroEmpleado() {
        setTitle("Registro de Empleado");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(15);

        JLabel cargoLabel = new JLabel("Cargo:");
        cargoField = new JTextField(15);
        
        JLabel cedulaLabel = new JLabel("Cedula:");
        cedulaField = new JTextField(15);

        registrarButton = new JButton("Registrar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(cargoLabel, gbc);

        gbc.gridx = 1;
        panel.add(cargoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cedulaLabel, gbc);

        gbc.gridx = 1;
        panel.add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(registrarButton, gbc);

        registrarButton.addActionListener((ActionEvent e) -> {
            registrarEmpleado();
        });

        add(panel);
        setVisible(true);
    }

    private void registrarEmpleado() {
        String nombre = nombreField.getText();
        String cargo = cargoField.getText();
        String cedula = cedulaField.getText();
        Empleado e = new Empleado(Integer.parseInt(cedula), nombre, cargo);
        
        System.out.println("Empleado añadido");
        System.out.println(nombre);
        System.out.println(cargo);
        System.out.println(cedula);
        DataManager.empleados.add(e);
        
        cerrarVentanaActual();

        
    }
    
    
    private void cerrarVentanaActual() {
        // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}
