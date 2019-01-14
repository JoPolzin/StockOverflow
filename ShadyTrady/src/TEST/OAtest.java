/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import model.OA;
import javax.swing.*;

/**
 *
 * @author walle
 */
public class OAtest {

    public static void main(String[] args) {
        OA test = new OA();
        test.DnsConfig();

        test.prepareDocument("DE000A1EWWW0");
        System.out.println("Ask:" + test.getAsk());
        System.out.println("Bid:" + test.getBid());
        System.out.println("Change:" + test.getChange());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        ImageIcon i = null;
        i = test.getGraph("woche");

        JLabel label = new JLabel(i);

        
        panel.add(label);

        frame.setSize(950, 650);
        frame.setVisible(true);
    }

}
