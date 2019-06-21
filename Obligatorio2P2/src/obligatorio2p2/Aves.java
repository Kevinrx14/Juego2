/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio2p2;

import java.util.*;
import javax.swing.*;
import java.io.*;
import Interfaz.*;

/**
 *
 * @author ezequiellopez
 */
public class Aves implements Serializable {

    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;
    private int[] configuracion;

    public Aves() {
        this.setPartidas();
        this.setJugadores();
        this.setDefaultConfig();
    }

    public int[] getConfiguracion() {
        return this.configuracion;
    }

    public void setDefaultConfig() {
        this.configuracion = new int[]{2, 20, 1, 5};
    }

    public void setUnaConfiguracion(int i, int configuracion) {
        this.configuracion[i] = configuracion;
    }

    public void setConfig(int a, int b, int c, int d) {
        this.configuracion = new int[]{a, b, c, d};
    }

    public ArrayList<Partida> getPartidas() {
        return this.partidas;
    }

    public void setPartidas() {
        this.partidas = new ArrayList<>();
    }

    /*
    Configuracion segun el indice:
    0 - Cantidad de jugadores
    1 - Aves por jugador
    2 - Rotaciones por Jugador
    3 - Tableta por jugador
    4 - Tipo de terminacion
    5 - Cantidad de turnos
     */
    public void setUnaPartida(ArrayList<Jugador> jugadores) {
        int[] configuracion = this.getConfiguracion();
        this.partidas.add(new Partida(configuracion[0], configuracion[1], configuracion[2], configuracion[3], jugadores));
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores() {
        this.jugadores = new ArrayList<>();
    }

    public void setJugador(String nombre, int edad, String alias, Icon image) {
        boolean existe = false;

        for (int i = 0; i < getJugadores().size(); i++) {
            if (this.getJugadores().get(i).getAlias().equals(alias)) {
                existe = true;
            }
            if (!existe) {
                this.getJugadores().add(new Jugador(nombre, edad, alias, image));
            }
        }
    }

    public void setPartidaGanada(String alias, int cantJug) {

    }

    public void getRanking() {
        Collections.sort(jugadores);
        for (int i = 0; i < this.getJugadores().size(); i++) {
            String alias = this.getJugadores().get(i).getAlias();
            int tres = 0;
            int dos = 0;
            int uno = 0;
            String imprimo = i + 1 + "- " + this.getJugadores().get(i).toString();
            for (int j = 0; j < this.getPartidas().size(); j++) {
                for (int x = 0; x < this.getPartidas().get(j).getJugadores().size(); x++) {
                    String aliasAux = this.getPartidas().get(j).getJugadores().get(x).getAlias();
                    if (aliasAux.equals(alias)) {
                        if (this.getPartidas().get(j).getCantJug() == 4) {
                            tres = tres + 1;
                        }
                        if (this.getPartidas().get(j).getCantJug() == 3) {
                            dos = dos + 1;
                        }
                        if (this.getPartidas().get(j).getCantJug() == 2) {
                            uno = uno + 1;
                        }
                    }
                }
            }
            imprimo = imprimo + " | Partidas contra 3 jugadores: " + tres + " | Partidas contra 2 jugadores: " + dos + " | Partidas contra 1 jugador: " + uno;
            System.out.println(imprimo);
        }
    }

    public void jugar(ArrayList<Jugador> jugPartida) {
        if (jugPartida.size() > 0) {
            setUnaPartida(jugPartida);
            int indice = this.getPartidas().size() - 1;
            Partida partida = this.getPartidas().get(indice);

            partida.iniciar();
        }
    }

    public void cargar() {

    }

    public void darDiferentes(String entrada) {
        ArchivoGrabacion arch = new ArchivoGrabacion("DIFERENTES.txt");
        ArchivoLectura lect = new ArchivoLectura(entrada);
        while (lect.hayMasLineas()) {
            String validador = lect.linea();
            boolean grabar = true;
            for (int i = 0; i < jugadores.size(); i++) {
                if (!compararString(validador, jugadores.get(i).getNombre())) {
                    grabar = false;
                }
            }
            if (grabar) {
                arch.grabarLinea(validador);
            }
        }
        arch.cerrar();
        lect.cerrar();
    }

    public boolean compararString(String a, String b) {
        boolean retorno = true;
        int contador = 0;
        boolean inflexion = false;
        if (a.length() == b.length() || a.length() - 1 == b.length() || a.length() + 1 == b.length()) {
            if (a.length() == b.length()) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        contador++;
                    }
                }
                if (contador > 1) {
                    retorno = false;
                }
            }
            if (a.length() - 1 == b.length()) {
                for (int i = 0; i < b.length(); i++) {
                    if (!inflexion) {
                        if (a.charAt(i) != b.charAt(i)) {
                            inflexion = true;
                            contador++;
                        }
                    } else {
                        if (a.charAt(i) != b.charAt(i - 1)) {
                            contador++;
                        }
                    }
                }
                if (contador > 1) {
                    retorno = false;
                }
            }
            if (a.length() + 1 == b.length()) {
                for (int i = 0; i < b.length(); i++) {
                    if (!inflexion) {
                        if (a.charAt(i) != b.charAt(i)) {
                            inflexion = true;
                            contador++;
                        }
                    } else {
                        if (a.charAt(i) != b.charAt(i + 1)) {
                            contador++;
                        }
                    }
                }
                if (contador > 1) {
                    retorno = false;
                }
            }
        }
        return retorno;
    }

    public static Aves recuperarData() {
        Aves a = new Aves();
        try {
            FileInputStream fff = new FileInputStream("archivo");
            BufferedInputStream bbb = new BufferedInputStream(fff);
            ObjectInputStream sss = new ObjectInputStream(bbb);
            a = (Aves) (sss.readObject());
        } catch (Exception e) {
            VentanaError vent = new VentanaError("Error al recuperar datos");
        }
        return a;
    }
}
