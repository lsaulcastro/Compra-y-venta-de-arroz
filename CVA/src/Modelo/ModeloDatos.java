/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author KelvinJp
 */
import java.sql.*;


/**
 *
 * @author KelvinJp
 */
public class ModeloDatos {
    
    private Connection conn; 
    private String hostname;
    private String portnumber;
    private String database;
    private String username;
    private String password;
    private String url;
    private static ModeloDatos modelo;
    
    private ModeloDatos(){
        hostname = "localhost";
        portnumber = "3306";
        database = "cva";
        username = "root";
        password = "";
        url = "jdbc:mysql://"+hostname+/*":"+portnumber+*/"/"+database+"?user="+username+"&password="+password;    
    }
    
    public static ModeloDatos getInstance(){
        if(modelo == null){
            modelo = new ModeloDatos();
        }
        return modelo;       
    }
    
   private void loadDriver() {
   
       try{
           Class.forName("com.mysql.jdbc.Driver").newInstance();
       }
       catch(Exception e){
           System.out.println("error en la carga de driver");         
       }
   }  
   public void connectar() throws SQLException {
       conn = DriverManager.getConnection(url);   
   }
   public void desconnectar(){
       if(getConn()!=null){
           try{
                getConn().close();
           }
           catch(Exception e){
          
           }
       }
   }
    public Connection getConn() {
        return conn;
    }
   
    
}
