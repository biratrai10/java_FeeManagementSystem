/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.color.*;
import java.io.*;
import java.util.*;
import javafx.scene.paint.Color;
import org.fees.model.Student;
import org.fees.controller.StudentDAO;
import org.fees.util.StudentUtil;
import org.fees.util.Global;
import org.fees.model.Payment;
import org.fees.controller.PaymentController;

/**
 *
 * @author DELL
 */
public class MainFrame extends javax.swing.JFrame {
private int id;
    private int StudentNo;
    private String FatherName;
    private String MotherName;
    private String StudentName;
    private String DateOfBirth;
    private int Grade;
    private int Batch;
    private double Due;
    private long ContactNo;
    private int sid;
    DefaultTableModel model,model1;    
    private double percent;
    private String searchValue;
    private int snum;
    private double regForm;
    private double annualFee;
        private double admissionFee;
    private double tuitionFee;
    private double otherFee;

    public MainFrame() {
        
        initComponents();
                jLabel_CurrentDate.setText(new Date().toString());
                        jLabel_User.setText(Global.user);

        radioButton();
model=new DefaultTableModel(null, new String[]{"Id","Student Reg No","Student Name","Father Name","Mother Name ","DOB","Grade","Batch Year","Due remains","Contact No"});
        jTable_View.setModel(model);
        loadTable1();
        valueOn();

    }
   
    public void loadTable1()
    {
       model1=new DefaultTableModel(null, new String[]{"Reciept No.","Student Reg No","Student Name","Grade","Batch Year","DOP","User Approved","Registration From","Admission fee","Annual Fee","Tuition Fee","Other Fee","Total Deposit Amount","Due remains"});
        jTable_Transaction.setModel(model1);  
    }
public void clearTable()
    {
        int count=jTable_View.getRowCount();
        for(int i=0;i<count;i++)
        {
            model.removeRow(0);
        }
    }
public void clearTable1()
{
    
        int count=jTable_Transaction.getRowCount();
        for(int i=0;i<count;i++)
        {
            model1.removeRow(0);
        }
}
    public void loadData()
    {
        StudentDAO sDAO=new StudentDAO();
List<Student> studentList=sDAO.fetchData();
clearTable();       
for(Student s:studentList)
        {
            model.addRow(new Object[]{s.getId(),s.getStudentNo(),s.getStudentName(),s.getFatherName(),s.getMotherName(),s.getDateOfBirth(),s.getGrade(),s.getBatch(),s.getDue(),s.getContactNo()});
        }
    }
    public void searchData()
    {
         StudentDAO sDAO=new StudentDAO();
List<Student> studentList=sDAO.searchList(searchValue);
clearTable();       
for(Student s:studentList)
        {
            model.addRow(new Object[]{s.getId(),s.getStudentNo(),s.getStudentName(),s.getFatherName(),s.getMotherName(),s.getDateOfBirth(),s.getGrade(),s.getBatch(),s.getDue(),s.getContactNo()});
        }
    }
    
