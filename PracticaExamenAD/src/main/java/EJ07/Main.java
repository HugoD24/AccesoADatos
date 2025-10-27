package EJ07;



/*A07. Aplicación de alumnado de un centro. Un alumno está formado por la siguiente
información: NRE, Nombre, Apellidos, Teléfono, Fecha de nacimiento y Beca que será un
valor que indicará si tiene o no beca. Tenemos que hacer una aplicación que muestre un menú
por terminal con las siguientes opciones:
• 0 - Finaliza la aplicación
• 1 - Alta alumno. La aplicación pedirá todos los datos del alumno y lo insertará en la base
de datos de alumnos (será un fichero) siempre y cuando no se encuentre.
• 2 - Eliminar alumno. La aplicación nos pedirá un NRE y eliminará dicho alumno si
existe.
• 3 - Modificar alumno. Para ello la aplicación nos pedirá un NRE y si dicho alumno existe
nos pedirá confirmación de que se quiere modificar (podemos ver la modificación en
eliminar el alumno y posteriormente pedir los datos para insertarlo, es decir, proceder a su
alta).
• 4 - Listar alumnos. La aplicación nos devolverá un listado de todos los alumnos
ordenados alfabéticamente por apellidos y nombre.*/


import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {

        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        int seleccion;

        Alumno alumno1 = new Alumno("49823966D", "Hugo", "Desiderio Garcia", "638523367", LocalDate.of(2003, 02, 24), true);
        listaAlumnos.add(alumno1);
        Alumno alumno2 = new Alumno("49823833F", "Juan", "Fernandez Gil", "618245628", LocalDate.of(1999,04,18),false);
        listaAlumnos.add(alumno2);
        Alumno alumno3 = new Alumno("47235766R","Pepe", "Garcia Romero", "617250258", LocalDate.of(2001,11,10),false);
        listaAlumnos.add(alumno3);

    do {
        System.out.println("Bienvenido al sistema de gestion de alumnos");
        System.out.println("Que acción deseas realizar: ");
        System.out.println("0 - Finalizar app");
        System.out.println("1 - Alta alumno");
        System.out.println("2 - Eliminar alumno");
        System.out.println("3 - Modificar alumno");
        System.out.println("4 - Listar alumnos");

        System.out.println("Selecciona una opcion");
        seleccion = sc.nextInt();

            switch (seleccion) {
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                case 1:
                    System.out.println("Has seleccionado: Alta alumno");
                    break;
                case 2:
                    System.out.println("Has seleccionado: Eliminar alumno");
                    break;
                case 3:
                    System.out.println("Has seleccionado: Modificar alumno");
                    break;
                case 4:
                    System.out.println("Has seleccionado: Listar alumnos");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");

            }

        }  while (seleccion != 0);




        File fichero = new File("ejercicioPractica.dat");

    }
}
