
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EjemploClaseFicheroBinario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la ruta de la carpeta
        System.out.print("Introduce la ruta  y el nombre del fichero: ");
        String ruta = sc.nextLine();

        // File fichero = new File(ruta);

        try {
            // --- ESCRIBIR los múltiplos de 7 ---
            FileOutputStream fos = new FileOutputStream(ruta);

            for (int i = 1; i <= 100; i++) {
                if (i % 7 == 0) {
                         // Convertimos a texto con salto de línea
                    fos.write(i);        // Escribimos los bytes del texto
                }
            }

            fos.close();
            System.out.println("Se han escrito los múltiplos de 7 en el fichero.");

            // --- LEER el contenido del fichero ---
            FileInputStream fis = new FileInputStream(ruta);

            int byteLeido;
            System.out.println("\n--- Contenido del fichero ---");
            while ((byteLeido = fis.read()) != -1) {
                System.out.print( byteLeido);
            }

            fis.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
