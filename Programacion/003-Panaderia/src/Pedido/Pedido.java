package Pedido;

import Producto.Producto;

public class Pedido {
    private int numProductos;
    private Producto[] lstProductos; // Listas estaticas
    private int contador = 0;


    public Pedido(int numProductos){
        this.numProductos = numProductos;
        lstProductos = new Producto[numProductos]; //Recibe 5 de lo q le pase antes del Main

    }
    //getter/setter
    public int getNumProdcutos() {
        return numProductos;
    }

    public void setNumProdcutos(int numProdcutos) {
        this.numProductos = numProdcutos;
    }
    //
    public void agregarProducto(Producto miProducto, int cant){
        if (contador<5) {
            this.lstProductos[contador] = miProducto;
            contador++;
        }else {
            contador = 0;
        }
    }
    // To string
    @Override
    public String toString() {
        return "Pedido{" +
                "numProductos=" + numProductos +
                '}';
    }

    public void imprimirTicket() {
        System.out.println("Su ticket digittal");
        System.out.println("Fecha ->" + "14/01/2025");
        System.out.println("Hora ->" + "12:10");
        for (int i = 0; i <lstProductos.length ; i++) {
                Producto miProducto = lstProductos[i];
                if (miProducto!= null){
                    System.out.println(lstProductos[i].toString());
                }else{
                    System.out.println("Has llegao al final de la lista");
                    break;
                }


        }
        for (int i = 0; i < lstProductos.length ; i++) {
            System.out.println(lstProductos[i].toString());
        }
    }
}
