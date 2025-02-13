import org.example.Biblioteca;
import org.example.Libro;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, true);
        Libro libro2 = new Libro("1984", "George Orwell", 1949, true);
        Libro libro3 = new Libro("EL MEJOR TRAPERO: DUKI", "Mauro Ezequiel", 2024, true);

        System.out.println(Libro.contadorLibro);

        Biblioteca biblio = new Biblioteca();

        // Agregar libros a la biblioteca
        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);
        biblio.agregarLibro(libro3);

        // Listar libros
        biblio.listarLibro();

        // Buscar y prestar un libro
        biblio.pestarLibro("EL MEJOR TRAPERO: DUKI");
        biblio.listarLibro();

        // Intentar prestar el mismo libro /// comprobar para poder devolver el mismo libro
        biblio.pestarLibro("EL MEJOR TRAPERO: DUKI");

        // Devolver el libro // aqui necesitamos devolver los libros
        biblio.devolverLibro("EL MEJOR TRAPERO: DUKI");

    }
}