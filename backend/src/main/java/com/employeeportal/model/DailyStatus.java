package com.employeeportal.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="daily_statuses", uniqueConstraints=@UniqueConstraint(columnNames={"userId","statusDate"}))
public class DailyStatus { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; Long userId; LocalDate statusDate; @Column(length=4000) String workDone; @Column(length=2000) String blockers; @Column(length=2000) String tomorrowPlan;
 public DailyStatus(){} public DailyStatus(Long id,Long uid,LocalDate d,String w,String b,String t){this.id=id;userId=uid;statusDate=d;workDone=w;blockers=b;tomorrowPlan=t;}
 public Long getId(){return id;} public Long getUserId(){return userId;} public LocalDate getStatusDate(){return statusDate;} public String getWorkDone(){return workDone;} public String getBlockers(){return blockers;} public String getTomorrowPlan(){return tomorrowPlan;}
 public void setWorkDone(String v){workDone=v;} public void setBlockers(String v){blockers=v;} public void setTomorrowPlan(String v){tomorrowPlan=v;}
}
