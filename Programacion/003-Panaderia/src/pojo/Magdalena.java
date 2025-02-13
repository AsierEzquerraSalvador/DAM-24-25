package pojo;

public class Magdalena {
    //ATRIBUTOS
    private String color;
    private String sabor;

    //CONSTRUCTOR
    public Magdalena(String sabor, String color) {
        this.sabor = sabor;
        this.color = color;
    }

    //MÉTODOS
    public String addSabor() {
        return sabor;
    }

    public String addColor() {
        return color;
    }
}
