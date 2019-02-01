/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Firebasezugriff.FirebaseZugriff;
import edu.emory.mathcs.backport.java.util.Collections;
import view.*;
import model.*;
import model.OA;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.StockOverflowGUI;

/**
 *
 * @author Commander
 */
public class maincontrol {

    /**
     * @return the aktieAnsehen
     */
    public AktieAnsehen getAktieAnsehen() {
        return aktieAnsehen;
    }

    private AktieAnsehen aktieAnsehen;

    private AktieKaufen aktieKaufen;

    private KaufBestätigung kaufBestätigung;

    private AktieVerkaufen aktieVerkaufen;

    private VerkaufBestätigung verkaufBestätigung;

    private AnmeldeFenster anmeldeFenster;
    
    private AbmeldeBestätigung abmeldeBestätigung;

    private RegistrierFenster registrierFenster;

    private ProfilFenster profilFenster;

    private EigenesDepot eigenesDepot;

    private StockOverflowGUI stockOverflowGUI;

    private Leaderboard leaderboard;

    private Loading loading;

    private String aktIsin;

    private FirebaseZugriff fz;
    private ArrayList<Benutzer> al;
    private boolean eingeloggt;

    private Benutzer b;

    public maincontrol() {
        loading = new Loading();
        loading.setVisible(true);
        loading.jProgressBar1.setValue(3);
        aktieAnsehen = new AktieAnsehen(this);
        loading.jProgressBar1.setValue(6);
        aktieKaufen = new AktieKaufen(this);
        loading.jProgressBar1.setValue(9);
        kaufBestätigung = new KaufBestätigung(this);
        loading.jProgressBar1.setValue(12);
        abmeldeBestätigung = new AbmeldeBestätigung(this);
        loading.jProgressBar1.setValue(14);
        aktieVerkaufen = new AktieVerkaufen(this);
        loading.jProgressBar1.setValue(15);
        verkaufBestätigung = new VerkaufBestätigung(this);
        loading.jProgressBar1.setValue(18);
        anmeldeFenster = new AnmeldeFenster(this);
        loading.jProgressBar1.setValue(21);
        registrierFenster = new RegistrierFenster(this);
        loading.jProgressBar1.setValue(24);
        profilFenster = new ProfilFenster(this);
        loading.jProgressBar1.setValue(27);
        eigenesDepot = new EigenesDepot(this);
        loading.jProgressBar1.setValue(30);
        stockOverflowGUI = new StockOverflowGUI(this);
        loading.jProgressBar1.setValue(33);

        fz = new FirebaseZugriff(this);
        al = fz.benutzerAuslesen();
        loading.jProgressBar1.setValue(80);
        if (al == null) {
            JOptionPane.showMessageDialog(null, "Keine Benutzer geladen oder Firebase ungültig.");
        }
        leaderboard = new Leaderboard(this);
        LeaderboardInit();
        AktienDatenInitialisieren();
        loading.jProgressBar1.setValue(100);
        loading.setVisible(false);
        stockOverflowGUI.setVisible(true);

    }

    public boolean getEingeloggt() {
        return eingeloggt;
    }

    public void switchTo(String Guiname) {

        getAktieAnsehen().setVisible(false);
        aktieKaufen.setVisible(false);
        kaufBestätigung.setVisible(false);
        aktieVerkaufen.setVisible(false);
        verkaufBestätigung.setVisible(false);
        abmeldeBestätigung.setVisible(false);
        anmeldeFenster.setVisible(false);
        registrierFenster.setVisible(false);
        profilFenster.setVisible(false);
        eigenesDepot.setVisible(false);
        stockOverflowGUI.setVisible(false);
        leaderboard.setVisible(false);

        switch (Guiname) {
            case "AktieAnsehen":

                getAktieAnsehen().setVisible(true);

                break;
            case "AktieKaufen":
                if (this.eingeloggt) {
                    aktieKaufen.setVisible(true);
                } else {
                    anmeldeFenster.setVisible(true);
                }
                break;
            case "KaufBestätigung":
                kaufBestätigung.setVisible(true);
                break;
            case "AktieVerkaufen":
                if (this.eingeloggt) {
                    aktieVerkaufen.setVisible(true);
                } else {
                    anmeldeFenster.setVisible(true);
                }
                break;
            case "VerkaufBestätigung":
                verkaufBestätigung.setVisible(true);
                break;
            case "AbmeldeBestätigung":
                abmeldeBestätigung.setVisible(true);
                break;
            case "AnmeldeFenster":
                anmeldeFenster.setVisible(true);
                break;
            case "RegistrierFenster":
                registrierFenster.setVisible(true);
                break;
            case "ProfilFenster":
                if (eingeloggt) {
                    profilFenster.setVisible(true);
                } else {
                    anmeldeFenster.setVisible(true);
                }
                break;
            case "EigenesDepot":
                if (eingeloggt) {
                    eigenesDepot.setVisible(true);
                } else {
                    anmeldeFenster.setVisible(true);
                }
                break;
            case "StockOverflowGUI":
                stockOverflowGUI.setVisible(true);
                break;
            case "Leaderboard":
                leaderboard.setVisible(true);
                break;

            default:
                break;

        }

    }

