/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import control.maincontrol;


/**
 *
 * @author hannah.claus
 */
public class AktieVerkaufen extends javax.swing.JFrame {
 private maincontrol c;
    /**
     * Creates new form NewJFrame
     */
    public AktieVerkaufen() {
        initComponents();
    }

       public AktieVerkaufen(maincontrol mc) {
        this.c = mc;
        
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StockOverflowVerkaufen = new javax.swing.JLabel();
        VerkaufenNameDerAktieEingabe = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        VerkaufenNameDerAktie = new javax.swing.JLabel();
        VerkaufenStückzahl = new javax.swing.JLabel();
        VerkaufenStückzahlEingeben = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        VerkaufenPreisProStück = new javax.swing.JLabel();
        VerkaufenPreisProStückEingeben = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        VerkaufenGesamtpreis = new javax.swing.JLabel();
        VerkaufenGesamtpreisEingeben = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        VerkaufenAbbrechen = new javax.swing.JButton();
        VerkaufenVerkaufen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StockOverflowVerkaufen.setFont(new java.awt.Font("Penultimate", 1, 36)); // NOI18N
        StockOverflowVerkaufen.setText("ShadyTrady");

        VerkaufenNameDerAktieEingabe.setViewportView(jTextPane1);

        VerkaufenNameDerAktie.setText("Name der Aktie");

        VerkaufenStückzahl.setText("Stückzahl");

        VerkaufenStückzahlEingeben.setViewportView(jTextPane2);

        VerkaufenPreisProStück.setText("Preis pro Stück");

        VerkaufenPreisProStückEingeben.setViewportView(jTextPane3);

        VerkaufenGesamtpreis.setText("Gesamtpreis");

        VerkaufenGesamtpreisEingeben.setViewportView(jTextPane4);

        VerkaufenAbbrechen.setText("Abbrechen");
        VerkaufenAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerkaufenAbbrechenActionPerformed(evt);
            }
        });

        VerkaufenVerkaufen.setText("Verkaufen");
        VerkaufenVerkaufen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerkaufenVerkaufenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VerkaufenGesamtpreis)
                            .addComponent(VerkaufenGesamtpreisEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerkaufenNameDerAktie)
                            .addComponent(VerkaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(StockOverflowVerkaufen)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(VerkaufenStückzahl)
                                        .addComponent(VerkaufenStückzahlEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(VerkaufenPreisProStück)
                                        .addComponent(VerkaufenPreisProStückEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(VerkaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerkaufenVerkaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(StockOverflowVerkaufen)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VerkaufenNameDerAktie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VerkaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(VerkaufenStückzahl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VerkaufenStückzahlEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(VerkaufenPreisProStück)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VerkaufenPreisProStückEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(VerkaufenGesamtpreis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VerkaufenGesamtpreisEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(VerkaufenVerkaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(VerkaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerkaufenVerkaufenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerkaufenVerkaufenActionPerformed
        this.c.switchTo("EigenesDepot");    }//GEN-LAST:event_VerkaufenVerkaufenActionPerformed

    private void VerkaufenAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerkaufenAbbrechenActionPerformed
        this.c.switchTo("StockOverflowGUI");    }//GEN-LAST:event_VerkaufenAbbrechenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AktieVerkaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AktieVerkaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AktieVerkaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AktieVerkaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AktieVerkaufen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StockOverflowVerkaufen;
    private javax.swing.JButton VerkaufenAbbrechen;
    private javax.swing.JLabel VerkaufenGesamtpreis;
    private javax.swing.JScrollPane VerkaufenGesamtpreisEingeben;
    private javax.swing.JLabel VerkaufenNameDerAktie;
    private javax.swing.JScrollPane VerkaufenNameDerAktieEingabe;
    private javax.swing.JLabel VerkaufenPreisProStück;
    private javax.swing.JScrollPane VerkaufenPreisProStückEingeben;
    private javax.swing.JLabel VerkaufenStückzahl;
    private javax.swing.JScrollPane VerkaufenStückzahlEingeben;
    private javax.swing.JButton VerkaufenVerkaufen;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration//GEN-END:variables
}
