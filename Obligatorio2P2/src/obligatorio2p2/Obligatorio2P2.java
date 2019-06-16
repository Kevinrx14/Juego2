package obligatorio2p2;
import Interfaz.*;
import java.io.*;
public class Obligatorio2P2 {

    public static void main(String[] args) {
    Aves a =new Aves();
    MenuPrincipal menu=new MenuPrincipal(a);
    menu.setVisible(true);
    }
    
}
