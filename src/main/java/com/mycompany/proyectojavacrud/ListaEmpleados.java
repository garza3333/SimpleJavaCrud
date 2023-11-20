
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListaEmpleados extends JFrame {
    private JTextArea infoEmpleados;

    public ListaEmpleados() {
        setTitle("Información de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        infoEmpleados = new JTextArea(10, 30);
        infoEmpleados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoEmpleados);

        JButton mostrarButton = new JButton("Mostrar Empleados");
        JButton cerrarButton = new JButton("Cerrar");

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(mostrarButton, BorderLayout.SOUTH);
        panel.add(cerrarButton, BorderLayout.NORTH);

        mostrarButton.addActionListener(e -> mostrarInformacionEmpleados());
        cerrarButton.addActionListener(e -> cerrarVentanaActual());

        add(panel);
        setVisible(true);
    }

    private void mostrarInformacionEmpleados() {
        // Obtener la lista de empleados desde DataManager
        ArrayList<Empleado> empleados = DataManager.empleados;

        if (empleados.isEmpty()) {
            infoEmpleados.setText("No hay empleados registrados.");
        } else {
            StringBuilder info = new StringBuilder();
            for (Empleado empleado : empleados) {
                info.append("ID: ").append(empleado.getId())
                    .append(", Nombre: ").append(empleado.getNombre())
                    .append(", Cargo: ").append(empleado.getCargo())
                    .append("\n");
            }
            infoEmpleados.setText(info.toString());
        }
    }

    private void cerrarVentanaActual() {
        // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}

