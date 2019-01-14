/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 
 */
public class Benutzer {
    
    /**
     * Name des Benutzers
     */
    private String Benutzername; 
    /**
     *  Name des Passwortes
     */
    private String Passwort; 
    /**
     * Name der Email
     */
    private String Email; 
    /**
     *  Hoehe des Kontostandes
     */    
    private Float Kontostand; 
    
    
    
    /**
     * getter-Methode des Benutzers
     * @see  Benutzername
     * @return 
     */ 
    public String getBenutzername() {
        return Benutzername;
    }
     /**
     * load-Methode des Benutzers
     * @return 
     */ 
    public void loadBenutzername(String Benutzername) {
        this.Benutzername = Benutzername;
    }
    /**
     * load-Methode des Passwortes
     * @return 
     */ 
     public void loadPasswort(String Passwort) {
        this.Passwort = Passwort;
    }
    /**
     * save-Methode
     */ 
      public void save(){}
      /**
     * setter-Methode des Benutzers
     * @return 
     */ 
    public void setBenutzername(String Benutzername) {
        this.Benutzername = Benutzername;
    }
    /**
     * getter-Methode des Passwortes
     * @return 
     */ 
    public String getPasswort() {
        return Passwort;
    }
     /**
     * getter-Methode der Email
     * @return 
     */ 
    public String getEmail() {
        return Email;
    }
     /**
     * getter-Methode des Kontostandes
     * @return 
     */ 
    public Float getKontostand() {
        return Kontostand;
    }
     /**
     * setter-Methode des Passwortes
     * @return 
     */ 
    public void setPasswort(String Passwort) {
        this.Passwort = Passwort;
    }
     /**
     * setter-Methode der Email
     * @return 
     */ 
    public void setEmail(String Email) {
        this.Email = Email;
    }
     /**
     * setter-Methode des Kontostandes
     * @return 
     */ 
    public void setKontostand(Float Kontostand) {
        this.Kontostand = Kontostand;
    }
    
    
    
}
