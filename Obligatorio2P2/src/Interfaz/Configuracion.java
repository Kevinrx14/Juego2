//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package Interfaz;

import obligatorio2p2.*;
import java.awt.*;

public class Configuracion extends javax.swing.JFrame {

    public Aves a;

    public Configuracion() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        blankTurn.setVisible(false);
        labTurn.setVisible(false);
        this.setResizable(false);
    }

    public Configuracion(Aves ave) {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setResizable(false);
        blankTurn.setVisible(true);
        labTurn.setVisible(true);
        a = ave;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cantJug = new javax.swing.JComboBox<>();
        formaTerm = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setearConfig = new javax.swing.JButton();
        configDefecto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cantAves = new javax.swing.JTextField();
        blankTurn = new javax.swing.JTextField();
        labTurn = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Aves 2.0 - Configuración");
        getContentPane().setLayout(null);

        cantJug.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        cantJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantJugActionPerformed(evt);
            }
        });
        getContentPane().add(cantJug);
        cantJug.setBounds(90, 60, 264, 26);

        formaTerm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terminar turnos", "Cantidad de aves"}));
        formaTerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaTermActionPerformed(evt);
            }
        });
        getContentPane().add(formaTerm);
        formaTerm.setBounds(90, 140, 264, 26);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cantidad de jugadores ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 60, 230, 20);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Cantidad de aves");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 100, 230, 20);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Forma de terminacion");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 140, 230, 20);

        setearConfig.setText("Listo");
        setearConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setearConfigActionPerformed(evt);
            }
        });
        getContentPane().add(setearConfig);
        setearConfig.setBounds(10, 260, 200, 37);

        configDefecto.setText("Configuración por defecto");
        configDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configDefectoActionPerformed(evt);
            }
        });
        getContentPane().add(configDefecto);
        configDefecto.setBounds(360, 260, 200, 37);

        jLabel4.setFont(new java.awt.Font("Malayalam MN", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 51, 255));
        jLabel4.setText("CONFIGURACION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 10, 340, 50);

        cantAves.setText("20");
        cantAves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantAvesActionPerformed(evt);
            }
        });
        getContentPane().add(cantAves);
        cantAves.setBounds(90, 100, 264, 24);

        blankTurn.setText("5");
        blankTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blankTurnActionPerformed(evt);
            }
        });
        getContentPane().add(blankTurn);
        blankTurn.setBounds(90, 180, 264, 24);

        labTurn.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        labTurn.setForeground(new java.awt.Color(51, 51, 255));
        labTurn.setText("Cantidad de turnos");
        getContentPane().add(labTurn);
        labTurn.setBounds(360, 180, 230, 20);

        jButton1.setText("<-Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 110, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazFondos/4064163432755241_1.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 590, 330);

        setBounds(0, 0, 589, 346);
    }// </editor-fold>//GEN-END:initComponents

    private void cantJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantJugActionPerformed

    }//GEN-LAST:event_cantJugActionPerformed

    private void setearConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setearConfigActionPerformed
        try {
            int jug = cantJug.getSelectedIndex() + 2;
            int aves = Integer.parseInt((String) (cantAves.getText()));
            int tipoTerm = 0;
            switch ((String) formaTerm.getSelectedItem()) {
                case "Terminar turnos":
                    tipoTerm = 2;
                    break;
                case "Cantidad de aves":
                    tipoTerm = 1;
                    break;
            }
            int turnos = Integer.parseInt((String) blankTurn.getText());
            if (aves > 4 && aves < 31) {
                if (turnos > 0 && turnos < 11) {
                    a.setConfig(jug, aves, tipoTerm, turnos);
                    this.setVisible(false);
                } else {
                    mostrarError("La cantidad de turnos ingresada no se encuentra entre 1 y 10");
                }
            } else {
                mostrarError("La cantidad de aves ingresada no se encuentra entre 5 y 30");
            }
        } catch (Exception e) {
            mostrarError("Por favor, verifica los datos ingresados");
        }

    }//GEN-LAST:event_setearConfigActionPerformed

    public void mostrarError(String mensaje) {
        VentanaError v = new VentanaError(mensaje);
        v.setVisible(true);
    }

    private void configDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configDefectoActionPerformed
        cantJug.setSelectedItem("2");
        formaTerm.setSelectedItem("Terminar turnos");
        blankTurn.setText("5");
        cantAves.setText("20");
    }//GEN-LAST:event_configDefectoActionPerformed

    private void cantAvesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantAvesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantAvesActionPerformed

    private void formaTermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaTermActionPerformed
        if (formaTerm.getSelectedItem().equals("Terminar turnos")) {
            blankTurn.setVisible(true);
            labTurn.setVisible(true);
        } else {
            blankTurn.setVisible(false);
            labTurn.setVisible(false);
        }
    }//GEN-LAST:event_formaTermActionPerformed

    private void blankTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blankTurnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blankTurnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blankTurn;
    private javax.swing.JTextField cantAves;
    private javax.swing.JComboBox<String> cantJug;
    private javax.swing.JButton configDefecto;
    private javax.swing.JComboBox<String> formaTerm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labTurn;
    private javax.swing.JButton setearConfig;
    // End of variables declaration//GEN-END:variables
}
