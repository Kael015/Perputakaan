/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Implement;

import Perpus.Entity.Enkembali;
import Perpus.Interfaces.InterKembali;
import Perpus.koneksi.Koneksi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yehez
 */
public class ImpleKembali implements InterKembali{
    
     private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rskembali;
    List<Enkembali> listkembali;

    public ImpleKembali() {
         koneksidb = new Koneksi();
    koneksidb.getKoneksi();
    }
    
    

    @Override
    public boolean Inkembali(Enkembali ek) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "insert into kembali values ("+ek.getIdKembali()+",'"+ek.getTglkembali()+"'," +
                ek.getIdpinjam()+")";
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Upkembali(Enkembali ek) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         status = false;
        query = "update kembali set Tglkembali = '"+ek.getTglkembali()+"' , Id_peminjam = "+ek.getIdpinjam()+
               " where Id_kembali = "+ek.getIdKembali();
         status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Delkembali(String IdKembali) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "delete from kembali where Id_kembali= " + IdKembali;
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selkembali() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         query = "select * from kembali";
        status = koneksidb.eksekusiQuery(query, true);
        if(status){
            rskembali = koneksidb.getRs();
            listkembali = new ArrayList<Enkembali>();
            
            try {
                while (rskembali.next()) {
                   Enkembali eke = new Enkembali();
                   eke.setIdKembali(rskembali.getInt(1));
                   eke.setTglkembali(rskembali.getString(2));
                   eke.setIdpinjam(rskembali.getInt(3));
                   listkembali.add(eke); 
                }
                rskembali.close();
                return listkembali;
            } catch (Exception e) {
                return null;
            }
            
        }
        return null;
    }
    
     public static void main(String[] args) {
        
       Enkembali ep = new Enkembali();
       ep.setIdpinjam(2);
       ep.setIdKembali(4);
       ep.setTglkembali("2015/5/15");
        new ImpleKembali().Upkembali(ep);
    }
    
}
