/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

import java.util.Hashtable;



/**
 *
 * Aktie (Duh)
 * 
 * @author MrVielBesserImProgrammierenAlsDu
 * JavaD0cs by: Schantallê und Zyrúp
 */
public class Aktie {
    /**
     * Name der Aktie
     */
    private String name; 
    
    /**
     * Preis der Aktie
     */
    private float preis;
    
    /**
     * letzter Aktualisierungszeitpunkt der Aktie
     */
    private Date stand;
    
    /**
     * Preisänderung der Aktie
     */
    private float veränderung; 
    
    /**
     * Anzahl der Anteile
     */
    private int stueckzahl;
    
    /**
     * The International Securities Identification Number (ISIN) is a code 
     * that uniquely identifies a specific securities issue.
     */
    private final String ISIN;
    
    /**Kreiert Objekt der Klasse Aktie
     * @param name.*
     * @param ISIN*/
    public Aktie(String name,String ISIN){
        this.name = name;
        this.ISIN = ISIN;
        
        
        
        
        
        
        
    }
            
    /**
     * Verlauf der Aktie
     */
    private Hashtable<Date, Float> verlauf = new Hashtable<Date, Float>();
    
    /**get-Methode für den Namen
     * @return .**/
    public String getName() {
        return name;
    }
    /**set-Methode für den Namen
     * @param name.**/
    public void setName(String name) {
        this.name = name;
    }
    /**get-Methode für den Preis
     * @return .**/
    public float getPreis() {
        return preis;
    }
    /**set-Methode für den Preis
     * @param preis.**/
    public void setPreis(float preis) {
        this.preis = preis;
    }
    /**get-Methode für den Stand der Aktie
     * @return .**/

    public Date getStand() {
        return stand;
    }
    /**set-Methode für den Stand
     * @param stand.**/
    public void setStand(Date stand) {
        this.stand = stand;
    }
    /**get-Methode für die Preisveränderung
     * @return .**/
    public float getVeränderung() {
        return veränderung;
    }
    /**set-Methode für die Preisänderung
     * @param veränderung.**/
    public void setVeränderung(float veränderung) {
        this.veränderung = veränderung;
    }
    /**get-Methode für die Stückzahl 
     * @return .**/
    public int getStueckzahl() {
        return stueckzahl;
    }
    /**set-Methode für die Stückzahl
     * @param stueckzahl.**/
    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }
    
    /**Aktualisierung des Preises
     * @param price.**/
    public void aktualisieren(float price) {
        
        setPreis(price);
        Date date = new Date();
        setStand(date);
        
        verlauf.put(date,price);
    }
    
    
}

