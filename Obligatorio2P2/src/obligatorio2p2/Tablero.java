//237308 -Ezequiel Lopez 240179 - Kevin Rinaldi
package obligatorio2p2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Tablero implements Serializable {

    private JButton botones[][];
    private boolean movimientoDisponible;
    private int botonesApretados;
    private int fila1;
    private int columna1;
    private int fila2;
    private int columna2;

    public Tablero(JButton[][] matBotones) {
        this.setMovimientoDisponible(true);
        this.setBotones(matBotones);
    }

    public void setBotones(JButton[][] matBotones) {
        this.botones = matBotones;
    }

    public JButton[][] getBotones() {
        return this.botones;
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

    public void setBotonesApretados(int num) {
        this.botonesApretados = num;
    }

    public void aumentarBotonesApretados() {
        this.setBotonesApretados(this.getBotonesApretados() + 1);
        if (this.getBotonesApretados() > 1) {
            this.setMovimientoDisponible(false);
            this.setBotonesApretados(0);
        }
    }

    public int getBotonesApretados() {
        return this.botonesApretados;
    }

    public boolean conectar() {
        boolean sePuedeConectar = false;

        if (this.validadorDeConectar()) {
            if (this.validarFila()) {
                sePuedeConectar = this.sePuedeConectarFila();
            } else {
                if (this.validarColumna()) {
                    sePuedeConectar = this.sePuedeConectarColumna();
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

    public boolean validarColor(Color color1, Color color2) {
        boolean validador = false;

        if (color1.equals(color2)) {
            validador = true;
        }
        return validador;
    }

    public Color[][] getColoresBotones() {
        JButton[][] tablero = this.getBotones();
        Color[][] colores = new Color[tablero.length][tablero[0].length];

        for (int i = 1; i < tablero.length; i++) {
            for (int j = 1; j < tablero[0].length; j++) {
                colores[i][j] = tablero[i][j].getBackground();
            }
        }

        return colores;
    }

    public String[][] getTextoBotones() {
        JButton[][] tablero = this.getBotones();
        String[][] texto = new String[tablero.length][tablero[0].length];

        for (int i = 1; i < tablero.length; i++) {
            for (int j = 1; j < tablero[0].length; j++) {
                texto[i][j] = tablero[i][j].getText();
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

    public boolean sePuedeConectarFila() {
        String[][] textoBotones = this.getTextoBotones();
        boolean validador = true;

        for (int j = this.getColumna1(); j <= this.getColumna2(); j++) {
            if (!textoBotones[this.getFila1()][j].isEmpty()) {
                validador = false;
            }
        }

        return validador;
    }

    public boolean sePuedeConectarColumna() {
        String[][] textoBotones = this.getTextoBotones();
        boolean validador = true;

        for (int i = this.getFila1(); i <= this.getFila2(); i++) {
            if (!textoBotones[i][this.getColumna1()].isEmpty()) {
                validador = false;
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

    public boolean validadorDeConectar() {
        boolean validador = false;
        Color color1 = this.getColoresBotones()[this.getFila1()][this.getColumna1()];
        Color color2 = this.getColoresBotones()[this.getFila2()][this.getColumna2()];

        if (!this.sonElMismoBoton()) {
            if (this.validarColumna() || this.validarFila()) {
                if (this.validarColor(color1, color2)) {
                    validador = true;
                }
            }
        }

        return validador;
    }

    public boolean extender(char direccion) {
        int[] extenderHasta = this.extenderHasta(direccion);
        boolean sePuedeExtender = false;

        if (this.hayAveConsecutiva(extenderHasta, direccion)) {
            sePuedeExtender = true;
        }

        return sePuedeExtender;
    }

    public boolean sonElMismoBoton() {
        boolean validador = false;

        if (this.validarFila() && this.validarColumna()) {
            validador = true;
        }

        return validador;
    }

    public boolean filaDecreciente() {
        return this.getFila1() > this.getFila2();
    }

    public boolean columnaDecreciente() {
        return this.getColumna1() > this.getColumna2();
    }

    public int[] extenderHasta(char direccion) {
        String[][] tablero = this.getTextoBotones();
        int[] ubicacion = new int[]{this.getFila1(), this.getColumna1()};

        switch (direccion) {
            case 'A':
                for (int i = this.getFila1(); i > 0; i--) {
                    if (tablero[i][this.getColumna1()].equals("X")) {
                        ubicacion[0] = i;
                        i = 0;
                    }
                }
                break;
            case 'B':
                for (int i = this.getFila1(); i < tablero.length; i++) {
                    if (tablero[i][this.getColumna1()].equals("X")) {
                        ubicacion[0] = i;
                        i = tablero.length;
                    }
                }
                break;
            case 'I':
                for (int i = this.getColumna1(); i > 0; i--) {
                    if (tablero[this.getFila1()][i].equals("X")) {
                        ubicacion[1] = i;
                        i = 0;
                    }
                }
                break;
            case 'D':
                for (int i = this.getColumna1(); i < tablero[0].length; i++) {
                    if (tablero[this.getFila1()][i].equals("X")) {
                        ubicacion[1] = i;
                        i = tablero[0].length;
                    }
                }
                break;
        }

        return ubicacion;
    }

    public boolean hayAveConsecutiva(int[] extenderHasta, char direccion) {
        boolean hayAve = false;
        String[][] textoBotones = this.getTextoBotones();
        Color[][] colorBotones = this.getColoresBotones();
        Color color = colorBotones[extenderHasta[0]][extenderHasta[1]];

        try {
            switch (direccion) {
                case 'A':
                    if (textoBotones[extenderHasta[0] - 1][extenderHasta[1]].equals("X")) {
                        if (colorBotones[extenderHasta[0] - 1][extenderHasta[1]].equals(color)) {
                            hayAve = true;
                        }
                    }
                    break;
                case 'B':
                    if (textoBotones[extenderHasta[0] + 1][extenderHasta[1]].equals("X")) {
                        if (colorBotones[extenderHasta[0] + 1][extenderHasta[1]].equals(color)) {
                            hayAve = true;
                        }
                    }
                    break;
                case 'I':
                    if (textoBotones[extenderHasta[0]][extenderHasta[1] - 1].equals("X")) {
                        if (colorBotones[extenderHasta[0]][extenderHasta[1] - 1].equals(color)) {
                            hayAve = true;
                        }
                    }
                    break;
                case 'D':
                    if (textoBotones[extenderHasta[0]][extenderHasta[1] + 1].equals("X")) {
                        if (colorBotones[extenderHasta[0]][extenderHasta[1] + 1].equals(color)) {
                            hayAve = true;
                        }
                    }
                    break;
            }
        } catch(NullPointerException e) {
            
        }

        return hayAve;
    }
}
