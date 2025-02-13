package herencia;

public class Reporte {
    //ATRIBUTOS
    protected String cadenaATransformar;
    //CONSTRUCTORES

    public Reporte(String cadena){
        this.cadenaATransformar = cadena;
    }

    //METODOS

    //GETTER/SETTER

    public void ImprimirCadena(){
        System.out.println(cadenaATransformar);
    }
}





/// PATRONES DE SOFTWARE