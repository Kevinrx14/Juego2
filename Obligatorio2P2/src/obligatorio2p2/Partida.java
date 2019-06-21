package obligatorio2p2;

import java.awt.Color;
import java.util.*;

public class Partida {

    private ArrayList<Jugador> jugadores;
    private int[] configuracion;
    private int turnoDeJugador;
    private int totalTurnos;
    private boolean partidaEnCurso;
    private boolean partidaTerminada;

    public Partida(
            int[] unaConfiguracion,
            ArrayList<Jugador> jugadores
    ) {
        this.setConfiguracion(unaConfiguracion);
        this.setJugadores(jugadores);
        this.setConfigJugadores();
        this.setTotalTurnos(0);
        this.setTurnoDeJugador(1);
        this.setPartidaEnCurso(true);
        this.setPartidaTerminada(false);
    }

    public Partida() {
        ArrayList<Jugador> jug = new ArrayList();
        this.setConfiguracion(new int[]{2, 20, 1, 5});
        this.setJugadores(jug);
        this.setConfigJugadores();
        this.setTotalTurnos(0);
        this.setTurnoDeJugador(1);
        this.setPartidaEnCurso(true);
        this.setPartidaTerminada(false);
    }

    public boolean getPartidaEnCurso() {
        return this.partidaEnCurso;
    }

    public void setPartidaEnCurso(boolean enCurso) {
        this.partidaEnCurso = enCurso;
    }

    public boolean getPartidaTerminada() {
        return this.partidaTerminada;
    }

    public void setPartidaTerminada(boolean terminada) {
        this.partidaTerminada = terminada;
    }

    public int[] getConfiguracion() {
        return this.configuracion;
    }

    public void setConfiguracion(int[] unaConfiguracion) {
        this.configuracion = unaConfiguracion;
    }

    public int getConfCantJugadores() {
        return this.configuracion[0];
    }

    public int getConfAvesJugador() {
        return this.configuracion[1];
    }

    public int getConfTipoTerminacion() {
        return this.configuracion[2];
    }

    public int getConfCantTurno() {
        return this.configuracion[3];
    }

    public int getTurnoDeJugador() {
        return this.turnoDeJugador;
    }

    public void setTurnoDeJugador(int jugador) {
        this.turnoDeJugador = jugador;
    }

    public void cambiarTurnoJugador() {
        int aux = this.getTurnoDeJugador();
        if (aux == this.getConfCantJugadores()) {
            aux = 0;
        }
        aux++;
        this.setTurnoDeJugador(aux);
    }

    public int getTotalTurnos() {
        return this.totalTurnos;
    }

    public void setTotalTurnos(int turnos) {
        this.totalTurnos = turnos;
    }

    public void aumentarTotalTurnos() {
        int aux = this.getTotalTurnos();
        aux++;
        this.setTotalTurnos(aux);
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(ArrayList<Jugador> todosJug) {
        this.jugadores = todosJug;
    }

    //Metodo que setea la cantidad de rotaciones, tabletas y aves disponibles por jugador
    public void setConfigJugadores() {
        ArrayList<Jugador> jugadores = this.getJugadores();

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setCantAves(this.getConfAvesJugador());
        }
        this.setColorJugadores();
    }

    public Color getColorJugador(int indice) {
        return this.getJugadores().get(indice).getColorJugador();
    }

    public void setColorJugadores() {
        Random rand = new Random();
        Color aux = Color.WHITE;
        int[] colores = new int[this.getConfCantJugadores()];
        int num;
        boolean validador;

        for (int i = 0; i < this.getConfCantJugadores(); i++) {
            do {
                validador = true;
                num = rand.nextInt(4);
                num++;
                for (int x = 0; x < i; x++) {
                    if (colores[x] == num) {
                        validador = false;
                    }
                }
            } while (!validador);
            colores[i] = num;
            switch (colores[i]) {
                case 1:
                    aux = Color.RED;
                    break;

                case 2:
                    aux = Color.BLUE;
                    break;

                case 3:
                    aux = Color.YELLOW;
                    break;

                case 4:
                    aux = Color.GREEN;
                    break;
            }

            this.getJugadores().get(i).setColorJug(aux);
        }
    }

    public boolean terminarPartida() {
        boolean terminar = false;

        switch (this.getConfTipoTerminacion()) {
            //Cantidad de aves
            case 1:
                int avesJug = this.getJugadores().get(this.getTurnoDeJugador()).getCantAves();
                if (avesJug == this.getConfAvesJugador()) {
                    this.setPartidaEnCurso(false);
                    this.setPartidaTerminada(true);
                }
                break;
            //Cantidad de turnos
            case 2:
                if (this.getTotalTurnos() == this.getConfCantTurno()) {
                    this.setPartidaEnCurso(false);
                    this.setPartidaTerminada(true);
                }
                break;
        }

        return terminar;
    }
}
