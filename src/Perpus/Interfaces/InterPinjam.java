/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Interfaces;

import Perpus.Entity.EnPinjam;
import java.util.List;

/**
 *
 * @author Yehez
 */
public interface InterPinjam {
    boolean Inpinjam(EnPinjam ep);
   boolean Uppinjam (EnPinjam ep);
   boolean Delpinjam (String Idpinjam);
    List selPinjam();
}
