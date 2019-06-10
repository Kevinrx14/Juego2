package obligatorio2p2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Tablero {

    private boolean movimientoDisponible;
    private int botonesApretados;
    private int fila1;
    private int columna1;
    private int fila2;
    private int columna2;

    public Tablero() {
        this.setMovimientoDisponible(true);
    }

    public void setFila1(int fila) {
        this.fila1 = fila;
    }

    public int getFila1() {
        return this.fila1;
    }

    public void setColumna1(int columna) {
        this.columna1 = columna;
    }

    public int getColumna1() {
        return this.columna1;
    }

    public void setFila2(int fila) {
        this.fila2 = fila;
    }

    public int getFila2() {
        return this.fila2;
    }

    public void setColumna2(int columna) {
        this.columna2 = columna;
    }

    public int getColumna2() {
        return this.columna2;
    }

    public void setMovimientoDisponible(boolean disponible) {
        this.movimientoDisponible = disponible;
    }

    public boolean getMovimientoDisponible() {
        return this.movimientoDisponible;
    }

    public void setBotonesApretados() {
        this.botonesApretados++;
        if (this.botonesApretados > 1) {
            this.setMovimientoDisponible(false);
        }
    }

    public int getBotonesApretados() {
        return this.botonesApretados;
    }

    public boolean conectar(JButton[][] botones) {
        String[][] coloresBotones = this.getColoresBotones(botones);
        String color1 = coloresBotones[this.getFila1()][this.getColumna1()];
        String color2 = coloresBotones[this.getFila2()][this.getColumna2()];
        boolean sePuedeConectar = false;

        if (validarColor(color1, color2) && validarColor(color2, color1)) {
            if (validarFila()) {
                sePuedeConectar = this.sePuedeConectarFila(botones, color1);
            } else {
                if (validarColumna()) {
                    sePuedeConectar = this.sePuedeConectarColumna(botones, color1);
                }
            }
        }
        
        return sePuedeConectar;
    }

    public boolean validarFila() {
        boolean validador = false;

        if (this.getFila1() == this.getFila2()) {
            validador = true;
        }

        return validador;
    }

    public boolean validarColumna() {
        boolean validador = false;

        if (this.getColumna1() == this.getColumna2()) {
            validador = true;
        }

        return validador;
    }

    public boolean validarColor(String color1, String color2) {
        boolean validador = false;

        if (color1.equals(color2)) {
            validador = true;
        }
        return validador;
    }

    public String[][] getColoresBotones(JButton[][] botones) {
        String[][] colores = new String[botones.length][botones[0].length];

        for (int i = 1; i < botones.length; i++) {
            for (int j = 1; j < botones[0].length; j++) {
                colores[i][j] = botones[i][j].getBackground().toString();
            }
        }

        return colores;
    }

    public String[][] getTextoBotones(JButton[][] botones) {
        String[][] texto = new String[botones.length][botones[0].length];

        for (int i = 1; i < botones.length; i++) {
            for (int j = 1; j < botones[0].length; j++) {
                texto[i][j] = botones[i][j].getText();
            }
        }

        return texto;
    }

    public boolean validarSiHayAves(String[][] tablero) {
        boolean validador = true;

        if (this.validarSiEsMismaFila()) {

        } else {
            if (this.validarSiEsMismaColumna()) {

            }
        }

        return validador;
    }

    public boolean validarSiEsMismaFila() {
        return this.getFila1() == this.getFila2();
    }

    public boolean validarSiEsMismaColumna() {
        return this.getColumna1() == this.getColumna2();
    }

    public boolean validarSiEstanDiagonal() {
        boolean validador = true;

        if (this.validarSiEsMismaColumna() || this.validarSiEsMismaFila()) {
            validador = false;
        }

        return validador;
    }

    public boolean sePuedeConectarFila(JButton[][] botones, String color1) {
        String[][] coloresBotones = this.getColoresBotones(botones);
        String[][] textoBotones = this.getTextoBotones(botones);
        boolean validador = false;

        for (int j = this.getColumna1(); j <= this.getColumna2(); j++) {
            if (coloresBotones[this.getFila1()][j].equals(color1)) {
                if (textoBotones[this.getFila1()][j].isEmpty()) {
                    validador = true;
                }
            }
        }

        return validador;
    }
    
    public boolean sePuedeConectarColumna(JButton[][] botones, String color1) {
        String[][] coloresBotones = this.getColoresBotones(botones);
        String[][] textoBotones = this.getTextoBotones(botones);
        boolean validador = false;

        for (int i = this.getFila1(); i <= this.getFila2(); i++) {
            if (coloresBotones[i][this.getColumna1()].equals(color1)) {
                if (textoBotones[i][this.getColumna1()].isEmpty()) {
                    validador = true;
                }
            }
        }

        return validador;
    }
    
    public Color[] getColoresRandom() {
        Random rand = new Random();
        int[][] tabletaAux = new int[2][2];
        Color[] colores = new Color[4];
        int num;
        int indice = 0;
        boolean validador;

        for (int i = 0; i < tabletaAux.length; i++) {
            for (int j = 0; j < tabletaAux[0].length; j++) {
                do {
                    validador = true;
                    num = rand.nextInt(4);
                    num++;
                    for (int x = 0; x < tabletaAux.length; x++) {
                        for (int y = 0; y < tabletaAux[0].length; y++) {
                            if (tabletaAux[x][y] == num) {
                                validador = false;
                            }
                        }
                    }
                } while (!validador);
                tabletaAux[i][j] = num;
                switch (tabletaAux[i][j]) {
                    case 1:
                        colores[indice] = Color.RED;
                        break;

                    case 2:
                        colores[indice] = Color.BLUE;
                        break;

                    case 3:
                        colores[indice] = Color.YELLOW;
                        break;

                    case 4:
                        colores[indice] = Color.GREEN;
                        break;
                }
                indice++;
            }
        }
        return colores;
    }
}
