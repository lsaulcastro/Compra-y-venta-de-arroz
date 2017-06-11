/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cva;

import Modelo.ModeloDatos;
import controlador.Contacto;
import static cva.EmpleadoVista.JtableEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sauld
 */
public class Contactos extends javax.swing.JFrame {

    /**
     * Creates new form Contactos
     */
  
    String [] titu = {"idcontacto","nombre","cedula","telefono","ciudad","tipo_contacto"};
    DefaultTableModel m =new DefaultTableModel();
 
    public Contactos() {
        initComponents();
        this.setLocationRelativeTo(this);  
        
    //    jTableMostrar.setModel(m);
     BusquedaAll();//
       
       
    }
    public void BusquedaFiltrada(String a){
     String [] d = new String[6];
      Statement s;
    String query = "SELECT *FROM contacto WHERE idCliente LIKE '%" + a + "%' "
                 + "OR nombre LIKE '%" + a + "%'"
                    + "OR cedula LIKE '%" + a+ "%'"
                 + "OR celula LIKE '%" +a + "%'"
                    + "OR ciudad LIKE '%" + a + "%'"
            + "OR tipo_contacto LIKE '%"+a+ "%'" ;
    ModeloDatos md = ModeloDatos.getInstance();
    
        try {
            md.connectar();
            s = ModeloDatos.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(query);
           // JOptionPane.showMessageDialog(null, d[0]);
           
            while(rs.next()) {
               d[0] = String.valueOf(rs.getInt("idCliente"));
                d[1] = rs.getString("nombre");
                d[2] = rs.getString("cedula");
                d[3] = rs.getString("celula");
                d[4] = rs.getString("ciudad");
                d[5] = rs.getString("tipo_contacto");
                m.addRow(d);
            }
            jTableMostrar.setModel(m);
        } catch (SQLException e) {
        }}
    
    public void BusquedaAll(){ Statement s;
         m = new DefaultTableModel(null,titu);
       String []d = new String[6];
    String query = "SELECT * FROM `contacto`";
    ModeloDatos md = ModeloDatos.getInstance();
       
        try {
            md.connectar();
            s = ModeloDatos.getInstance().getConn().createStatement();
            ResultSet rs = s.executeQuery(query);
           // JOptionPane.showMessageDialog(null, d[0]);
           
            while(rs.next()) {
                d[0] = String.valueOf(rs.getInt(1));
                d[1] = rs.getString(2);
                d[2] = rs.getString(3);
                d[3] = rs.getString(4);
                d[4] = rs.getString(5);
                d[5] = rs.getString(6);
             
                m.addRow(d);
            }
           
            jTableMostrar.setModel(m);
        } catch (SQLException e) {
        }
           //   JOptionPane.showMessageDialog(null, this.idContacto);
           md.desconnectar();}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tconta = new javax.swing.JComboBox<>();
        celularcon = new javax.swing.JTextField();
        nombrecon = new javax.swing.JTextField();
        cedulacon = new javax.swing.JTextField();
        ciudadcon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMostrar = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        texBus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnmodifi = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btnfact = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();

        jMenuItem1.setText("Modificar contacto");

        jPopupMenu1.setToolTipText("");

