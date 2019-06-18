package obligatorio2p2;
import Interfaz.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Obligatorio2P2 {

    public static void main(String[] args) {
    Aves a =new Aves();
    ArchivoLectura lect=new ArchivoLectura("Jugadores.txt");
    while (lect.hayMasLineas()){
        String[] linea=lect.linea().split(",");
        int edad=Integer.parseInt(linea[1]);
        int totalPartidas=Integer.parseInt(linea[4]);
        Jugador j=new Jugador(linea[0], edad, linea[3], linea[2]);
        j.setTotalPartidas(totalPartidas);
        a.getJugadores().add(j);
    }
    lect.cerrar();
    MenuPrincipal menu=new MenuPrincipal(a);
    menu.setVisible(true);
    }
    
}
