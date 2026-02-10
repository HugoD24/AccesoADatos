package vista;

import entidades.Empleado;
import servicio.EmpleadoService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmpleadoService logica = new EmpleadoService();
        Empleado empleado = new Empleado("Juan García", 2400L, "Ventas");
        //ejercicio1(logica, empleado);
        //ejercicio2(logica, 1);
        //ejercicio3(logica,1,1000);
        //ejercicio4(logica, 30000L);
        //ejercicio5(logica);
        ejercicio6(logica,"Juan García");
    }

    public static void ejercicio1(EmpleadoService es, Empleado e){
        if(es.insertarEmpleado(e)){
            System.out.println("Empleado insertado");
        }
    }
    public static void ejercicio2(EmpleadoService es, int id){
        Empleado empleado = es.getEmpleadoById(id);
        if (empleado != null){
            System.out.println(empleado);
        }
    }
    public static void ejercicio3(EmpleadoService es, int id, long salarioSumar){
        if(es.actualizarEmpleado(id, salarioSumar)){
            System.out.println("Salario del empleado actualizado");
        }else {
            System.out.println("No modificado");
        }
    }
    public static void ejercicio4(EmpleadoService es, Long salario){
        List<Empleado> listaEmpleados = es.obtenerEmpleadosSalarioSuperior(salario);
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }
    public static void ejercicio5(EmpleadoService es){
        List<Empleado> listaEmpleados = es.obtenerEmpleadosVentas();
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }
    public static void ejercicio6(EmpleadoService es, String nombre){
        if(es.eliminarEmpleado(nombre)){
            System.out.println("Empleado eliminado");
        }else  {
            System.out.println("No eliminado");
        }
    }
}
