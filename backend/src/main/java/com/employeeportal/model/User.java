package com.employeeportal.model;
import jakarta.persistence.*;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
 @Column(nullable=false,unique=true) String email;
 @Column(nullable=false) String name;
 @Column(unique=true) String employeeCode;
 @Column(nullable=false) String role;
 String department, designation, phone, joiningDate, managerName;
 @Column(nullable=false) String passwordHash;
 Double casualLeave=6.0, sickLeave=6.0, earnedLeave=12.0;
 public User(){}
 public User(Long id,String email,String name,String code,String role,String dept,String designation,String passwordHash,String managerName){this.id=id;this.email=email;this.name=name;this.employeeCode=code;this.role=role;this.department=dept;this.designation=designation;this.passwordHash=passwordHash;this.managerName=managerName;}
 public Long getId(){return id;} public String getEmail(){return email;} public String getName(){return name;} public String getEmployeeCode(){return employeeCode;} public String getRole(){return role;} public String getDepartment(){return department;} public String getDesignation(){return designation;} public String getPasswordHash(){return passwordHash;} public String getPhone(){return phone;} public String getJoiningDate(){return joiningDate;} public String getManagerName(){return managerName;} public Double getCasualLeave(){return casualLeave;} public Double getSickLeave(){return sickLeave;} public Double getEarnedLeave(){return earnedLeave;}
 public void setName(String v){name=v;} public void setDepartment(String v){department=v;} public void setDesignation(String v){designation=v;} public void setPhone(String v){phone=v;} public void setJoiningDate(String v){joiningDate=v;} public void setManagerName(String v){managerName=v;} public void setCasualLeave(Double v){casualLeave=v;} public void setSickLeave(Double v){sickLeave=v;} public void setEarnedLeave(Double v){earnedLeave=v;}
}
