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
        VerkaufenNameDerAktieEingabe = new javax.swing.JTextPane();
        VerkaufenNameDerAktie = new javax.swing.JLabel();
        VerkaufenStückzahl = new javax.swing.JLabel();
        VerkaufenStückzahlEingeben = new javax.swing.JTextPane();
        VerkaufenPreisProStück = new javax.swing.JLabel();
        VerkaufenPreisProStückEingeben = new javax.swing.JTextPane();
        VerkaufenGesamtpreis = new javax.swing.JLabel();
        VerkaufenGesamtpreisEingeben = new javax.swing.JTextPane();
        VerkaufenAbbrechen = new javax.swing.JButton();
        VerkaufenVerkaufen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StockOverflowVerkaufen.setFont(new java.awt.Font("Noto Serif", 1, 36)); // NOI18N
        StockOverflowVerkaufen.setText("StockOverflow");

        VerkaufenNameDerAktieEingabe.setEditable(false);

        VerkaufenNameDerAktie.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
        VerkaufenNameDerAktie.setText("Name der Aktie");

        VerkaufenStückzahl.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
        VerkaufenStückzahl.setText("Stückzahl");

        VerkaufenPreisProStück.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
        VerkaufenPreisProStück.setText("Preis pro Stück");

        VerkaufenPreisProStückEingeben.setEditable(false);

        VerkaufenGesamtpreis.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
        VerkaufenGesamtpreis.setText("Gesamtpreis");

        VerkaufenGesamtpreisEingeben.setEditable(false);

        VerkaufenAbbrechen.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
        VerkaufenAbbrechen.setText("Abbrechen");
        VerkaufenAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerkaufenAbbrechenActionPerformed(evt);
            }
        });

        VerkaufenVerkaufen.setFont(new java.awt.Font("Noto Serif", 0, 11)); // NOI18N
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(StockOverflowVerkaufen)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(VerkaufenStückzahl)
                                        .addComponent(VerkaufenStückzahlEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(VerkaufenPreisProStück)
                                        .addComponent(VerkaufenPreisProStückEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(2, 2, 2)))
                            .addComponent(VerkaufenGesamtpreis)
                            .addComponent(VerkaufenNameDerAktie)
                            .addComponent(VerkaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerkaufenGesamtpreisEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(VerkaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VerkaufenVerkaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(StockOverflowVerkaufen)
                .addGap(35, 35, 35)
                .addComponent(VerkaufenNameDerAktie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerkaufenNameDerAktieEingabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerkaufenStückzahl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VerkaufenPreisProStück, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerkaufenPreisProStückEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VerkaufenStückzahlEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(VerkaufenGesamtpreis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerkaufenGesamtpreisEingeben, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(VerkaufenVerkaufen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(VerkaufenAbbrechen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerkaufenAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerkaufenAbbrechenActionPerformed
        this.c.switchTo("StockOverflowGUI");    }//GEN-LAST:event_VerkaufenAbbrechenActionPerformed

    private void VerkaufenVerkaufenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerkaufenVerkaufenActionPerformed
        this.c.aktieverkaufen(this.VerkaufenNameDerAktieEingabe.getText(), Integer.parseInt(this.VerkaufenStückzahlEingeben.getText()));
    }//GEN-LAST:event_VerkaufenVerkaufenActionPerformed

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
    private javax.swing.JTextPane VerkaufenGesamtpreisEingeben;
    private javax.swing.JLabel VerkaufenNameDerAktie;
    private javax.swing.JTextPane VerkaufenNameDerAktieEingabe;
    private javax.swing.JLabel VerkaufenPreisProStück;
    private javax.swing.JTextPane VerkaufenPreisProStückEingeben;
    private javax.swing.JLabel VerkaufenStückzahl;
    private javax.swing.JTextPane VerkaufenStückzahlEingeben;
    private javax.swing.JButton VerkaufenVerkaufen;
    // End of variables declaration//GEN-END:variables
}
