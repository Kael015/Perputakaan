/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Laporan;

import Perpus.koneksi.Koneksi;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author legollas
 */
public class report {

    public report(String buku, String paramsReport, String paramsvalue) {
        Koneksi k = new Koneksi();
        HashMap hashMap = new HashMap();
        hashMap.put(paramsReport, paramsvalue);
        Connection c = k.getKoneksi();
        File file = new File(buku);
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, c);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setVisible(true);
            //JasperViewer.viewReport(jasperPrint);
        } catch (JRException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public report(String buku, Map<String, Object> params) {
        Koneksi k = new Koneksi();       
        Connection c = k.getKoneksi();
        File file = new File(buku);
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, c);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setVisible(true);
            //JasperViewer.viewReport(jasperPrint);
        } catch (JRException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
