import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjemploClaseFileWriter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la ruta de la carpeta
        System.out.print("Introduce la ruta  y el nombre del fichero: ");
        String ruta = sc.nextLine();

        // File fichero = new File(ruta);

        try {
            FileWriter fr = new FileWriter(ruta);


            // Pedimos tres cadenas por teclado
            for (int i = 1; i <= 3; i++) {
                System.out.print("Introduce la cadena " + i + ": ");
                String texto = sc.nextLine();
                fr.write(texto + "\n"); // Escribimos cada cadena en una nueva línea
            }

            fr.close(); // Cerramos el fichero
            System.out.println("Se han escrito las 3 cadenas en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }


        sc.close();
    }
}
