/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Interfaces;

import Perpus.Entity.Enkembali;
import java.util.List;

/**
 *
 * @author Yehez
 */
public interface InterKembali {
     boolean Inkembali(Enkembali ek);
   boolean Upkembali (Enkembali ek);
   boolean Delkembali (String IdKembali);
    List selkembali();
    
}
