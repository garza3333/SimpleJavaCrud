
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActualizarEmpleado extends JFrame {
    private final JPanel panelEmpleados;

    public ActualizarEmpleado() {
        setTitle("Actualizar Empleado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cambiado a EXIT_ON_CLOSE para cerrar la aplicación
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        panelEmpleados = new JPanel();
        panelEmpleados.setLayout(new BoxLayout(panelEmpleados, BoxLayout.Y_AXIS));

        JButton mostrarButton = new JButton("Mostrar Empleados");
        mostrarButton.addActionListener(e -> mostrarInformacionEmpleados());

        JButton salirButton = new JButton("Salir");
        salirButton.addActionListener(e -> cerrarVentanaActual());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(mostrarButton);
        buttonPanel.add(salirButton);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(panelEmpleados, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void mostrarInformacionEmpleados() {
        // Obtener la lista de empleados desde DataManager
        ArrayList<Empleado> empleados = DataManager.empleados;

        panelEmpleados.removeAll(); // Limpiar el panel antes de mostrar los empleados

        if (empleados.isEmpty()) {
            JLabel noEmpleadosLabel = new JLabel("No hay empleados registrados.");
            panelEmpleados.add(noEmpleadosLabel);
        } else {
            for (Empleado empleado : empleados) {
                JPanel empleadoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                JTextField nombreField = new JTextField(empleado.getNombre(), 15);
                JTextField cargoField = new JTextField(empleado.getCargo(), 15);

                JButton actualizarButton = new JButton("Actualizar");
                actualizarButton.addActionListener(e -> actualizarEmpleado(empleado, nombreField.getText(), cargoField.getText()));

                empleadoPanel.add(new JLabel("ID: " + empleado.getId()));
                empleadoPanel.add(new JLabel("Nombre:"));
                empleadoPanel.add(nombreField);
                empleadoPanel.add(new JLabel("Cargo:"));
                empleadoPanel.add(cargoField);
                empleadoPanel.add(actualizarButton);
                panelEmpleados.add(empleadoPanel);
            }
        }

        panelEmpleados.revalidate(); // Actualizar el panel
        panelEmpleados.repaint();
    }

    private void actualizarEmpleado(Empleado empleado, String nuevoNombre, String nuevoCargo) {
        empleado.setNombre(nuevoNombre);
        empleado.setCargo(nuevoCargo);

    }

    private void cerrarVentanaActual() {
        // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }


}

