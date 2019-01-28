/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.maincontrol;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * 
 * Aktienkonto wird bei der erzeugung des Benutzers erzeugt. nach
 *
 * @author zochrab.blume
 */
public class Aktienkonto {

    private Integer id = -1;
/**
 * 
 * Key ist isin 
 * value ist stueckzahl
 */
    private Hashtable<String, Integer> Gekaufte_Aktien = new Hashtable();
    private ArrayList<Aktie> Aktien = new ArrayList();
 
    private maincontrol c;
   
    public Aktienkonto() {
        Gekaufte_Aktien = new Hashtable<>();
    }

    public Aktienkonto(maincontrol mc) {
        Gekaufte_Aktien = new Hashtable<>();

        this.c = mc;

    }
    
    private double Guthaben;

    /**
     * Aktien kaufen
     *
     * @param aid
     * @param Stueckzahl
     * @param Preis
     */
    public void aktie_kaufen(String aid, int Stueckzahl, Float Preis) {
      

        if (!Gekaufte_Aktien.isEmpty()) {

            if (!this.Gekaufte_Aktien.containsKey(aid)) {
                Gekaufte_Aktien.put(aid, Stueckzahl);
                Aktien.add(new Aktie(aid, Preis));
            } else {
           
                this.Gekaufte_Aktien.replace(aid, this.Gekaufte_Aktien.get(aid) + Stueckzahl);
            
            } 

        }
        else {
          
        Gekaufte_Aktien.put(aid, Stueckzahl);
                Aktien.add(new Aktie(aid, Preis));
        }
    }
        public boolean aktieverkaufen(String aid, Integer Stueckzahl, Float Preis) {
        
         if (Gekaufte_Aktien.isEmpty() || this.Aktien.isEmpty()) {
             return false;
         }
        else {
             
            if (this.Gekaufte_Aktien.containsKey(aid)) {
            if  (this.Gekaufte_Aktien.get(aid) >= Stueckzahl){
                 this.Gekaufte_Aktien.replace(aid, this.Gekaufte_Aktien.get(aid) - Stueckzahl);
                 return true;
            }
            
                
              
            
            } 

        }
        return false;
         
        }
       
    public ArrayList<Aktie> getAktien() {
        return Aktien;
    }

    public void setAktien(ArrayList<Aktie> Aktien) {
        this.Aktien = Aktien;
    }

    public maincontrol getC() {
        return c;
    }

    public void setC(maincontrol c) {
        this.c = c;
    }

    /**
     * Aktien verkaufen
     *
     * @param aid
     */
    public void aktie_verkaufen(int aid) {

    }

    /**
     * Errechnung des Gewinns über einen bestimmten Zeitraum
     *
     * @param aid
     * @return den Gewinn
     */
    public float gewinn(int aid) {
        return 0;
    }

    public double getGuthaben() {
        return Guthaben;
    }

    public void setGuthaben(double Guthaben) {
        this.Guthaben = Guthaben;
    }

    /**
     * Erstellt einzigartige ID zur Unterscheidung von Aktien mit gleichen Namen
     *
     * @return die erstellte ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Weist einzigartige ID zur Unterscheidung von Aktien mit gleichen Namen
     * einer Aktien zu Setzt die zugewiesene ID
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * get-Methode für die gekauften Aktien
     *
     * @return
     */
    public Hashtable<String, Integer> getGekaufte_Aktien() {
        return Gekaufte_Aktien;
    }

    /**
     * set-Methode für die gekauften Aktien
     *
     * @param Gekaufte_Aktien
     */
    public void setGekaufte_Aktien(Hashtable<String, Integer> Gekaufte_Aktien) {
        this.Gekaufte_Aktien = Gekaufte_Aktien;
    }

   
    
    @Override
    public String toString(){
        String ausgabe = "";
        ausgabe+="ID: "+id+"\n";
      
        ausgabe+="gekaufte Aktien, Anzahl: "+Gekaufte_Aktien.size()+"\n";
 
        for (Aktie a : this.Aktien){
          ausgabe+= a.toString() + "\n" 
                  +  " Stueckzahl: " + this.Gekaufte_Aktien.get(a.getISIN()) + "\n";
        }     
        return ausgabe;
    }
}
