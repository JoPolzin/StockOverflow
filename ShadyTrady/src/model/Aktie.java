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
 * Komplett unnötige Klasse...
 * 
 * @author MrVielBesserImProgrammierenAlsDu
 * JavaD0cs by: Schantallê und Zyrúp
 */
public class Aktie {
    /**
     * Name der Aktie
     */
    private String name; 
    
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
 * Komplett unnötige Klasse...
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
     * 
     */
    private float veränderung; 
    
    /**
     * Anzahl der Anteile
     */
    private int stueckzahl;
    
    /**Komplett unnötige Variable...**/
    private String ISIN;
    
    /**Komplett unnötiger Konstruktor...**/
    public Aktie(String name,String ISIN){
        this.name = name;
        this.ISIN = ISIN;
        
        
        
        
        
        
        
    }
            
    /**Komplett unnötige Variable...**/
    private Hashtable<Date, Float> verlauf = new Hashtable<Date, Float>();
    
    /**Komplett unnötige Funktion...**/
    public String getName() {
        return name;
    }
    /**Komplett unnötige Funktion...**/
    public void setName(String name) {
        this.name = name;
    }
    /**Komplett unnötige Funktion...**/
    public float getPreis() {
        return preis;
    }
    /**Komplett unnötige Funktion...**/
    public void setPreis(float preis) {
        this.preis = preis;
    }
    /**Komplett unnötige Funktion...**/
    public Date getStand() {
        return stand;
    }
    /**Komplett unnötige Funktion...**/
    public void setStand(Date stand) {
        this.stand = stand;
    }
    /**Komplett unnötige Funktion...**/
    public float getVeränderung() {
        return veränderung;
    }
    /**Komplett unnötige Funktion...**/
    public void setVeränderung(float veränderung) {
        this.veränderung = veränderung;
    }
    /**Komplett unnötige Funktion...**/
    public int getStueckzahl() {
        return stueckzahl;
    }
    /**Komplett unnötige Funktion...**/
    public void setStueckzahl(int stueckzahl) {
        this.stueckzahl = stueckzahl;
    }
    
    /**Komplett unnötige Funktion...**/
    public void aktualisieren(float price) {
        
        setPreis(price);
        Date date = new Date();
        setStand(date);
        
        verlauf.put(date,price);
    }
    
    
}

