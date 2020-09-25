/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.model;
/**
 *
 * @author DELL
 */
public class Student {
    private int id;
    private int StudentNo;
    private String StudentName;
    private String FatherName;
    private String MotherName;
    private String DateOfBirth;
    private int Grade;
    private int Batch;
    private double Due;
    private Long ContactNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(int StudentNo) {
        this.StudentNo = StudentNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String MotherName) {
        this.MotherName = MotherName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int Grade) {
        this.Grade = Grade;
    }

    public int getBatch() {
        return Batch;
    }

    public void setBatch(int Batch) {
        this.Batch = Batch;
    }

    public double getDue() {
        return Due;
    }

    public void setDue(double Due) {
        this.Due = Due;
    }

    public long getContactNo() {
        return ContactNo;
    }

    public void setContactNo(long ContactNo) {
        this.ContactNo = ContactNo;
    }
       
}
