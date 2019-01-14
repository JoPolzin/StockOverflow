/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Hashtable;

/**
 *
 * @author MrVielBesserImProgrammierenAlsDu
 */
public class Aktie {
    /**name der Aktie**/
    private String name = ""; 
    
    /**preis der Aktie**/
    private float preis = 0.0f;
    
    /**letze aktualisierung der Aktie**/
    private long stand = 0;
    
    /**veränderung des Preises der Aktie seit letzter Messung[...]**/
    private float veränderung = 0.0f; 
    
    /**anzahl der (noch) kaufbaren Aktien*/
    private int stueckzahl = 0; 
    
    /**UUID der Aktie**/
    private int AID = 0;
    
    /**Daten aus dem die Graphik erzeugt werden. jeder ehemalge akt. Preis ist
       ein neuer Eintrag. ab einer bestimmten Anzahl werden ältere Daten ausgedünnt.**/
    private Hashtable<Long, Float> verlauf = new Hashtable<Long, Float>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }
    
    public float getStand() {
        return stand;
    }

    public void setStand(long stand) {
        this.stand = stand;
    }

    public float getVeränderung() {
        return veränderung;
    }

    public void setVeränderung(float veränderung) {
        this.veränderung = veränderung;
    }

    public int getStueckzahl() {
        return stueckzahl;
    }

    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }
    
    /**to be continued**/
    public void verlaufAktualisieren(long t, float price) {
        
        //Hier fehlt noch so einiges...
        setPreis(price);
        setStand(t);
    }
    
    
}