     /*public void searchNum()
    {
         StudentDAO sDAO=new StudentDAO();
List<Student> studentList=sDAO.searchListNum(snum);
clearTable();       
for(Student s:studentList)
        {
            model.addRow(new Object[]{s.getId(),s.getStudentNo(),s.getStudentName(),s.getFatherName(),s.getMotherName(),s.getDateOfBirth(),s.getGrade(),s.getBatch(),s.getDue(),s.getContactNo()});
        }
    }*/
    public void loadTransaction()
    {
        StudentDAO sDAO=new StudentDAO();
List<Payment> paymentList=sDAO.fetchPayment();
clearTable1(); 
int i=0;
int k=0;
String uname="";
String pname="";
for(Payment p:paymentList)
        {
                            
            model1.addRow(new Object[]{p.getId(),p.getSid(),p.getUid(),p.getRegForm(),p.getAdmissionFee(),p.getAnnualFee(),p.getTuitionFee(),p.getOtherFee(),p.getTotalAmount(),p.getDop()});
 int sid=Integer.parseInt(jTable_Transaction.getValueAt(i,1).toString());
 int uid=Integer.parseInt(jTable_Transaction.getValueAt(i,2).toString());
//StudentDAO u=new StudentDAO();
    jTable_Transaction.setValueAt(p.getDop(), i, 5);
     jTable_Transaction.setValueAt(p.getRegForm(), i, 7);
     jTable_Transaction.setValueAt(p.getAdmissionFee(), i, 8);
    jTable_Transaction.setValueAt(p.getAnnualFee(), i, 9);
    jTable_Transaction.setValueAt(p.getTuitionFee(), i, 10);
    jTable_Transaction.setValueAt(p.getOtherFee(), i, 11);
    jTable_Transaction.setValueAt(p.getTotalAmount(), i, 12);

List<Student> studentList=sDAO.verifyStudent(sid);
for(Student s:studentList)
{
    
      jTable_Transaction.setValueAt(s.getStudentNo(), k, 1);
       jTable_Transaction.setValueAt(s.getStudentName(), k, 2);
         jTable_Transaction.setValueAt(s.getGrade(), k, 3);
  jTable_Transaction.setValueAt(s.getBatch(), k, 4);
  jTable_Transaction.setValueAt(s.getDue(), k, 13);

k++;

}
uname=sDAO.verifyUser(uid);
// jTable_Transaction.setValueAt(uname, i, 2);
  jTable_Transaction.setValueAt(uname, i, 6);
         grandTotal();
 
         i++;
 
        }
    }
     public void grandTotal()
 {
     int count=  jTable_Transaction.getRowCount();
     double gtotal=0;
     for(int i=0;i<count;i++)
     {
     double total=Double.parseDouble(  jTable_Transaction.getValueAt(i,12).toString());

    gtotal+=total;
     }
     jLabel_cash.setText(gtotal+"");
 }
  public void selectData()
  {
      int row=jTable_View.getSelectedRow();
        id=Integer.parseInt(jTable_View.getValueAt(row,0).toString());
                sid=id;
      StudentNo=Integer.parseInt(jTable_View.getValueAt(row,1).toString());
        StudentName=jTable_View.getValueAt(row,2).toString();
      FatherName=jTable_View.getValueAt(row,3).toString();
       MotherName=jTable_View.getValueAt(row,4).toString();
      DateOfBirth=jTable_View.getValueAt(row,5).toString();
       Grade=Integer.parseInt(jTable_View.getValueAt(row,6).toString());
              Batch=Integer.parseInt(jTable_View.getValueAt(row,7).toString());
                     Due=Double.parseDouble(jTable_View.getValueAt(row,8).toString());
              ContactNo=Long.parseLong(jTable_View.getValueAt(row,9).toString());  
      StudentUtil.sid=id;
            StudentUtil.sno=StudentNo;
            StudentUtil.grade=Grade;
            StudentUtil.cno=ContactNo;
            StudentUtil.dob=DateOfBirth;
            StudentUtil.fname=FatherName;
                        StudentUtil.sname=StudentName;
            StudentUtil.mname=MotherName;
            StudentUtil.batch=Batch;
  }
  public void feesDetails()
  {
                  jTextField_StudentId.setText(id+"");
                  jTextField_StudentRegNo.setText(StudentNo+"");
                              jTextField_StudentName.setText(StudentName);
                              jTextField_StudentDue.setText(Due+"");


  }
   public void radioButton()
    {
        ButtonGroup.add(jRadioButton_First);
                ButtonGroup.add(jRadioButton_Second);
    }
   double gtotal;
   public void GrandTotal()
   {
      regForm=Double.parseDouble(jTextField_RegFrom.getText());
      annualFee=Double.parseDouble(jTextField_AnnualFee.getText());
      tuitionFee=Double.parseDouble(jTextField_TuitionFee.getText());
      admissionFee=Double.parseDouble(jTextField_AdmissionFee.getText());
      otherFee=Double.parseDouble(jTextField_OtherFee.getText());

       gtotal=regForm+annualFee+tuitionFee+otherFee+admissionFee;
       
       jTextField_Total.setText(gtotal+"");
   }
   public void valueOn()
   {
       jTextField_RegFrom.setText("0.0");
              jTextField_AnnualFee.setText("0.0");
       jTextField_AdmissionFee.setText("0.0");
       jTextField_TuitionFee.setText("0.0");
       jTextField_OtherFee.setText("0.0");
jTextField_Total.setText("0.0");
jTextField_StudentDue.setText("0.0");
jTextField_Deposit.setText("0.0");

   }
   public void valueOn1()
   {
       jTextField_RegFrom.setText("0.0");
              jTextField_AnnualFee.setText("0.0");
       jTextField_AdmissionFee.setText("0.0");
       jTextField_TuitionFee.setText("0.0");
       jTextField_OtherFee.setText("0.0");
       jTextField_Total.setText("0.0");
       jTextField_Deposit.setText("0.0");


   }
   public void printBill()
 {
    // int count=jTable_Transactions.getRowCount();
     String str="                        Fee Managements\n                        New Banashower,kathmandu\n";
     str+="\n                  Fee Recepit                  ";
     str+="         "+jLabel_CurrentDate.getText()+"\n";
     str+="\nStudent Reg No. "+jTextField_StudentRegNo.getText()+"\n";
     str+="\nStudent Name. "+jTextField_StudentName.getText()+"\n";
     str+="Sno.   "+"Particular               "+"             Amount";
     for(int i=0;i<1;i++)
     {
         str+="\n1.   "+"Registration Form Fee.               "+jTextField_RegFrom.getText()+"\n";
         str+="\n2.   "+"Admission Fee.                            "+jTextField_AdmissionFee.getText()+"\n";
         str+="\n3.   "+"Annual Fee.                                   "+jTextField_AnnualFee.getText()+"\n";
         str+="\n4.   "+"Tuition Fee.                            "+jTextField_TuitionFee.getText()+"\n";
         str+="\n5.   "+"Other Fee.                                 "+jTextField_OtherFee.getText()+"\n";
     }
         str+="\nGrand Total:                                 "+jTextField_Total.getText();
         str+="\n                                    Signature ..............";
     BillPrint ob=new BillPrint();
     ob.jTextArea_Bill.setLineWrap(true);
     ob.jTextArea_Bill.setText(str);
     ob.setVisible(true);
     try{
         ob.jTextArea_Bill.print();
     }
     catch(Exception ex)
     {
         System.out.println(ex);
     }
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
        desktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane_StudentInfo = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_View = new javax.swing.JTable();
        jButton_AddStudent = new javax.swing.JButton();
        jButton_ViewStudent = new javax.swing.JButton();
        jButton_DeleteStudent = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel_FeesInfo = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_StudentId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_StudentName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_StudentDue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_StudentRegNo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton_First = new javax.swing.JRadioButton();
        jRadioButton_Second = new javax.swing.JRadioButton();
        jButton_Calculate = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField_Total = new javax.swing.JTextField();
        jButton_UpdateFee = new javax.swing.JButton();
        jButton_SavePrint = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_RegFrom = new javax.swing.JTextField();
        jTextField_AdmissionFee = new javax.swing.JTextField();
        jTextField_AnnualFee = new javax.swing.JTextField();
        jTextField_TuitionFee = new javax.swing.JTextField();
        jTextField_OtherFee = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField_Deposit = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel_User = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Transaction = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel_cash = new javax.swing.JLabel();
        jButton_Data = new javax.swing.JButton();
        jLabel_CurrentDate = new javax.swing.JLabel();
        jTextField_Search = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_UpgradeClass = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fees MGMT");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fees Management");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane_StudentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane_StudentInfoMouseClicked(evt);
            }
        });

        jTable_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_View);

        jButton_AddStudent.setText("Add Student");
        jButton_AddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddStudentActionPerformed(evt);
            }
        });

        jButton_ViewStudent.setText("View Student");
        jButton_ViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ViewStudentActionPerformed(evt);
            }
        });

        jButton_DeleteStudent.setText("Erase Student");
        jButton_DeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_AddStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_ViewStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_DeleteStudent)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_AddStudent)
                    .addComponent(jButton_ViewStudent)
                    .addComponent(jButton_DeleteStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        jTabbedPane_StudentInfo.addTab("Students Details", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Fees Amount Information");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("25% Due Before First Term Exam");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("50% Due Before Mid Term Exam");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("75% Due Before Pre-Board Exam");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("100% Due Before Board Exam");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Fee Deposit");

        jTextField_StudentId.setEditable(false);
        jTextField_StudentId.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StudentIdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Id");

        jTextField_StudentName.setEditable(false);
        jTextField_StudentName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Name");

        jTextField_StudentDue.setEditable(false);
        jTextField_StudentDue.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_StudentDue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_StudentDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_StudentDueActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Reg No");

        jTextField_StudentRegNo.setEditable(false);
        jTextField_StudentRegNo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Due Amount                     Rs");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Choice Term");

        jRadioButton_First.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton_First.setText("Yes 25%");
        jRadioButton_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_FirstActionPerformed(evt);
            }
        });

        jRadioButton_Second.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton_Second.setSelected(true);
        jRadioButton_Second.setText("No");
        jRadioButton_Second.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SecondActionPerformed(evt);
            }
        });

        jButton_Calculate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Calculate.setText("Calculate");
        jButton_Calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CalculateActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Total Amount                   Rs");

        jTextField_Total.setEditable(false);
        jTextField_Total.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_Total.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton_UpdateFee.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_UpdateFee.setText("Update Fee");
        jButton_UpdateFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateFeeActionPerformed(evt);
            }
        });

        jButton_SavePrint.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_SavePrint.setText("Pay & Print");
        jButton_SavePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SavePrintActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Registration From");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Admission Fee");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Annual Fee");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Tuition Fee");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Other Fee");

        jTextField_RegFrom.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_AdmissionFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_AnnualFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_TuitionFee.setEditable(false);
        jTextField_TuitionFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField_OtherFee.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(174, 174, 174)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_OtherFee, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_TuitionFee, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_AnnualFee, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_AdmissionFee, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_RegFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField_RegFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_AdmissionFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField_AnnualFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField_TuitionFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField_OtherFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Cash Deposit                     Rs");

        jTextField_Deposit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_Deposit.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Logged In As:");

        jLabel_User.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel_User.setText("User");

        javax.swing.GroupLayout jPanel_FeesInfoLayout = new javax.swing.GroupLayout(jPanel_FeesInfo);
        jPanel_FeesInfo.setLayout(jPanel_FeesInfoLayout);
        jPanel_FeesInfoLayout.setHorizontalGroup(
            jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_StudentRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jRadioButton_First)
                                        .addGap(2, 2, 2)
                                        .addComponent(jRadioButton_Second))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_StudentDue, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_SavePrint)
                                    .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton_UpdateFee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_Calculate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_FeesInfoLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_User, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_FeesInfoLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_Deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_FeesInfoLayout.setVerticalGroup(
            jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_FeesInfoLayout.createSequentialGroup()
                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_User, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_StudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_FeesInfoLayout.createSequentialGroup()
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_StudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_StudentRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Calculate))))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField_StudentDue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_UpdateFee)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_FeesInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jRadioButton_First, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jRadioButton_Second, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton_SavePrint))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_FeesInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_FeesInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane_StudentInfo.addTab("Fees Structure", jPanel4);

        jTable_Transaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_Transaction);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Total Collection Amount : Rs");

        jLabel_cash.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel_cash.setText("Current cash");

        jButton_Data.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton_Data.setText("Load");
        jButton_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_cash)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton_Data)
                        .addGap(19, 19, 19))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel_cash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_Data)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane_StudentInfo.addTab("All Transactions", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_StudentInfo)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane_StudentInfo)
        );

        jLabel_CurrentDate.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel_CurrentDate.setText("Current Date & Time");

        jTextField_Search.setBackground(new java.awt.Color(240, 240, 240));
        jTextField_Search.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField_Search.setForeground(new java.awt.Color(51, 51, 51));
        jTextField_Search.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_Search.setText("Search.....");
        jTextField_Search.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextField_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_SearchMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField_SearchMouseExited(evt);
            }
        });
        jTextField_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SearchActionPerformed(evt);
            }
        });
        jTextField_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_SearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_CurrentDate)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_CurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem_Exit.setText("Exit");
        jMenuItem_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem_UpgradeClass.setText("Upgrade Class");
        jMenuItem_UpgradeClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_UpgradeClassActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_UpgradeClass);

        jMenuItem1.setText("Change Password");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ExitActionPerformed
