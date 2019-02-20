/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import model.FirebaseZugriff;
import control.maincontrol;
import java.util.ArrayList;
import java.util.HashMap;
import model.Aktie;
import model.Benutzer;
import view.EigenesDepot;

/**
 *
 * @author walle
 */
public class andereTests {

    public static void main(String[] args) {
        //ArrayList<Benutzer> benutzer = new ArrayList<>();
       // Benutzer b = new Benutzer();
        //b.setBenutzername("bana");
        //b.setKontostand(550);
        /*
        Benutzer b1 = new Benutzer();
        b1.setBenutzername("b1");
        b1.setKontostand(600);
        Benutzer b2 = new Benutzer();
        b2.setBenutzername("b2");
        b2.setKontostand(430);
        Benutzer b3 = new Benutzer();
        b3.setBenutzername("b3");
        b3.setKontostand(700);
        Aktie e = new Aktie("","DE0007164600");
        e.setStueckzahl(3);
        b3.getDepot().getAktien().add(e);
        benutzer.add(b);
        benutzer.add(b1);
        benutzer.add(b2);
        benutzer.add(b3);
        
        System.out.println("unsort:"+benutzer.toString());
        //benutzer = maincontrol.SortBenutzer(benutzer);
        System.out.println("sort:"+ benutzer.toString());
        System.out.println(b3.GesamtKapital());*/
        //maincontrol c = new maincontrol();
       // c.setB(b);
        FirebaseZugriff fb = new FirebaseZugriff();
        //fb.ObjektLöschen("depots/Louie","a1");
        //EigenesDepot d = new EigenesDepot(c);
        //System.out.println(fb.WertEinerReferenz("depots/er/DE000A1EWWW0", "anzahl"));
      fb.WertEinerReferenzVerändern("Config/AllowLeaderboard", "AllowLeaderboard", "false");
        
        
        
        
        
        
        
        
        
        

    }

}
