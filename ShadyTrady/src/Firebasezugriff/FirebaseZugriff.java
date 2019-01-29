/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firebasezugriff;

import control.maincontrol;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aktie;
import model.Aktienkauf;
import model.Aktienkonto;
import model.Benutzer;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

/**
 *
 * @author koeppen
 */
public class FirebaseZugriff {

    final String firebase_baseUrl = "https://aktienspiel-97ea0.firebaseio.com/";
    Firebase firebase;
    maincontrol c;

    public FirebaseZugriff(maincontrol c) {
        this.c = c;
        try {
            firebase = new Firebase(firebase_baseUrl);

        } catch (FirebaseException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Die Methode benutzerAuslesen() liest alle als Benutzer in der Firebase
     * gespeicherten Eintr�ge aus und gibt diese in Form einer ArrayList zur�ck.
     *
     * ACHTUNG: Bislang hat der Benutzer die Attribute "benutzername", "email"
     * und "kontostand". Wenn sich das �ndert, dann mus diese Methode angepasst
     * werden!!!
     *
     * Alle Benutzer in der Firebase müssen die echte Struktur des
     * Benutzer-Objekts haben!
     *
     * @return alle Benutzer in einer ArrayList
     */
    public ArrayList<Benutzer> benutzerAuslesen() {
        FirebaseResponse response, response2;
        ArrayList<Benutzer> al = new ArrayList();

        try {
            response = firebase.get("users");

            Iterator it = response.getBody().entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                LinkedHashMap lhm = (LinkedHashMap) pairs.getValue();
                Benutzer tmp = new Benutzer();
                //Hier Ergänzen, wenn der Benutzer weitere Attribute bekommt!
                if (!lhm.containsKey("benutzername") || !lhm.containsKey("email") || !lhm.containsKey("kontostand") || !lhm.containsKey("passwort")) {
                    return null;
                }
                tmp.setBenutzername((String) lhm.get("benutzername"));
                tmp.setEmail((String) lhm.get("email"));
                tmp.setKontostand((Double) lhm.get("kontostand"));
                tmp.setPasswort((String) lhm.get("passwort"));
                response2 = firebase.get("depots/" + tmp.getBenutzername());

                Iterator it2 = response2.getBody().entrySet().iterator();

                while (it2.hasNext()) {

                    Map.Entry pairs2 = (Map.Entry) it2.next();
                    LinkedHashMap lhm2 = (LinkedHashMap) pairs2.getValue();
                    System.out.println(lhm2.toString());
                    //Hier Ergänzen, wenn der Benutzer weitere Attribute bekommt!
                    if (!lhm2.containsKey("anzahl") || !lhm2.containsKey("isin") || !lhm2.containsKey("preis")) {
                        return null;
                    }
                    int anzahl = (int) lhm2.get("anzahl");
                    for (int i = 1; i <= anzahl; i = i + 1) {
                        Aktie akt = new Aktie((String) lhm2.get("isin"),(double)lhm2.get("preis"));
                        akt.setPreis((double) lhm2.get("preis"));
                        akt.setStueckzahl((int) lhm2.get("anzahl"));
                        tmp.getDepot().getAktien().add(akt);

                    }

                }
                al.add(tmp);
            }
        } catch (FirebaseException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
    /**
     * Gibt die Anzahl der childs an dieser Position wieder.
     * @param Reference 
     */

    public int childCount(String Reference) {
        FirebaseResponse response;
        try {
            response = firebase.get(Reference);
            Iterator it = response.getBody().entrySet().iterator();
            int Zähler = 0;
            while (it.hasNext()) {
                it.next();
                Zähler++;
                
            }
            return Zähler;

        } catch (FirebaseException ex) {
            System.out.println("Fehler");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Fehler");
        }
        return 0;

    }

   
    
    
    
    
    
    
    /**
     * Ver�ndert den Firebaseeintrag eines Benutzers. Alle anderen bleiben
     * bestehen.
     *
     * @param geaenderterBenutzer der ge�nderte Benutzer
     */
    public void aendereBenutzer(Benutzer geaenderterBenutzer) {
        ergaenzeBenutzer(geaenderterBenutzer);
    }

    /**
     * ergaenzt einen neuen Benutzer ohne die bestehenden zu ver�ndern. Der
     * Benutzer kommt in das Child "users". Das Aktienkonto kommt in das child
     * "depots"
     *
     * @param b der neue Benutzer
     */
    public void ergaenzeBenutzer(Benutzer b) {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        Aktienkonto ak = b.getDepot();
        b.setDepot(null);//vorsichtiges Löschen, damit in der Firebase kein geschachteltes Objekt entsteht.
        dataMap.put(b.getBenutzername(), b);

        //dataMap.put(b.getBenutzername(), b.getDepot());
        try {
            FirebaseResponse response = firebase.patch("users", dataMap);
        } catch (FirebaseException | JacksonUtilityException | UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }

        b.setDepot(ak); //Rücksetzen um b nicht zu verändern...
        dataMap.clear();
        int zaehler = 0;
        Hashtable<String, Integer> st = ak.getGekaufte_Aktien();
        for (Aktie a : ak.getAktien()) {

            int kaufzahl = st.get(a.getISIN());
            Aktienkauf akt = new Aktienkauf(a.getISIN(), kaufzahl);
            akt.setPreis(a.getPreis());
            System.out.println(akt.toString());
            dataMap.put("a" + zaehler, akt);
            zaehler++;
        }

        try {
            FirebaseResponse response = firebase.patch("depots/" + b.getBenutzername(), dataMap);
            dataMap.clear();
        } catch (FirebaseException | JacksonUtilityException | UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Erg�nzt eine Gruppe von Nutzern in die Firebase. Bestehende DAten bleiben
     * bestehen.
     *
     * @param gruppe ArrayList mit den zu erg�nzenden Benutzern
     */
    public void erganzeBenutzerGruppe(ArrayList<Benutzer> gruppe) {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        for (Benutzer b : gruppe) {
            dataMap.put(b.getBenutzername(), b);
        }
        try {
            FirebaseResponse response = firebase.patch(dataMap);
        } catch (FirebaseException ex) {
            Logger.getLogger(FirebaseZugriff.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (JacksonUtilityException ex) {
            Logger.getLogger(FirebaseZugriff.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * ver�ndert die Eintr�ge aller �bergebenen Benutzer. L�sst die �brigen
     * Benutzer bestehen.
     *
     * @param gruppe die zu ver�ndernden Benutzer
     */
    public void aendereBenutzerGruppe(ArrayList<Benutzer> gruppe) {
        erganzeBenutzerGruppe(gruppe);
    }

    /**
     * entfernt alle Eintr�ge aus der Firebase. ACHTUNG: Das kann doch auch
     * manuell per Browser passieren...
     */
    public void loescheAlleEintraege() {
        try {
            FirebaseResponse response = firebase.delete();
        } catch (FirebaseException ex) {
            Logger.getLogger(FirebaseZugriff.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        Benutzer b = new Benutzer();
        b.setBenutzername("TestNutzer");
        b.setEmail("j@kl.mn");
        b.setPasswort("informatik");
        b.setKontostand(1000);
        Aktie a1 = new Aktie("DE0007164600", 45.78);
        a1.setStueckzahl(4);
        Aktie a2 = new Aktie("US02079K3059", 55);
        a2.setStueckzahl(2);
        Aktienkonto ak = new Aktienkonto();
        ak.aktie_kaufen("DE0007164600", 4, Float.parseFloat("92.66"));
        ak.aktie_kaufen("DE000A1EWWW0", 1, Float.parseFloat("204.20"));

        System.out.println(ak.toString());
        b.setDepot(ak);
   

    }
    /**
     * 
     * 
     * Ergänz eine Aktie zudem grade angemeldeten Benutzer.
     * @param ak 
     */
    
    
    
    public void aktieErgänzen(Aktienkauf ak){
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        int Stelle = this.childCount("depots/"+c.getB().getBenutzername())+1;
        dataMap.put("a"+Stelle, ak);
        try {
            FirebaseResponse response = firebase.patch("depots/" + c.getB().getBenutzername(), dataMap);
            dataMap.clear();
        } catch (FirebaseException | JacksonUtilityException | UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
    }

}
