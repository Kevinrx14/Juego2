package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import obligatorio2p2.*;

public class PanelDeJuego extends javax.swing.JFrame {

    private JButton[][] botones;
    private Tablero tablero;
    private Partida partida;
    private String movimiento;
    private ArrayList<Jugador> jugadores;

    public PanelDeJuego() {
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
    }

    public PanelDeJuego(Partida nuevaPartida) {
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

        this.partida = nuevaPartida;
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
        this.jugadores = this.partida.getJugadores();
        this.setUiJugadores();
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

    private void setUiJugadores() {
        int cantJugadores = jugadores.size();
        String ubicacion = "/avatares/";

        ImageIcon imagen1 = new ImageIcon(getClass().getResource(ubicacion + this.jugadores.get(0).getImage()));
        Icon avatar1 = new ImageIcon(imagen1.getImage().getScaledInstance(avatarJugador1.getWidth(), avatarJugador1.getHeight(), Image.SCALE_DEFAULT));
        this.avatarJugador1.setIcon(avatar1);
        this.nombreJugador1.setText(this.jugadores.get(0).getAlias());
        this.nombreJugador1.setBackground(this.jugadores.get(0).getColorJugador());
        this.nombreJugador1.setHorizontalAlignment(SwingConstants.CENTER);
        this.nombreJugador1.setOpaque(true);
        this.avatarJugador1.setVisible(true);
        this.nombreJugador1.setVisible(true);

        ImageIcon imagen2 = new ImageIcon(getClass().getResource(ubicacion + this.jugadores.get(1).getImage()));
        Icon avatar2 = new ImageIcon(imagen2.getImage().getScaledInstance(avatarJugador2.getWidth(), avatarJugador2.getHeight(), Image.SCALE_DEFAULT));
        this.avatarJugador2.setIcon(avatar2);
        this.nombreJugador2.setText(this.jugadores.get(1).getAlias());
        this.nombreJugador2.setBackground(this.jugadores.get(1).getColorJugador());
        this.nombreJugador2.setHorizontalAlignment(SwingConstants.CENTER);
        this.nombreJugador2.setOpaque(true);
        this.avatarJugador2.setVisible(true);
        this.nombreJugador2.setVisible(true);

        if (cantJugadores > 2) {
            ImageIcon imagen3 = new ImageIcon(getClass().getResource(ubicacion + this.jugadores.get(2).getImage()));
            Icon avatar3 = new ImageIcon(imagen3.getImage().getScaledInstance(avatarJugador3.getWidth(), avatarJugador3.getHeight(), Image.SCALE_DEFAULT));
            this.avatarJugador3.setIcon(avatar3);
            this.nombreJugador3.setText(this.jugadores.get(2).getAlias());
            this.nombreJugador3.setBackground(this.jugadores.get(2).getColorJugador());
            this.nombreJugador3.setHorizontalAlignment(SwingConstants.CENTER);
            this.nombreJugador3.setOpaque(true);
            this.avatarJugador3.setVisible(true);
            this.nombreJugador3.setVisible(true);
        }

        if (cantJugadores > 3) {
            ImageIcon imagen4 = new ImageIcon(getClass().getResource(ubicacion + this.jugadores.get(3).getImage()));
            Icon avatar4 = new ImageIcon(imagen4.getImage().getScaledInstance(avatarJugador4.getWidth(), avatarJugador4.getHeight(), Image.SCALE_DEFAULT));
            this.avatarJugador4.setIcon(avatar4);
            this.nombreJugador4.setText(this.jugadores.get(3).getAlias());
            this.nombreJugador4.setBackground(this.jugadores.get(3).getColorJugador());
            this.nombreJugador4.setHorizontalAlignment(SwingConstants.CENTER);
            this.nombreJugador4.setOpaque(true);
            this.avatarJugador4.setVisible(true);
            this.nombreJugador4.setVisible(true);
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
        int jugador = this.partida.getTurnoDeJugador() - 1;
        Color colorJug = this.jugadores.get(jugador).getColorJugador();

        if (botones[fila][columna].getBackground().equals(colorJug)) {
            if (botones[fila][columna].getText().isEmpty()) {
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
                            if (this.tablero.conectar()) {
                                System.out.println("flag se pudo conectar");
                                this.ponerAvesConectar();
                                this.movimiento = "no";
                                this.partida.cambiarTurnoJugador();
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
        }
    }

    public void ponerAvesConectar() {
        int fila1 = this.tablero.getFila1();
        int fila2 = this.tablero.getFila2();
        int columna1 = this.tablero.getColumna1();
        int columna2 = this.tablero.getColumna2();
        Color color = this.botones[fila1][columna1].getBackground();

        if (this.tablero.validarFila()) {
            if (this.tablero.columnaDecreciente()) {
                int aux = columna1;
                columna1 = columna2;
                columna2 = aux;
            }
            for (int i = columna1; i <= columna2; i++) {
                this.botones[fila1][i].setText("X");
                this.botones[fila1][i].setBackground(color);
            }
        } else {
            if (this.tablero.filaDecreciente()) {
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

    public void ponerAvesExtender(char direccion) {
        int[] extenderHasta = this.tablero.extenderHasta(direccion);
        int fila1 = this.tablero.getFila1();
        int columna1 = this.tablero.getColumna1();
        Color color = this.botones[fila1][columna1].getBackground();

        switch (direccion) {
            case 'A':
                for (int i = fila1; i >= extenderHasta[0]; i--) {
                    this.botones[i][columna1].setText("X");
                    this.botones[i][columna1].setBackground(color);
                }
                break;
            case 'B':
                for (int i = fila1; i <= extenderHasta[0]; i++) {
                    this.botones[i][columna1].setText("X");
                    this.botones[i][columna1].setBackground(color);
                }
                break;
            case 'I':
                for (int i = columna1; i >= extenderHasta[1]; i--) {
                    this.botones[fila1][i].setText("X");
                    this.botones[fila1][i].setBackground(color);
                }
                break;
            case 'D':
                for (int i = columna1; i >= extenderHasta[1]; i++) {
                    this.botones[fila1][i].setText("X");
                    this.botones[fila1][i].setBackground(color);
                }
                break;
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
        avatarJugador1.setBounds(40, 20, 74, 68);
        avatarJugador1.setVisible(false);

        nombreJugador1.setText("Nombre Jugador");
        nombreJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombreJugador1);
        nombreJugador1.setBounds(31, 99, 95, 16);
        nombreJugador1.setVisible(false);

        avatarJugador2.setText("jLabel1");
        getContentPane().add(avatarJugador2);
        avatarJugador2.setBounds(190, 20, 74, 68);
        avatarJugador2.setVisible(false);

        nombreJugador2.setText("Nombre Jugador");
        nombreJugador2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombreJugador2);
        nombreJugador2.setBounds(180, 100, 95, 16);
        nombreJugador2.setVisible(false);

        avatarJugador3.setText("jLabel1");
        getContentPane().add(avatarJugador3);
        avatarJugador3.setBounds(350, 20, 74, 68);
        avatarJugador3.setVisible(false);

        nombreJugador3.setText("Nombre Jugador");
        nombreJugador3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombreJugador3);
        nombreJugador3.setBounds(340, 100, 95, 16);
        nombreJugador3.setVisible(false);

        avatarJugador4.setText("jLabel1");
        getContentPane().add(avatarJugador4);
        avatarJugador4.setBounds(520, 20, 74, 68);
        avatarJugador4.setVisible(false);

        nombreJugador4.setText("Nombre Jugador");
        nombreJugador4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nombreJugador4);
        nombreJugador4.setBounds(510, 100, 95, 16);
        nombreJugador4.setVisible(false);

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
            if (this.tablero.extender('I')) {
                this.ponerAvesExtender('I');
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
                this.partida.cambiarTurnoJugador();
            }
        }
    }//GEN-LAST:event_botonExtenderIzquierdaActionPerformed

    private void botonExtenderArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderArribaActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender('A')) {
                this.ponerAvesExtender('A');
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
                this.partida.cambiarTurnoJugador();
            }
        }
    }//GEN-LAST:event_botonExtenderArribaActionPerformed

    private void botonExtenderDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderDerechaActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender('D')) {
                this.ponerAvesExtender('D');
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
                this.partida.cambiarTurnoJugador();
            }
        }
    }//GEN-LAST:event_botonExtenderDerechaActionPerformed

    private void botonExtenderAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExtenderAbajoActionPerformed
        if (this.tablero.getBotonesApretados() == 1) {
            if (this.tablero.extender('B')) {
                this.ponerAvesExtender('B');
                this.tablero.aumentarBotonesApretados();
                this.mostrarBotonesExtender(false);
                this.partida.cambiarTurnoJugador();
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
