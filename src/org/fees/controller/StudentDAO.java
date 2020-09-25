/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.controller;
import java.io.*;
import org.fees.util.DBConnection;
import java.sql.*;
import java.util.*;
import org.fees.model.*;
/**
 *
 * @author DELL
 */
public class StudentDAO {
     public int insertRecord(Student s)
    {
        int count=0;
	try {
	Connection con=DBConnection.getConnection();
		String sql="insert into student(student_no,student_name,father_name,mother_name,dob,grade,batch,due,contact_no) values (?,?,?,?,?,?,?,?,?)";
                PreparedStatement st=con.prepareStatement(sql);
                st.setInt(1,s.getStudentNo());
                st.setString(2,s.getStudentName());
                                st.setString(3,s.getFatherName());
                st.setString(4,s.getMotherName());

                st.setString(5,s.getDateOfBirth());
                st.setInt(6,s.getGrade());
                st.setInt(7, s.getBatch());
                st.setDouble(8, s.getDue());
                st.setLong(9, s.getContactNo());
               count=st.executeUpdate();
                con.close();
        }
	
	catch(Exception ex)
	{
		System.out.println(ex);
	}
        return count;
    }
      public List fetchData()
  {
      List<Student> studentList=new ArrayList();
      try{
          Connection con=DBConnection.getConnection();
		String sql="select * from student";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
      while(rs.next())
      {
          Student ob=new Student();
          ob.setId(rs.getInt("id"));
                              ob.setStudentNo(rs.getInt("student_no"));
                    ob.setStudentName(rs.getString("student_name"));
                                        ob.setFatherName(rs.getString("father_name"));
                    ob.setMotherName(rs.getString("mother_name"));
                                        ob.setDateOfBirth(rs.getString("dob"));

          ob.setGrade(rs.getInt("grade"));
          ob.setBatch(rs.getInt("batch"));

                         ob.setDue(rs.getDouble("Due"));
                    ob.setContactNo(rs.getLong("contact_no"));
                   studentList.add(ob);
      }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return studentList;
  }
       public int EraseData(Student s)
  {
     int count=0;
    
     try {
	Connection con=DBConnection.getConnection();
		String sql="delete from student where id=? ";
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1, s.getId());
		count=pst.executeUpdate();
                con.close();
        }
	
	catch(Exception ex)
	{
		System.out.println(ex);
	}
        return count;
  }
       
          public List searchList(String abc)
  {
      List<Student> studentList=new ArrayList();
      try{
          Connection con=DBConnection.getConnection();
		String sql="select * from student where student_name like ? ";
 PreparedStatement pst=con.prepareStatement(sql);
             pst.setString(1,"%"+abc+"%");
   //                       pst.setInt(2,xyz);
             ResultSet rs=pst.executeQuery();
      while(rs.next())
      {
          Student ob=new Student();
          ob.setId(rs.getInt("id"));
                              ob.setStudentNo(rs.getInt("student_no"));
                    ob.setStudentName(rs.getString("student_name"));
                                        ob.setFatherName(rs.getString("father_name"));
                    ob.setMotherName(rs.getString("mother_name"));
                                        ob.setDateOfBirth(rs.getString("dob"));

          ob.setGrade(rs.getInt("grade"));
          ob.setBatch(rs.getInt("batch"));

                         ob.setDue(rs.getDouble("Due"));
                    ob.setContactNo(rs.getLong("contact_no"));
                   studentList.add(ob);
      }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return studentList;
  }
         public double getTotalAmount(int id,Connection con)
{
    double due=0;
    try{
		String sql="select due from student where id=?";
                
             PreparedStatement pst=con.prepareStatement(sql);
             pst.setInt(1,id);
                ResultSet rs=pst.executeQuery();
                while(rs.next())
      {
         due=rs.getDouble("due");
                   
      }
    }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
    return due;
}
public void updateDue(int id,double newDue,Connection con)
{
    try {
		String sql="update student set due=? where id=?";
			PreparedStatement pst=con.prepareStatement(sql);
                       
                        pst.setDouble(1, newDue);
                        pst.setInt(2, id);

               pst.execute();
        }
	
	catch(Exception ex)
	{
		System.out.println(ex);
	}
} 
public List fetchPayment()
{
     List<Payment> paymentList1=new ArrayList();
      try{
          Connection con=DBConnection.getConnection();
		String sql="select * from transactions";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
      while(rs.next())
      {
          Payment ob1=new Payment();                    
          ob1.setId(rs.getInt("id"));
                    ob1.setSid(rs.getInt("sid"));
                    ob1.setUid(rs.getInt("uid"));
                    ob1.setRegForm(rs.getDouble("reg_fee"));
                    ob1.setAdmissionFee(rs.getDouble("admission_fee"));
                    ob1.setAnnualFee(rs.getDouble("annual_fee"));
                    ob1.setTuitionFee(rs.getDouble("tuition_fee"));
                     ob1.setOtherFee(rs.getDouble("other_fee"));
                                         ob1.setTotalAmount(rs.getDouble("total_deposit"));
ob1.setDop(rs.getDate("dop"));
                     paymentList1.add(ob1);
      }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return paymentList1;
}
public List verifyStudent(int sid)
{
         List<Student> studentList1=new ArrayList();

    String uname="";
      try{
          Connection con=DBConnection.getConnection();
		String sql="select * from student where id=?";
                PreparedStatement pst=con.prepareStatement(sql);
               System.out.println(sid);
             pst.setInt(1,sid);
                ResultSet rs=pst.executeQuery();
                while(rs.next())
      {                     
          Student s=new Student();
          s.setStudentNo(rs.getInt("student_no"));
                     s.setStudentName(rs.getString("student_name"));
                   s.setGrade(rs.getInt("grade"));
                   s.setBatch(rs.getInt("batch"));
                                      s.setDue(rs.getDouble("due"));

                                          studentList1.add(s);

      }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return studentList1;
}
public String verifyUser(int uid)
{
    String pname="";
    try{
          Connection con=DBConnection.getConnection();
		String sql="select username from userdetails where id=?";
                PreparedStatement pst=con.prepareStatement(sql);
               System.out.println(uid);
             pst.setInt(1,uid);
                ResultSet rs=pst.executeQuery();
                while(rs.next())
      {
                     pname=rs.getString("username");
      }
      }
      catch(Exception ex)
      {
          System.out.println(ex);
      }
      return pname;
}
public int updateClass(Student s)
{
    int count=0;
    try {
		          Connection con=DBConnection.getConnection();
        String sql="update student set grade=?,due=? where grade=?";
			PreparedStatement pst=con.prepareStatement(sql);
                       
                        pst.setInt(1, s.getGrade());
                        pst.setDouble(2,s.getDue());
                        pst.setInt(3, 14);
count=pst.executeUpdate();
                con.close();

        }
	
	catch(Exception ex)
	{
		System.out.println(ex);
	}
    return count;
}
}
