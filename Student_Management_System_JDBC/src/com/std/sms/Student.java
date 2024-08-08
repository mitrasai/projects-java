package com.std.sms;

public class Student {
    private int std_id;
    private String std_name;
    private double std_gpa;
    private String city;
    private String university;

    public Student(int std_id, String std_name, double std_gpa, String city, String university){
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_gpa = std_gpa;
        this.city = city;
        this.university = university;
    }

    // Getters and Setters
    public int getStd_id(){
        return std_id;
    }
    public void setStd_id(int std_id){
        this.std_id = std_id;
    }
    public String getStd_name(){
        return std_name;
    }
    public void setStd_name(String std_name){
        this.std_name = std_name;
    }
    public double getStd_gpa(){
        return std_gpa;
    }
    public void setStd_gpa(double std_gpa){
        this.std_gpa = std_gpa;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getUniversity(){
        return  university;
    }
    public void setUniversity(String university){
        this.university = university;
    }

    // display students
    @Override
    public String toString(){
        return std_id +
                "\t" + std_name +
                "\t" + std_gpa +
                "\t" + city +
                "\t" + university;
    }
}
