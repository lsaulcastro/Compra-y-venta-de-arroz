
package controlador;

import cva.Contactos;
import cva.Factura;
import javax.swing.JFrame;


public class FacturaControlador {

    private  static JFrame jf1;
    
    public FacturaControlador(){}
    //Patron de singleton
    public static JFrame getintance(){
         if (jf1 == null) {
             jf1 = new Factura();
         }
         return jf1;
     }
}
