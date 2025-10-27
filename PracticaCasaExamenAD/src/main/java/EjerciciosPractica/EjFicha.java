package EjerciciosPractica;

/*A04. Crear un programa que reciba el nombre de un fichero y una palabra (esta palabra se
debe pedir en el programa por terminal) y nos devuelva un entero con la fila en la que la
cadena se encuentra (si no se encuentra devuelve -1)*/

import java.io.*;
import java.util.Scanner;

public class EjFicha {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la palabra a buscar: ");
        String palabraBuscar = sc.nextLine();


        String RutaFichero = "src/main/java/EjerciciosPractica/FicheroEj";


        int num = metodoBuscar(RutaFichero,palabraBuscar);
        System.out.println(num);

    }

    public static int metodoBuscar(String nombreFichero, String palabraBusc){

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
            String linea = br.readLine();
            int contador = 0;

            while (linea != null) {
                contador++;
                if (linea.contains(palabraBusc)) {
                    return contador;
                }
                linea = br.readLine();
            }
            br.close();
            return -1;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