    public void login(String benutzername, String password) {
        boolean erfolgreich;
        Benutzer b = null;
        if (al == null) {
            JOptionPane.showMessageDialog(null, "Anmeldung nicht möglich. Es sind keine Benutzer bekannt.");

        }
        for (Benutzer tmp : al) {
            if (tmp.getBenutzername().equals(benutzername)) {
                b = tmp;
                break;
            }
        }
        if (b == null) {
            System.out.println("Falscher Benutzer");
            JOptionPane.showMessageDialog(null, "Der Benutzer existiert nicht.");
            return;
        }
        if (b.getPasswort().equals(password)) {

            System.out.println("Login erfolgreich");
            JOptionPane.showMessageDialog(null, "Login erfolgreich.\n Angemeldeter Benutezr:\n" + b.toString());
            
            this.b = b;
            erfolgreich = true;
            this.eingeloggt = true;
            this.switchTo("EigenesDepot");

        }

    }

    public boolean register(String benutzername, String password, String confPassword, String email) {
        /*FirebaseSaveObject fso = new FirebaseSaveObject();
        if (fso.userUpdates.containsKey(benutzername)) {
            System.out.print("oh well");
        }
        if (password == confPassword) {

            fso.userUpdates.put(benutzername, password);
        }*/
        for (Benutzer b : al) {
            if (b.getBenutzername().equalsIgnoreCase(benutzername)) {
                JOptionPane.showMessageDialog(null, "Benutzername schon vergeben");
                return false;
            }
            if (b.getEmail().equalsIgnoreCase(benutzername)) {
                JOptionPane.showMessageDialog(null, "Benutzername schon vergeben");
                return false;
            }
        }
        if (password.equals(confPassword)) {
            Benutzer tmp = new Benutzer();
            tmp.setBenutzername(benutzername);
            tmp.setPasswort(password);
            tmp.setEmail(email);
            tmp.setKontostand(1000);
            fz.ergaenzeBenutzer(tmp);
            JOptionPane.showMessageDialog(null, "Benutzername eingetragen: " + tmp.toString());
            this.al = this.fz.benutzerAuslesen();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Passwortfelder nicht gleich");

            return false;
        }

    }

    public String getAktIsin() {
        return aktIsin;
    }

