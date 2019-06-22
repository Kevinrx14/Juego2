//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package Interfaz;

import java.awt.*;
import obligatorio2p2.*;
import javax.swing.*;

public class RegistroJugador extends javax.swing.JFrame {

    private static String ubicacion = "/avatares/";

    private Aves a;
    private ImageIcon image;
    private boolean avatarSeleccionado;

    public RegistroJugador() {
        initComponents();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.avatarSeleccionado = false;
    }

    public RegistroJugador(Aves av) {
        initComponents();
        a = av;
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.avatarSeleccionado = false;
        avatar1.setOpaque(false);
        avatar2.setOpaque(false);
        avatar3.setOpaque(false);
        avatar4.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        config = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        registrar = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        alias = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        avatar1 = new javax.swing.JButton();
        avatar2 = new javax.swing.JButton();
        avatar3 = new javax.swing.JButton();
        avatar4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        config.setText("Configuración");
        config.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configActionPerformed(evt);
            }
        });

        salir.setText("Salir");

        jLabel6.setText("Aves© v1.1 beta by Kevin & Ezequiel ");

        registrar.setText("¡Registrate!");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Aves 2.0 - Registrar Jugador");
        getContentPane().setLayout(null);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(50, 80, 150, 24);

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        getContentPane().add(age);
        age.setBounds(50, 150, 150, 24);

        alias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasActionPerformed(evt);
            }
        });
        getContentPane().add(alias);
        alias.setBounds(50, 220, 150, 24);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 60, 120, 16);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Edad");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 130, 110, 16);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("Alias");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 200, 110, 16);

        register.setBackground(new java.awt.Color(153, 255, 153));
        register.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        register.setText("Registrar");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(40, 330, 588, 35);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Elige tu avatar");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 0, 130, 21);

        avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/bird1.jpg"))); // NOI18N
        avatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar1ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar1);
        avatar1.setBounds(230, 30, 191, 140);

        avatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/bird2.jpg"))); // NOI18N
        avatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar2ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar2);
        avatar2.setBounds(440, 30, 189, 140);

        avatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/bird3.jpg"))); // NOI18N
        avatar3.setAutoscrolls(true);
        avatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar3ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar3);
        avatar3.setBounds(230, 180, 190, 140);

        avatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/bird4.jpg"))); // NOI18N
        avatar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar4ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar4);
        avatar4.setBounds(440, 180, 190, 140);

        jButton1.setText("<-Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 110, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazFondos/registroJug.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-5, -4, 680, 400);

        setBounds(0, 0, 675, 420);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void aliasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aliasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aliasActionPerformed

    private void configActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configActionPerformed
        Configuracion config = new Configuracion();
        config.setVisible(true);
    }//GEN-LAST:event_configActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed

    }//GEN-LAST:event_registrarActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jugarActionPerformed

    private void avatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar1ActionPerformed
        image = new ImageIcon(getClass().getResource(this.ubicacion + "bird1.jpg"));
        this.avatarSeleccionado = true;
    }//GEN-LAST:event_avatar1ActionPerformed

    private void avatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar2ActionPerformed
        image = new ImageIcon(getClass().getResource(this.ubicacion + "bird2.jpg"));
        this.avatarSeleccionado = true;
    }//GEN-LAST:event_avatar2ActionPerformed

    private void avatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar3ActionPerformed
        image = new ImageIcon(getClass().getResource(this.ubicacion + "bird3.jpg"));
        this.avatarSeleccionado = true;
    }//GEN-LAST:event_avatar3ActionPerformed

    private void avatar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar4ActionPerformed
        image = new ImageIcon(getClass().getResource(this.ubicacion + "bird4.jpg"));
        this.avatarSeleccionado = true;
    }//GEN-LAST:event_avatar4ActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        String nombre = this.name.getText();
        String edadTexto = this.age.getText();
        String alias = this.alias.getText();
        int edad = 0;

        if (this.avatarSeleccionado) {
            if (!nombre.isEmpty() && !edadTexto.isEmpty() && !alias.isEmpty()) {
                try {
                    edad = Integer.parseInt(edadTexto);
                    Jugador j = new Jugador(nombre, edad, alias, image);
                    a.getJugadores().add(j);
                    this.dispose();
                    VentanaError vent = new VentanaError("Bienvenido a Aves " + alias);
                    vent.setearIcono(image);
                    vent.setVisible(true);
                } catch (NumberFormatException e) {
                    this.mostrarVentana("La edad ingresada no es valida");
                }
            } else {
                this.mostrarVentana("No se completaron todos los campos");
            }
        } else {
            this.mostrarVentana("No se eligio un avatar");
        }
    }//GEN-LAST:event_registerActionPerformed

    public void mostrarVentana(String mensaje) {
        VentanaError vent = new VentanaError(mensaje);
        vent.setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTextField alias;
    private javax.swing.JButton avatar1;
    private javax.swing.JButton avatar2;
    private javax.swing.JButton avatar3;
    private javax.swing.JButton avatar4;
    private javax.swing.JButton config;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jugar;
    private javax.swing.JTextField name;
    private javax.swing.JButton register;
    private javax.swing.JButton registrar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