        jMenuItem2.setText("Modificar");
        jMenuItem2.setComponentPopupMenu(jPopupMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador Contactos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Datos del contacto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Documento:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de contacto:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ciudad:");

        tconta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Factoria" }));
        tconta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcontaActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1496571844_user-plus.png"))); // NOI18N

        jTableMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMostrar.setToolTipText("");
        jTableMostrar.setComponentPopupMenu(jPopupMenu1);
        jTableMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMostrarMouseClicked(evt);
            }
        });
        jTableMostrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableMostrarKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMostrar);

        texBus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texBusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                texBusKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Busqueda Filtrada:");

        btnmodifi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmodifi.setText("Modificar");
        btnmodifi.setEnabled(false);
        btnmodifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifiActionPerformed(evt);
            }
        });

        btnborrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnborrar.setText("Borrar");
        btnborrar.setEnabled(false);
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });

        btnfact.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnfact.setForeground(new java.awt.Color(204, 0, 0));
        btnfact.setText("Facturar");
        btnfact.setEnabled(false);
        btnfact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfactActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ID.setForeground(new java.awt.Color(255, 0, 0));
        ID.setText("ID");

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombrecon)
                                    .addComponent(cedulacon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(ciudadcon))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnguardar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(celularcon, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(tconta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(342, 342, 342))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(331, 331, 331))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnmodifi)
                        .addGap(113, 113, 113)
                        .addComponent(btnborrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(btnfact)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8)
                        .addGap(36, 36, 36)
                        .addComponent(texBus, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ID)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(ID)
                .addGap(2, 2, 2)
                .addComponent(jLabel7)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(celularcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrecon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(tconta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedulacon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ciudadcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodifi)
                    .addComponent(btnborrar)
                    .addComponent(jLabel8)
                    .addComponent(texBus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfact))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcontaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcontaActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_tcontaActionPerformed

    private void texBusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texBusKeyPressed
      //  BusquedaFiltrada(jTextField1.getText());
             
    }//GEN-LAST:event_texBusKeyPressed

    private void texBusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texBusKeyReleased
        m = new DefaultTableModel(null,titu);
        BusquedaFiltrada(texBus.getText());
    }//GEN-LAST:event_texBusKeyReleased

    private void btnmodifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifiActionPerformed
       btnguardar.setEnabled(true);
        controlador.Contacto con = new controlador.Contacto();
   if(ID.getText() != "ID" && nombrecon.getText()!="" && cedulacon.getText()!= "" && celularcon.getText() != "" && ciudadcon.getText() != "" ){
       con =  con.ActualizarContacto(nombrecon.getText(), cedulacon.getText(), celularcon.getText(), ciudadcon.getText(),tconta.getSelectedItem().toString(), ID.getText() );
        nombrecon.setText("");
        cedulacon.getText();cedulacon.setText("");
        celularcon.getText();celularcon.setText("");
        ciudadcon.getText();ciudadcon.setText(""); 
   }else{
       JOptionPane.showMessageDialog(null,"Por favor no dejar campos vacios\nSelecione el contacto a modificar");
   }
        
      
    }//GEN-LAST:event_btnmodifiActionPerformed

    private void btnfactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfactActionPerformed
    int a = jTableMostrar.getSelectedRow();
            JFrame jf  = controlador.FacturaControlador.getintance();
       int b = JOptionPane.showConfirmDialog(this, "¿ ESTA SEGURO HACERLE UNA FACTURA A ESTE EMPLEADO ?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if (b == 0) {      
            jf.setVisible(true);
          Factura.nombreCon.setText(jTableMostrar.getValueAt(a, 1).toString());
        Factura.telefoContac.setText(jTableMostrar.getValueAt(a, 3).toString());
        Factura.idContacto.setText(jTableMostrar.getValueAt(a, 0).toString());
        this.dispose();
        }
    }//GEN-LAST:event_btnfactActionPerformed

    private void jTableMostrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMostrarKeyPressed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jTableMostrarKeyPressed

    private void jTableMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMostrarMouseClicked
        // TODO add your handling code here:
         int a = jTableMostrar.getSelectedRow();
        if (a>=0) {
            btnmodifi.setEnabled(true);
            btnfact.setEnabled(true);
            btnborrar.setEnabled(true);
            int A = jTableMostrar.getSelectedRow();
       btnguardar.setEnabled(false);
       if (A >= 0){
           
       ID.setText(jTableMostrar.getValueAt(A, 0).toString());
       nombrecon.setText(jTableMostrar.getValueAt(A, 1).toString());
       cedulacon.setText(jTableMostrar.getValueAt(A, 2).toString());
       celularcon.setText(jTableMostrar.getValueAt(A, 3).toString());
       ciudadcon.setText(jTableMostrar.getValueAt(A, 4).toString());
       }else{
       JOptionPane.showMessageDialog(null, "Por Favor, Seleccione un contacto");
       }
            
        }else{
            
        }
    }//GEN-LAST:event_jTableMostrarMouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String nombre = nombrecon.getText();nombrecon.setText("");
        String cedula = cedulacon.getText();cedulacon.setText("");
        String celular = celularcon.getText();celularcon.setText("");
        String ciudad = ciudadcon.getText();ciudadcon.setText("");
        String tipo_Contacto = (String) tconta.getSelectedItem();
        controlador.Contacto con = new controlador.Contacto(nombre, cedula, celular, ciudad, tipo_Contacto);
        con =  con.agregarContacto();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
        // TODO add your handling code here:
        
        int b = JOptionPane.showConfirmDialog(this, "¿ ESTA SEGURO DE BORRAR EL EMPLEADO ?", "Confirmar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if (b == 0) {        
           controlador.Contacto con = new Contacto().DeleteEm(String.valueOf(ID.getText()));
            JOptionPane.showMessageDialog(null,"Accion exitosa");
        }
    }//GEN-LAST:event_btnborrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btnfact;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodifi;
    private javax.swing.JTextField cedulacon;
    private javax.swing.JTextField celularcon;
    private javax.swing.JTextField ciudadcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTable jTableMostrar;
    private javax.swing.JTextField nombrecon;
    private javax.swing.JComboBox<String> tconta;
    private javax.swing.JTextField texBus;
    // End of variables declaration//GEN-END:variables
}
