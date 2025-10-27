import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjemploClaseBufferedReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la ruta de la carpeta
        System.out.print("Introduce la ruta  y el nombre del fichero: ");
        String ruta = sc.nextLine();

        // File fichero = new File(ruta);

        try {
            FileReader fr = new FileReader(ruta);

            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();
            while (linea!=null){
                System.out.println(linea);
                linea=br.readLine();
            }
            br.close();
            fr.close(); // Cerramos el flujo
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }


        sc.close();
    }
}