    public void setAktIsin(String aktIsin) {
        this.aktIsin = aktIsin;
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
    public void AktieDatenInitialisieren(String ISIN, String name) {
        OA.prepareDocument(ISIN);
        getAktieAnsehen().Change.setText(Float.toString(OA.getChange()));
        getAktieAnsehen().Preis.setText(Float.toString(OA.getAsk()));
        getAktieAnsehen().ISIN.setText(ISIN);
        getAktieAnsehen().Name.setText(name);
        getAktieAnsehen().AktienBild.setIcon(OA.getGraph("intraday"));
        aktieAnsehen.momentanerPreis = OA.getAsk();
        aktieAnsehen.ausgewählteISIN = ISIN;
    }

    public void aktiekaufen(String isin, Integer Stückzahl, Double Preis) {
        if (this.eingeloggt) {
            //getB().setKontostand(getB().getKontostand() - Preis);
            //getB().getDepot().aktie_kaufen(isin, Stückzahl, Preis);
            OA.prepareDocument(isin);

            Aktienkauf ak = new Aktienkauf(isin, Stückzahl);
            ak.setPreis(Preis);
            fz.aktieErgänzen(ak);
            int neuer_preis = (int) Math.round(Preis) * Stückzahl;
            int Wert = (int) Math.round((double)fz.WertEinerReferenz("users/"+b.getBenutzername(),"kontostand"));
            int neuer_Kontostand = Wert - neuer_preis;
            b.setKontostand(neuer_Kontostand);
            System.out.println(b.getEmail());
            System.out.println(b.getPasswort());
            fz.aendereBenutzer(b);
            
            
        } else {
            this.switchTo("AnmeldeFenster");

        }

    }

    /**
     * AktieAnsehen-Funktion Aktualisiert eine Aktie und färbt diese.
     *
     *
     *
     *
     */
    public void AktieDatenAktualisieren() {
        OA.prepareDocument(getAktieAnsehen().ausgewählteISIN);
        getAktieAnsehen().Change.setText(Float.toString(OA.getChange()));
        getAktieAnsehen().Preis.setText(Float.toString(OA.getAsk()));
        if (getAktieAnsehen().momentanerPreis > OA.getAsk()) {
            getAktieAnsehen().Preis.setBackground(Color.red);

        } else if (getAktieAnsehen().momentanerPreis < OA.getAsk()) {
            getAktieAnsehen().Preis.setBackground(Color.green);

        } else {
            getAktieAnsehen().Preis.setBackground(Color.white);
        }

    }

    public void aktieverkaufen(String isin, Integer Stückzahl, Float Preis) {
        if (this.eingeloggt) {
        } else {
            this.switchTo("AnmeldeFenster");

        }

    }

    /**
     * Gibt eine aufwärts sortierte Liste der Bnutzer zurück sortiert nach dem
     * GesamtKapital.
     *
     *
     *
     * @param Benutzer
     * @return
     */
    public ArrayList<Benutzer> SortBenutzer(ArrayList<Benutzer> Benutzer) {
        ArrayList<Benutzer> sort = Benutzer;
        boolean done = false;

        while (!done) {
            done = true;
            for (int i = 0; i < sort.size(); i++) {
                if (i != sort.size() - 1) {
                    if (sort.get(i).GesamtKapital() > sort.get(i + 1).GesamtKapital()) {
                        Benutzer m = sort.get(i + 1);
                        sort.set(i + 1, sort.get(i));
                        sort.set(i, m);
                        done = false;
                    }
                }

            }

        }
        return sort;

    }

    /**
     *
     *
     * Initialisiert das Leaderboard.
     */
    public void LeaderboardInit() {
        double GesamtKapital = 0;
        ArrayList<Benutzer> sortList = this.SortBenutzer(al);
        Collections.reverse(sortList);
        if (sortList.size() >= 5) {
            leaderboard.Platz1.setText(sortList.get(0).getBenutzername());
            leaderboard.Platz2.setText(sortList.get(1).getBenutzername());
            leaderboard.Platz3.setText(sortList.get(2).getBenutzername());
            leaderboard.Platz4.setText(sortList.get(3).getBenutzername());
            leaderboard.Platz5.setText(sortList.get(4).getBenutzername());
            leaderboard.Punktzahl1.setText("" + RundenKommastellen(sortList.get(0).GesamtKapital()));
            leaderboard.Punktzahl2.setText("" + RundenKommastellen(sortList.get(1).GesamtKapital()));
            leaderboard.Punktzahl3.setText("" + RundenKommastellen(sortList.get(2).GesamtKapital()));
            leaderboard.Punktzahl4.setText("" + RundenKommastellen(sortList.get(3).GesamtKapital()));
            leaderboard.Punktzahl5.setText("" + RundenKommastellen(sortList.get(4).GesamtKapital()));
            for (Benutzer b : sortList) {
                GesamtKapital = GesamtKapital + b.GesamtKapital();

            }

            leaderboard.GesamtPunktzahl.setText("" + RundenKommastellen(GesamtKapital));

        }

    }

    public double RundenKommastellen(double Zahl) {
        Zahl = Zahl * 100;
        Zahl = Math.round(Zahl);
        return Zahl / 100;

    }

    public void aktualisiereLeaderboard() {
        this.al = this.fz.benutzerAuslesen();
        this.LeaderboardInit();

    }

    /**
     * @return the b
     */
    public Benutzer getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Benutzer b) {
        this.b = b;
    }

}
