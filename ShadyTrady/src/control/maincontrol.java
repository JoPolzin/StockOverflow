/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import view.*;
import model.*;
import TEST.*;
import shadytrady.*;

/**
 *
 * @author Commander
 */
public class maincontrol {

    private AktieAnsehen aktieAnsehen = new AktieAnsehen(this);

    private AktieKaufen aktieKaufen = new AktieKaufen(this);

    private AktieVerkaufen aktieVerkaufen = new AktieVerkaufen(this);

    private AnmeldeFenster anmeldeFenster = new AnmeldeFenster(this);

    private EigenesDepot eigenesDepot = new EigenesDepot(this);

    private StockOverflowGUI stockOverflowGUI = new StockOverflowGUI(this);
    
    private FirebaseSaveObject fso = new FirebaseSaveObject(this);
    
    private Benutzer b;

    public maincontrol() {

        stockOverflowGUI.setVisible(true);
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
    
    public void login(String benutzername, String password){
      
        
        if (this.fso.getpassword(benutzername).equals(password)){
        
        System.out.println("Login erfolgreich");
        b = new Benutzer(benutzername);
        this.switchTo("EigenesDepot");
        }
    
    
    
    
    
    }

    public static void main(String[] args) {
        new maincontrol();
    }
    
    
    public static void aktieladen(String ISIN){
        
        
        
        
        
    }
    
    public static void aktieZeitraum(String Zeitraum){
        
        
        
    }
    
    
    

}
