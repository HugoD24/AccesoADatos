package File;

import java.io.File;
import java.io.IOException;

public class InfoFile {
    public static void main(String[] args) {
        File f = new File("datos.txt");

        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (f.exists()) {
            System.out.println("Nombre: " + f.getName());
            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
            System.out.println("¿Es fichero? " + f.isFile());
            System.out.println("Es directorio? " + f.isDirectory());
        }else {
            System.out.println("No existe el archivo");
        }
    }
}
