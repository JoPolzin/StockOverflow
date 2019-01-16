/*
 * 
 */
package control;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
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
    /**
     * Die aktuell ausgewählte Website.
     *
     *
     */
    private static Document doc;

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
        getDNS().put("Siemens", "DE0007236101");
        getDNS().put("adidas AG" , "DE000A1EWWW0");                
        getDNS().put("SAP SE", "DE0007164600");
        getDNS().put("Allianz SE","");
        getDNS().put("BASF SE","");
        getDNS().put("Bayer AG","");
        getDNS().put("Bayerische Motorenwerke AG","");
        getDNS().put("Beiersdorf AG","");
        getDNS().put("Continental AG","");
        getDNS().put("Covestro AG","");
        getDNS().put("Daimler AG","");
        getDNS().put("Deutsche Bank AG","");
        getDNS().put("Deutsche Börse AG","");
        getDNS().put("Deutsche Lufthansa Ag", "DE0008232125");
        getDNS().put("Deutsche Post AG","");
        getDNS().put("Deutsche Telekom AG", "DE0005557508");
        getDNS().put("E.ON SE","");
        getDNS().put("Fresenius Medical Care KGaA","");
        getDNS().put("Fresenius SE & Co. KGaA","");
        getDNS().put("HeidelbergCement AG","DE0006047004");
        getDNS().put("Henkel AG & Co. KGaA VZ","DE0006048432");
        getDNS().put("Infineon Technologies AG","DE0006231004");
        getDNS().put("Linde PLC","IE00BZ12WP82");
        getDNS().put("","");
        getDNS().put("","");
        getDNS().put("","");
        getDNS().put("","");
        getDNS().put("","");
        
        
        
        
        
        
        
        
        
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
    public static void  prepareDocument(String ISIN) {
        try {
            doc = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + ISIN).get();
            
        } catch (Exception e) {
System.out.println("Fehler in prepareDocument()");
            

        }

    }
    /**
     * 
     * Gibt ein ImageIcon mit dem Graphen von einem bestimmten Zeitraum zurück.
     * Akzeptierte Zeiträume sind: intraday,woche,monat,monat6 und jahr.
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

}
