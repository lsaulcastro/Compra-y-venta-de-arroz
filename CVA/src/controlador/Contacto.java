

package controlador;

import java.sql.PreparedStatement;
import Modelo.ModeloDatos;
import cva.Contactos;
import static cva.Contactos.jTableMostrar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Contacto {
   // Atributos de los contactos se guardan el nombre, cedula, celular, ciudad y el tipo de contacto
    private int idContacto; 
    private String nombre;
    private String cedula;
    private String celular;
    private String ciudad;
    private String tipo_contacto;
    private static JFrame jf;
    public String[] d = new String [5];
    public int [] da = new int [0];
    
    public Contacto(){}
    public Contacto(String nombre, String cedula,String celular,String ciudad,String tipo_contacto){this.nombre = nombre;this.cedula = cedula;this.celular = celular;this.ciudad = ciudad; this.tipo_contacto = tipo_contacto;}
    //Nombre metodos
    public void setNombre(String nom){this.nombre = nom;}
    public String getNombre(){return this.nombre;}
    //celular metodos
    public void setCelular(String cel){this.celular = cel;}
    public String getCelular(){return this.celular;}
    //cedula metodos
    public void setCedula(String cedu){this.cedula = cedu;}
    public String getCedula(){return this.cedula;}
    //Metodos de ciudad
    public void serCiudad(String ciudad){this.ciudad = ciudad;}
    public String getCiudad(){return this.ciudad;}
    //Metods tipo de contacto
    public void setTipo_Contacto(String t){ this.tipo_contacto = t;}
    public String getTipo_Contacto(){return this.tipo_contacto;}
    ///
        public int getIdcontacto(){return this.idContacto;}

    
     public static JFrame getintance(){
         if (jf == null) {
             jf = new Contactos();
         }
         return jf;
     }
    public  Contacto agregarContacto(){
        
        PreparedStatement pstmt1 = null;
        ModeloDatos md = ModeloDatos.getInstance();
      /*
        hacemos un insert a la base de datos con los paramentros recibidos 
        */
        String sql1;
        sql1  = "INSERT INTO `contacto` (`nombre`, `cedula`, `celula`, `ciudad`, `tipo_contacto`) VALUES (?,?,?,?,?) ";
        
       System.out.println(""+this.nombre+ nombre); 
        try{        
            md.connectar();            
            pstmt1 = md.getConn().prepareStatement(sql1);           
            pstmt1.setString(1, this.nombre);
            pstmt1.setString(2,this.cedula);
            pstmt1.setString(3, this.celular);
            pstmt1.setString(4, this.ciudad);  
            pstmt1.setString(5, this.tipo_contacto);  
            
            int exito = pstmt1.executeUpdate();
           
            if(exito == 0 )
                System.out.println("No funciono "+exito);
            
            else {
                System.out.println("Si FUNCIONO"+exito);
                JOptionPane.showMessageDialog(null,"Contacto ingresado correctamente en la base de datos"); 
                //this.idContacto = exito; 
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error!\nLa cedula ingresada ya esta en la base de datos.\n"+e);         }
            return this;
        
    }
    
    public Contacto BuscarContacto(){
          Statement s;
       String []d = new String[6];
    String query = "SELECT * FROM `contacto`";
    ModeloDatos md = ModeloDatos.getInstance();
       
        try {
            md.connectar();
            s = md.getConn().createStatement();
            ResultSet rs = s.executeQuery(query);
           // JOptionPane.showMessageDialog(null, d[0]);
           
            while(rs.next()) {
                d[0] = String.valueOf(rs.getInt(1));
                d[1] = rs.getString(2);
                d[2] = rs.getString(3);
                d[3] = rs.getString(4);
                d[4] = rs.getString(5);
                d[5] = rs.getString(6);
             
               
            }
           
           
        } catch (SQLException e) {
        }
           //   JOptionPane.showMessageDialog(null, this.idContacto);

    return this;
    }
   public  Contacto ActualizarContacto(String a, String b, String c, String d ,String e, String id){
        
        PreparedStatement pstmt1 = null;
        ModeloDatos md = ModeloDatos.getInstance();
      /*
        hacemos un insert a la base de datos con los paramentros recibidos 
        */
        String sql1;
        sql1  = "UPDATE `contacto` SET `nombre`='"+a+"',`cedula`='"+b+"',`celula`='"+c+"',`ciudad`='"+d+"',`tipo_contacto`='"+e+"'WHERE idCliente='"+id+"'";
        
       System.out.println(""+this.nombre+ nombre); 
        try{        
            md.connectar();            
            pstmt1 = md.getConn().prepareStatement(sql1);           
            
            
            int exito = pstmt1.executeUpdate();
           
            if(exito == 0 )
                System.out.println("No funciono "+exito);
            else {
                System.out.println("Si FUNCIONO"+exito);
                //this.idContacto = exito; 
            }
            
        }catch(SQLException ee){
        }
            return this;
        
    }
   
   public Contacto DeleteEm(String a){
   Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
        String query = "DELETE FROM `contacto` WHERE idCliente = '"+Integer.parseInt(a)+"'";
        Statement s;
        try {
         modelo.connectar();
         s = modelo.getConn().createStatement();
         s.executeUpdate(query);
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!  "+e);
        }
   
   return this;
   }
   
    
}
