/*
 * 
 */
package control;

import java.io.IOException;
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
     * Hashtable mit Börsennamen und den dazugrhörigen ISIN's ISIN =
     * Internationale Wertpapierkennnummer
     */
    private Hashtable<String, String> DNS = new Hashtable();
    /**
     * Die aktuell ausgewählte Website.
     * 
     * 
     */
    private Document doc;

    public static void main(String[] args) {
        OA t = new OA();
        t.DnsConfig();
        t.setDoc(t.getDocument("DE0007236101"));
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
    public float getAsk() {
        try {
            
            return Float.parseFloat(getDoc().getElementById("ask").text().replace(',', '.').replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            
            return Float.parseFloat(getDoc().getElementById("bid").text().replace(',', '.').replaceAll(" ", ""));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0f;
        }

    }
    
    /**
     * Gibt bei gegebener ISIN den "change"-Wert der ausgewählten Aktie zurück.
     * @param ID
     * @return
     * @throws IOException
     */
    public float getChange() {
        try {
            
            return Float.parseFloat(getDoc().getElementById("delta").text().replace(',', '.').replaceAll(" ", "").replaceAll("%", ""));
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
    
    public Document getDocument(String ISIN) {
        try{
            Document document = Jsoup.connect("https://www.tradegate.de/orderbuch.php?isin=" + ISIN).get();
        return document;
        }catch(Exception e){
            System.err.println(e.getMessage());
            System.out.println("error");
            return null;
            
            
        }
        
        
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
    

}
