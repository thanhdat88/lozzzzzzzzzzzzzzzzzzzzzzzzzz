package com.example.quanlydiemsinhvien.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class StudentDTO {
    @SerializedName("classCode")
    @Expose
    private String classCode;
    @SerializedName("studentAdress")
    @Expose
    private String studentAdress;
    @SerializedName("studentBirhDay")
    @Expose
    private String studentBirhDay;
    @SerializedName("studentCode")
    @Expose
    private String studentCode;
    @SerializedName("studentEmail")
    @Expose
    private String studentEmail;
    @SerializedName("studentId")
    @Expose
    private int studentId;
    @SerializedName("studentName")
    @Expose
    private String studentName;

    public StudentDTO() {
    }

    public StudentDTO(String classCode, String studentAdress, String studentBirhDay, String studentCode, String studentEmail, String studentName) {
        this.classCode = classCode;
        this.studentAdress = studentAdress;
        this.studentBirhDay = studentBirhDay;
        this.studentCode = studentCode;
        this.studentEmail = studentEmail;
        this.studentName = studentName;
    }

    public StudentDTO(String studentAdress, String studentBirhDay, String studentCode, String studentName) {
        this.studentAdress = studentAdress;
        this.studentBirhDay = studentBirhDay;
        this.studentCode = studentCode;
        this.studentName = studentName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public String getStudentBirhDay() {
        return studentBirhDay;
    }

    public void setStudentBirhDay(String studentBirhDay) {
        this.studentBirhDay = studentBirhDay;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
