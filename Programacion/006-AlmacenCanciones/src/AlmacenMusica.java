public class AlmacenMusica {

    private static Cancion primera; // Referencia al primer elemento de la lista enlazada

    public AlmacenMusica() {
        primera = null; // Inicialmente la lista está vacía
    }

    public static void addCancion(Cancion cancion) {
        if (primera == null) { //Si la lista está vacía, la nueva canción se convierte en el primer nodo.
            primera = cancion;
        } else {
            Cancion temp = primera; //Temp apunta a la primera canción (nodo)
            while (temp.next != null) { //Si ya hay canciones, se recorre la lista hasta el último nodo.
                temp = temp.next; //Va apuntando al sig avanzando en el bucle hasta que llega a la ultima y ya la añade.
            }
            temp.next = cancion; // Se añade la nueva canción al final
        }
        System.out.println("Canción añadida: " + cancion);
    }

    public static void deleteCancion(Cancion cancion) {
        if (primera == null) { // Si la lista está vacía, no hay nada que eliminar
            return;
        }
        //Caso 1: Si se quiere eliminar la primera cancion
        if (primera.equals(cancion)) { // Si la canción a eliminar es la primera, primera apunta al siguiente nodo.
            primera = primera.next; // La nueva "primera" será el segundo nodo e imprimira desde ese
            System.out.println("Canción eliminada: " + cancion);
            return;
        }
        //Caso 2: Si la cancion está en medio o al final
        Cancion temp = primera;
        while (temp.next != null && !temp.next.equals(cancion)) { //Si la canción está en medio o al final, se recorre la lista hasta encontrarla
            temp = temp.next;
        }
        if (temp.next != null) { // Si se encontró la canción
            temp.next = temp.next.next; // Se salta el nodo y enlaza el siguiente
            System.out.println("Canción eliminada: " + cancion);
        }
    }
    public static void imprimirCancion() {
        Cancion temp = primera; //temp comienza en el primer nodo
        while (temp != null) { //Mientras no lleguemos al final
            System.out.println(temp); //Imprime la canción actual
            temp = temp.next; //Avanza al siguiente nodo
        }
    }

    //Apuntes:
    //Lista enlazada: Cada nodo (canción) apunta al siguiente.
    //next: Referencia al siguiente nodo en la lista.
    //temp: Puntero temporal que va recorriendo los nodos uno por uno, ayuda a moverse dentro de la lista, para busqueda, eliminacion e impresion de nodos
    //Búsqueda: Se usa un while para recorrer la lista.
    //Eliminación: Se cambia la referencia next del nodo anterior.
}
