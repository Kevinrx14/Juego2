//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package obligatorio2p2;

import java.awt.Color;
import javax.swing.*;
import java.io.Serializable;

public class Jugador implements Serializable, Comparable {

    private String nombre;
    private String alias;
    private Color colorJug;
    private ImageIcon image;
    private int edad;
    private int cantAves;
    private int totalPartidas;
    private int contra1;
    private int contra2;
    private int contra3;
    private int ganadas;

    public Jugador(String nombre, int edad, String alias, ImageIcon image) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setAlias(alias);
        this.setImage(image);
        this.setContra1(0);
        this.setContra2(0);
        this.setContra3(0);
        this.setGanadas(0);

    }

    public int getContra1() {
        return contra1;
    }

    public void setContra1(int contra1) {
        this.contra1 = contra1;
    }

    public int getContra2() {
        return contra2;
    }

    public void setContra2(int contra2) {
        this.contra2 = contra2;
    }

    public int getContra3() {
        return contra3;
    }

    public void setContra3(int contra3) {
        this.contra3 = contra3;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getCantAves() {
        return this.cantAves;
    }

    public void setCantAves(int cantAves) {
        this.cantAves = cantAves;
    }

    public int getTotalPartidas() {
        return this.totalPartidas;
    }

    public void setTotalPartidas(int unaCant) {
        this.totalPartidas = unaCant;
    }

    public Color getColorJugador() {
        return this.colorJug;
    }

    public void setColorJug(Color color) {
        this.colorJug = color;
    }

    @Override
    public boolean equals(Object o) {
        return (this.getNombre() == ((Jugador) o).getNombre());
    }

    @Override
    public int compareTo(Object o) {
        return this.getTotalPartidas() - ((Jugador) o).getTotalPartidas();
    }

    @Override
    public String toString() {
        return this.getAlias();
    }
}
