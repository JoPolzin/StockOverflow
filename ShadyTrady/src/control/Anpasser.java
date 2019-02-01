/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
    public Anpasser(maincontrol c){
        this.c = c;
        
    }
    
    
    

    public void run() {
        while(true) {
            try {
                sleep(20000);//Auslösung alle 5 Minuten
                c.setAl(c.getFz().benutzerAuslesen());
                
                
            } catch (InterruptedException e) {
            }
            System.out.println("Demo-Thread");
        }
    }

}
