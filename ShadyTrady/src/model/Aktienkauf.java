/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *  Sammelklasse zur Ablage aller Aktienkäufe in der Firebase
 * @author K
 */
public class Aktienkauf {
    private String kaeufername;
    private String iisn;
    private int anzahl;
    public Aktienkauf(String derKaeufer, String dieIISN, int dieAnzahl){
        kaeufername = derKaeufer;
        iisn = dieIISN;
        anzahl = dieAnzahl;
    }

    /**
     * @return the kaeufername
     */
    public String getKaeufername() {
        return kaeufername;
    }

    /**
     * @param kaeufername the kaeufername to set
     */
    public void setKaeufername(String kaeufername) {
        this.kaeufername = kaeufername;
    }

    /**
     * @return the iisn
     */
    public String getIisn() {
        return iisn;
    }

    /**
     * @param iisn the iisn to set
     */
    public void setIisn(String iisn) {
        this.iisn = iisn;
    }

    /**
     * @return the anzahl
     */
    public int getAnzahl() {
        return anzahl;
    }

    /**
     * @param anzahl the anzahl to set
     */
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
    
    @Override
    public String toString(){
        String ausgabe = "";
        ausgabe+="Kaeufer: "+kaeufername+"\n";
        ausgabe+="IISN: "+iisn+"\n";
        ausgabe+="Anzahl: "+anzahl+"\n";
        return ausgabe;
    }
}
