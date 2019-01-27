/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.maincontrol;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ICH HASB KEINE AHNUNG WAS ICH MACHE HILFE!!!!!!!!! DANKE JOHANNA
 *
 * Aktienkonto wird bei der erzeugung des Benutzers erzeugt. nach
 *
 * @author zochrab.blume
 */
public class Aktienkonto {

    private Integer id;
    private Hashtable<Aktie, Integer> Gekaufte_Aktien;
    private int Guthaben;
    private Aktie gekaufteAktie;
    private maincontrol c;

    public Aktienkonto() {
        Gekaufte_Aktien = new Hashtable<>();
    }

    public Aktienkonto(maincontrol mc) {
        Gekaufte_Aktien = new Hashtable<>();

        this.c = mc;

    }

    /**
     * Aktien kaufen
     *
     * @param aid
     * @param Stueckzahl
     * @param Preis
     */
    public void aktie_kaufen(String aid, int Stueckzahl, double Preis) {
        /*
        boolean bereitsgekauft = false;

        if (!Gekaufte_Aktien.isEmpty()) {

            this.Gekaufte_Aktien.forEach((Aktie akt, Integer b) -> {
                if (akt.getISIN().equals(aid)) {

                }
            });

            if (!bereitsgekauft) {
                Gekaufte_Aktien.put(new Aktie(aid, Preis), Stueckzahl);

            }

        }
         */
        Gekaufte_Aktien.put(new Aktie(aid, Preis), Stueckzahl);

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
    public Hashtable<Aktie, Integer> getGekaufte_Aktien() {
        return Gekaufte_Aktien;
    }

    /**
     * set-Methode für die gekauften Aktien
     *
     * @param Gekaufte_Aktien
     */
    public void setGekaufte_Aktien(Hashtable<Aktie, Integer> Gekaufte_Aktien) {
        this.Gekaufte_Aktien = Gekaufte_Aktien;
    }

    /**
     * get-Methode für das Guthaben
     *
     * @return
     */
    public Integer getGuthaben() {
        return Guthaben;
    }

    /**
     * set-Methode für das Guthaben
     *
     * @param Guthaben
     */
    public void setGuthaben(Integer Guthaben) {
        this.Guthaben = Guthaben;
    }

    /**
     * get-Methode für die gekaufte Aktie
     *
     * @return
     */
    public Aktie getGekaufteAktie() {
        return gekaufteAktie;
    }

    /**
     * set-Methode für die gekaufte Aktie
     *
     * @param gekaufteAktie
     */
    public void setGekaufteAktie(Aktie gekaufteAktie) {
        this.gekaufteAktie = gekaufteAktie;
    }
    
    @Override
    public String toString(){
        String ausgabe = "";
        ausgabe+="ID: "+id+"\n";
        ausgabe+="Guthaben: "+Guthaben+"\n";
        ausgabe+="gekaufte Aktien, Anzahl: "+Gekaufte_Aktien.size()+"\n";
        Iterator it = Gekaufte_Aktien.entrySet().iterator();
            while (it.hasNext()) {
                ausgabe+= it.next().toString()+"\n";
            }
        return ausgabe;
    }
}
