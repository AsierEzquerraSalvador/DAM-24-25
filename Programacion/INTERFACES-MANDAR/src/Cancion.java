public class Cancion {
    private int id;
    private String titulo;
    Cancion next; // Referencia al siguiente nodo

    public Cancion(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}