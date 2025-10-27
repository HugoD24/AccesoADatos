package EjemploObjectStream;

import java.io.*;
import java.util.ArrayList;

public class EjemploSerializacion {
    public static void serializarObjeto(ArrayList<Producto> listaProductos){
        FileOutputStream flujoSalida = null;
        ObjectOutputStream serializador = null;
        try {
            flujoSalida = new FileOutputStream("archivo.dat");
            serializador = new ObjectOutputStream(flujoSalida);

            //Escribo el ArrayList completo
            serializador.writeObject(listaProductos);

        } catch (IOException ioe) {
            System.out.println("Error en la salida de datos");
        } finally {
            if (serializador != null)
                try {
                    serializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }
    }

    public static ArrayList<Producto> deserializarObjetos(){
        ArrayList<Producto> listaProductos = null;

        FileInputStream flujoEntrada = null;
        ObjectInputStream deserializador = null;

        try {
            flujoEntrada = new FileInputStream("archivo.dat");
            deserializador = new ObjectInputStream(flujoEntrada);

            //Leo el ArrayList
            listaProductos = (ArrayList<Producto>)deserializador.readObject();


        } catch (FileNotFoundException fnfe ) {
            fnfe.printStackTrace();
        } catch (ClassNotFoundException cnfe ) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (deserializador != null)
                try {
                    deserializador.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
        }

        return listaProductos;
    }

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Leche", 1.15f));
        productos.add(new Producto("Pan", 0.95f));
        productos.add(new Producto("Café", 3.75f));
        productos.add(new Producto("Huevos", 2.49f));

        serializarObjeto(productos);
        System.out.println("Productos serializados a archivo de datos");
        ArrayList<Producto> productosLeidos = new ArrayList<>();
        productosLeidos=deserializarObjetos();
        System.out.println("Listado de productos leidos de archivo de datos");
        for (Producto p:productosLeidos){
            System.out.printf("%s - %.2f €%n", p.getNombre(), p.getPrecio());
        }
    }
}
