package com.employeeportal.model;
import jakarta.persistence.*;
@Entity @Table(name="payslips") public class Payslip { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; Long userId;@Column(name = "payslip_month")
private String month; Double basicSalary,hra,allowances,pf,tax,netSalary; String publishedOn;
 public Payslip(){} public Payslip(Long id,Long uid,String m,Double b,Double h,Double a,Double pf,Double tax,Double net,String p){this.id=id;userId=uid;month=m;basicSalary=b;hra=h;allowances=a;this.pf=pf;this.tax=tax;netSalary=net;publishedOn=p;}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Long getUserId(){return userId;} public String getMonth(){return month;} public Double getBasicSalary(){return basicSalary;} public Double getHra(){return hra;} public Double getAllowances(){return allowances;} public Double getPf(){return pf;} public Double getTax(){return tax;} public Double getNetSalary(){return netSalary;} public String getPublishedOn(){return publishedOn;}
}
