/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perpus.Entity;

/**
 *
 * @author Yehez
 */
public class Enuser {
        private String Nmuser;
    private Integer Iduser;
    private String P_user;
    private String P_pass;
    private String Mail;
    private String Alamat;
    private String Jenkel;
    private String Tgl_lahir;

    public String getJenkel() {
        return Jenkel;
    }

    public void setJenkel(String Jenkel) {
        this.Jenkel = Jenkel;
    }

    public String getTgl_lahir() {
        return Tgl_lahir;
    }

    public void setTgl_lahir(String Tgl_lahir) {
        this.Tgl_lahir = Tgl_lahir;
    }

    public String getNmuser() {
        return Nmuser;
    }

    public void setNmuser(String Nmuser) {
        this.Nmuser = Nmuser;
    }

    public Integer getIduser() {
        return Iduser;
    }

    public void setIduser(Integer Iduser) {
        this.Iduser = Iduser;
    }

    public String getP_user() {
        return P_user;
    }

    public void setP_user(String P_user) {
        this.P_user = P_user;
    }

    public String getP_pass() {
        return P_pass;
    }

    public void setP_pass(String P_pass) {
        this.P_pass = P_pass;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    
    
    
}
