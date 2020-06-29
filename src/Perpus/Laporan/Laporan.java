/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Laporan;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author KIKI
 */
public class Laporan {
    private Boolean status;
    Connection koneksi;
    
    public Laporan() {
        try {
            String server = "jdbc:mysql://localhost:3306/perpus";
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(server,"root","");
        } catch (Exception se) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal" + se);
        }
    }
    
    public void cetakBuku(){
        try {
            InputStream sumber = getClass().getResourceAsStream("\\Perputakaan\\src\\Perpus\\Laporan\\buku.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(sumber);
            Map params = new HashMap();
            JasperPrint jp = JasperFillManager.fillReport(jr, params, koneksi);

            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setExtendedState(viewer.getExtendedState() | 0x6);
            viewer.setVisible(true);
            viewer.setTitle("Laporan Buku Seluruh");
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan report " + ex);
        }        
    }

}
