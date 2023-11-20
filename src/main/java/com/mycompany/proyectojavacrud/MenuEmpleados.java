
package com.mycompany.proyectojavacrud;


import javax.swing.*;

public class MenuEmpleados extends JFrame {
    public MenuEmpleados() {
        setTitle("Menú de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú de Empleados");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Agregar un empleado");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Actualizar lista de empleados");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Eliminar un empleado");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        JButton opcion4Button = new JButton("4 - Mostrar lista de empleados");
        opcion4Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion4Button);

        JButton opcion5Button = new JButton("5 - Salir");
        opcion5Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion5Button);

        opcion1Button.addActionListener(e -> {
            // Lógica para agregar un empleado
            new RegistroEmpleado();
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para actualizar lista de empleados
            new ActualizarEmpleado();
        });

        opcion3Button.addActionListener(e -> {
            // Lógica para eliminar un empleado
            new EliminarEmpleado();
        });

        opcion4Button.addActionListener(e -> {
            // Lógica para mostrar lista de empleados
            new ListaEmpleados();
        });

        opcion5Button.addActionListener(e -> {
            // Cerrar el menú de empleados y salir
            salirDelMenuEmpleados();
        });

        add(panel);
        setVisible(true);
    }

    private void salirDelMenuEmpleados() {
        // Cierra la ventana del menú de empleados
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
            new Lobby();
        });
    }


}

