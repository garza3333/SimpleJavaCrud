
package com.mycompany.proyectojavacrud;


import javax.swing.*;

public class MenuFacturacion extends JFrame {
    
    public MenuFacturacion() {
        setTitle("Menú de Facturación");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel tituloLabel = new JLabel("Menú de Facturación");
        tituloLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tituloLabel);

        JButton opcion1Button = new JButton("1 - Agregar una factura");
        opcion1Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion1Button);

        JButton opcion2Button = new JButton("2 - Ver facturas");
        opcion2Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion2Button);

        JButton opcion3Button = new JButton("3 - Salir");
        opcion3Button.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(opcion3Button);

        opcion1Button.addActionListener(e -> {
            // Lógica para agregar una factura
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio:"));
            double precioConImpuesto = precio * 1.13; // Suma el 13% al precio
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");

            JOptionPane.showMessageDialog(this, "Factura agregada:\nPrecio: $" + precioConImpuesto + "\nCliente: " + nombreCliente);
        });

        opcion2Button.addActionListener(e -> {
            // Lógica para ver las facturas
            JOptionPane.showMessageDialog(this, "Seleccionaste: Ver facturas");
        });

        opcion3Button.addActionListener(e -> {
            // Cerrar el menú de facturación y salir
            salirDelMenuFacturacion();
        });

        add(panel);
        setVisible(true);
    }

    private void salirDelMenuFacturacion() {
        // Cierra la ventana del menú de facturación
        SwingUtilities.invokeLater(() -> {
            setVisible(false);
            dispose();
            new Lobby();
        });
    }

}
