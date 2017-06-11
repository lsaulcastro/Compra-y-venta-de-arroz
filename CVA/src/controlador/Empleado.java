
package controlador;

import Modelo.ModeloDatos;
import cva.EmpleadoVista;
import static cva.EmpleadoVista.JtableEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public  class Empleado {
    
    
    public static JFrame em;
    
    public Empleado(){}
    
    public static JFrame getinstance(){
        if (em == null) {
            em = new EmpleadoVista();
        }
    return em;
    }
    DefaultTableModel model;
    ///Metodo agregar empleado
    public  Empleado AgregarEmpleado(String a, String b, String c, String d){
        String query="INSERT INTO `empleado`(`nombre`, `ced`, `celular`, `cargo`) VALUES (?,?,?,?)";
        Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
        PreparedStatement p = null;
        String a1 = a;String b1 = b;String c1 = c; String d1= d;
        try {
            modelo.connectar();
            p =  modelo.getConn().prepareStatement(query);
            p.setString(1, a1);p.setString(2, b1);p.setString(3, c1);p.setString(4, d1);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null,"Contacto ingresado correctamente en la base de datos"); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error! " + e);
        }
        
        
    return this;
    }

    public Empleado BusquedaAll(){
        String [] tituloEmple = {"idEmpleado","Nombre","Cedula","Telefono","Cargo"};
         model = new DefaultTableModel(null, tituloEmple);
         JtableEmpleado.setModel(model);
        String query = "SELECT * FROM `empleado` ";
        Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
        String datos[]= new String[5];
        try {
            modelo.connectar();
            Statement s;
            s = modelo.getConn().createStatement();
            ResultSet rs  = s.executeQuery(query);
            
            while(rs.next()){
             datos[0] = String.valueOf(rs.getInt(1));
             datos[1] = rs.getString(2);
             datos[2] = rs.getString(3);
             datos[3] = rs.getString(4);
             datos[4] = rs.getString(5);
             
            model.addRow(datos);
            }
            System.out.println(datos[0] + datos[1]);
            JtableEmpleado.setModel(model);
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error!" + e);
        }
        
    return this;
    }
    
    public Empleado BusquedaFiltrada(String a){
        String [] tituloEmple = {"idEmpleado","Nombre","Cedula","Telefono","Cargo"};
         model = new DefaultTableModel(null, tituloEmple);
         JtableEmpleado.setModel(model);
      Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
      String query = "SELECT * FROM empleado WHERE idempleado LIKE '%"+a+"%'" 
              +"OR nombre LIKE '%"+a+"%'" + "OR ced LIKE '%"+a+"%'"
              + "OR celular LIKE '%" +a+"%'" + "OR cargo LIKE '%"+a+"%'";
     //String datos[];
        try {
            modelo.connectar();
            Statement s ;
            s = modelo.getConn().createStatement();
            ResultSet rs;
             rs = s.executeQuery(query);
            while (rs.next()) { 
                 String datos[] = {String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};  
               // System.out.println(datos);
                 model.addRow(datos);
            }
          //  JOptionPane.showMessageDialog(null, model);
            JtableEmpleado.setModel(model);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error!" + ex);
        }
    
    return this;
    }
    
    public Empleado updateEmpleado(String a, String b, String c,String d,String e){
         ModeloDatos modelo = ModeloDatos.getInstance();
         String query = "UPDATE empleado SET nombre = '"+a+"', ced = '"+b+"', celular = '"+c+"', cargo = '"+d+"' where idempleado = '"+e+"' ";
         PreparedStatement p;
         try {
            modelo.connectar();
            p = modelo.getConn().prepareStatement(query);
            p.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error! " + ex);
        }
            modelo.desconnectar();
        return this;}
    
    public Empleado deleteEmpleado(String a){
        Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
        String query = "DELETE FROM `empleado` WHERE idempleado = '"+Integer.parseInt(a)+"'";
        Statement s;
        try {
         modelo.connectar();
         s = modelo.getConn().createStatement();
         s.executeUpdate(query);
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!  "+e);
        }
        return this;}
}