System.exit(0);
    }//GEN-LAST:event_jMenuItem_ExitActionPerformed

    private void jButton_AddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddStudentActionPerformed
        AddStudent ap=new AddStudent();
        desktop.add(ap);
        ap.setVisible(true);
    }//GEN-LAST:event_jButton_AddStudentActionPerformed

    private void jTabbedPane_StudentInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane_StudentInfoMouseClicked

       // sid=0;
       valueOn1();

               loadData();    }//GEN-LAST:event_jTabbedPane_StudentInfoMouseClicked

    private void jButton_ViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ViewStudentActionPerformed
if(sid<=0)
      {
          JOptionPane.showMessageDialog(null,"Choice Data !!!");
      }
else{
ViewStudent ap=new ViewStudent();
        desktop.add(ap);
        ap.setVisible(true);
}
    }//GEN-LAST:event_jButton_ViewStudentActionPerformed

    private void jButton_DeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteStudentActionPerformed
 id=sid;
       if(id>0)
       {
Student s=new Student();
        s.setId(id);
        
        StudentDAO sDAO=new StudentDAO();
int count=sDAO.EraseData(s);
if(count>0)
      {
          JOptionPane.showMessageDialog(null,"Record Delete ");
          sid=0;
      }
loadData();
       }
       else
       {
                     JOptionPane.showMessageDialog(null,"Choice Data !!!");

       }
    }//GEN-LAST:event_jButton_DeleteStudentActionPerformed
    private void jTable_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ViewMouseClicked

