/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.*;
import model.*;
import model.OA;
import TEST.*;
import java.awt.Color;
import java.util.ArrayList;
import shadytrady.*;
import view.StockOverflowGUI;

/**
 *
 * @author Commander
 */
public class maincontrol {

    private AktieAnsehen aktieAnsehen;

    private AktieKaufen aktieKaufen;

    private AktieVerkaufen aktieVerkaufen;

    private AnmeldeFenster anmeldeFenster;

    private EigenesDepot eigenesDepot;

    private StockOverflowGUI stockOverflowGUI;

    private FirebaseSaveObject fso;

    private Benutzer b;

    public maincontrol() {
        aktieAnsehen = new AktieAnsehen(this);
        aktieKaufen = new AktieKaufen(this);
        aktieVerkaufen = new AktieVerkaufen(this);
        anmeldeFenster = new AnmeldeFenster(this);
        eigenesDepot = new EigenesDepot(this);
        stockOverflowGUI = new StockOverflowGUI(this);
        fso = new FirebaseSaveObject(this);

        stockOverflowGUI.setVisible(true);
        AktienDatenInitialisieren();
    }

    public void switchTo(String Guiname) {

        aktieAnsehen.setVisible(false);
        aktieKaufen.setVisible(false);
        aktieVerkaufen.setVisible(false);
        anmeldeFenster.setVisible(false);
        eigenesDepot.setVisible(false);
        stockOverflowGUI.setVisible(false);

        switch (Guiname) {
            case "AktieAnsehen":
                aktieAnsehen.setVisible(true);
                break;
            case "AktieKaufen":
                aktieKaufen.setVisible(true);
                break;
            case "AktieVerkaufen":
                aktieVerkaufen.setVisible(true);
                break;
            case "AnmeldeFenster":
                anmeldeFenster.setVisible(true);
                break;
            case "EigenesDepot":
                eigenesDepot.setVisible(true);
                break;
            case "StockOverflowGUI":
                stockOverflowGUI.setVisible(true);
                break;

            default:
                break;

        }

    }

    public void login(String benutzername, String password) {
        boolean erfolgreich = false;

        if (this.fso.getpassword(benutzername).equals(password)) {

            System.out.println("Login erfolgreich");
            b = new Benutzer(benutzername);
            this.switchTo("EigenesDepot");
            erfolgreich = true;
        }

    }
    public void register(String benutzername, String password,String confPassword){
        FirebaseSaveObject fso = new FirebaseSaveObject();
       if( fso.userUpdates.containsKey(benutzername)){
           System.out.print("oh well");
       }
       if(password==confPassword){
           
            fso.userUpdates.put(benutzername, password);
       }
            
     }
    
    
    
    

    public static void main(String[] args) {
        new maincontrol();
    }

    //StockOverflowGUI-Funktionen
    /**
     * StockOverflowGUI Initialisiert Aktien des Daxes.
     */
    public void AktienDatenInitialisieren() {
        OA.DnsConfig();
        stockOverflowGUI.PreisListe = new ArrayList<>();

        for (int i = 0; i < stockOverflowGUI.AktienFelder.size(); i++) {

            OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i)));
            stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i));
            stockOverflowGUI.PreisFelder.get(i).setText(Float.toString(OA.getAsk()));
            stockOverflowGUI.ChangeFelder.get(i).setText(Float.toString(OA.getChange()));
            stockOverflowGUI.PreisListe.add(OA.getAsk());
        }
    }

    /**
     * StockOverflowGUI Aktualisiert Aktien des Daxes und färbt diese.
     */

    public void AktienDatenAktualisieren() {
        for (int i = 0; i < stockOverflowGUI.AktienFelder.size(); i++) {

            OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i)));
            stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i));
            stockOverflowGUI.PreisFelder.get(i).setText(Float.toString(OA.getAsk()));
            stockOverflowGUI.ChangeFelder.get(i).setText(Float.toString(OA.getChange()));
            if ((float) stockOverflowGUI.PreisListe.get(i) > OA.getAsk()) {
                stockOverflowGUI.PreisFelder.get(i).setBackground(Color.red);
            } else if ((float) stockOverflowGUI.PreisListe.get(i) < OA.getAsk()) {
                stockOverflowGUI.PreisFelder.get(i).setBackground(Color.green);

            } else {
                stockOverflowGUI.PreisFelder.get(i).setBackground(Color.white);
            }
            stockOverflowGUI.PreisListe.set(i, OA.getAsk());

        }

    }

    //AktieAnsehen:
    /**
     * AktieAnsehen-Funktion Aktualisiert eine Aktie.
     *
     *
     * @param ISIN
     */

    public void AktieDatenInitialisieren(String ISIN) {
        OA.prepareDocument(aktieAnsehen.ISIN.getText());
        aktieAnsehen.Change.setText(Float.toString(OA.getChange()));
        aktieAnsehen.Preis.setText(Float.toString(OA.getAsk()));
        aktieAnsehen.momentanerPreis = OA.getAsk();
        aktieAnsehen.ausgewählteISIN = ISIN;
    }

    /**
     * AktieAnsehen-Funktion Aktualisiert eine Aktie und färbt diese.
     *
     *
     *
     *
     */

    public void AktieDatenAktualisieren() {
        OA.prepareDocument(aktieAnsehen.ausgewählteISIN);
        aktieAnsehen.Change.setText(Float.toString(OA.getChange()));
        aktieAnsehen.Preis.setText(Float.toString(OA.getAsk()));
        if (aktieAnsehen.momentanerPreis > OA.getAsk()) {
            aktieAnsehen.Preis.setBackground(Color.red);

        } else if (aktieAnsehen.momentanerPreis < OA.getAsk()) {
            aktieAnsehen.Preis.setBackground(Color.green);

        } else {
            aktieAnsehen.Preis.setBackground(Color.white);
        }

    }

}
