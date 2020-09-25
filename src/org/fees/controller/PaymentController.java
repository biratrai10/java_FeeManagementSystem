/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.controller;
import org.fees.model.Payment;
import java.sql.*;
import java.util.*;
import java.io.*;
import org.fees.util.DBConnection;
/**
 *
 * @author DELL
 */
public class PaymentController {
    public void saveData(List<Payment> list ){
         Connection con=null;
       try{
           con=DBConnection.getConnection();
           con.setAutoCommit(false);
           for(int i=0;i<list.size();i++)
           {
               String sql="insert into transactions(sid,uid,reg_fee,admission_fee,annual_fee,tuition_fee,other_fee,total_deposit,dop) values (?,?,?,?,?,?,?,?,?) ";
               PreparedStatement pst=con.prepareStatement(sql);
               pst.setInt(1,list.get(i).getSid());
               pst.setInt(2, list.get(i).getUid());
               pst.setDouble(3,list.get(i).getRegForm());
               pst.setDouble(4,list.get(i).getAdmissionFee());
               pst.setDouble(5,list.get(i).getAnnualFee());
               pst.setDouble(6,list.get(i).getTuitionFee());
               pst.setDouble(7,list.get(i).getOtherFee());
               pst.setDouble(8,list.get(i).getTotalAmount());
               pst.setDate(9, new java.sql.Date(list.get(i).getDop().getTime()));
               pst.execute();
               //get stock quantity from product table
               StudentDAO sdao=new StudentDAO();
               double due=sdao.getTotalAmount(list.get(i).getSid(),con);
           //update stock quantity of product table
           double newDue=due-list.get(i).getTotalAmount();
           sdao.updateDue(list.get(i).getSid(),newDue,con);
           con.commit();
           
           }
           
       }
       catch(Exception ex)
       {
           System.out.println(ex);
       try{
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
       
       }
       finally{
            try{
                con.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            }
    }
    public void saveData1(List<Payment> list ){
         Connection con=null;
       try{
           con=DBConnection.getConnection();
           for(int i=0;i<list.size();i++)
           {
               String sql="insert into transactions(sid,uid,reg_fee,admission_fee,annual_fee,tuition_fee,other_fee,total_deposit,dop) values (?,?,?,?,?,?,?,?,?) ";
               PreparedStatement pst=con.prepareStatement(sql);
               pst.setInt(1,list.get(i).getSid());
               pst.setInt(2, list.get(i).getUid());
               pst.setDouble(3,list.get(i).getRegForm());
               pst.setDouble(4,list.get(i).getAdmissionFee());
               pst.setDouble(5,list.get(i).getAnnualFee());
               pst.setDouble(6,list.get(i).getTuitionFee());
               pst.setDouble(7,list.get(i).getOtherFee());
               pst.setDouble(8,list.get(i).getTotalAmount());
               pst.setDate(9, new java.sql.Date(list.get(i).getDop().getTime()));
               pst.execute();
               //get stock quantity from product table
               //StudentDAO sdao=new StudentDAO();
              // double due=sdao.getTotalAmount(list.get(i).getSid(),con);
           //update stock quantity of product table
           //double newDue=due-list.get(i).getTotalAmount();
          // sdao.updateDue(list.get(i).getSid(),newDue,con);
           con.close();
           
           }
           
       }
       catch(Exception ex)
       {
           System.out.println(ex);
      
       
       }
       
    }
    }

