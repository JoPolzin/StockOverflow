/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import control.OA;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author walle
 */
public class OAtest {

    public static void main(String[] args) {

        OA.DnsConfig();

        String aktieName = "adidas AG";

        String isinTest = OA.getDNS().get(aktieName);
        OA.prepareDocument(isinTest);
        System.out.println("Ask:" + OA.getAsk());
        System.out.println("Bid:" + OA.getBid());
        System.out.println("Change:" + OA.getChange());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        ImageIcon i = null;
        i = OA.getGraph("woche");

        JLabel label = new JLabel(aktieName, i, JLabel.CENTER);
        panel.add(label);
        frame.setSize(650, 400);
        frame.setVisible(true);
        for (int z = 0; z < 10000; z++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OAtest.class.getName()).log(Level.SEVERE, null, ex);
            }
            OA.aktualisieren();
            System.out.println("Ask:" + OA.getAsk());
            System.out.println("Bid:" + OA.getBid());
            System.out.println("Change:" + OA.getChange());
            i = OA.getGraph("intraday");
            label.setIcon(i);

        }

    }

}
