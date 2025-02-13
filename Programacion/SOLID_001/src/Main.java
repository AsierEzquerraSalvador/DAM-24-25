import herencia.Reporte;
import printers.PrintTOJSON;
import printers.PrintToHTML;
import printers.PrintToXML;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Reporte printToHTML = new PrintToHTML("HTML");
        Reporte printTOJSON = new PrintTOJSON("JSON");
        Reporte printToXML = new PrintToXML("XML");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(printTOJSON);
        lst.add(printToXML);
        lst.add(printToHTML);

        for (Reporte reporte : lst){
            reporte.ImprimirCadena();
        }
    }
}