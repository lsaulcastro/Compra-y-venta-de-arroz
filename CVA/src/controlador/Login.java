
package controlador;

import Modelo.ModeloDatos;
import cva.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;


public class Login {
    public static boolean as =  false;
    public Login(){}
    
    
    public void ValidarLogin(String a, String b){
        Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
        String query = "SELECT `name`,`password` FROM `user` WHERE `password` = '"+a+"'AND name = '"+b+"'";
        Statement s;
        ResultSet rs;
        
        try {
            modelo.connectar();
            s = modelo.getConn().createStatement();
            rs = s.executeQuery(query);
            if (rs.next()) {
                as = true;
              cva.Principal p = new Principal();
               p.setVisible(true);
               
            }else{
                as= false;
                JOptionPane.showMessageDialog(null, "Usuario u Contraseña, INCORRECTOS!");
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error! " + e);
        }
    modelo.desconnectar();
    
    }
}
