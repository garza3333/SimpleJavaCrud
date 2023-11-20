
package com.mycompany.proyectojavacrud;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EliminarEmpleado extends JFrame {
    private JPanel panelEmpleados;

    public EliminarEmpleado() {
        setTitle("Eliminar Empleado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cambiado a EXIT_ON_CLOSE para cerrar la aplicación
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        panelEmpleados = new JPanel();
        panelEmpleados.setLayout(new BoxLayout(panelEmpleados, BoxLayout.Y_AXIS));

        JButton mostrarButton = new JButton("Mostrar Empleados");
        mostrarButton.addActionListener(e -> mostrarInformacionEmpleados());

        JButton salirButton = new JButton("Salir"); // Botón para salir
        salirButton.addActionListener(e -> cerrarVentanaActual()); // Acción para cerrar la ventana

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

                JLabel infoLabel = new JLabel("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() +
                        ", Cargo: " + empleado.getCargo());

                JButton eliminarButton = new JButton("Eliminar");
                eliminarButton.addActionListener(e -> eliminarEmpleado(empleado));

                empleadoPanel.add(infoLabel);
                empleadoPanel.add(eliminarButton);
                panelEmpleados.add(empleadoPanel);
            }
        }

        panelEmpleados.revalidate(); // Actualizar el panel
        panelEmpleados.repaint();
    }

    private void eliminarEmpleado(Empleado empleado) {
        // Eliminar el empleado de la lista en DataManager
        DataManager.eliminarEmpleado(empleado);
        mostrarInformacionEmpleados(); // Actualizar la información después de eliminar
    }

    private void cerrarVentanaActual() {
        // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
        });
    }

}



