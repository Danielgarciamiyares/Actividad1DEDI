/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Formularios.Vuelo.FrmVuelos;
import Formularios.Compania.FrmCompania;
import Formularios.Aeropuerto.FrmAeropuertoAccion;

/**
 *
 * @author Usuario
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
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

        btnAeropuertos = new javax.swing.JButton();
        btnCompanias = new javax.swing.JButton();
        btnVueloos = new javax.swing.JButton();
        btnRecaudacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAeropuertos.setText("Aeropuertos");
        btnAeropuertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAeropuertosActionPerformed(evt);
            }
        });

        btnCompanias.setText("Compañias");
        btnCompanias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompaniasActionPerformed(evt);
            }
        });

        btnVueloos.setText("Vuelos");
        btnVueloos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloosActionPerformed(evt);
            }
        });

        btnRecaudacion.setText("Recaudacion");
        btnRecaudacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecaudacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAeropuertos)
                        .addGap(18, 18, 18)
                        .addComponent(btnCompanias))
                    .addComponent(btnRecaudacion))
                .addGap(18, 18, 18)
                .addComponent(btnVueloos)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAeropuertos)
                    .addComponent(btnCompanias)
                    .addComponent(btnVueloos))
                .addGap(18, 18, 18)
                .addComponent(btnRecaudacion)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAeropuertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAeropuertosActionPerformed
        FrmAeropuertoAccion.getInstance().setVisible(true);
    }//GEN-LAST:event_btnAeropuertosActionPerformed

    private void btnCompaniasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompaniasActionPerformed
        FrmCompania.getInstance().setVisible(true);
    }//GEN-LAST:event_btnCompaniasActionPerformed

    private void btnVueloosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloosActionPerformed
        FrmVuelos.getInstance().setVisible(true);
    }//GEN-LAST:event_btnVueloosActionPerformed

    private void btnRecaudacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecaudacionActionPerformed
        FrmRecaudacion.getInstance().setVisible(true);
    }//GEN-LAST:event_btnRecaudacionActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAeropuertos;
    private javax.swing.JButton btnCompanias;
    private javax.swing.JButton btnRecaudacion;
    private javax.swing.JButton btnVueloos;
    // End of variables declaration//GEN-END:variables
}
