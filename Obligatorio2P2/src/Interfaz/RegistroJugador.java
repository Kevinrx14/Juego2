/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.*;
import obligatorio2p2.*;
import javax.swing.*;
/**
 *
 * @author ezequiellopez
 */
public class RegistroJugador extends javax.swing.JFrame {

    /**
     * Creates new form RegistroJugador
     */
    private Aves a;
    private String image;
    public RegistroJugador() {
        initComponents();
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    public RegistroJugador(Aves av) {
        initComponents();
        a=av;
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setTitle("Aves 2.0 - Registrar Jugador");
        getContentPane().setLayout(null);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(50, 80, 100, 24);

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        getContentPane().add(age);
        age.setBounds(50, 150, 100, 24);

        alias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aliasActionPerformed(evt);
            }
        });
        getContentPane().add(alias);
        alias.setBounds(50, 220, 100, 24);

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 60, 45, 16);

        jLabel2.setText("Edad");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 130, 28, 16);

        jLabel3.setText("Alias");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 200, 28, 16);

        register.setText("Registrar");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(6, 314, 588, 32);

        jLabel5.setText("Elige tu avatar");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(365, 6, 80, 16);

        avatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/pepe.jpg"))); // NOI18N
        avatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar1ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar1);
        avatar1.setBounds(208, 28, 191, 140);

        avatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/sartori.jpeg"))); // NOI18N
        avatar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar2ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar2);
        avatar2.setBounds(405, 28, 189, 140);

        avatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/Untitled.png"))); // NOI18N
        avatar3.setAutoscrolls(true);
        avatar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar3ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar3);
        avatar3.setBounds(210, 174, 190, 140);

        avatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatares/maduro.jpg"))); // NOI18N
        avatar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatar4ActionPerformed(evt);
            }
        });
        getContentPane().add(avatar4);
        avatar4.setBounds(405, 174, 190, 140);

        setBounds(0, 0, 618, 391);
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
        Configuracion config=new Configuracion();
        config.setVisible(true);
    }//GEN-LAST:event_configActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        
    }//GEN-LAST:event_registrarActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jugarActionPerformed

    private void avatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar1ActionPerformed
        image="pepe.jpg";
    }//GEN-LAST:event_avatar1ActionPerformed

    private void avatar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar2ActionPerformed
        image="sartori.jpeg";
    }//GEN-LAST:event_avatar2ActionPerformed

    private void avatar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar3ActionPerformed
        image="Untitled.png";
    }//GEN-LAST:event_avatar3ActionPerformed

    private void avatar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatar4ActionPerformed
        image="maduro.jpg";
    }//GEN-LAST:event_avatar4ActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        try{
            int edad=Integer.parseInt(age.getText());
            Jugador j = new Jugador(name.getText(), edad, alias.getText(), image);
            a.getJugadores().add(j);
            System.out.println("flag");
        }catch(NullPointerException e){
            VentanaError error=new VentanaError("Selecciona un avatar antes de registrarte");
            error.setVisible(true);
        }catch(Exception e){
            VentanaError error=new VentanaError("Por favor, verifica los datos");
            error.setVisible(true);
        }
        System.out.println("flag2");
        for (int i=0; i<a.getJugadores().size();i++){
            System.out.println(a.getJugadores().get(i).toString());
        }
        
    }//GEN-LAST:event_registerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTextField alias;
    private javax.swing.JButton avatar1;
    private javax.swing.JButton avatar2;
    private javax.swing.JButton avatar3;
    private javax.swing.JButton avatar4;
    private javax.swing.JButton config;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jugar;
    private javax.swing.JTextField name;
    private javax.swing.JButton register;
    private javax.swing.JButton registrar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
