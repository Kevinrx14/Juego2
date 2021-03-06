//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package Interfaz;

import java.awt.*;
import obligatorio2p2.*;
import javax.swing.*;
import java.util.*;

public class SeleccionarJugadores extends javax.swing.JFrame {

    private Aves aves;
    private ArrayList<Jugador> juegan;
    private ArrayList<Jugador> listaJug;

    public SeleccionarJugadores(Aves a) {
        initComponents();
        this.aves = a;
        jugar.setVisible(false);
        juegan = new ArrayList();
        listaJug = new ArrayList(aves.getJugadores());
        this.sinSeleccionar.setListData(this.listaJug.toArray());
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enPartida = new javax.swing.JList();
        seleccionar = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        sinSeleccionar = new javax.swing.JList();
        quitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Selecciona los jugadores");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 40, 390, 16);

        enPartida.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(enPartida);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(350, 100, 170, 132);

        seleccionar.setText("Agregar>>");
        seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(seleccionar);
        seleccionar.setBounds(200, 100, 150, 29);

        jugar.setText("JUGAR");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        getContentPane().add(jugar);
        jugar.setBounds(180, 250, 200, 60);

        volver.setText("<-Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(10, 10, 110, 29);

        sinSeleccionar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(sinSeleccionar);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 100, 170, 132);

        quitar.setText("<<Quitar");
        quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarActionPerformed(evt);
            }
        });
        getContentPane().add(quitar);
        quitar.setBounds(200, 190, 150, 29);

        setBounds(0, 0, 550, 382);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarActionPerformed
        int remover = sinSeleccionar.getSelectedIndex();
        try {
            if (!(sinSeleccionar.getSelectedValue() == null)) {
                if (aves.getConfiguracion().length > juegan.size()) {
                    juegan.add((Jugador) sinSeleccionar.getSelectedValue());
                }
                if (aves.getConfiguracion()[0] == juegan.size()) {
                    jugar.setVisible(true);
                    seleccionar.setVisible(false);
                }
                listaJug.remove(remover);
                sinSeleccionar.setListData(this.listaJug.toArray());
                enPartida.setListData(this.juegan.toArray());
            }
        } catch (Exception e) {
            //Do Nothing
        }
    }//GEN-LAST:event_seleccionarActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        Partida p = new Partida(aves.getConfiguracion(), juegan);
        PanelDeJuego pan = new PanelDeJuego(p, aves);
        pan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jugarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarActionPerformed
        int remover = enPartida.getSelectedIndex();
        try {
            if (!(enPartida.getSelectedValue() == null)) {
                if (aves.getConfiguracion().length > juegan.size()) {
                    seleccionar.setVisible(true);
                    listaJug.add((Jugador) enPartida.getSelectedValue());
                    juegan.remove(remover);
                }
                if (aves.getConfiguracion()[0] != juegan.size()) {
                    jugar.setVisible(false);

                }
                sinSeleccionar.setListData(this.listaJug.toArray());
                enPartida.setListData(this.juegan.toArray());
            }
        } catch (Exception e) {
            //Do Nothing
        }
    }//GEN-LAST:event_quitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList enPartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jugar;
    private javax.swing.JButton quitar;
    private javax.swing.JButton seleccionar;
    private javax.swing.JList sinSeleccionar;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
