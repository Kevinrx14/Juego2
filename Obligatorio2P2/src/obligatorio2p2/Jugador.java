/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio2p2;
import java.awt.Color;
import javax.swing.*;
/**
 *
 * @author ezequiellopez
 */
public class Jugador implements Comparable {
  private String nombre;
    private String alias;
    private Color colorJug;
    private String image;
    private int edad;
    private int cantAves;
    private int totalPartidas;

    public Jugador(String nombre, int edad, String alias, String image) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setAlias(alias);
        this.setImage(image);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

