package views;

import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author mitchellgriffith
 */
public class NewJFrame extends javax.swing.JFrame {

  /**
   * Creates new form NewJFrame
   */
  public NewJFrame() {
    initComponents();
  }

  public JMenuItem getNewMenuItem(){ return newMenu; }
  public JMenuItem getOpenMenuItem(){ return openMenu; }
  public JMenuItem getSaveMenuItem(){ return saveMenu; }
  public JMenuItem getSaveAsMenuItem(){ return saveAsMenu; }
  public JTextArea getTextArea(){ return jTextArea1; }
  public JTextField getFileName(){ return fileNameField; } 
  public JTextField getEdited(){return editedField; }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jPanel1 = new javax.swing.JPanel();
    editedField = new javax.swing.JTextField();
    fileNameField = new javax.swing.JTextField();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    openMenu = new javax.swing.JMenuItem();
    newMenu = new javax.swing.JMenuItem();
    saveMenu = new javax.swing.JMenuItem();
    saveAsMenu = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

    jPanel1.setLayout(new java.awt.BorderLayout());

    editedField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editedFieldActionPerformed(evt);
      }
    });
    jPanel1.add(editedField, java.awt.BorderLayout.CENTER);

    fileNameField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fileNameFieldActionPerformed(evt);
      }
    });
    jPanel1.add(fileNameField, java.awt.BorderLayout.PAGE_END);

    getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

    jMenu1.setText("File");

    openMenu.setText("Open");
    jMenu1.add(openMenu);

    newMenu.setText("New");
    jMenu1.add(newMenu);

    saveMenu.setText("Save");
    saveMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveMenuActionPerformed(evt);
      }
    });
    jMenu1.add(saveMenu);

    saveAsMenu.setText("Save As");
    saveAsMenu.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveAsMenuActionPerformed(evt);
      }
    });
    jMenu1.add(saveAsMenu);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_saveMenuActionPerformed

  private void saveAsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_saveAsMenuActionPerformed

  private void fileNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameFieldActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_fileNameFieldActionPerformed

  private void editedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editedFieldActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_editedFieldActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField editedField;
  private javax.swing.JTextField fileNameField;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JMenuItem newMenu;
  private javax.swing.JMenuItem openMenu;
  private javax.swing.JMenuItem saveAsMenu;
  private javax.swing.JMenuItem saveMenu;
  // End of variables declaration//GEN-END:variables
}