selectData();
feesDetails();
    }//GEN-LAST:event_jTable_ViewMouseClicked

    private void jTextField_StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StudentIdActionPerformed

    private void jRadioButton_SecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SecondActionPerformed
        valueOn1();
        percent=0;
jTextField_AdmissionFee.setEditable(false);
jTextField_AnnualFee.setEditable(false);
       jTextField_RegFrom.setEditable(true);

    }//GEN-LAST:event_jRadioButton_SecondActionPerformed

    private void jRadioButton_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_FirstActionPerformed
valueOn1();
        percent=25;
          double atotal=(Due*percent)/100;
       
       jTextField_TuitionFee.setText(atotal+"");
       jTextField_AdmissionFee.setEditable(true);
jTextField_AnnualFee.setEditable(true);

       jTextField_RegFrom.setEditable(false);

    }//GEN-LAST:event_jRadioButton_FirstActionPerformed

    private void jTextField_StudentDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_StudentDueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_StudentDueActionPerformed

    private void jButton_CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CalculateActionPerformed

GrandTotal();
    }//GEN-LAST:event_jButton_CalculateActionPerformed

    private void jButton_UpdateFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_UpdateFeeActionPerformed
    private void jButton_SavePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SavePrintActionPerformed
double deposit=Double.parseDouble(jTextField_Deposit.getText());
if(deposit>0)
{
if(percent>0)
{
/*System.out.println(regForm);
System.out.println(annualFee);
System.out.println(otherFee);
System.out.println(tuitionFee);
System.out.println(admissionFee);
System.out.println(jLabel_User.getText());
System.out.println(id);*/
List<Payment> list=new ArrayList();
      
            Payment ob=new Payment();
            int sid=id;
            int uid=Global.uid;
                        Date d=new Date();
                        ob.setSid(sid);
                        ob.setUid(uid);
                        ob.setRegForm(regForm);
                        ob.setAdmissionFee(admissionFee);
                        ob.setAnnualFee(annualFee);
                        ob.setTuitionFee(tuitionFee);
                                                ob.setOtherFee(otherFee);
                        ob.setTotalAmount(deposit);
                        ob.setDop(d);
                        list.add(ob);
        
PaymentController pc=new PaymentController();
pc.saveData(list);
printBill();


}
else
{
   /* System.out.println(regForm);
System.out.println(annualFee);
System.out.println(otherFee);
System.out.println(tuitionFee);
System.out.println(admissionFee);
System.out.println(jLabel_User.getText());
System.out.println(id);*/
List<Payment> list=new ArrayList();
      
            Payment ob=new Payment();
            int sid=id;
            int uid=Global.uid;
                        Date d=new Date();
                        ob.setSid(sid);
                        ob.setUid(uid);
                        ob.setRegForm(regForm);
                        ob.setAdmissionFee(admissionFee);
                        ob.setAnnualFee(annualFee);
                        ob.setTuitionFee(tuitionFee);
                                                ob.setOtherFee(otherFee);
                        ob.setTotalAmount(deposit);
                        ob.setDop(d);
                        list.add(ob);
        
PaymentController pc=new PaymentController();
pc.saveData1(list);
printBill();

}
}
else
{
                     JOptionPane.showMessageDialog(null,"! Enter Cash Deposit !");
    
    
}
    }//GEN-LAST:event_jButton_SavePrintActionPerformed

    private void jTextField_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SearchKeyTyped
