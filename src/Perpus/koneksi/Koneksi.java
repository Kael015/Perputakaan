
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yehez
 */
public class Koneksi {
  private Connection koneksi;
  private ResultSet rs;
  private PreparedStatement ps;
          
  public Connection getKoneksi() {
    if (koneksi == null){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            try {
                
                String url ="jdbc:mysql://localhost:3306/db_perpus";
                koneksi = DriverManager.getConnection(url,"root","");
                System.out.println("koneksi sukses");
            } catch (SQLException se) {
                System.out.println("koneksi gagal "+se);
                System.exit(0);
            }
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("class tidak ditemukan "+cnfe);
                System.exit(0);
        }
    }
    return koneksi;
}
  
  public  ResultSet getRs(){
      return rs;
  }
  public boolean eksekusiQuery(String query, boolean baris){
      try {
          ps = koneksi.prepareStatement(query);
          if(baris){
              rs = ps.executeQuery();
          }
          else {
              ps.executeUpdate();
          }
          return true;
      } catch (SQLException e) {
          return false;
      }
  }
    public static void main(String[] args) {
        new Koneksi().getKoneksi();
    }
}
