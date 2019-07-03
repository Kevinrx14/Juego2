//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package Interfaz;

import java.awt.*;
import obligatorio2p2.*;
import java.io.*;
import javax.swing.*;

public class MenuPrincipal extends javax.swing.JFrame {

    public Aves a;
    public String hola;

    public MenuPrincipal() {
        initComponents();
        this.setTitle("Aves v2.0 Beta");
        a = new Aves();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public MenuPrincipal(Aves av) {
        initComponents();
        this.setTitle("Aves v2.0 Beta");
        a = av;
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public Aves getAves() {
        return this.a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        registro = new javax.swing.JButton();
        config = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        texto = new javax.swing.JLabel();
        diferentes = new javax.swing.JButton();
        puntuaciones = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        fondoImg = new javax.swing.JLabel();

        jButton4.setText("Configuracion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(26, 14, 0, 0);

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        getContentPane().add(jugar);
        jugar.setBounds(140, 130, 267, 29);

        registro.setText("¡Registrate!");
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        getContentPane().add(registro);
        registro.setBounds(140, 200, 267, 29);

        config.setText("Configuración");
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });
        getContentPane().add(config);
        config.setBounds(140, 280, 267, 29);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 0, 0);

        texto.setFont(new java.awt.Font("Marker Felt", 1, 48)); // NOI18N
        texto.setForeground(new java.awt.Color(0, 153, 153));
        texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto.setText("AVES 2.0");
        getContentPane().add(texto);
        texto.setBounds(130, 10, 290, 130);

        diferentes.setText("Diferencia de nombres");
        diferentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diferentesActionPerformed(evt);
            }
        });
        getContentPane().add(diferentes);
        diferentes.setBounds(290, 330, 170, 100);

        puntuaciones.setText("Puntuaciones");
        puntuaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntuacionesActionPerformed(evt);
            }
        });
        getContentPane().add(puntuaciones);
        puntuaciones.setBounds(80, 330, 170, 100);

        salir.setBackground(new java.awt.Color(255, 51, 51));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(210, 470, 120, 29);

        fondoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazFondos/background.jpg"))); // NOI18N
        getContentPane().add(fondoImg);
        fondoImg.setBounds(0, 0, 540, 530);

        setBounds(0, 0, 539, 546);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        SeleccionarJugadores sel = new SeleccionarJugadores(a);
        sel.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        if (a.getConfiguracion()[0] <= a.getJugadores().size()) {
            SeleccionarJugadores panel = new SeleccionarJugadores(a);
            panel.setVisible(true);
        } else {
            VentanaError vent = new VentanaError("No hay suficientes jugadores registrados");
            vent.setVisible(true);
        }
    }//GEN-LAST:event_jugarActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        RegistroJugador registro = new RegistroJugador(a);
        registro.setVisible(true);
    }//GEN-LAST:event_registroActionPerformed

    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        Configuracion config = new Configuracion(a);
        config.setVisible(true);
    }//GEN-LAST:event_configActionPerformed

    private void diferentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diferentesActionPerformed
        try {
            SelectArch sel = new SelectArch(a);
            sel.setVisible(true);
        } catch (NullPointerException e) {
            VentanaError vent = new VentanaError("Selecciona un archivo por favor");
            vent.setVisible(true);
        }


    }//GEN-LAST:event_diferentesActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        try {
            FileOutputStream ff = new FileOutputStream("archivo");
            BufferedOutputStream b = new BufferedOutputStream(ff);
            ObjectOutputStream ss = new ObjectOutputStream(b);
            ss.writeObject(a);
            ss.flush();
            ss.close();
            this.dispose();
        } catch (Exception e) {
            VentanaError vent = new VentanaError("ERROR AL GUARDAR LA PARTIDA");
        }
    }//GEN-LAST:event_salirActionPerformed

    private void puntuacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntuacionesActionPerformed
        
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File archivo = guardar.getSelectedFile();
        archivo.getAbsolutePath();
        a.excel(archivo.getAbsolutePath());
        VentanaError vent = new VentanaError("Se ha creado el archivo");
        vent.setVisible(true);
    }//GEN-LAST:event_puntuacionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton config;
    private javax.swing.JButton diferentes;
    private javax.swing.JLabel fondoImg;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jugar;
    private javax.swing.JButton puntuaciones;
    private javax.swing.JButton registro;
    private javax.swing.JButton salir;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}
