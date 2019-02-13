/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.maincontrol;
import model.OA;

/**
 *
 * @author hannah.claus
 */
public class AktieAnsehen extends javax.swing.JFrame {

    private maincontrol c;

    /**
     * Speichert die Werte der aktuellen Aktie um sie später mit dem neuen Wert
     * zu vergleichen
     */
    public float momentanerPreis;
    /**
     * Die ISIN momentan ausgewählte Aktie.
     * 
     */
    public String ausgewählteISIN;
    
    

    /**
     * Creates new form NewJFrame
     */
    public AktieAnsehen() {
        initComponents();
    }

    public AktieAnsehen(maincontrol mc) {
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        DepotAnsehen = new javax.swing.JButton();
        ÜberschriftAnsehen = new javax.swing.JLabel();
        LogInAnsehen = new javax.swing.JButton();
        zurückAktieAnsehen = new javax.swing.JButton();
        ChangeAnsehen = new javax.swing.JLabel();
        PreisAnsehen = new javax.swing.JLabel();
        KaufenAnsehen = new javax.swing.JButton();
        VerkaufenAnsehen = new javax.swing.JButton();
        PreisAngabeAnsehen = new javax.swing.JScrollPane();
        Preis = new javax.swing.JTextPane();
        ChangeAngabeAnsehen = new javax.swing.JScrollPane();
        Change = new javax.swing.JTextPane();
        TagAnsehen = new javax.swing.JButton();
        WocheAnsehen = new javax.swing.JButton();
        MonatAnsehen = new javax.swing.JButton();
        HalbesJahrAnsehen = new javax.swing.JButton();
        JahrAnsehen = new javax.swing.JButton();
        ISIN = new javax.swing.JTextField();
        JLISIN = new javax.swing.JLabel();
        AktienBild = new javax.swing.JLabel();
        laden = new javax.swing.JButton();
        Aktualisieren = new javax.swing.JButton();
        Name = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        DepotAnsehen.setText("Depot");
        DepotAnsehen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DepotAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepotAnsehenActionPerformed(evt);
            }
        });

        ÜberschriftAnsehen.setFont(new java.awt.Font("Penultimate", 1, 36)); // NOI18N
        ÜberschriftAnsehen.setText("StockOverflow");

        LogInAnsehen.setText("Log In");
        LogInAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInAnsehenActionPerformed(evt);
            }
        });

        zurückAktieAnsehen.setText("Zurück");
        zurückAktieAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zurückAktieAnsehenActionPerformed(evt);
            }
        });

        ChangeAnsehen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChangeAnsehen.setText("Change");

        PreisAnsehen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PreisAnsehen.setText("Preis");

        KaufenAnsehen.setText("Kaufen");
        KaufenAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaufenAnsehenActionPerformed(evt);
            }
        });

        VerkaufenAnsehen.setText("Verkaufen");
        VerkaufenAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerkaufenAnsehenActionPerformed(evt);
            }
        });

        Preis.setEditable(false);
        PreisAngabeAnsehen.setViewportView(Preis);

        Change.setEditable(false);
        Change.setToolTipText("");
        ChangeAngabeAnsehen.setViewportView(Change);

        TagAnsehen.setText("Tag");
        TagAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TagAnsehenActionPerformed(evt);
            }
        });

        WocheAnsehen.setText("Woche");
        WocheAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WocheAnsehenActionPerformed(evt);
            }
        });

        MonatAnsehen.setText("Monat");
        MonatAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonatAnsehenActionPerformed(evt);
            }
        });

        HalbesJahrAnsehen.setText("6 Monate");
        HalbesJahrAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HalbesJahrAnsehenActionPerformed(evt);
            }
        });

        JahrAnsehen.setText("Jahr");
        JahrAnsehen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JahrAnsehenActionPerformed(evt);
            }
        });

        ISIN.setEditable(false);
        ISIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISINActionPerformed(evt);
            }
        });

        JLISIN.setText("ISIN:");

        laden.setText("Laden");
        laden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ladenActionPerformed(evt);
            }
        });

        Aktualisieren.setText("Aktualisieren");
        Aktualisieren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AktualisierenActionPerformed(evt);
            }
        });

        Name.setEditable(false);

        jLabel1.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TagAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(WocheAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MonatAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HalbesJahrAnsehen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JahrAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 117, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(AktienBild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(KaufenAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(PreisAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ChangeAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(VerkaufenAnsehen))
                                            .addComponent(PreisAngabeAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ChangeAngabeAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Aktualisieren))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ÜberschriftAnsehen)
                                .addGap(47, 47, 47)))
                        .addComponent(DepotAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLISIN)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Name)
                            .addComponent(ISIN, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(laden)
                        .addGap(310, 310, 310)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogInAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(zurückAktieAnsehen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LogInAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepotAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ÜberschriftAnsehen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(zurückAktieAnsehen)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ISIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JLISIN)
                        .addComponent(laden)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Aktualisieren)
                                .addGap(18, 18, 18)
                                .addComponent(ChangeAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ChangeAngabeAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(PreisAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PreisAngabeAnsehen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(KaufenAnsehen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VerkaufenAnsehen))
                            .addComponent(AktienBild, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TagAnsehen)
                    .addComponent(WocheAnsehen)
                    .addComponent(MonatAnsehen)
                    .addComponent(HalbesJahrAnsehen)
                    .addComponent(JahrAnsehen))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DepotAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepotAnsehenActionPerformed
        this.c.switchTo("EigenesDepot");    }//GEN-LAST:event_DepotAnsehenActionPerformed

    private void LogInAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInAnsehenActionPerformed
        this.c.login();    
         
		
		}//GEN-LAST:event_LogInAnsehenActionPerformed

    private void zurückAktieAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zurückAktieAnsehenActionPerformed
        this.c.setAktIsin(this.ISIN.getText());
        this.c.switchTo("StockOverflowGUI");    }//GEN-LAST:event_zurückAktieAnsehenActionPerformed

    private void KaufenAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaufenAnsehenActionPerformed
        this.c.setAktIsin(this.ISIN.getText());
        this.c.switchTo("AktieKaufen");    }//GEN-LAST:event_KaufenAnsehenActionPerformed
        
    private void VerkaufenAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerkaufenAnsehenActionPerformed
        this.c.setAktIsin(this.ISIN.getText());
        this.c.switchTo("AktieVerkaufen");    }//GEN-LAST:event_VerkaufenAnsehenActionPerformed

    private void ISINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISINActionPerformed

    private void ladenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ladenActionPerformed
        c.AktieDatenInitialisieren(ISIN.getText(),Name.getText());
    }//GEN-LAST:event_ladenActionPerformed

    private void TagAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TagAnsehenActionPerformed

        AktienBild.setIcon(OA.getGraph("intraday"));
    }//GEN-LAST:event_TagAnsehenActionPerformed

    private void WocheAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WocheAnsehenActionPerformed
        AktienBild.setIcon(OA.getGraph("woche"));
    }//GEN-LAST:event_WocheAnsehenActionPerformed

    private void MonatAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonatAnsehenActionPerformed
        AktienBild.setIcon(OA.getGraph("monat"));
    }//GEN-LAST:event_MonatAnsehenActionPerformed

    private void HalbesJahrAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HalbesJahrAnsehenActionPerformed
        AktienBild.setIcon(OA.getGraph("monat6"));
    }//GEN-LAST:event_HalbesJahrAnsehenActionPerformed

    private void JahrAnsehenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JahrAnsehenActionPerformed
        AktienBild.setIcon(OA.getGraph("jahr"));
    }//GEN-LAST:event_JahrAnsehenActionPerformed

    private void AktualisierenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AktualisierenActionPerformed
        c.AktieDatenAktualisieren();
    }//GEN-LAST:event_AktualisierenActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        if(c.getEingeloggt()){
            LogInAnsehen.setText("Abmelden");
        }
        else{
            LogInAnsehen.setText("Log In");
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(AktieAnsehen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AktieAnsehen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AktieAnsehen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AktieAnsehen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AktieAnsehen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AktienBild;
    private javax.swing.JButton Aktualisieren;
    public javax.swing.JTextPane Change;
    private javax.swing.JScrollPane ChangeAngabeAnsehen;
    private javax.swing.JLabel ChangeAnsehen;
    private javax.swing.JButton DepotAnsehen;
    private javax.swing.JButton HalbesJahrAnsehen;
    public javax.swing.JTextField ISIN;
    private javax.swing.JLabel JLISIN;
    private javax.swing.JButton JahrAnsehen;
    private javax.swing.JButton KaufenAnsehen;
    private javax.swing.JButton LogInAnsehen;
    private javax.swing.JButton MonatAnsehen;
    public javax.swing.JTextPane Name;
    public javax.swing.JTextPane Preis;
    private javax.swing.JScrollPane PreisAngabeAnsehen;
    private javax.swing.JLabel PreisAnsehen;
    private javax.swing.JButton TagAnsehen;
    private javax.swing.JButton VerkaufenAnsehen;
    private javax.swing.JButton WocheAnsehen;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton laden;
    private javax.swing.JButton zurückAktieAnsehen;
    private javax.swing.JLabel ÜberschriftAnsehen;
    // End of variables declaration//GEN-END:variables
}
