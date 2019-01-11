/*
 * 
 */
package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
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
     * Hashtable mit Börsennamen und den dazugrhörigen ISIN's
     * ISIN = Internationale Wertpapierkennnummer
     */
    private  Hashtable<String, String> DNS = new Hashtable();

    public static void main(String[] args) {
        OA t = new OA();
        t.DnsConfig();
        System.out.println(t.getAsk(t.getDNS().get("Siemens")));
    }

    /**
     * Gibt bei gegebener ISIN den "ask"-Wert der Aktie zurück.
     * @param ID
     * @return
     * @throws IOException
     */
    public float getAsk(String ISIN) {
        try {
            Document doc = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + ISIN).get();
            return Float.parseFloat(doc.getElementById("ask").text().replace(',', '.').replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0f;
        }
    }
    /**
     * Konfiguriert die DNS-Liste.
     */
    public void DnsConfig() {
        getDNS().put("Siemens", "DE0007236101");
    }

    /**
     * @return the DNS
     */
    public Hashtable<String, String> getDNS() {
        return DNS;
    }

}
