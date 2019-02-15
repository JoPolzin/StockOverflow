/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.FirebaseZugriff;
import edu.emory.mathcs.backport.java.util.Collections;
import view.*;
import model.*;
import model.OA;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import view.StockOverflowGUI;
import java.util.Timer;
import java.util.TimerTask;
import model.DatenSpeicher;

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

    public AktieVerkaufen aktieVerkaufen;

    private VerkaufBestätigung verkaufBestätigung;

    private AnmeldeFenster anmeldeFenster;

    private AbmeldeBestätigung abmeldeBestätigung;

    private RegistrierFenster registrierFenster;

    private ProfilFenster profilFenster;

    private EigenesDepot eigenesDepot;

    private StockOverflowGUI stockOverflowGUI;

    private Leaderboard leaderboard;

    private Loading loading;

    public String letztesFenster;

    private String aktIsin;

    private FirebaseZugriff fz;
    private ArrayList<Benutzer> al;
    private boolean eingeloggt;

    private Benutzer b;

    private Anpasser anpasser;
    private int x;
    /**
     * Variable für den Timer. Wenn true läuft der Timer weiter.
     *
     */
    public boolean t = true;
    /**
     * Speichert temporär die Daten der Aktien für das Leaderboard.
     *
     *
     */
    private HashMap<String, Object> WerteDerAktien;

    private Timer timer = new Timer();

    public void timerStart() {
        AktienDatenInitialisieren(0);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                while (t) {
                    AktienDatenAktualisieren(getX());
                }
            }
        }, 5000, 5000);
    }

    public void timerReset() {
        timer.cancel();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                while (t) {
                    AktienDatenAktualisieren(getX());
                }
            }
        }, 5000, 5000);
    }

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
        x = 0;

        fz = new FirebaseZugriff(this);
        //al = fz.benutzerAuslesen();
        loading.jProgressBar1.setValue(80);
        /*if (al == null) {
            JOptionPane.showMessageDialog(null, "Keine Benutzer geladen oder Firebase ungültig.");
        }*/
        leaderboard = new Leaderboard(this);
        timerStart();

        loading.jProgressBar1.setValue(100);
        loading.setVisible(false);
        stockOverflowGUI.setVisible(true);
        this.anpasser = new Anpasser(this);
        anpasser.start();

    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
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
        getLeaderboard().setVisible(false);
        letztesFenster = Guiname;
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
                    this.Depotausgeben();
                    eigenesDepot.setVisible(true);
                } else {
                    anmeldeFenster.setVisible(true);
                }
                break;
            case "StockOverflowGUI":
                stockOverflowGUI.setVisible(true);
                break;
            case "Leaderboard":
                getLeaderboard().setVisible(true);
                break;

            default:
                break;

        }

    }

    public void login() {
        if (eingeloggt) {
            this.logout();
            return;

        } else {

            this.switchTo("AnmeldeFenster");
        }

    }

    public void login(String benutzername, String password) {
        if (eingeloggt) {

        }
        Benutzer b = null;
        b = fz.EinenBenutzerAuslesen(benutzername);
       
        if (!b.Dflt) {
            System.out.println("Falscher Benutzer");
            JOptionPane.showMessageDialog(null, "Der Benutzer existiert nicht.");
            return;
        }
        else if (b.getPasswort().equals(password)) {

            this.stockOverflowGUI.getLogInGUI().setText("Logout");
            this.b = b;
            this.eingeloggt = true;
            this.switchTo(letztesFenster);
            System.out.println("Login erfolgreich");
            JOptionPane.showMessageDialog(null, "Login erfolgreich.\n Angemeldeter Benutzer:\n" + b.toString());
            System.out.println(this.b.getDepot().toString());

            return;

        } else {
            System.out.println("falsches Passwort");
            JOptionPane.showMessageDialog(null, "falsches Passwort");
            this.eingeloggt = false;
            return;

        }

    }

    public void logout() {
        this.eingeloggt = false;
        System.out.println("Logout erfolgreich");
        JOptionPane.showMessageDialog(null, "Logout erfolgreich");

        this.stockOverflowGUI.getLogInGUI().setText("Login");

        this.switchTo("StockOverflowGUI");

    }

    public boolean register(String benutzername, String password, String confPassword, String email) {
        /*FirebaseSaveObject fso = new FirebaseSaveObject();
        if (fso.userUpdates.containsKey(benutzername)) {
            System.out.print("oh well");
        }
        if (password == confPassword) {
            fso.userUpdates.put(benutzername, password);
        }*/
        this.al = fz.benutzerAuslesen();
        for (Benutzer b : getAl()) {
            if (this.fz.WertEinerReferenz("users/"+benutzername, "benutzername")!=null) {
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
            getFz().ergaenzeBenutzer(tmp);
            JOptionPane.showMessageDialog(null, "Benutzername eingetragen: " + tmp.toString());

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
    public void AktienDatenInitialisieren(int x) {
        this.t = false;
        OA.DnsConfig();

        stockOverflowGUI.PreisListe = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            if (i + x >= 0) {
                OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i + x)));
                stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i + x));
                stockOverflowGUI.PreisFelder.get(i).setText(Float.toString(OA.getAsk()));
                stockOverflowGUI.ChangeFelder.get(i).setText(Float.toString(OA.getChange()));
                stockOverflowGUI.PreisListe.add(OA.getAsk());

                stockOverflowGUI.PreisFelder.get(i).setBackground(Color.white);
            } else {
                stockOverflowGUI.AktienFelder.get(i).setText("");
                stockOverflowGUI.PreisFelder.get(i).setText("");
                stockOverflowGUI.ChangeFelder.get(i).setText("");
                stockOverflowGUI.PreisListe.add(OA.getAsk());
            }
        }
        this.t = true;
    }

    /**
     * StockOverflowGUI Aktualisiert Aktien des Daxes und färbt diese.
     */
    public void AktienDatenAktualisieren(int x) {
        this.t = false;
        for (int i = 0; i < 15; i++) {

            if (i + x >= 0) {
                OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i + x)));
                stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i + x));
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
            } else {
                //dont do anything...
            }
        }
        this.t = true;
    }

    //AktieAnsehen:
    /**
     * AktieAnsehen-Funktion Aktualisiert eine Aktie.
     *
     *
     * @param ISIN
     */
    public void AktieDatenInitialisieren(String ISIN, String name) {
        this.t = false;
        OA.prepareDocument(ISIN);
        getAktieAnsehen().Change.setText(Float.toString(OA.getChange()));
        getAktieAnsehen().Preis.setText(Float.toString(OA.getAsk()));
        getAktieAnsehen().ISIN.setText(ISIN);
        getAktieAnsehen().Name.setText(name);
        getAktieAnsehen().AktienBild.setIcon(OA.getGraph("intraday"));
        aktieAnsehen.momentanerPreis = OA.getAsk();
        aktieAnsehen.ausgewählteISIN = ISIN;
        this.t = true;
    }

    public void aktiekaufen(String isin, Integer Stückzahl) {

        if (this.eingeloggt) {
            //getB().setKontostand(getB().getKontostand() - Preis);
            //getB().getDepot().aktie_kaufen(isin, Stückzahl, Preis);
            this.t = false;
            OA.prepareDocument(isin);
            float Preis = OA.getAsk();

            int neuer_preis = (int) Math.round(Preis) * Stückzahl;
            int Konto_Wert = (int) Math.round((double) getFz().WertEinerReferenz("users/" + b.getBenutzername(), "kontostand"));

            int neuer_Kontostand = Konto_Wert - neuer_preis;
            if (neuer_Kontostand <= 0) {
                this.t = true;
                return;
            }
            b.setKontostand(neuer_Kontostand);;

            Aktienkauf ak = new Aktienkauf(isin, Stückzahl);
            ak.setPreis(Preis);
            if (fz.WertEinerReferenz("depots/" + b.getBenutzername() + "/" + isin, "anzahl") != null) {
                ak.setAnzahl(Stückzahl + (int) fz.WertEinerReferenz("depots/" + b.getBenutzername() + "/" + isin, "anzahl"));
            } else {
                ak.setAnzahl(Stückzahl);
            }
            getFz().aktieErgänzen(ak);
            getFz().aendereBenutzer(b);
            this.b = fz.EinenBenutzerAuslesen(b.getBenutzername());

        } else {
            this.switchTo("AnmeldeFenster");

        }
        this.t = true;

        this.Depotausgeben();

    }

    /**
     * AktieAnsehen-Funktion Aktualisiert eine Aktie und färbt diese.
     *
     *
     *
     *
     */
    public void AktieDatenAktualisieren() {
        this.t = false;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hallo");
                // Your database code here
            }
        }, 2000, 2000);

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
        this.t = true;
    }

    public void aktieverkaufen(String isin, Integer Stückzahl) {
        if (this.eingeloggt) {
            this.t = false;
            OA.prepareDocument(isin);
            double aktienWert = OA.getAsk();
            this.fz.AktieStückzahlAktualisieren(isin, Stückzahl, aktienWert);

            this.getB().setKontostand(this.RundenKommastellen(this.b.getKontostand() + aktienWert * Stückzahl));
            this.fz.aendereBenutzer(this.b);
            this.b = fz.EinenBenutzerAuslesen(b.getBenutzername());
            this.t = true;

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
        DatenSpeicher.AktienWerte = new HashMap<>();
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
        this.al = this.fz.benutzerAuslesen();
        this.t = false;
        double GesamtKapital = 0;
        ArrayList<Benutzer> sortList = this.SortBenutzer(getAl());
        Collections.reverse(sortList);
        for (Benutzer b : sortList) {
            System.out.println(b.getBenutzername() + "---" + b.GesamtKapital());
        }

        if (sortList.size() >= 5) {
            getLeaderboard().Platz1.setText(sortList.get(0).getBenutzername());
            getLeaderboard().Platz2.setText(sortList.get(1).getBenutzername());
            getLeaderboard().Platz3.setText(sortList.get(2).getBenutzername());
            getLeaderboard().Platz4.setText(sortList.get(3).getBenutzername());
            getLeaderboard().Platz5.setText(sortList.get(4).getBenutzername());
            getLeaderboard().Punktzahl1.setText("" + RundenKommastellen(sortList.get(0).GesamtKapital()));
            getLeaderboard().Punktzahl2.setText("" + RundenKommastellen(sortList.get(1).GesamtKapital()));
            getLeaderboard().Punktzahl3.setText("" + RundenKommastellen(sortList.get(2).GesamtKapital()));
            getLeaderboard().Punktzahl4.setText("" + RundenKommastellen(sortList.get(3).GesamtKapital()));
            getLeaderboard().Punktzahl5.setText("" + RundenKommastellen(sortList.get(4).GesamtKapital()));
            for (Benutzer b : sortList) {
                GesamtKapital = GesamtKapital + b.GesamtKapital();

            }

            getLeaderboard().GesamtPunktzahl.setText("" + RundenKommastellen(GesamtKapital));

        }
        this.t = true;

    }

    public double RundenKommastellen(double Zahl) {
        Zahl = Zahl * 100;
        Zahl = Math.round(Zahl);
        return Zahl / 100;

    }

    public void aktualisiereLeaderboard() {
        this.setAl(this.getFz().benutzerAuslesen());
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

    /**
     * @return the al
     */
    public ArrayList<Benutzer> getAl() {
        return al;
    }

    /**
     * @param al the al to set
     */
    public void setAl(ArrayList<Benutzer> al) {
        this.al = al;
    }

    /**
     * @return the fz
     */
    public FirebaseZugriff getFz() {
        return fz;
    }

    /**
     * @return the anpasser
     */
    public Anpasser getAnpasser() {
        return anpasser;
    }

    public void LeaderboardAktu() {
        this.anpasser.start();

    }

    public boolean isEingeloggt() {
        return eingeloggt;
    }

    /**
     * @return the leaderboard
     */
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public void Depotausgeben() {

        if (this.b.getDepot() != null) {
            for (int i = 0; i < 15; i++) {
                this.eigenesDepot.getNamenFlds().get(i).setText("");
                this.eigenesDepot.getPreisFlds().get(i).setText("");
                this.eigenesDepot.getStueckzahlFlds().get(i).setText("");
            }

            for (int i = 0; i < this.b.getDepot().getAktien().size() && i < 15; i++) {

                Aktie akt = this.b.getDepot().getAktien().get(i);

                System.out.println(akt.getISIN());
                int Preis = akt.getStueckzahl();

                this.eigenesDepot.getNamenFlds().get(i).setText(akt.getISIN());
                this.eigenesDepot.getPreisFlds().get(i).setText(akt.getName());
                this.eigenesDepot.getStueckzahlFlds().get(i).setText(this.b.getDepot().getGekaufte_Aktien().get(akt.getISIN()).toString());

                //   }
            }
        }

    }

    public void AktieKaufenInitialisieren() {
        this.aktieKaufen.KaufenNameDerAktieEingabe.setText(this.aktieAnsehen.ausgewählteISIN);
        this.t = false;
        OA.prepareDocument(this.aktieAnsehen.ausgewählteISIN);
        this.aktieKaufen.KaufenPreisProStückEingabe.setText("" + OA.getAsk());
        this.t = true;
    }

    public void AktieVerkaufenInitilalisieren(String isin) {
        this.aktieVerkaufen.VerkaufenNameDerAktieEingabe.setText(isin);

    }

}
