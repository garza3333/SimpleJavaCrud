
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    private JTextField usuarioField;
    private JPasswordField passwordField;

    public MenuPrincipal() {
        setTitle("Sistema de Gestión - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usuarioLabel = new JLabel("Usuario:");
        panel.add(usuarioLabel);
        usuarioField = new JTextField();
        panel.add(usuarioField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener((ActionEvent e) -> {
            String usuario = usuarioField.getText();
            String password = new String(passwordField.getPassword());
            
            if (usuario.equals("kanoba") && password.equals("choxo")) {
                // Aquí abrirías el menú principal
                abrirMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }
        });
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }
    
    private void cerrarVentanaActual() {
        
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

    private void abrirMenuPrincipal() {
        this.cerrarVentanaActual();
        DataManager dm = new DataManager();
        Lobby lb = new Lobby();
        
    }


}
