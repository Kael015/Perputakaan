/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Interfaces;

import Perpus.Entity.Enbuku;
import java.util.List;

/**
 *
 * @author Yehez
 */
public interface Interbuku {
    
     boolean Inbuku(Enbuku eb);
   boolean Upbuku (Enbuku eb);
   boolean Delbuku (String Idbuku);
    List selbuku();
   
}
