/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio2p2;

import java.util.*;
import javax.swing.*;
import java.io.*;
import java.io.*;
import Interfaz.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class Aves implements Serializable {

    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;
    //0 - Cant Jugadores
    //1 - Cant aves por jugador
    //2 - tipo de terminacion
    //3 - cant turnos por jugador
    private int[] configuracion;

    public Aves() {
        this.setPartidas();
        this.setJugadores();
        this.setDefaultConfig();
    }

    public void excel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datos = new Object[this.getJugadores().size() + 1][8];
        datos[0][0] = "NOMBRE";
        datos[0][1] = "EDAD";
        datos[0][2] = "ALIAS";
        datos[0][3] = "JUGADAS CONTRA 3";
        datos[0][4] = "JUGADAS CONTRA 2";
        datos[0][5] = "JUGADAS CONTRA 1";
        datos[0][6] = "TOTAL DE GANADAS";

        for (int i = 0; i < this.getJugadores().size(); i++) {
            datos[i + 1][0] = this.getJugadores().get(i).getNombre();
            datos[i + 1][1] = this.getJugadores().get(i).getEdad();
            datos[i + 1][2] = this.getJugadores().get(i).getAlias();
            datos[i + 1][3] = this.getJugadores().get(i).getContra3();
            datos[i + 1][4] = this.getJugadores().get(i).getContra2();
            datos[i + 1][5] = this.getJugadores().get(i).getContra1();
            datos[i + 1][6] = this.getJugadores().get(i).getGanadas();
        }

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datos) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("Puntuaciones.xls");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
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
    public void setUnaPartida(Partida unaPartida) {
        this.partidas.add(unaPartida);
    }

    public ArrayList<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores() {
        this.jugadores = new ArrayList<>();
    }

    public void setJugador(String nombre, int edad, String alias, ImageIcon image) {
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
            int ganadas = 0;
            for (int j = 0; j < this.getPartidas().size(); j++) {
                for (int x = 0; x < this.getPartidas().get(j).getJugadores().size(); x++) {
                    String aliasAux = this.getPartidas().get(j).getJugadores().get(x).getAlias();
                    if (aliasAux.equals(alias)) {
                        if (this.getPartidas().get(j).getConfCantJugadores() == 4) {
                            tres = tres + 1;
                        }
                        if (this.getPartidas().get(j).getConfCantJugadores() == 3) {
                            dos = dos + 1;
                        }
                        if (this.getPartidas().get(j).getConfCantJugadores() == 2) {
                            uno = uno + 1;
                        }
                        if (this.getPartidas().get(j).getGanador().equals(this.getJugadores().get(i))) {
                            ganadas = ganadas + 1;
                        }

                    }
                }
            }
            this.getJugadores().get(i).setContra3(tres);
            this.getJugadores().get(i).setContra2(dos);
            this.getJugadores().get(i).setContra1(uno);
            this.getJugadores().get(i).setGanadas(ganadas);

        }
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
