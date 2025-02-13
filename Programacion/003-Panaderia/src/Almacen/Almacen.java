package Almacen;

import Producto.Producto;

public class Almacen {

    private int numProductosAlmacen;

    public static int contador= 0;

    private static Producto[] lstProductoAlmacen;

    public Almacen (int numProductosAlmacen){
        this.numProductosAlmacen = numProductosAlmacen;
        lstProductoAlmacen = new Producto[numProductosAlmacen];
    }

    public void AgregarProductoAlInventario(Producto producto){
        if (contador<10) {
            this.lstProductoAlmacen[contador] = producto;
            contador++;
        }else {
            contador = 0;
        }
    }


    public static void MostrarInventario(){
        System.out.println("INVENTARIO");
        for (int i = 0; i <lstProductoAlmacen.length ; i++) {
            Producto miProducto = lstProductoAlmacen[i];
            if (miProducto!= null){
                System.out.println(lstProductoAlmacen[i].toString());
            }else{
                System.out.println("No hay mas productos campeon");
                break;
            }
        }


    }
    public Producto buscarProductoPorNombre(String nombre){
        for (int i = 0; i < lstProductoAlmacen.length; i++) { //Recorre la lista con max 10 productos
            Producto producto= lstProductoAlmacen[i];
            if (producto!=null){
                if (nombre.equals(lstProductoAlmacen[i].getNombre())){
                    System.out.println(lstProductoAlmacen[i].toString());
                }
            }else {
                System.out.println("No hay más productos en el almacen.");
            }
        }
        return null;
    }

}
