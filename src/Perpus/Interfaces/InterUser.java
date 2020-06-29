/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Interfaces;

import Perpus.Entity.Enuser;
import java.util.List;


/**
 *
 * @author Yehez
 */
public interface InterUser {
   boolean Inuser(Enuser eu);
   boolean Upuser (Enuser eu);
   boolean Deluser (String Iduser);
    List seluser();
   boolean loginUser(String kode, String password);
   
    
}
