package obligatorio2p2;

import java.awt.Color;
import java.util.*;

public class Partida {

    private ArrayList<Jugador> jugadores;
    private int[] configuracion;
    private int turnoDeJugador;
    private int totalTurnos;

    public Partida(
            int[] unaConfiguracion,
            ArrayList<Jugador> jugadores
    ) {
        this.setConfiguracion(unaConfiguracion);
        this.setJugadores(jugadores);
        this.setConfigJugadores();
        this.setTotalTurnos(0);
        this.setTurnoDeJugador(1);
    }

    public Partida() {
        ArrayList<Jugador> jug = new ArrayList();
        this.setConfiguracion(new int[]{2, 20, 1, 5});
        this.setJugadores(jug);
        this.setConfigJugadores();
        this.setTotalTurnos(0);
        this.setTurnoDeJugador(1);
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

//    public void iniciar() {
//        System.out.println("Jugadores:");
//        for (int i = 0; i < this.getConfCantJugadores(); i++) {
//            this.mostrarColorYJugador(i);
//        }
//
//        switch (this.getConfTipoTerminacion()) {
//            case 1:
//                this.partidaConTerminacionAves();
//                break;
//            case 2:
//                this.partidaConTerminacionTurnos();
//                break;
//        }
//
//        this.terminarPartida();
//    }
//    public void partidaConTerminacionTurnos() {
//        Tablero tablero = this.getTablero();
//        boolean salidaEmergencia = false;
//
//        for (int turno = 1; turno <= this.getCantTurnos(); turno++) {
//            for (int jug = 0; jug < this.getCantJug(); jug++) {
//                System.out.println(tablero.toString());
//                System.out.print("Es el turno de ");
//                this.mostrarColorYJugador(jug);
//                //salidaEmergencia = this.movimiento(jug);
//                if (salidaEmergencia) {
//                    turno = this.getCantTurnos() + 1;
//                    jug = this.getCantJug() + 1;
//                }
//            }
//        }
//    }
//
//    public void partidaConTerminacionAves() {
//        ArrayList<Jugador> jugadores = this.getJugadores();
//        Tablero tablero = this.getTablero();
//        boolean salidaEmergencia = false;
//        boolean running = true;
//
//        do {
//            for (int jug = 0; jug <= this.getCantJug(); jug++) {
//                System.out.println(tablero.toString());
//                System.out.print("Es el turno de ");
//                this.mostrarColorYJugador(jug);
//                //salidaEmergencia = this.movimiento(jug);
//                if (salidaEmergencia) {
//                    running = false;
//                    jug = this.getCantJug() + 1;
//                }
//                if (jugadores.get(jug).getCantAves() == 0) {
//                    running = false;
//                    jug = this.getCantJug() + 1;
//                }
//            }
//        } while (running);
//    }
    public void mostrarColorYJugador(int indice) {
        //String colorJug = this.getColorJugador(indice);
        String alias = this.getJugadores().get(indice).getAlias();
        //  System.out.println(colorJug + " - " + alias);
    }

    public char[] indColores(String movimiento) {
        char[] ordenados = new char[4];
        for (int i = 0; i < 4; i++) {
            ordenados[i] = movimiento.charAt(i);
        }
        return ordenados;
    }

    /*
    public boolean movimiento(int indiceJug) {
        int[] indices;
        Interfaz interfaz = new Interfaz();
        String movimiento;
        String indicacion1 = "";
        String indicacion2 = "";
        char tipoMovimiento;
        boolean salidaEmergencia = false;
        boolean running = true;

        do {
            movimiento = interfaz.ingresarString("jugada");
            tipoMovimiento = movimiento.charAt(0);
            if (tipoMovimiento != 'X') {
                if (tipoMovimiento == 'P') {
                    if (movimiento.charAt(1) == 'M') {
                        indices = interfaz.getIndicesDeIndicacion(1, movimiento);
                        indicacion1 = movimiento.substring(indices[0], indices[1] + 1);
                        indices = interfaz.getIndicesDeIndicacion(2, movimiento);
                        indicacion2 = movimiento.substring(indices[0] + 1, indices[1]);
                    } else {
                        indicacion1 = movimiento.substring(2);
                    }
                } else {
                    indices = interfaz.getIndicesDeIndicacion(1, movimiento);
                    indicacion1 = movimiento.substring(indices[0], indices[1]);
                    indices = interfaz.getIndicesDeIndicacion(2, movimiento);
                    indicacion2 = movimiento.substring(indices[0], indices[1]);
                }
            }
            switch (tipoMovimiento) {
                //Rotar
                case 'R':
                    running = rotar(indicacion1, indicacion2, indiceJug);
                    break;
                //Conectar
                case 'C':
                    running = conectar(indicacion1, indicacion2, indiceJug);
                    break;
                //Poner tableta 
                case 'P':
                    if (movimiento.charAt(1) == 'M') {
                        running = ponerTabletaArmada(indicacion1, indicacion2);
                    } else {
                        running = ponerTableta(indicacion1);
                    }
                    break;
                //Extender 
                case 'E':
                    running = extender(indicacion1, indicacion2, indiceJug);
                    break;
                //Salir    
                case 'X':
                    salidaEmergencia = true;
                    running = false;
                    break;

            }
        } while (running);
        return salidaEmergencia;
    }

    public boolean conectar(String indicacion1, String indicacion2, int indiceJug) {
        int[] posicion1 = this.traducirPosicion(indicacion1);
        int[] posicion2 = this.traducirPosicion(indicacion2);
        boolean running = false;

        running = this.getTablero().conectar(posicion1[0], posicion1[1], posicion2[0], posicion2[1], indiceJug, this);

        return running;
    }

    public boolean extender(String indicacion1, String indicacion2, int indiceJug) {
        int[] posicion = this.traducirPosicion(indicacion2);
        char direccion = indicacion1.charAt(0);
        String colorJug = this.getColorJugador(indiceJug);
        boolean running;

        running = this.getTablero().extender(posicion[0], posicion[1], direccion, indiceJug, this);

        return running;
    }
    public int[] traducirPosicion(String posicion) {
        char[] filasChar = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        int[] devolverPosicion = new int[2];
        char fila;

        fila = posicion.charAt(0);
        devolverPosicion[1] = Integer.parseInt(posicion.substring(1)) - 1;

        for (int i = 0; i < filasChar.length; i++) {
            if (fila == filasChar[i]) {
                devolverPosicion[0] = i;
            }
        }

            return devolverPosicion;
    }
     */
    public void terminarPartida() {
        ArrayList<Jugador> jugadores = this.getJugadores();
        ArrayList<Integer> listaIndicesJug = new ArrayList<>();
        String alias;
        int aux;
        int mayor = 0;

        for (int i = 0; i < jugadores.size(); i++) {
            aux = jugadores.get(i).getCantAves();
            if (aux > mayor) {
                mayor = aux;
                listaIndicesJug = new ArrayList<>();
                listaIndicesJug.add(i);
            } else {
                if (aux == mayor) {
                    listaIndicesJug.add(i);
                }
            }
        }

        if (listaIndicesJug.size() == 1) {
            alias = jugadores.get(listaIndicesJug.get(0)).getAlias();
            System.out.println("El ganador es " + alias + "con " + mayor + " aves");
        } else {
            System.out.print("Hubo empate entre ");
            for (int i = 0; i < listaIndicesJug.size(); i++) {
                alias = this.getJugadores().get(listaIndicesJug.get(i)).getAlias();
                System.out.print(alias + " ");
                if (i == listaIndicesJug.size() - 2) {
                    System.out.print("y ");
                }
            }
            System.out.println("");
        }
    }

    public void iniciarPartida() {

    }

}
