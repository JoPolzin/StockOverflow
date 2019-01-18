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
public class StockOverflowGUI extends javax.swing.JFrame {
    private maincontrol c;
    /**
     * Creates new form NewJFrame
     */
    public StockOverflowGUI(maincontrol mc) {
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

        ÜberschriftOverflow = new javax.swing.JLabel();
        DepotGUI = new javax.swing.JButton();
        LogInGUI = new javax.swing.JButton();
        AktienGUI = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ÜberschriftOverflow.setFont(new java.awt.Font("Penultimate", 1, 36)); // NOI18N
        ÜberschriftOverflow.setText("Stock im Arsch");

        DepotGUI.setText("Depot");
        DepotGUI.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DepotGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepotGUIActionPerformed(evt);
            }
        });

        LogInGUI.setText("Log In");
        LogInGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInGUIActionPerformed(evt);
            }
        });

        AktienGUI.setFont(new java.awt.Font("Penultimate", 0, 24)); // NOI18N
        AktienGUI.setText("Aktien");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(209, Short.MAX_VALUE)
                        .addComponent(ÜberschriftOverflow)
                        .addGap(41, 41, 41)
                        .addComponent(DepotGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LogInGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(AktienGUI)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LogInGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DepotGUI, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ÜberschriftOverflow))
                .addGap(31, 31, 31)
                .addComponent(AktienGUI)
                .addContainerGap(479, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInGUIActionPerformed
        this.c.switchTo("AnmeldeFenster");
    }//GEN-LAST:event_LogInGUIActionPerformed

    private void DepotGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepotGUIActionPerformed
        c.switchTo("EigenesDepot");
    }//GEN-LAST:event_DepotGUIActionPerformed

    /**
     * @param args the command line arguments
     
    public static void main(String args[]) {
        /* Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockOverflowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockOverflowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockOverflowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockOverflowGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockOverflowGUI().setVisible(true);
            }
        });
    }
*/
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AktienGUI;
    private javax.swing.JButton DepotGUI;
    private javax.swing.JButton LogInGUI;
    private javax.swing.JLabel ÜberschriftOverflow;
    // End of variables declaration//GEN-END:variables
}
