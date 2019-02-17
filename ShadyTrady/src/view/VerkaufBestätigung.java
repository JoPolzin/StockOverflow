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
public class VerkaufBestätigung extends javax.swing.JFrame {
 private maincontrol c;
    /**
     * Creates new form NewJFrame
     */
    public VerkaufBestätigung() {
        initComponents();
    }

       public VerkaufBestätigung(maincontrol mc) {
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

        StockOverflowAnmeldung = new javax.swing.JLabel();
        OKVerkaufBestätigung = new javax.swing.JButton();
        NachrichtVerkaufBestätigung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        StockOverflowAnmeldung.setFont(new java.awt.Font("Noto Serif", 1, 36)); // NOI18N
        StockOverflowAnmeldung.setText("StockOverflow");

        OKVerkaufBestätigung.setFont(new java.awt.Font("Noto Serif", 0, 18)); // NOI18N
        OKVerkaufBestätigung.setText("OK");
        OKVerkaufBestätigung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKVerkaufBestätigungActionPerformed(evt);
            }
        });

        NachrichtVerkaufBestätigung.setFont(new java.awt.Font("Noto Serif", 0, 14)); // NOI18N
        NachrichtVerkaufBestätigung.setText("Die Aktie wurde erfolgreich verkauft!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NachrichtVerkaufBestätigung)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(StockOverflowAnmeldung)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(OKVerkaufBestätigung, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StockOverflowAnmeldung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NachrichtVerkaufBestätigung, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OKVerkaufBestätigung, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnmeldenAnmeldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnmeldenAnmeldenActionPerformed
        this.c.switchTo("EigenesDepot");
    }//GEN-LAST:event_AnmeldenAnmeldenActionPerformed

    private void OKVerkaufBestätigungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKVerkaufBestätigungActionPerformed
        this.c.switchTo("EigenesDepot");
    }//GEN-LAST:event_OKVerkaufBestätigungActionPerformed

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
            java.util.logging.Logger.getLogger(VerkaufBestätigung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerkaufBestätigung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerkaufBestätigung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerkaufBestätigung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new VerkaufBestätigung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NachrichtVerkaufBestätigung;
    private javax.swing.JButton OKVerkaufBestätigung;
    private javax.swing.JLabel StockOverflowAnmeldung;
    // End of variables declaration//GEN-END:variables
}
