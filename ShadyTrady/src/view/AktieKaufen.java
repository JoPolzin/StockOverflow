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
public class AktieKaufen extends javax.swing.JFrame {
 private maincontrol c;
    /**
     * Creates new form NewJFrame
     */
    public AktieKaufen() {
        initComponents();
    }

       public AktieKaufen(maincontrol mc) {
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

        StockOverflowKaufen = new javax.swing.JLabel();
        KaufenNameDerAktieEingabe = new javax.swing.JTextPane();
        KaufenNameDerAktie = new javax.swing.JLabel();
        KaufenStückzahl = new javax.swing.JLabel();
        KaufenStückzahlEingabe = new javax.swing.JTextPane();
        KaufenPreisProStück = new javax.swing.JLabel();
        KaufenPreisProStückEingabe = new javax.swing.JTextPane();
        KaufenGesamtpreis = new javax.swing.JLabel();
        KaufenGesamtpreisEingabe = new javax.swing.JTextPane();
        KaufenAbbrechen = new javax.swing.JButton();
        KaufenKaufen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StockOverflowKaufen.setFont(new java.awt.Font("Penultimate", 1, 36)); // NOI18N
        StockOverflowKaufen.setText("StockOverflow");

        KaufenNameDerAktie.setText("Name der Aktie");

        KaufenStückzahl.setText("Stückzahl");

        KaufenPreisProStück.setText("Preis pro Stück");

        KaufenGesamtpreis.setText("Gesamtpreis");

        KaufenAbbrechen.setText("Abbrechen");
        KaufenAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaufenAbbrechenActionPerformed(evt);
            }
        });

        KaufenKaufen.setText("Kaufen");
        KaufenKaufen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaufenKaufenActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KaufenGesamtpreis)
                            .addComponent(KaufenNameDerAktie)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(StockOverflowKaufen))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KaufenStückzahl)
                                    .addComponent(KaufenStückzahlEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KaufenGesamtpreisEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KaufenPreisProStück)
                                    .addComponent(KaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KaufenPreisProStückEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(KaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KaufenKaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(StockOverflowKaufen)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KaufenPreisProStück)
                            .addComponent(KaufenStückzahl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(KaufenNameDerAktie)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KaufenStückzahlEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KaufenPreisProStückEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(KaufenGesamtpreis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KaufenGesamtpreisEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(KaufenKaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(KaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KaufenKaufenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaufenKaufenActionPerformed
  c.aktiekaufen(this.KaufenNameDerAktie.getText(), this.KaufenStückzahl.getText(), this.KaufenGesamtpreis.getText());
        this.c.switchTo("EigenesDepot");    }//GEN-LAST:event_KaufenKaufenActionPerformed

    private void KaufenAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaufenAbbrechenActionPerformed
        this.c.switchTo("StockOverflowGUI");    }//GEN-LAST:event_KaufenAbbrechenActionPerformed

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
            java.util.logging.Logger.getLogger(AktieKaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AktieKaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AktieKaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AktieKaufen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AktieKaufen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KaufenAbbrechen;
    private javax.swing.JLabel KaufenGesamtpreis;
    private javax.swing.JTextPane KaufenGesamtpreisEingabe;
    private javax.swing.JButton KaufenKaufen;
    private javax.swing.JLabel KaufenNameDerAktie;
    private javax.swing.JTextPane KaufenNameDerAktieEingabe;
    private javax.swing.JLabel KaufenPreisProStück;
    private javax.swing.JTextPane KaufenPreisProStückEingabe;
    private javax.swing.JLabel KaufenStückzahl;
    private javax.swing.JTextPane KaufenStückzahlEingabe;
    private javax.swing.JLabel StockOverflowKaufen;
    // End of variables declaration//GEN-END:variables
}
