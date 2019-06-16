package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import obligatorio2p2.*;

public class PanelDeJuego extends javax.swing.JFrame {

    private JButton[][] botones;
    private Tablero tablero;
//    private Partida partida;
    private String movimiento;

    public PanelDeJuego(/*Partida nuevaPartida*/) {
        this.initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setResizable(false);
        panelJuego.setLayout(new GridLayout(11, 11));
        botones = new JButton[11][11];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                JButton jButton = new JButton();
                jButton.addActionListener(new ListenerBoton(i, j));
                panelJuego.add(jButton);
                botones[i][j] = jButton;
            }
        }

//        this.partida = nuevaPartida;
        this.tablero = new Tablero(botones);
        this.pintarBotones();

        botones[1][1].setBackground(Color.RED);
        botones[1][2].setBackground(Color.BLUE);
        botones[2][1].setBackground(Color.GREEN);
        botones[2][2].setBackground(Color.YELLOW);

        botones[1][3].setBackground(Color.GREEN);
        botones[1][4].setBackground(Color.YELLOW);
        botones[2][3].setBackground(Color.RED);
        botones[2][4].setBackground(Color.BLUE);

        this.movimiento = "no";
        this.mostrarBotonesExtender(false);
    }

    private void pintarBotones() {
        Color[] colores;

        for (int i = 1; i <= 10; i += 2) {
            for (int j = 1; j <= 10; j += 2) {
                colores = this.tablero.getColoresRandom();
                botones[i][j].setBackground(colores[0]);
                botones[i][j + 1].setBackground(colores[1]);
                botones[i + 1][j].setBackground(colores[2]);
                botones[i + 1][j + 1].setBackground(colores[3]);
            }
        }
    }

    private void mostrarBotonesExtender(boolean mostrar) {
        botonExtenderIzquierda.setVisible(mostrar);
        botonExtenderDerecha.setVisible(mostrar);
        botonExtenderArriba.setVisible(mostrar);
        botonExtenderAbajo.setVisible(mostrar);
    }

    private class ListenerBoton implements ActionListener {

        private int x;
        private int y;

        public ListenerBoton(int i, int j) {
// en el constructor se almacena la fila y columna que se presionó
            x = i;
            y = j;
        }

        public void actionPerformed(ActionEvent e) {
// cuando se presiona un botón, se ejecutará este método
            clickBoton(x, y);
        }
    }

    private void clickBoton(int fila, int columna) {
        if (this.movimiento.equals("conectar")) {
            System.out.println("flag conectar");
            if (this.tablero.getBotonesApretados() == 0) {
                System.out.println("flag primer boton");
                this.tablero.setFila1(fila);
                this.tablero.setColumna1(columna);
                this.tablero.aumentarBotonesApretados();
            } else {
                if (this.tablero.getBotonesApretados() == 1) {
                    System.out.println("flag segundo boton");
                    this.tablero.setFila2(fila);
                    this.tablero.setColumna2(columna);
                    this.tablero.aumentarBotonesApretados();
                    if (this.tablero.conectar(this.botones)) {
                        System.out.println("flag se pudo conectar");
                        this.ponerAves();
                        this.movimiento = "no";
                        
                    }
                }
            }
            System.out.println("flag movimiento: " + this.movimiento);
            System.out.println("--------------------------------------");
        } else {
            if (this.movimiento.equals("extender")) {
                if (this.tablero.getBotonesApretados() == 0) {
                    this.tablero.setFila1(fila);
                    this.tablero.setColumna1(columna);
                    this.tablero.aumentarBotonesApretados();
                    this.mostrarBotonesExtender(true);
                }
            }
        }
    }

    public void ponerAves() {
        int fila1 = this.tablero.getFila1();
        int fila2 = this.tablero.getFila2();
        int columna1 = this.tablero.getColumna1();
        int columna2 = this.tablero.getColumna2();
        Color color = this.botones[fila1][columna1].getBackground();
        
        if (this.tablero.validarFila()) {
            if(this.tablero.columnaDecreciente()) {
                int aux = columna1;
                columna1 = columna2;
                columna2 = aux;
            }
            for (int i = columna1; i <= columna2; i++) {
                this.botones[fila1][i].setText("X");
                this.botones[fila1][i].setBackground(color);
            }
        } else {
            if(this.tablero.filaDecreciente()) {
                int aux = fila1;
                fila1 = fila2;
                fila2 = aux;
            }
            for (int i = fila1; i <= fila2; i++) {
                this.botones[i][columna1].setText("X");
                this.botones[i][columna1].setBackground(color);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelJuego = new javax.swing.JPanel();
        avatarJugador1 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        avatarJugador2 = new javax.swing.JLabel();
        nombreJugador2 = new javax.swing.JLabel();
        avatarJugador3 = new javax.swing.JLabel();
        nombreJugador3 = new javax.swing.JLabel();
        avatarJugador4 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();
        botonConectar = new javax.swing.JButton();
        botonExtender = new javax.swing.JButton();
        botonExtenderArriba = new javax.swing.JButton();
        botonExtenderIzquierda = new javax.swing.JButton();
        botonExtenderDerecha = new javax.swing.JButton();
        botonExtenderAbajo = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        getContentPane().add(panelJuego);
        panelJuego.setBounds(6, 133, 484, 422);

        avatarJugador1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/index.png"))); // NOI18N
        avatarJugador1.setText("jLabel1");
        getContentPane().add(avatarJugador1);
        avatarJugador1.setBounds(43, 24, 74, 68);

        nombreJugador1.setText("Nombre Jugador");
        getContentPane().add(nombreJugador1);
        nombreJugador1.setBounds(31, 99, 95, 16);

        avatarJugador2.setText("jLabel1");
        getContentPane().add(avatarJugador2);
        avatarJugador2.setBounds(200, 20, 74, 68);

        nombreJugador2.setText("Nombre Jugador");
        getContentPane().add(nombreJugador2);
        nombreJugador2.setBounds(180, 100, 95, 16);

        avatarJugador3.setText("jLabel1");
        getContentPane().add(avatarJugador3);
        avatarJugador3.setBounds(360, 30, 74, 68);

        nombreJugador3.setText("Nombre Jugador");
        getContentPane().add(nombreJugador3);
        nombreJugador3.setBounds(340, 100, 95, 16);

        avatarJugador4.setText("jLabel1");
        getContentPane().add(avatarJugador4);
        avatarJugador4.setBounds(530, 30, 74, 68);

        nombreJugador4.setText("Nombre Jugador");
        getContentPane().add(nombreJugador4);
        nombreJugador4.setBounds(510, 100, 95, 16);

        botonConectar.setText("Conectar");
        botonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarActionPerformed(evt);
            }
        });
        getContentPane().add(botonConectar);
        botonConectar.setBounds(510, 140, 120, 32);

        botonExtender.setText("Extender");
        botonExtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtenderActionPerformed(evt);
            }
        });
        getContentPane().add(botonExtender);
        botonExtender.setBounds(510, 180, 120, 32);

        botonExtenderArriba.setText("↑");
        botonExtenderArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtenderArribaActionPerformed(evt);
            }
        });
        getContentPane().add(botonExtenderArriba);
        botonExtenderArriba.setBounds(550, 250, 40, 32);

        botonExtenderIzquierda.setText("←");
        botonExtenderIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtenderIzquierdaActionPerformed(evt);
            }
        });
        getContentPane().add(botonExtenderIzquierda);
        botonExtenderIzquierda.setBounds(510, 280, 40, 32);

        botonExtenderDerecha.setText("→");
        botonExtenderDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtenderDerechaActionPerformed(evt);
            }
        });
        getContentPane().add(botonExtenderDerecha);
        botonExtenderDerecha.setBounds(590, 280, 40, 32);

        botonExtenderAbajo.setText("↓");
        botonExtenderAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExtenderAbajoActionPerformed(evt);
            }
        });
        getContentPane().add(botonExtenderAbajo);
        botonExtenderAbajo.setBounds(550, 310, 40, 32);

        botonSalir.setText("Salir");
        getContentPane().add(botonSalir);
        botonSalir.setBounds(510, 480, 120, 32);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(521, 370, 100, 16);

        setBounds(0, 0, 666, 554);
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarActionPerformed
        this.movimiento = "conectar";
        jLabel1.setText(movimiento);
        this.mostrarBotonesExtender(false);
        this.tablero.setBotonesApretados(0);
    }//GEN-LAST:event_botonConectarActionPerformed

    private void botonExtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderActionPerformed
        this.movimiento = "extender";
        jLabel1.setText(movimiento);
        this.mostrarBotonesExtender(false);
        this.tablero.setBotonesApretados(0);
    }//GEN-LAST:event_botonExtenderActionPerformed

    private void botonExtenderIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderIzquierdaActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender(botones)) {
                //this.ponerAves();
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
            }
        }
    }//GEN-LAST:event_botonExtenderIzquierdaActionPerformed

    private void botonExtenderArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderArribaActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender(botones)) {
                //this.ponerAves();
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
            }
        }
    }//GEN-LAST:event_botonExtenderArribaActionPerformed

    private void botonExtenderDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderDerechaActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender(botones)) {
                //this.ponerAves();
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
            }
        }
    }//GEN-LAST:event_botonExtenderDerechaActionPerformed

    private void botonExtenderAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderAbajoActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender(botones)) {
                //this.ponerAves();
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
            }
        }
    }//GEN-LAST:event_botonExtenderAbajoActionPerformed

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
            java.util.logging.Logger.getLogger(PanelDeJuego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelDeJuego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelDeJuego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelDeJuego.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelDeJuego(/*new Partida()*/).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatarJugador1;
    private javax.swing.JLabel avatarJugador2;
    private javax.swing.JLabel avatarJugador3;
    private javax.swing.JLabel avatarJugador4;
    private javax.swing.JButton botonConectar;
    private javax.swing.JButton botonExtender;
    private javax.swing.JButton botonExtenderAbajo;
    private javax.swing.JButton botonExtenderArriba;
    private javax.swing.JButton botonExtenderDerecha;
    private javax.swing.JButton botonExtenderIzquierda;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel nombreJugador3;
    private javax.swing.JLabel nombreJugador4;
    private javax.swing.JPanel panelJuego;
    // End of variables declaration//GEN-END:variables
}
