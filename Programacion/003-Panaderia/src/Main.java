import Almacen.Almacen;
import Pedido.Pedido;
import Producto.Producto;
import pojo.Magdalena;
import pojo.MagdalenaFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Magdalena magdalena1 = new Magdalena("Chocolate", "Marrón");
        Magdalena magdalena2 = new Magdalena("Vainilla", "Crema");
        Magdalena magdalena3 = new Magdalena("Fresa", "Rosa");
        Magdalena magdalena4 = new Magdalena("Limón", "Amarilla");

        MagdalenaFactory magdalenaFactory = new MagdalenaFactory();

        magdalenaFactory.addMagdalena(magdalena1);
        magdalenaFactory.addMagdalena(magdalena2);
        magdalenaFactory.addMagdalena(magdalena3);
        magdalenaFactory.addMagdalena(magdalena4);
        magdalenaFactory.printMagdalena();

        Producto magdalena = new Producto("Magdalena de chocolate",1.50, 10);
        Producto croissant = new Producto("Croissant de fresa" ,1.20,15);
        Producto galleta = new Producto("Galleta de chocolate",2.00,25);

        System.out.println(magdalena.getNombre());
        magdalena.setStock(25);
        System.out.println(magdalena.toString());
        System.out.println(croissant.toString());
        System.out.println(galleta.toString());

        //Crear un pedido con capacidad pa 5 productos
        Pedido pedido = new Pedido(5);
        pedido.agregarProducto(magdalena,3);
        pedido.agregarProducto(croissant,5);
        pedido.agregarProducto(galleta,6);
        pedido.agregarProducto(magdalena,12);
        pedido.agregarProducto(croissant,4);
        pedido.imprimirTicket();

        //Crear el almacen
        Almacen Almacen = new Almacen(10);
        Almacen.AgregarProductoAlInventario(new Producto("Galleta",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Croissant",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Galleta",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Croissant",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));
        Almacen.AgregarProductoAlInventario(new Producto("Magdalena",1.50,15));

        Almacen.MostrarInventario();
        System.out.println("");
        System.out.println("dime el producto a buscar");
        Scanner lector = new Scanner(System.in);
        String producto = lector.nextLine();
        Almacen.buscarProductoPorNombre(producto);
    }
}