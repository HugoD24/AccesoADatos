package EjemploFicherosXML;



import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EjemploFicheroXML {
    public static void generarFicheroXML(ArrayList<Producto> listaProductos){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        DOMImplementation dom = builder.getDOMImplementation();

        //Creo un documento XML y creo el nodo raiz "productos"
        Document documento = dom.createDocument(null, "xml", null);
        Element raiz = documento.createElement("productos");
        documento.getDocumentElement().appendChild(raiz);

        Element nodoProducto = null;
        Element nodoDatos = null ;
        Text texto = null;

        //Recorro la lista de productos y creo un subnodo producto por cada elemento
        for (Producto producto : listaProductos) {
            nodoProducto = documento.createElement("producto");
            raiz.appendChild(nodoProducto);

            //Por cada dato de cada producto creo un nuevo subnodo
            nodoDatos = documento.createElement("nombre");
            nodoProducto.appendChild(nodoDatos);
            texto = documento.createTextNode(producto.getNombre());
            nodoDatos.appendChild(texto);

            nodoDatos = documento.createElement("precio");
            nodoProducto.appendChild(nodoDatos);
            texto = documento.createTextNode(String.valueOf(producto.getPrecio()));
            nodoDatos.appendChild(texto);
        }

        //Finalizo el documento xml y lo guardo en un fichero de texto
        DOMSource src = new DOMSource(documento);
        Result resultado = new StreamResult(new File("fichero.xml"));


        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(src, resultado);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Producto> leerFicheroXML(String rutaFichero){
        ArrayList<Producto> listaProducto=new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document documento=null;
        try {
            builder = factory.newDocumentBuilder();
             documento =  builder.parse(new File(rutaFichero));
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        //Recorro cada uno de los elementos producto para obtener sus campos
        NodeList productos = documento.getElementsByTagName("producto");
        for (int i = 0; i < productos.getLength(); i++) {
            Node producto = productos.item( i );

            Element elemento = ( Element ) producto;
            Producto p=new Producto(elemento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue(),Float.valueOf(elemento.getElementsByTagName("precio").item(0).getChildNodes().item(0).getNodeValue()));
            listaProducto.add(p);
        }
        return listaProducto;
    }
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Leche", 1.15f));
        productos.add(new Producto("Pan", 0.95f));
        productos.add(new Producto("Café", 3.75f));
        productos.add(new Producto("Huevos", 2.49f));
        generarFicheroXML(productos);
        System.out.println("Fichero XML generado correctamente");
        ArrayList<Producto> listaProducto=leerFicheroXML("fichero.xml");
        for (Producto p:listaProducto){
            System.out.printf("%s - %.2f €%n", p.getNombre(), p.getPrecio());
        }


    }
}
