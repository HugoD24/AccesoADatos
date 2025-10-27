import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejemploClaseFileWriter1 {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Pedimos ruta y nombre del fichero
            System.out.print("Introduce la ruta completa del fichero:");
            String ruta = sc.nextLine();

            File fichero = new File(ruta);

            // Comprobamos si existe
            boolean existe = fichero.exists();

            try {
                // Si existe → append = true  |  Si no existe → append = false (lo crea)
                FileWriter fw = new FileWriter(fichero, existe);

                for (int i = 1; i <= 3; i++) {
                    System.out.print("Introduce la línea " + i + ": ");
                    String linea = sc.nextLine();
                    fw.write(linea + "\n");
                }

                fw.close();

                if (existe) {
                    System.out.println("El fichero ya existía: se han añadido las líneas al final.");
                } else {
                    System.out.println("El fichero no existía: se ha creado con el contenido nuevo.");
                }

            } catch (IOException e) {
                System.out.println("Error al escribir en el fichero: " + e.getMessage());
            }

            sc.close();
        }


}
