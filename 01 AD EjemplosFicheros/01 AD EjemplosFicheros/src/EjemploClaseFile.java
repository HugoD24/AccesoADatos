
import java.io.File;
import java.util.Scanner;

public class EjemploClaseFile {
    public static void ejemplo1(File carpeta){



        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
            return;
        }

        // --- 1º listado: todos los ficheros y directorios ---
        System.out.println("\n--- Contenido completo de la carpeta ---");
        File[] todos = carpeta.listFiles();
        if (todos != null) {
            for (File f : todos) {
                System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
            }
        }

    }

    public static void ejemplo2(File carpeta){
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio.");
            return;
        }


        File[] todos = carpeta.listFiles();
        // --- 2º listado: solo directorios no ocultos ---
        System.out.println("\n--- Solo directorios no ocultos ---");
        if (todos != null) {
            for (File f : todos) {
                if (f.isDirectory() && !f.isHidden()) {
                    System.out.println("[DIR] " + f.getName());
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la ruta de la carpeta
        System.out.print("Introduce la ruta de la carpeta: ");
        String ruta = sc.nextLine();

        File carpeta = new File(ruta);

       ejemplo1(carpeta);
        ejemplo2(carpeta);
        sc.close();
    }
}
