/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Firebasezugriff.FirebaseZugriff;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import model.Benutzer;

/**
 * Sinn dieser Klasse ist es, dass alle paar Zeiteinheiten die Aktionkonten
 * aller Benutzer an die Veränderungen der Börse angepasst werden. Kurse steigen
 * und fallen ständig, das bedeutet, dass sich die Kurse aller Benutzer zur
 * Laufzeit ändern. Das beeinflusst auch den Highscore. Es sollte genügen, dass
 * ein oder mehrere angemeldete Benutzer das Anpassen auslösen, denn wenn keiner
 * angemeldet ist, dann interessiert es auch niemanden, was grade mit den Konten
 * passiert...
 *
 * @author K
 */
class Anpasser extends Thread {

    maincontrol c;
    FirebaseZugriff fz;
    ArrayList<Benutzer> al;
    

    public Anpasser(maincontrol c) {
        this.c = c;

    }

    public void run() {

        try {
            System.out.println("Demo-Thread");
            fz = new FirebaseZugriff(c);
             al = fz.benutzerAuslesen();
            LeaderboardInit();
            sleep(1000*60);

        } catch (Exception e) {
        }
        System.out.println("Demo-Thread");

    }

    public void LeaderboardInit() {
        double GesamtKapital = 0;
        ArrayList<Benutzer> sortList = this.SortBenutzer(this.al);
        Collections.reverse(sortList);
        if (sortList.size() >= 5) {
            c.getLeaderboard().Platz1.setText(sortList.get(0).getBenutzername());
            c.getLeaderboard().Platz1.setText(sortList.get(1).getBenutzername());
            c.getLeaderboard().Platz1.setText(sortList.get(2).getBenutzername());
            c.getLeaderboard().Platz1.setText(sortList.get(3).getBenutzername());
            c.getLeaderboard().Platz1.setText(sortList.get(4).getBenutzername());
            c.getLeaderboard().Punktzahl1.setText("" + c.RundenKommastellen(sortList.get(0).GesamtKapital()));
            c.getLeaderboard().Punktzahl1.setText("" + c.RundenKommastellen(sortList.get(1).GesamtKapital()));
            c.getLeaderboard().Punktzahl1.setText("" + c.RundenKommastellen(sortList.get(2).GesamtKapital()));
            c.getLeaderboard().Punktzahl1.setText("" + c.RundenKommastellen(sortList.get(3).GesamtKapital()));
            c.getLeaderboard().Punktzahl1.setText("" + c.RundenKommastellen(sortList.get(4).GesamtKapital()));
            for (Benutzer b : sortList) {
                GesamtKapital = GesamtKapital + b.GesamtKapital();

            }

            c.getLeaderboard().GesamtPunktzahl.setText("" + c.RundenKommastellen(GesamtKapital));

        }
    }
        /**
         * Gibt eine aufwärts sortierte Liste der Bnutzer zurück sortiert nach
         * dem GesamtKapital.
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

}


