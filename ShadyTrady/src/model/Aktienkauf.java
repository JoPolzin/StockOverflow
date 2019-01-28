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
    private String isin;
    private int anzahl;
    private double preis;
    public Aktienkauf(String derKaeufer, String dieISIN, int dieAnzahl){
        kaeufername = derKaeufer;
        isin = dieISIN;
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
    public String getIsin() {
        return isin;
    }

    /**
     * @param isin the iisn to set
     */
    public void setIisn(String isin) {
        this.isin = isin;
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
        ausgabe+="IISN: "+isin+"\n";
        ausgabe+="Anzahl: "+anzahl+"\n";
        return ausgabe;
    }

    /**
     * @return the preis
     */
    public double getPreis() {
        return preis;
    }

    /**
     * @param preis the preis to set
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }
}
