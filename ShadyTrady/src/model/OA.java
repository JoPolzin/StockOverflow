/*
 * 
 */
package model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.function.BiConsumer;
import javax.swing.ImageIcon;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * OA = Online-Aktien Diese statische Klasse beeinhaltet alle Funktionen zum
 * zugreifen auf die Informationen von tradegate.
 *
 * @author walle
 */
public class OA {

    /**
     * Hashtable mit Börsennamen und den dazugrhörigen ISIN's ISIN =
     * Internationale Wertpapierkennnummer
     */
    private static Hashtable<String, String> DNS = new Hashtable();

    private static ArrayList<String> DNSString = new ArrayList<>();

    /**
     * Die aktuell ausgewählte Website.
     *
     *
     */
    private static Document doc;

    private static String momentaneISIN;

    public static void main(String[] args) {
        OA t = new OA();
        t.DnsConfig();
        t.prepareDocument("DE000A1EWWW0");
        System.out.println(t.getAsk());
        System.out.println(t.getBid());
        System.out.println(t.getChange());

        //System.out.println(t.getAsk(t.getDNS().get("Siemens")));
    }

    /**
     * Gibt bei gegebener ISIN den "ask"-Wert der Aktie zurück.
     *
     * @param ID
     * @return
     * @throws IOException
     */
    public static float getAsk() {
        try {

            return Float.parseFloat(doc.getElementById("ask").text().replace(',', '.').replaceAll(" ", ""));
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
    public static float getBid() {
        try {

            return Float.parseFloat(doc.getElementById("bid").text().replace(',', '.').replaceAll(" ", ""));
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
    public static float getChange() {
        try {

            return Float.parseFloat(doc.getElementById("delta").text().replace(',', '.').replaceAll(" ", "").replaceAll("%", ""));
        } catch (Exception e) {
            System.out.println("Fehler in getChange()");
            return 0f;
        }

    }

    /**
     * Konfiguriert die DNS-Liste.
     */
    public static void DnsConfig() {

        getDNS().put("adidas AG", "DE000A1EWWW0");
        getDNS().put("Allianz SE", "DE0008404005");
        getDNS().put("BASF SE", "DE000BASF111");
        getDNS().put("Bayer AG", "DE000BAY0017");
        getDNS().put("Bayerische Motorenwerke AG", "DE0005190003");
        getDNS().put("Beiersdorf AG", "DE0005200000");
        getDNS().put("Continental AG", "DE0005439004");
        getDNS().put("Covestro AG", "DE0006062144");
        getDNS().put("Daimler AG", "DE0007100000");
        getDNS().put("Deutsche Bank AG", "DE0005140008");
        getDNS().put("Deutsche Börse AG", "DE0005810055");
        getDNS().put("Deutsche Lufthansa Ag", "DE0008232125");
        getDNS().put("Deutsche Post AG", "DE0005552004");
        getDNS().put("Deutsche Telekom AG", "DE0005557508");
        getDNS().put("E.ON SE", "DE000ENAG999");
        getDNS().put("Fresenius Medical Care KGaA", "DE0005785802");
        getDNS().put("Fresenius SE & Co. KGaA", "DE0005785604");
        getDNS().put("HeidelbergCement AG", "DE0006047004");
        getDNS().put("Henkel AG & Co. KGaA VZ", "DE0006048432");
        getDNS().put("Infineon Technologies AG", "DE0006231004");
        getDNS().put("Linde PLC", "IE00BZ12WP82");
        getDNS().put("Merck KGaA", "DE0006599905");
        getDNS().put("Münchener Rückvers.-Ges. AG", "DE0008430026");
        getDNS().put("RWE AG", "DE0007037129");
        getDNS().put("SAP SE", "DE0007164600");
        getDNS().put("Siemens", "DE0007236101");
        getDNS().put("thyssenkrupp AG", "DE0007500001");
        getDNS().put("Volkswagen AG VZ", "DE0007664039");
        getDNS().put("Vonovia SE", "DE000A1ML7J1");
        getDNS().put("Wirecard AG", "DE0007472060");

        getDNSString().add("adidas AG");
        getDNSString().add("Allianz SE");
        getDNSString().add("BASF SE");
        getDNSString().add("Bayer AG");
        getDNSString().add("Bayerische Motorenwerke AG");
        getDNSString().add("Beiersdorf AG");
        getDNSString().add("Continental AG");
        getDNSString().add("Covestro AG");
        getDNSString().add("Daimler AG");
        getDNSString().add("Deutsche Bank AG");
        getDNSString().add("Deutsche Börse AG");
        getDNSString().add("Deutsche Lufthansa Ag");
        getDNSString().add("Deutsche Post AG");
        getDNSString().add("Deutsche Telekom AG");
        getDNSString().add("E.ON SE");
        getDNSString().add("Fresenius Medical Care KGaA");
        getDNSString().add("Fresenius SE & Co. KGaA");
        getDNSString().add("HeidelbergCement AG");
        getDNSString().add("Henkel AG & Co. KGaA VZ");
        getDNSString().add("Infineon Technologies AG");
        getDNSString().add("Linde PLC");
        getDNSString().add("Merck KGaA");
        getDNSString().add("Münchener Rückvers.-Ges. AG");
        getDNSString().add("RWE AG");
        getDNSString().add("SAP SE");
        getDNSString().add("Siemens");
        getDNSString().add("thyssenkrupp AG");
        getDNSString().add("Volkswagen AG VZ");
        getDNSString().add("Vonovia SE");
        getDNSString().add("Wirecard AG");

    }

    /**
     * @return the DNS
     */
    public static Hashtable<String, String> getDNS() {
        return DNS;
    }

    /**
     * Ladet das Document der Website herunter, mit der angegebenen ISIN.
     *
     *
     * @param ISIN
     */
    public static void prepareDocument(String ISIN) {
        try {
            doc = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + ISIN).get();
            momentaneISIN = ISIN;
        } catch (Exception e) {
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
    public static ImageIcon getGraph(String Zeitraum) {
        try {
            String link = doc.getElementById(Zeitraum).attr("src");
            String completeLink = "https://www.tradegate.de" + link;

            return new ImageIcon(new URL(completeLink));
        } catch (Exception e) {
            System.out.println("Fehler in getGraph()");
            return null;
        }

    }

    /**
     * aktualisiert das Document der momentanen Aktie.
     *
     *
     */

    public static void aktualisieren() {
        try {
            doc = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + momentaneISIN).get();

        } catch (Exception e) {
            System.out.println("Fehler in prepareDocument()");

        }

    }

    /**
     * @return the DNSSTring
     */
    public static ArrayList<String> getDNSString() {
        return DNSString;
    }

    
    private static String Hilfsvariable = new String();
    public static String getName(String ISIN) {

       Hilfsvariable = "Fehler";
        if (getDNS().contains(ISIN)) {

            getDNS().forEach((String a, String b) -> {
                if (b.equals(ISIN)) {
                    Hilfsvariable = a;
                }
            });

        }
        
       

        return Hilfsvariable;
    }

}
