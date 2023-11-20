
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;

public class RegistroProducto extends JFrame {
    private final JTextField nombreField;
    private final JTextField precioField;
    private final JTextField codigoField;
    private final JButton registrarButton;

    public RegistroProducto() {
        setTitle("Registro de Producto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(15);
        formPanel.add(nombreLabel, gbc);
        gbc.gridx++;
        formPanel.add(nombreField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField(15);
        formPanel.add(precioLabel, gbc);
        gbc.gridx++;
        formPanel.add(precioField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        JLabel codigoLabel = new JLabel("Codigo:");
        codigoField = new JTextField(15);
        formPanel.add(codigoLabel, gbc);
        gbc.gridx++;
        formPanel.add(codigoField, gbc);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(e -> registrarProducto());

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(registrarButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void registrarProducto() {
        String nombre = nombreField.getText();
        String precio = precioField.getText();
        String codigo = codigoField.getText();
        
        Producto p = new Producto(Integer.parseInt(codigo),nombre,Double.parseDouble(precio));
        
        DataManager.productos.add(p);
        
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