searchValue=jTextField_Search.getText();
//int a=Integer.parseInt(jTextField_Search.getText());
char ch=evt.getKeyChar();
if(!(ch>='0' &&ch<='9'))
{
        searchData();
}
/*else if(ch>='0' && ch<='9')
{
//snum=Integer.parseInt(jTextField_Search.getText().toString());
//System.out.println("Here it is ");
    //System.out.println(a);
}
       //searchData();
*/

    }//GEN-LAST:event_jTextField_SearchKeyTyped

    private void jTextField_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchActionPerformed

//snum=Integer.parseInt(jTextField_Search.getText());
//searchNum();
    }//GEN-LAST:event_jTextField_SearchActionPerformed

    private void jButton_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DataActionPerformed
      
                //clearTable1();

        loadTransaction();

    }//GEN-LAST:event_jButton_DataActionPerformed

    private void jMenuItem_UpgradeClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_UpgradeClassActionPerformed
UpgradeClass n=new UpgradeClass();
desktop.add(n);
n.setVisible(true);


    }//GEN-LAST:event_jMenuItem_UpgradeClassActionPerformed

    private void jTextField_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SearchMouseClicked

jTextField_Search.setText("");
    }//GEN-LAST:event_jTextField_SearchMouseClicked

    private void jTextField_SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SearchMouseExited
      //  jTextField_Search.setText("search");


    }//GEN-LAST:event_jTextField_SearchMouseExited

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
ChangePassword cp=new ChangePassword();
desktop.add(cp);
cp.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed
 
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton jButton_AddStudent;
    private javax.swing.JButton jButton_Calculate;
    private javax.swing.JButton jButton_Data;
    private javax.swing.JButton jButton_DeleteStudent;
    private javax.swing.JButton jButton_SavePrint;
    private javax.swing.JButton jButton_UpdateFee;
    private javax.swing.JButton jButton_ViewStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_CurrentDate;
    private javax.swing.JLabel jLabel_User;
    private javax.swing.JLabel jLabel_cash;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_Exit;
    private javax.swing.JMenuItem jMenuItem_UpgradeClass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_FeesInfo;
    private javax.swing.JRadioButton jRadioButton_First;
    private javax.swing.JRadioButton jRadioButton_Second;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane_StudentInfo;
    private javax.swing.JTable jTable_Transaction;
    private javax.swing.JTable jTable_View;
    private javax.swing.JTextField jTextField_AdmissionFee;
    private javax.swing.JTextField jTextField_AnnualFee;
    private javax.swing.JTextField jTextField_Deposit;
    private javax.swing.JTextField jTextField_OtherFee;
    private javax.swing.JTextField jTextField_RegFrom;
    private javax.swing.JTextField jTextField_Search;
    private javax.swing.JTextField jTextField_StudentDue;
    private javax.swing.JTextField jTextField_StudentId;
    private javax.swing.JTextField jTextField_StudentName;
    private javax.swing.JTextField jTextField_StudentRegNo;
    private javax.swing.JTextField jTextField_Total;
    private javax.swing.JTextField jTextField_TuitionFee;
    // End of variables declaration//GEN-END:variables
}
