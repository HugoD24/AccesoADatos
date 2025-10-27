package File;
import java.io.File;

public class Pruebas {
    public static void main(String[] args) {

        File f = new File("carpeta");
        System.out.println(f.isDirectory());

        File f2 = new File("datos.txt");
        System.out.println(f2.isFile());


    }
}
