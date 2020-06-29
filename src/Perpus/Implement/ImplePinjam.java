/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Implement;

import Perpus.Entity.EnPinjam;
import Perpus.Interfaces.InterPinjam;
import Perpus.koneksi.Koneksi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yehez
 */
public class ImplePinjam implements InterPinjam{
    private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rspinjam;
    List<EnPinjam> listpinjam;
    
    public ImplePinjam(){
    koneksidb = new Koneksi();
    koneksidb.getKoneksi();
}
    
    @Override
    public boolean Inpinjam(EnPinjam ep) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         status = false;
        query = "insert into peminjam values ("+ep.getIdpinjam() +","+ep.getIdbuku()+",'" + 
                ep.getNmpinjam()+"','"+ep.getTgl_pinjam()+"','"+ep.getNotelp()+"','"+ep.getAlamat()+"')";
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Uppinjam(EnPinjam ep) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "update peminjam set Id_buku = "+ep.getIdbuku()+", Nmpeminjam = '"+ep.getNmpinjam()+
                "', Tglpinjam = '"+ep.getTgl_pinjam() + "', Notelp = '"+ep.getNotelp()+"', Alamat = '"+ep.getAlamat()+
               "' where Id_peminjam = "+ep.getIdpinjam();
         status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Delpinjam(String Idpinjam) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         status = false;
        query = "delete from peminjam where Id_peminjam = " + Idpinjam;
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selPinjam() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         query = "select * from peminjam";
        status = koneksidb.eksekusiQuery(query, true);
        if(status){
            rspinjam = koneksidb.getRs();
            listpinjam = new ArrayList<EnPinjam>();
            
            try {
                while (rspinjam.next()) {
                   EnPinjam epi = new EnPinjam();
                   epi.setIdpinjam(rspinjam.getInt(1));
                   epi.setIdbuku(rspinjam.getInt(2));
                   epi.setNmpinjam(rspinjam.getString(3));
                   epi.setTgl_pinjam(rspinjam.getString(4));
                   epi.setNotelp(rspinjam.getString(5));
                   epi.setAlamat(rspinjam.getString(6));
                   listpinjam.add(epi); 
                }
                rspinjam.close();
                return listpinjam;
            } catch (Exception e) {
                return null;
            }
            
        }
        return null;
    }
    
    public static void main(String[] args) {
        
       EnPinjam ep = new EnPinjam();
       ep.setIdpinjam(2);
       ep.setIdbuku(1);
       ep.setNmpinjam("Orang");
       ep.setTgl_pinjam("2015/5/15");
       ep.setNotelp("082225534359");
       ep.setAlamat("Jl Mangga");
        new ImplePinjam().Inpinjam(ep);
    }
    
}
