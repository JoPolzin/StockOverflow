/*
 * 
 */
package model;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * OA = Online-Aktien Diese statische Klasse beeinhaltet alle Funktionen zum
 * zugreifen auf die Informationen von tradegate. Dafür muss zuerst ein Document
 * erstellt werden mit der ISIN der gewählten Aktie.(prepareDocument) Falls die
 * DNS benutz werden soll, muss die zuerst initialisiert werden.
 *
 * @author walle
 */
public class OA {

    /**
     * Hashtable mit Börsennamen und den dazugrhörigen ISIN's ISIN =
     * Internationale Wertpapierkennnummer
     */
    private Hashtable<String, String> DNS;
    /**
     * Die aktuell ausgewählte Website.
     */
    private Document doc;

    public static void main(String[] args) {
        OA t = new OA();
        t.DnsConfig();
        t.prepareDocument("DE000A1EWWW0");
        System.out.println(t.getAsk());
        System.out.println(t.getBid());
        System.out.println(t.getChange());

    }

    /**
     * Gibt bei gegebener ISIN den "ask"-Wert der Aktie zurück.
     *
     * @param ID
     * @return
     * @throws IOException
     */
    public float getAsk() {
        try {

            return Float.parseFloat(this.doc.getElementById("ask").text().replace(',', '.').replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println("Fehler in getAsk()");
            return 0f;
        }

    }

    /**
     * Gibt bei gegebener ISIN den "bid"-Wert der Aktie zurück.
     *
     * @param ID
     * @return
     * @throws IOException
     */
    public float getBid() {
        try {

            return Float.parseFloat(this.doc.getElementById("bid").text().replace(',', '.').replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println("Fehler in getBid()");
            return 0f;
        }

    }

    /**
     * Gibt bei gegebener ISIN den "change"-Wert der ausgewählten Aktie zurück.
     *
     * @param ID
     * @return
     * @throws IOException
     */
    public float getChange() {
        try {

            return Float.parseFloat(this.doc.getElementById("delta").text().replace(',', '.').replaceAll(" ", "").replaceAll("%", ""));
        } catch (Exception e) {
            System.out.println("Fehler in getChange()");
            return 0f;
        }

    }

    /**
     * Initialisiert und konfiguriert die DNS-Liste.
     */
    public void DnsConfig() {
        DNS = new Hashtable();
        getDNS().put("Siemens", "DE0007236101");
    }

    /**
     * @return the DNS
     */
    public Hashtable<String, String> getDNS() {
        return DNS;
    }

    /**
     * Ladet das Document der Website herunter, mit der angegebenen ISIN.
     *
     *
     * @param ISIN
     */
    public void prepareDocument(String ISIN) {
        try {
            doc = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + ISIN).get();

        } catch (IOException e) {
            System.out.println("Fehler in prepareDocument()");

        }

    }

    /**
     *
     * Gibt ein ImageIcon mit dem Graphen von einem bestimmten Zeitraum zurück.
     * Akzeptierte Zeiträume sind: intraday,woche,monat,monat6 und jahr.
     *
     * @param Zeitraum
     * @return
     */

    public ImageIcon getGraph(String Zeitraum) {
        try {
            String link = doc.getElementById(Zeitraum).attr("src");
            String completeLink = "https://www.tradegate.de" + link;

            return new ImageIcon(new URL(completeLink));
        } catch (Exception e) {
            System.out.println("Fehler in getGraph()");
            return null;
        }

    }

}
