package com.employeeportal.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="attendance")
public class Attendance { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; Long userId; LocalDate workDate; String status,checkIn,checkOut; Double hours,shortfall,overtime;
 public Attendance(){} public Attendance(Long id,Long uid,LocalDate d,String s,String in,String out,Double h){this.id=id;userId=uid;workDate=d;status=s;checkIn=in;checkOut=out;hours=h;shortfall=Math.max(0,8-h);overtime=Math.max(0,h-8);}
 public Long getId(){return id;} public void setId(Long v){id=v;} public Long getUserId(){return userId;} public LocalDate getWorkDate(){return workDate;} public String getStatus(){return status;} public String getCheckIn(){return checkIn;} public String getCheckOut(){return checkOut;} public Double getHours(){return hours;} public Double getShortfall(){return shortfall==null?0:shortfall;} public Double getOvertime(){return overtime==null?0:overtime;}
 public void setUserId(Long v){userId=v;} public void setWorkDate(LocalDate v){workDate=v;} public void setStatus(String v){status=v;} public void setCheckIn(String v){checkIn=v;} public void setCheckOut(String v){checkOut=v;} public void setHours(Double v){hours=v;shortfall=Math.max(0,8-v);overtime=Math.max(0,v-8);}
}
