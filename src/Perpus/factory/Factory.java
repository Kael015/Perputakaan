/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.factory;

import Perpus.Implement.ImpleBuku;
import Perpus.Implement.ImpleKembali;
import Perpus.Implement.ImplePinjam;
import Perpus.Implement.ImpleUser;
import Perpus.Interfaces.InterKembali;
import Perpus.Interfaces.InterPinjam;
import Perpus.Interfaces.InterUser;
import Perpus.Interfaces.Interbuku;

/**
 *
 * @author Yehez
 */
public class Factory {
    private static Interbuku BukuDAO;
    private static InterKembali KembaliDAO;
    private static InterPinjam PinjamDAO;
    private static InterUser UserDAO;
    
    
     public static Interbuku getInterbuku(){
    BukuDAO = new ImpleBuku();
    return BukuDAO;
    
}
     
     
     
    public static InterKembali getInterKembali() {
        KembaliDAO = new ImpleKembali();
        return KembaliDAO;
    }
    
    
    public static InterPinjam getInterPinjam() {
        PinjamDAO = new ImplePinjam();
        return PinjamDAO;
    }
    
    public static InterUser getInterUser() {
        UserDAO = new ImpleUser();
        return UserDAO;
    }
    
}
