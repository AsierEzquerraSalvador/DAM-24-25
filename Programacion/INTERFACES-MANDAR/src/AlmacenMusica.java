import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AlmacenMusica implements IEstanteria {

    private static Cancion primera;

    ArrayList<Cancion> lstCanciones;

    /* public AlmacenMusica(ArrayList<Cancion> lstCanciones) {
        this.lstCanciones = lstCanciones;
    } */

    public AlmacenMusica(){
        this.lstCanciones = new ArrayList<Cancion>();

    }

    @Override
    public void addCancion(Cancion c) {
        if (primera == null) { //Si la lista está vacía, la nueva canción se convierte en el primer nodo.
            primera = c;
        } else {
            Cancion temp = primera; //Temp apunta a la primera canción (nodo)
            while (temp.next != null) { //Si ya hay canciones, se recorre la lista hasta el último nodo.
                temp = temp.next; //Va apuntando al sig avanzando en el bucle hasta que llega a la ultima y ya la añade.
            }
            temp.next = c; // Se añade la nueva canción al final
        }
        System.out.println("Canción añadida: " + c);
    }

    @Override
    public void updateCancion(Cancion c) {
        if (primera != null) { // Si la lista no está vacía
            Cancion temp = primera;
            boolean found = false;

            while (temp != null) { // Recorremos la lista enlazada
                if (temp.equals(c)) { // Si encontramos la canción a actualizar
                    found = true;
                    Scanner lector = new Scanner(System.in);
                    System.out.print("Dime el nuevo título de la canción: ");
                    String newTitle = lector.nextLine();

                    temp.setTitulo(newTitle); // Actualizamos el título de la canción
                    System.out.println("Canción actualizada: " + temp);
                    break;
                }
                temp = temp.next;
            }

            if (!found) {
                System.out.println("La canción no se encuentra en la lista.");
            }
        } else {
            System.out.println("La lista de canciones está vacía.");
        }
    }

    @Override
    public void deleteCancion(Cancion c) {
        if (primera == null) { // Si la lista está vacía, no hay nada que eliminar
            return;
        }
        //Caso 1: Si se quiere eliminar la primera cancion
        if (primera.equals(c)) { // Si la canción a eliminar es la primera, primera apunta al siguiente nodo.
            primera = primera.next; // La nueva "primera" será el segundo nodo e imprimira desde ese
            System.out.println("Canción eliminada: " + c);
            return;
        }
        //Caso 2: Si la cancion está en medio o al final
        Cancion temp = primera;
        while (temp.next != null && !temp.next.equals(c)) { //Si la canción está en medio o al final, se recorre la lista hasta encontrarla
            temp = temp.next;
        }
        if (temp.next != null) { // Si se encontró la canción
            temp.next = temp.next.next; // Se salta el nodo y enlaza el siguiente
            System.out.println("Canción eliminada: " + c);
        }

    }

    @Override
    public void imprimir() {
        Cancion temp = primera; //temp comienza en el primer nodo
        while (temp != null) { //Mientras no lleguemos al final
            System.out.println(temp); //Imprime la canción actual
            temp = temp.next; //Avanza al siguiente nodo
        }

    }
}
