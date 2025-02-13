package printers;

import herencia.Reporte;
import interfaces.Print;

public class PrintTOJSON extends Reporte {
    private String cadenaEnHtml;
    public PrintTOJSON(String cadena){
        super(cadena);

    }

}
