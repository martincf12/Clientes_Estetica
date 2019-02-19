
package Ventanas;
import java.awt.Image;
import java.awt.Toolkit;

public class Principal extends javax.swing.JFrame {
    
    public Principal() {
        initComponents();  
        this.setLocationRelativeTo(null);
    }
    @Override
    public Image getIconImage()
    {
       Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/vcICONO.jpg"));
       return retValue; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLOGO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonSALIR = new javax.swing.JButton();
        jButtonCLIENTE = new javax.swing.JButton();
        jButtonADDCLIENTE = new javax.swing.JButton();
        jLabelFONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(600, 500));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vc400x400.png"))); // NOI18N
        getContentPane().add(jLabelLOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 30, 370, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("ver. 1.0");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        jButtonSALIR.setBackground(new java.awt.Color(0, 102, 0));
        jButtonSALIR.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButtonSALIR.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSALIR.setText("Salir");
        jButtonSALIR.setMaximumSize(new java.awt.Dimension(107, 23));
        jButtonSALIR.setMinimumSize(new java.awt.Dimension(107, 23));
        jButtonSALIR.setPreferredSize(new java.awt.Dimension(107, 23));
        jButtonSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSALIRActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 120, 30));

        jButtonCLIENTE.setBackground(new java.awt.Color(0, 102, 0));
        jButtonCLIENTE.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButtonCLIENTE.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCLIENTE.setText("Clientes");
        jButtonCLIENTE.setMaximumSize(new java.awt.Dimension(107, 23));
        jButtonCLIENTE.setMinimumSize(new java.awt.Dimension(107, 23));
        jButtonCLIENTE.setPreferredSize(new java.awt.Dimension(107, 23));
        jButtonCLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLIENTEActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 120, 30));

        jButtonADDCLIENTE.setBackground(new java.awt.Color(0, 102, 0));
        jButtonADDCLIENTE.setFont(new java.awt.Font("Consolas", 1, 11)); // NOI18N
        jButtonADDCLIENTE.setForeground(new java.awt.Color(255, 255, 255));
        jButtonADDCLIENTE.setText("Agregar Cliente");
        jButtonADDCLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonADDCLIENTEActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonADDCLIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 120, 30));

        jLabelFONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/800x500-green-wallpaper-hd.jpg"))); // NOI18N
        jLabelFONDO.setMaximumSize(new java.awt.Dimension(600, 500));
        jLabelFONDO.setMinimumSize(new java.awt.Dimension(600, 500));
        jLabelFONDO.setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().add(jLabelFONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSALIRActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSALIRActionPerformed

    private void jButtonADDCLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonADDCLIENTEActionPerformed
        AgCliente a = new AgCliente();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        this.setVisible(false);      
    }//GEN-LAST:event_jButtonADDCLIENTEActionPerformed

    private void jButtonCLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLIENTEActionPerformed
        Cli a = new Cli();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        this.setVisible(false);        
    }//GEN-LAST:event_jButtonCLIENTEActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonADDCLIENTE;
    private javax.swing.JButton jButtonCLIENTE;
    private javax.swing.JButton jButtonSALIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFONDO;
    private javax.swing.JLabel jLabelLOGO;
    // End of variables declaration//GEN-END:variables
}
