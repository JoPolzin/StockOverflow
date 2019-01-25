/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Firebasezugriff;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public FirebaseZugriff() {
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
     * @return alle Benutzer in einer ArrayList
     */
    public ArrayList<Benutzer> benutzerAuslesen() {
        FirebaseResponse response;
        ArrayList<Benutzer> al = new ArrayList();

        try {
            response = firebase.get();
            Iterator it = response.getBody().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                LinkedHashMap lhm = (LinkedHashMap) pairs.getValue();
                Benutzer tmp = new Benutzer();
                //Hier Ergänzen, wenn der Benutzer weitere Attribute bekommt!
                tmp.setBenutzername((String) lhm.get("benutzername"));
                tmp.setEmail((String) lhm.get("email"));
                tmp.setKontostand((Double) lhm.get("kontostand"));
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
     * Ver�ndert den Firebaseeintrag eines Benutzers. Alle anderen bleiben
     * bestehen.
     *
     * @param geaenderterBenutzer der ge�nderte Benutzer
     */
    public void aendereBenutzer(Benutzer geaenderterBenutzer) {
        ergaenzeBenutzer(geaenderterBenutzer);
    }

    /**
     * ergaenzt einen neuen Benutzer ohne die bestehenden zu ver�ndern.
     *
     * @param b der neue Benutzer
     */
    public void ergaenzeBenutzer(Benutzer b) {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap.put(b.getBenutzername(), b);
        try {
            FirebaseResponse response = firebase.patch(dataMap);
        } catch (FirebaseException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JacksonUtilityException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
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
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JacksonUtilityException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FirebaseZugriff.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
