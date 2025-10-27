import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploClaseFileReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la ruta de la carpeta
        System.out.print("Introduce la ruta  y el nombre del fichero: ");
        String ruta = sc.nextLine();

       // File fichero = new File(ruta);

        try {
            FileReader fr = new FileReader(ruta);

            int c; // Aquí guardaremos cada carácter leído
            System.out.println("--- Contenido del fichero ---");
            while ((c = fr.read()) != -1) {
                System.out.print((char) c); // Convertimos el código numérico a carácter
            }

            fr.close(); // Cerramos el flujo
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }


        sc.close();
    }
}
