
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Implement;

import Perpus.Entity.Enuser;
import Perpus.Interfaces.InterUser;
import Perpus.koneksi.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yehez
 */
public class ImpleUser implements InterUser{

    
    private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rsUser, rsLogin;
    List<Enuser> listuser;

    public ImpleUser() {
        koneksidb = new Koneksi();
        koneksidb.getKoneksi();
    }
    
    
            
    @Override
    public boolean Inuser(Enuser eu) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "insert into user values (" + eu.getIduser() +",'"+eu.getNmuser()+"','"+ 
                eu.getP_user()+"',MD5('"+eu.getP_pass()+"') ,'"+eu.getMail()+"','"+eu.getAlamat()+ "','"+ eu.getJenkel()+"','"+eu.getTgl_lahir()+"')";
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Upuser(Enuser eu) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "update user set Nmuser = '"+eu.getNmuser()+"', P_user = '" + eu.getP_user()+
                "', P_pass = MD5('"+eu.getP_pass()+"') , Mail = '"+eu.getMail()+"', Alamat = '"+eu.getAlamat()+
                "', Jenkel = '"+eu.getJenkel()+"', Tgl_lahir = '"+eu.getTgl_lahir()+
                "' where Id_user = "+eu.getIduser();
         status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Deluser(String Iduser) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "delete from user where Id_user = " + Iduser;
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List seluser() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        query = "select * from user ";
        status = koneksidb.eksekusiQuery(query, true);
        if(status){
            rsUser = koneksidb.getRs();
            listuser = new ArrayList<Enuser>();
            
            try {
                while (rsUser.next()) {
                   Enuser enu = new Enuser();
                   enu.setIduser(rsUser.getInt(1));
                   enu.setNmuser(rsUser.getString(2));
                   enu.setP_user(rsUser.getString(3));
                   enu.setP_pass(rsUser.getString(4));
                   enu.setMail(rsUser.getString(5));
                   enu.setAlamat(rsUser.getString(6));
                   enu.setJenkel(rsUser.getString(7));
                   enu.setTgl_lahir(rsUser.getString(8));
                   listuser.add(enu); 
                }
                rsUser.close();
                return listuser;
            } catch (Exception e) {
                return null;
            }
            
        }
        return null;
    }
    
    public boolean loginUser(String kode, String password) {
        String pass=null;
        query = "select * from user where P_user = '"+kode+"' and P_pass = MD5('"+password+"')";
        status = koneksidb.eksekusiQuery(query, true);
        if (status){
            rsLogin = koneksidb.getRs();
            try {
                rsLogin.next();
                pass = rsLogin.getString(4);
                rsLogin.close();

                if (pass.equals("")){
                    status = false;
                }else{
                    status = true;
                }
            } catch (SQLException ex) {
                return false;
            }
        }
        return status;
    }
    public static void main(String[] args) {
        
        Enuser en = new Enuser();
        en.setIduser(2);
        en.setNmuser("Yehez");
        en.setP_user("yehez");
        en.setP_pass("amikom");
        en.setMail("yehezkiel@gmail.com");
        en.setJenkel("L");
        en.setAlamat("perumahan candi gebang");
        en.setTgl_lahir("1997/12/20");
        new ImpleUser().Inuser(en);
    }
    
}
