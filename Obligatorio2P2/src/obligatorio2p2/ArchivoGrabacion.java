//Kevin Rinaldi - 240179
//Ezequiel Lopez - 237308
package obligatorio2p2;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion(String unNombre) {
        try {
            out = new Formatter(unNombre);
        } catch (FileNotFoundException e) {
            System.exit(1);
        } catch (SecurityException e) {
            System.exit(1);
        }
    }

    public void grabarLinea(String linea) {
        out.format("%s%n", linea);
    }

    public void cerrar() {
        out.close();
    }
}
