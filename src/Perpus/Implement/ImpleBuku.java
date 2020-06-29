/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Implement;

import Perpus.Entity.Enbuku;
import Perpus.Interfaces.Interbuku;
import Perpus.koneksi.Koneksi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yehez
 */
public class ImpleBuku implements Interbuku{
    private String query;
    private Koneksi koneksidb;
    private boolean status;
    private ResultSet rsBuku;
    List<Enbuku> listbuku;
    
    public ImpleBuku(){
         koneksidb = new Koneksi();
        koneksidb.getKoneksi();
    }

    @Override
    public boolean Inbuku(Enbuku eb) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           status = false;
        query = "insert into buku values ("+eb.getIdbuku()+","+eb.getIdbuku()+",'"+
                eb.getJudul()+"','"+eb.getPegarang()+"','"+eb.getThterbit()+ "',"+eb.getJumhal()+",'"+eb.getDate()+"',"+eb.getJumbuku()+",'"+
                eb.getKategori()+"','"+eb.getPenerbit()+"')";
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Upbuku(Enbuku eb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    status = false;
        query = "update buku set Id_user = "+eb.getIduser()+", Judul = '"+eb.getJudul()+
                "', Pengarang = '"+eb.getPegarang()+"', Thnterbit = '"+eb.getThterbit()+"', Jumhal = "+eb.getJumhal()+
                ", Tgl_input = '"+ eb.getDate()+ "', Jml_buku = "+eb.getJumbuku()+ ", kategori = '" +eb.getKategori()+
                "', Penerbit = '"+eb.getPenerbit()+"' where Id_user = "+eb.getIdbuku();
         status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public boolean Delbuku(String Idbuku) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        status = false;
        query = "delete from buku where Id_buku = " + Idbuku;
        status = koneksidb.eksekusiQuery(query, false);
        return status;
    }

    @Override
    public List selbuku() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        query = "select * from buku";
        status = koneksidb.eksekusiQuery(query, true);
        if(status){
            rsBuku = koneksidb.getRs();
            listbuku = new ArrayList<Enbuku>();
            
            try {
                while (rsBuku.next()) {
                   Enbuku ebu = new Enbuku();
                   ebu.setIdbuku(rsBuku.getInt(1));
                   ebu.setIduser(rsBuku.getInt(2));
                   ebu.setJudul(rsBuku.getString(3));
                   ebu.setPegarang(rsBuku.getString(4));
                   ebu.setThterbit(rsBuku.getString(5));
                   ebu.setJumhal(rsBuku.getInt(6));
                   ebu.setDate(rsBuku.getString(7));
                   ebu.setJumbuku(rsBuku.getInt(8));
                   ebu.setKategori(rsBuku.getString(9));
                   ebu.setPenerbit(rsBuku.getString(10));
                   listbuku.add(ebu); 
                }
                rsBuku.close();
                return listbuku;
            } catch (Exception e) {
                return null;
            }
            
        }
        return null;
    }
    
    public static void main(String[] args) {
        
       Enbuku eb = new Enbuku();
       eb.setIdbuku(1);
       eb.setIduser(1);
       eb.setJudul("Java");
       eb.setPegarang("faisal");
       eb.setThterbit("1997");
       eb.setJumhal(214);
       eb.setDate("2015/5/15");
       eb.setJumbuku(5);
       eb.setKategori("Sastra");
       eb.setPenerbit("Andi");
        new ImpleBuku().Inbuku(eb);
    }

    
}
