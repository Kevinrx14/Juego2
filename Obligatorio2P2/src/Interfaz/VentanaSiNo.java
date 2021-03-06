//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import obligatorio2p2.*;

public class VentanaSiNo extends javax.swing.JFrame {

    private Partida partida;
    private PanelDeJuego panel;

    public VentanaSiNo(String mensaje, Partida unaPartida, PanelDeJuego unPanel) {
        initComponents();
        labelMensaje.setText(mensaje);
        labelMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        this.partida = unaPartida;
        this.panel = unPanel;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSi = new javax.swing.JButton();
        botonNo = new javax.swing.JButton();
        labelMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        botonSi.setText("Si");
        botonSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiActionPerformed(evt);
            }
        });
        getContentPane().add(botonSi);
        botonSi.setBounds(218, 109, 60, 32);

        botonNo.setText("No");
        botonNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNoActionPerformed(evt);
            }
        });
        getContentPane().add(botonNo);
        botonNo.setBounds(303, 109, 60, 32);

        labelMensaje.setText("jLabel1");
        labelMensaje.setFocusable(false);
        labelMensaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(labelMensaje);
        labelMensaje.setBounds(31, 26, 338, 77);

        setBounds(0, 0, 399, 188);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiActionPerformed
        this.partida.setPartidaEnCurso(false);
        this.panel.cerrar();
        this.dispose();
    }//GEN-LAST:event_botonSiActionPerformed

    private void botonNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNoActionPerformed
        this.partida.setPartidaEnCurso(true);
        this.dispose();
    }//GEN-LAST:event_botonNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonNo;
    private javax.swing.JButton botonSi;
    private javax.swing.JLabel labelMensaje;
    // End of variables declaration//GEN-END:variables
}
