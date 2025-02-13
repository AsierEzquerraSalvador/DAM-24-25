// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
       AlmacenMusica almacenMusica = new AlmacenMusica();

        Cancion cancion = new Cancion(1,"ROCKSTAR");
        Cancion cancion1 = new Cancion(2,"HELLO COTTO");
        Cancion cancion2 = new Cancion(3,"YA NO SOS IGUAL");
        Cancion cancion3 = new Cancion(4,"VIDA DE ROCK");
        Cancion cancion4 = new Cancion(5,"TRAP N EXPORT");
        Cancion cancion5 = new Cancion(6,"NUEVA ERA");
        almacenMusica.addCancion(cancion);
        almacenMusica.addCancion(cancion1);
        almacenMusica.addCancion(cancion2);
        almacenMusica.addCancion(cancion3);
        almacenMusica.addCancion(cancion4);
        almacenMusica.addCancion(cancion5);

        almacenMusica.updateCancion(cancion5);
        almacenMusica.deleteCancion(cancion3);
        almacenMusica.imprimir();



    }
}