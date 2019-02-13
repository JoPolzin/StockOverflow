/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import control.maincontrol;
import java.util.Arrays;


/**
 *
 * @author hannah.claus
 */
public class ProfilFenster extends javax.swing.JFrame {
 private maincontrol c;
    /**
     * Creates new form NewJFrame
     */
    public ProfilFenster() {
        initComponents();
    }

       public ProfilFenster(maincontrol mc) {
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

        StockOverflowProfil = new javax.swing.JLabel();
        ProfilBenutzername = new javax.swing.JTextPane();
        ProfilBenutzernameAnzeigen = new javax.swing.JLabel();
        ProfilPasswort = new javax.swing.JLabel();
        ProfilPasswortAnzeigen = new javax.swing.JPasswordField();
        ProfilAbbrechen = new javax.swing.JButton();
        ProfilPasswortÄndern = new javax.swing.JButton();
        ProfilGuthabneAnzeigen = new javax.swing.JTextPane();
        ProfilGuthaben = new javax.swing.JLabel();
        ProfilLogOut = new javax.swing.JButton();
        ProfilLöschen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StockOverflowProfil.setFont(new java.awt.Font("Penultimate", 1, 36)); // NOI18N
        StockOverflowProfil.setText("StockOverflow");

        ProfilBenutzername.setEditable(false);
        ProfilBenutzername.setFont(new java.awt.Font("Penultimate", 0, 11)); // NOI18N

        ProfilBenutzernameAnzeigen.setFont(new java.awt.Font("Penultimate", 0, 11)); // NOI18N
        ProfilBenutzernameAnzeigen.setText("Benutzername");

        ProfilPasswort.setFont(new java.awt.Font("Penultimate", 0, 11)); // NOI18N
        ProfilPasswort.setText("Passwort");

        ProfilPasswortAnzeigen.setEditable(false);
        ProfilPasswortAnzeigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilPasswortAnzeigenActionPerformed(evt);
            }
        });

        ProfilAbbrechen.setFont(new java.awt.Font("Penultimate", 0, 14)); // NOI18N
        ProfilAbbrechen.setText("Abbrechen");
        ProfilAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilAbbrechenActionPerformed(evt);
            }
        });

        ProfilPasswortÄndern.setText("Ändern");
        ProfilPasswortÄndern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilPasswortÄndernActionPerformed(evt);
            }
        });

        ProfilGuthabneAnzeigen.setEditable(false);
        ProfilGuthabneAnzeigen.setFont(new java.awt.Font("Penultimate", 0, 11)); // NOI18N

        ProfilGuthaben.setFont(new java.awt.Font("Penultimate", 0, 11)); // NOI18N
        ProfilGuthaben.setText("Guthaben");

        ProfilLogOut.setFont(new java.awt.Font("Penultimate", 0, 14)); // NOI18N
        ProfilLogOut.setText("Log Out");
        ProfilLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfilLogOutActionPerformed(evt);
            }
        });

        ProfilLöschen.setFont(new java.awt.Font("Penultimate", 0, 14)); // NOI18N
        ProfilLöschen.setText("Profil Löschen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfilPasswort)
                    .addComponent(ProfilBenutzernameAnzeigen)
                    .addComponent(StockOverflowProfil)
                    .addComponent(ProfilBenutzername, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProfilGuthaben)
                    .addComponent(ProfilGuthabneAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ProfilPasswortAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfilPasswortÄndern))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProfilAbbrechen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfilLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfilLöschen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StockOverflowProfil)
                .addGap(20, 20, 20)
                .addComponent(ProfilBenutzernameAnzeigen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfilBenutzername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProfilGuthaben)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfilGuthabneAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProfilPasswort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ProfilPasswortÄndern, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ProfilPasswortAnzeigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ProfilAbbrechen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfilLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfilLöschen)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProfilAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfilAbbrechenActionPerformed
       this.c.switchTo("StockOverflowGUI");
    }//GEN-LAST:event_ProfilAbbrechenActionPerformed

    private void AnmeldenAnmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnmeldenAnmeldenActionPerformed
        this.c.switchTo("EigenesDepot");
    }//GEN-LAST:event_AnmeldenAnmeldenActionPerformed

    private void ProfilPasswortAnzeigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfilPasswortAnzeigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfilPasswortAnzeigenActionPerformed

    private void ProfilPasswortÄndernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfilPasswortÄndernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfilPasswortÄndernActionPerformed

    private void ProfilLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfilLogOutActionPerformed
       this.c.logout();
    }//GEN-LAST:event_ProfilLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilFenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ProfilFenster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProfilAbbrechen;
    private javax.swing.JTextPane ProfilBenutzername;
    private javax.swing.JLabel ProfilBenutzernameAnzeigen;
    private javax.swing.JLabel ProfilGuthaben;
    private javax.swing.JTextPane ProfilGuthabneAnzeigen;
    private javax.swing.JButton ProfilLogOut;
    private javax.swing.JButton ProfilLöschen;
    private javax.swing.JLabel ProfilPasswort;
    private javax.swing.JPasswordField ProfilPasswortAnzeigen;
    private javax.swing.JButton ProfilPasswortÄndern;
    private javax.swing.JLabel StockOverflowProfil;
    // End of variables declaration//GEN-END:variables
}
