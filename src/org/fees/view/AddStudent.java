/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.view;
import javax.swing.*;
import org.fees.controller.StudentDAO;
import org.fees.model.Student;
/**
 *
 * @author DELL
 */
public class AddStudent extends javax.swing.JInternalFrame {
private int grade;
    /**
     * Creates new form AddStudent
     */
    public AddStudent() {
        initComponents();
        radioButton();

    }
    public void radioButton()
    {
        ButtonGroup.add(jRadioButton_First);
                ButtonGroup.add(jRadioButton_Second);
    }
 public void clearFields()
    {
          jTextField_StudentNo.setText("");
                    jTextField_StudentName.setText("");
          jTextField_FatherName.setText("");
          jTextField_MotherName.setText("");

               jTextField_Due.setText("");
        jTextField_DateOfBirth.setText("");
              jTextField_Due.setText("");
jTextField_ContactNo.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextField_StudentNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_StudentName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_FatherName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_MotherName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_DateOfBirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Batch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Due = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField_ContactNo = new javax.swing.JTextField();
        jButton_Save = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jRadioButton_First = new javax.swing.JRadioButton();
        jRadioButton_Second = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Add Student");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Student No:");

        jTextField_StudentNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_StudentNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_StudentNoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Student Name:");

        jTextField_StudentName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_StudentName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_StudentNameKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Father's Name:");

        jTextField_FatherName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_FatherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_FatherNameKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Mother's Name:");

        jTextField_MotherName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_MotherName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_MotherNameKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Date Of Birth:");

        jTextField_DateOfBirth.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_DateOfBirth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DateOfBirthKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Grade:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Batch Year:");

        jTextField_Batch.setEditable(false);
        jTextField_Batch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_Batch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Batch.setText("2019");
        jTextField_Batch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BatchActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Due:");

        jTextField_Due.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_Due.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DueKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Contact No:");

        jTextField_ContactNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_ContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ContactNoKeyTyped(evt);
            }
        });

        jButton_Save.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_Save.setText("Save");
        jButton_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveActionPerformed(evt);
            }
        });

        jButton_Exit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_Exit.setText("Exit");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jRadioButton_First.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton_First.setText("11");
        jRadioButton_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_FirstActionPerformed(evt);
            }
        });

        jRadioButton_Second.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton_Second.setText("12");
        jRadioButton_Second.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SecondActionPerformed(evt);
            }
        });

        jLabel10.setText("Eg: 1999-01-24");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField_DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton_First)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton_Second))
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField_Batch, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField_Due, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jTextField_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField_StudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField_StudentName, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(jTextField_FatherName)
                                .addComponent(jTextField_MotherName)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_StudentNo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_FatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_MotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_DateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_First)
                    .addComponent(jRadioButton_Second))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Batch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Due, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveActionPerformed
int no=Integer.parseInt(jTextField_StudentNo.getText());
String sname=jTextField_StudentName.getText();
String fname=jTextField_FatherName.getText();
String mname=jTextField_MotherName.getText();
String dob=jTextField_DateOfBirth.getText();
        int batch=Integer.parseInt(jTextField_Batch.getText());
               double due=Double.parseDouble(jTextField_Due.getText());
       long contact=Long.parseLong(jTextField_ContactNo.getText());
        Student s=new Student();
        s.setStudentNo(no);
                s.setStudentName(sname);
        s.setFatherName(fname);
        s.setMotherName(mname);
        s.setGrade(grade);
        s.setBatch(batch);
        s.setDateOfBirth(dob);
        s.setDue(due);
        s.setContactNo(contact);
        //now handover this object to controller class ProductDAO
        StudentDAO SDAO=new StudentDAO();
      int count=SDAO.insertRecord(s);
      if(count>0)
      {
          JOptionPane.showMessageDialog(null,"Record Saved");
      }
    clearFields();

    }//GEN-LAST:event_jButton_SaveActionPerformed

    private void jRadioButton_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_FirstActionPerformed
grade=11;

    }//GEN-LAST:event_jRadioButton_FirstActionPerformed

    private void jTextField_BatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BatchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BatchActionPerformed

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
dispose();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jRadioButton_SecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SecondActionPerformed
grade=12;
    }//GEN-LAST:event_jRadioButton_SecondActionPerformed

    private void jTextField_DueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DueKeyTyped
char ch=evt.getKeyChar();
if(!(ch>='0' && ch<='9'))
{
    evt.consume();
}
    }//GEN-LAST:event_jTextField_DueKeyTyped

    private void jTextField_ContactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ContactNoKeyTyped
char ch=evt.getKeyChar();
if(!(ch>='0' && ch<='9'))
{
    evt.consume();
}

    }//GEN-LAST:event_jTextField_ContactNoKeyTyped

    private void jTextField_MotherNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_MotherNameKeyTyped
char ch=evt.getKeyChar();
if(ch>='0' && ch<='9')
{
    evt.consume();
}

    }//GEN-LAST:event_jTextField_MotherNameKeyTyped

    private void jTextField_FatherNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_FatherNameKeyTyped
char ch=evt.getKeyChar();
if(ch>='0' && ch<='9')
{
    evt.consume();
}

    }//GEN-LAST:event_jTextField_FatherNameKeyTyped

    private void jTextField_StudentNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_StudentNameKeyTyped
char ch=evt.getKeyChar();
if(ch>='0' && ch<='9')
{
    evt.consume();
}

    }//GEN-LAST:event_jTextField_StudentNameKeyTyped

    private void jTextField_StudentNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_StudentNoKeyTyped
char ch=evt.getKeyChar();
if(!(ch>='0' && ch<='9'))
{
    evt.consume();
}

    }//GEN-LAST:event_jTextField_StudentNoKeyTyped

    private void jTextField_DateOfBirthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DateOfBirthKeyTyped


    }//GEN-LAST:event_jTextField_DateOfBirthKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton_First;
    private javax.swing.JRadioButton jRadioButton_Second;
    private javax.swing.JTextField jTextField_Batch;
    private javax.swing.JTextField jTextField_ContactNo;
    private javax.swing.JTextField jTextField_DateOfBirth;
    private javax.swing.JTextField jTextField_Due;
    private javax.swing.JTextField jTextField_FatherName;
    private javax.swing.JTextField jTextField_MotherName;
    private javax.swing.JTextField jTextField_StudentName;
    private javax.swing.JTextField jTextField_StudentNo;
    // End of variables declaration//GEN-END:variables
}
