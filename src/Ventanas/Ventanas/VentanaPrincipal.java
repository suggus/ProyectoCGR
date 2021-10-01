package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {

    private JPanel VentanaPrincipal;
    private JTextField tfNombre;
    private JComboBox cbElegirParque;
    private JButton bAceptar;
    private JButton bCancelar;

    public VentanaPrincipal() {
        cbElegirParque.addItem("Vitoria");
        cbElegirParque.addItem("Donostia");
        cbElegirParque.addItem("Bilbao");


        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbElegirParque.getSelectedItem()=="Vitoria" && tfNombre.equals("root")){
                        JFrame frame = new JFrame("Empleado");
                        frame.setContentPane(new Empleado());
                } else if(cbElegirParque.getToolTipText()=="Donostia"){

                }else if(cbElegirParque.getToolTipText()=="Bilbao"){

                }else{
                    System.out.println("Base de datos incorrecta");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().VentanaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
