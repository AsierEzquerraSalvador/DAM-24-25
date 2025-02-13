package pojo;

public class MagdalenaFactory {
    //ATRIBUTOS
    int contador = 0;
    private Magdalena[] listaMagdalena = new Magdalena[4];

    //MÉTODOS
    public void addMagdalena (Magdalena miMagdalena) {
        listaMagdalena[contador] = miMagdalena;
        contador++;
    }

    public void printMagdalena () {
        Magdalena magdalena;
        for (int i = 0; i < listaMagdalena.length; i++) {
            magdalena = listaMagdalena[i];
            System.out.print("Magdalena " + (i + 1) + ": ");
            System.out.print("Atributos: Sabor - " + magdalena.addSabor());
            System.out.println(", Color - " + magdalena.addColor());
        }
    }
}
