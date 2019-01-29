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
    private double preis;
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
    public Aktie(String ISIN,double Preis){
        this.preis = Preis;
        this.ISIN = ISIN;
        
        
        
        
        
        
        
    }

    
    
    
            
   
    
    /**get-Methode für den Namen
     * @return .**/
    public String getISIN() {
        return ISIN;
    }
    
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
    public double getPreis() {
        return preis;
    }
    /**set-Methode für den Preis
     * @param preis.**/
    public void setPreis(double preis) {
        this.preis = preis;
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
   
    @Override
    public String toString(){
        String ausgabe="";
        ausgabe+=ISIN+" "+name+"\n";
        return ausgabe;
    }
    
    
}

