/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.*;
import model.*;
import model.OA;
import TEST.*;
import java.awt.Color;
import java.util.ArrayList;
import shadytrady.*;
import view.StockOverflowGUI;

/**
 *
 * @author Commander
 */
public class maincontrol {

    private AktieAnsehen aktieAnsehen;

    private AktieKaufen aktieKaufen;

    private AktieVerkaufen aktieVerkaufen;

    private AnmeldeFenster anmeldeFenster;

    private EigenesDepot eigenesDepot;

    private StockOverflowGUI stockOverflowGUI ;

    private FirebaseSaveObject fso;

    private Benutzer b;
    /**
     * Speichert die Werte des Dax um sie dannach mit den neuen Werten zu 
     * vergleichen.
     * 
     * 
     */
    private ArrayList<Object> PreisListe;

    public maincontrol() {
        aktieAnsehen = new AktieAnsehen(this);
        aktieKaufen = new AktieKaufen(this);
        aktieVerkaufen = new AktieVerkaufen(this);
        anmeldeFenster = new AnmeldeFenster(this);
        eigenesDepot = new EigenesDepot(this);
        stockOverflowGUI = new StockOverflowGUI(this);
        fso = new FirebaseSaveObject(this);
        
        
        stockOverflowGUI.setVisible(true);
        AktienDatenInitialisieren();
    }

    public void switchTo(String Guiname) {

        aktieAnsehen.setVisible(false);
        aktieKaufen.setVisible(false);
        aktieVerkaufen.setVisible(false);
        anmeldeFenster.setVisible(false);
        eigenesDepot.setVisible(false);
        stockOverflowGUI.setVisible(false);

        switch (Guiname) {
            case "AktieAnsehen":
                aktieAnsehen.setVisible(true);
                break;
            case "AktieKaufen":
                aktieKaufen.setVisible(true);
                break;
            case "AktieVerkaufen":
                aktieVerkaufen.setVisible(true);
                break;
            case "AnmeldeFenster":
                anmeldeFenster.setVisible(true);
                break;
            case "EigenesDepot":
                eigenesDepot.setVisible(true);
                break;
            case "StockOverflowGUI":
                stockOverflowGUI.setVisible(true);
                break;

            default:
                break;

        }

    }

    public void login(String benutzername, String password) {

        if (this.fso.getpassword(benutzername).equals(password)) {

            System.out.println("Login erfolgreich");
            b = new Benutzer(benutzername);
            this.switchTo("EigenesDepot");
        }

    }

    public static void main(String[] args) {
        new maincontrol();
    }
    //StockOverflowGUI-Funktionen
    public void AktienDatenInitialisieren(){
        OA.DnsConfig();
        PreisListe = new ArrayList<>();
        
        
        
        
        for(int i = 0;i<stockOverflowGUI.AktienFelder.size();i++){
            
            OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i)));
            stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i));
            stockOverflowGUI.PreisFelder.get(i).setText(Float.toString(OA.getAsk()));
            stockOverflowGUI.ChangeFelder.get(i).setText(Float.toString(OA.getChange()));
            PreisListe.add(OA.getAsk());
    }
    }
        
        
    public void AktienDatenAktualisieren(){
        for(int i = 0;i<stockOverflowGUI.AktienFelder.size();i++){
            
            OA.prepareDocument(OA.getDNS().get(OA.getDNSString().get(i)));
            stockOverflowGUI.AktienFelder.get(i).setText(OA.getDNSString().get(i));
            stockOverflowGUI.PreisFelder.get(i).setText(Float.toString(OA.getAsk()));
            stockOverflowGUI.ChangeFelder.get(i).setText(Float.toString(OA.getChange()));
            if((float)PreisListe.get(i)>OA.getAsk()){
            stockOverflowGUI.PreisFelder.get(i).setBackground(Color.red);            
            }else if((float)PreisListe.get(i)<OA.getAsk()){
                stockOverflowGUI.PreisFelder.get(i).setBackground(Color.green);
                
            
            
            
            
            
    }else stockOverflowGUI.PreisFelder.get(i).setBackground(Color.white);  
        
        
        
        
    }
        
        
        
        
        
        
        
        
    }
    
    
    
    
    

}
