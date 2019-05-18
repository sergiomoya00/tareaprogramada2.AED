/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Collections.BST;
import Collections.Validation;
import SYSTEM.HDD;
import SYSTEM.Partitions;
import SYSTEM.SystemManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Fanny Brenes
 */
public class PartitionCreation extends javax.swing.JFrame {
 private Partitions partition;
   private HDD hdd;
   public Partitions getPartition() {
        return partition;
    }
   public HDD getHDD() {
        return hdd;
    }
    /**
     * Creates new form PartitionCreation
     */
    public PartitionCreation() {
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

        txtroot = new javax.swing.JTextField();
        txtsize = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtroot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrootActionPerformed(evt);
            }
        });
        getContentPane().add(txtroot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 70, -1));
        getContentPane().add(txtsize, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 70, 20));

        jLabel1.setText("Raiz");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel2.setText("Tamaño");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Validation sec=new Validation();
    boolean size=sec.Validate(txtsize.getText());
    if (size!=false){
     
     int e=Integer.parseInt(txtsize.getText());
     
     float x=SystemManager.getInstance().getHDD(0).getSize();
     float y=SystemManager.getInstance().getHDD(0).getFreespace();
     float g=SystemManager.getInstance().getHDD(0).getSpaceused();
     
     if (e<x&&x>g){
     float spaceused=g+e;
     float freespace=y-e;
     SystemManager.getInstance().removeHDD(0);
     this.hdd=new HDD();
     this.hdd.setSize(x);
     this.hdd.setSpaceused(spaceused);
     this.hdd.setFreespace(freespace);
     SystemManager.getInstance().addHDD(hdd);
     
    
        this.partition= new Partitions();
        this.partition.setRoot(txtroot.getText()+".NTFS");
        this.partition.setSize(e);
        SystemManager.getInstance().addPartition(partition);
          BST<Partitions> part=new BST<>();
          part.insert(partition);
          SystemManager.getInstance().addTree(part);
        
        SecondWindow usuario = new SecondWindow();
        usuario.setVisible(true);
        this.setVisible(false);}
    else{
     JOptionPane.showMessageDialog(null,"Tamaño mayor al del disco duro o Almacenamiento lleno");
    }

    }
         else{
     JOptionPane.showMessageDialog(null,"Error no se puede avanzar");
    }
    
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtrootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrootActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrootActionPerformed

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
            java.util.logging.Logger.getLogger(PartitionCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartitionCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartitionCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartitionCreation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartitionCreation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtroot;
    private javax.swing.JTextField txtsize;
    // End of variables declaration//GEN-END:variables
}
