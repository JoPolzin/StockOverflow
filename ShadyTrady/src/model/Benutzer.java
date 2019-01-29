/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 *
 * Request#2: Konstuktor ausarbeiten
 *
 * Request#1(closed): Benutzer erfordert Designtechnische Entscheidung:
 *
 *
 * 1. Es gibt immer einen automatisch erzeugten Default-User(Guest) beim
 * Login/Logout werden dessen Attribute Ueberschrieben. Es gibt demnach
 * verschiedene Berechtiegungsstufen. Gast darf: alle Guis angucken (Aktionen
 * sind geperrt) und sich Einloggen User darf: sein Depot verwalten / Aktien an
 * und verkaufen und sich ausloggen Es werden beim Gast Defaultwerte angezeigt.
 * Ueber eine zusaetzliches Attribut ::Booloean wird abgefragt ob ein gast die
 * entsprechenden Berechtigungen hat. Ueber Das Objekt koennten konkrete
 * loginversuche behandelt werden.
 *
 * 2. Das konkretes Objekt wird erst nach dem Login wird erst nach dem Login
 * erstellt und nach dem Logout geloescht. Die Anzeigen haben interne
 * Defaultanzeigen fuer benutzerspezifische Daten, welcher sie solange benutzen
 * bis ein benutzer existiert. Link von Anzeige zu Modell geht ueber den
 * Control, welcher alle Objekte erzeugt. Sinnvoll waere auch dort eine Boolean
 * fuers Login zu verwenden um Nullpointerexheptions vorzubeugen.
 *
 * Solution: Nach basisdemokratischer Abstimmung der Logikgruppe:
 *
 * Vorschlag 1. - Vorschlag 2. Zochrab Enthaltungen: Johanna, Leon nicht
 * teilgenommon: Chantal, Joshua
 *
 * wurde sich fuer die zweite Version entschieden.
 *
 *
 *******************************************************************************
 *
 * Allgemeines:
 *
 * Der Benutzer umfaesst/verwaltet primitive Benutzerinformationen wie:
 * Benutzer, Email und Kontostand. !Achtung das Passwort wird hierbei nicht
 * gespeichert!
 *
 * Er wird bei jeder Sitzung neu erzeugt. Der benutzer enthaelt(-> erzeugt)
 * jeweils ein eigenes Aktienkonto und ist demnach wichtig fuer die
 * kommunikation bei Aktienaktionen.
 *
 * Fuer den Bnutzer ist vorallem eine gute zusammenarbeit mit der Firebase
 * erfordert. Hier kommen vermutlich noch jede menge weitere funktion zustande
 * um die Sitzungen zu verwalten
 *
 *
 * @author Chantal
 * @author Leon
 */
public class Benutzer {

    /**
     * Name des Benutzers
     */
    private String Benutzername;

    /**
     * Name des Passwortes
     */
    private String Passwort;

    /**
     * Name der Email
     */
    private String Email;
    /**
     * Hoehe des Kontostandes
     */
    private double Kontostand;
    /**
     * Aktienkonto des Benutzers
     */
    private Aktienkonto depot;

    public Benutzer(String Benutzername) {
        this.Benutzername = Benutzername;
        depot = new Aktienkonto();
    }

    public Benutzer() {
        depot = new Aktienkonto();
    }

    /**
     * getter-Methode des Benutzers
     *
     * @see Benutzername
     * @return
     */
    public String getBenutzername() {
        return Benutzername;
    }

    /**
     * load-Methode des Benutzers
     *
     * @param Benutzername
     */
    public void loadBenutzername(String Benutzername) {
        this.Benutzername = Benutzername;
    }

    /**
     * load-Methode des Passwortes
     *
     * @return
     */
    public void loadPasswort(String Passwort) {
        this.Passwort = Passwort;
    }

    /**
     * save-Methode
     */
    public void save() {
    }

    /**
     * setter-Methode des Benutzers
     *
     * @param Benutzername
     */
    public void setBenutzername(String Benutzername) {
        this.Benutzername = Benutzername;
    }

    /**
     * getter-Methode des Aktienkontos
     *
     * @return
     */
    public Aktienkonto getDepot() {
        return depot;
    }

    /**
     * setter-Methode des Aktienkontos
     *
     * @param depot
     */
    public void setDepot(Aktienkonto depot) {
        this.depot = depot;
    }

    /**
     * getter-Methode des Passwortes
     *
     * @return
     */
    public String getPasswort() {
        return Passwort;
    }

    /**
     * getter-Methode der Email
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     * getter-Methode des Kontostandes
     *
     * @return
     */
    public double getKontostand() {
        return Kontostand;
    }

    /**
     * setter-Methode des Passwortes
     *
     * @return
     */
    public void setPasswort(String Passwort) {
        this.Passwort = Passwort;
    }

    /**
     * setter-Methode der Email
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * setter-Methode des Kontostandes
     *
     * @param Kontostand
     */
    public void setKontostand(double Kontostand) {
        this.Kontostand = Kontostand;
    }

    @Override
    public String toString() {
        String ausgabe = "";
        ausgabe += "Benutzername: " + Benutzername + "\n";
        ausgabe += "Passwort: " + Passwort + "\n";
        ausgabe += "Kontostand: " + Kontostand + "\n";
        ausgabe += "Email: " + Email + "\n";
        ausgabe += "Depot: " + Arrays.toString(depot.getAktien().toArray()) + "\n";
        return ausgabe;
    }
    /**
     * Berechnet das gesamte Kapital mit den aktuellen Werten der Aktien.
     * 
     * 
     * @return 
     */

    public double GesamtKapital() {
        double Kapital = this.getKontostand();
        for (Aktie e : this.depot.getAktien()) {
            
            OA.prepareDocument(e.getISIN());
            System.out.println(e.getISIN());
            System.out.println(e.getStueckzahl());
            System.out.println(OA.getAsk());
            double Aktienwert  = (int) Math.round(OA.getAsk()) * e.getStueckzahl();
            Kapital = Kapital + Aktienwert;
        }
        return Kapital;

    }

}
