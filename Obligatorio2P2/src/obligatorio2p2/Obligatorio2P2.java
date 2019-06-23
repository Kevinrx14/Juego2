//237308 -Ezequiel Lopez 240179 - Kevin Rinaldi
package obligatorio2p2;
import Interfaz.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
public class Obligatorio2P2 {

    public static void main(String[] args) {
    Aves a = Aves.recuperarData();
    MenuPrincipal menu=new MenuPrincipal(a);
    menu.setVisible(true);
    }
    
}
