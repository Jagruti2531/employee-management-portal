package com.employeeportal.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="leave_requests")
public class LeaveRequest { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; Long userId; String type; LocalDate startDate,endDate; String duration,session; @Column(length=1000) String reason; String status; String managerComment; LocalDate actionDate;
 public LeaveRequest(){} public LeaveRequest(Long id,Long uid,String type,LocalDate s,LocalDate e,String duration,String session,String reason,String status){this.id=id;userId=uid;this.type=type;startDate=s;endDate=e;this.duration=duration;this.session=session;this.reason=reason;this.status=status;}
 public Long getId(){return id;} public Long getUserId(){return userId;} public String getType(){return type;} public LocalDate getStartDate(){return startDate;} public LocalDate getEndDate(){return endDate;} public String getDuration(){return duration;} public String getSession(){return session;} public String getReason(){return reason;} public String getStatus(){return status;} public String getManagerComment(){return managerComment;} public LocalDate getActionDate(){return actionDate;}
 public void setStatus(String v){status=v;} public void setManagerComment(String v){managerComment=v;} public void setActionDate(LocalDate v){actionDate=v;}
}
