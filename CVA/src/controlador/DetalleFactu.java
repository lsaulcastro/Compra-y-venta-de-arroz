
package controlador;

import Modelo.ModeloDatos;
import cva.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DetalleFactu {
    
    
  public  DetalleFactu (){}
  
  public void AddDeta(String a, String b){
      Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
      String query ="INSERT INTO `detalle_pesada`(`cant_sacos`, `peso`) VALUES (?,?)";
      PreparedStatement p;
      try {
          modelo.connectar();
          p = modelo.getConn().prepareStatement(query);
          p.setString(1, a);p.setString(2, b);
          p.executeUpdate();
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"Error!!  " + ex);
      }
  
      modelo.desconnectar();
  }
  
  public void AddJtable(){
        Modelo.ModeloDatos modelo = ModeloDatos.getInstance();
      String[] tituDeta = {"idDetalle","Cantidad De Sacos","Peso (kilos)"};
      DefaultTableModel model = new DefaultTableModel(null,tituDeta);
      String query = "SELECT * FROM `detalle_pesada`";
      Statement s;
      ResultSet rs;
      try {
          modelo.connectar();
          s = modelo.getConn().createStatement();
          rs = s.executeQuery(query);
          while (rs.next()) {              
              String[] datos = {String.valueOf(rs.getInt(1)),rs.getString(2),rs.getString(3)};
              model.addRow(datos);
          }
          Factura.jtableDetalle.setModel(model);
      } catch (SQLException e) {
      }
  
  }
}
