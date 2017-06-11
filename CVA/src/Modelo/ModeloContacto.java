///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Modelo;
//import controlador.Contacto;
//import java.sql.PreparedStatement;
//
///**
// *
// * @author sauld
// */
//public class ModeloContacto
//{
//   
//     public Cliente agregarCliente(Cliente cliente){
//         System.out.println("++++++++AGREGANDO CLIENTE++++-");
//         
//         
//         
//        PreparedStatement pstmt1 = null;
//        ModeloContacto md = ModeloContacto.getInstance();
//      /*
//        hacemos un insert a la base de datos con los paramentros recibidos 
//        */
//        String sql1;
//           Cliente cmds = null;    
//        sql1  = "INSERT INTO `cliente` (`correo`,`nombre`,`apellido`,`direccion`, `telefono`) VALUES (?,?,?,?,?) ";
//        
//       
//        try{        
//            md.connectar();            
//            pstmt1 = md.getConn().prepareStatement(sql1);           
//            pstmt1.setString(1, correo);
//            pstmt1.setString(2,nombre);
//            pstmt1.setString(3, apellido);
//            pstmt1.setString(4, direccion);  
//            pstmt1.setString(5, telefono);  
//            int exito = pstmt1.executeUpdate();
//           
//            if(exito == 0 )
//                System.out.println("No funciono "+exito);
//            else
//                System.out.println("Si FUNCIONO"+exito);
//            
//           
//                cmds = new Cliente(correo, nombre, apellido, direccion, telefono);
//            
//        }
//        catch(Exception e){
//         e.printStackTrace();
//        }finally{
//            return cmds;
//        }  
//    }
//}
