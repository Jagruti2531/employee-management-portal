package com.employeeportal;
import com.employeeportal.model.*; import com.employeeportal.repo.*; import org.springframework.boot.*; import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.context.annotation.Bean; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import java.time.*; import java.util.*;
@SpringBootApplication public class EmployeePortalApplication{
 public static void main(String[] args){SpringApplication.run(EmployeePortalApplication.class,args);}
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean CommandLineRunner seed(UserRepository users,AttendanceRepository att,LeaveRepository leaves,PayslipRepository pays,DailyStatusRepository ds,AnnouncementRepository anns,PasswordEncoder enc){return args->{
  if(users.findByEmail("hr@company.com").isEmpty()){
   User hr=users.save(new User(null,"hr@company.com","Anita Desai","HR-001","HR","Human Resources","HR Manager",enc.encode("Hr@123"),""));
   User mgr=users.save(new User(null,"manager@company.com","Neeraj Mehta","MGR-001","MANAGER","Engineering","Engineering Manager",enc.encode("Manager@123"),""));
   String[][] data={{"employee@company.com","Jagruti Salunkhe","EMP-001","Java Developer","Engineering"},{"rahul@company.com","Rahul Sharma","EMP-002","Software Engineer","Engineering"},{"priya@company.com","Priya Patil","EMP-003","QA Engineer","Engineering"},{"amit@company.com","Amit Joshi","EMP-004","Backend Developer","Engineering"},{"sneha@company.com","Sneha Kulkarni","EMP-005","Accountant","Finance"},{"rohit@company.com","Rohit Deshmukh","EMP-006","Full Stack Developer","Engineering"},{"neha@company.com","Neha More","EMP-007","UI Developer","Engineering"},{"akash@company.com","Akash Pawar","EMP-008","QA Analyst","Engineering"},{"pooja@company.com","Pooja Shinde","EMP-009","UI/UX Developer","Product"},{"kunal@company.com","Kunal Patil","EMP-010","Sales Executive","Sales"}};
   for(int i=0;i<data.length;i++){User u=users.save(new User(null,data[i][0],data[i][1],data[i][2],"EMPLOYEE",data[i][4],data[i][3],enc.encode("Employee@123"),"Neeraj Mehta"));u.setJoiningDate(LocalDate.now().minusMonths(8+i%5).toString());u.setPhone("98"+String.format("%08d",10000000+i));u.setCasualLeave(6.0);u.setSickLeave(6.0);u.setEarnedLeave(12.0);users.save(u);
    for(int d=1;d<=8;d++){LocalDate date=LocalDate.now().minusDays(d);double h=(d%4==0?6.5:(d%5==0?7.25:8.5));String st=(h<8?"SHORTFALL":"PRESENT");att.save(new Attendance(null,u.getId(),date,st,(d%3==0?"10:05":"09:30"),(h<8?"16:30":"18:00"),h));}
    ds.save(new DailyStatus(null,u.getId(),LocalDate.now().minusDays(1),"Worked on assigned project tasks, attended team sync and completed testing/debugging activities.",i%3==0?"Waiting for requirement clarification.":"No blockers.","Continue development and testing of assigned work."));
    pays.save(new Payslip(null,u.getId(),"September 2026",35000.0+i*1000,12000.0,5000.0,4200.0,200.0,47600.0+i*800,LocalDate.now().toString()));
    pays.save(new Payslip(null,u.getId(),"August 2026",35000.0+i*1000,12000.0,5000.0,4200.0,200.0,47600.0+i*800,LocalDate.now().minusMonths(1).toString()));
    leaves.save(new LeaveRequest(null,u.getId(),"Casual Leave",LocalDate.now().plusDays(5+i%3),LocalDate.now().plusDays(5+i%3),"FULL_DAY","","Personal work","PENDING"));
    if(i<4)leaves.save(new LeaveRequest(null,u.getId(),"Sick Leave",LocalDate.now().minusDays(10+i),LocalDate.now().minusDays(10+i),"HALF_DAY",i%2==0?"FIRST_HALF":"SECOND_HALF","Medical appointment","APPROVED"));
   }
   anns.save(new Announcement(null,"Monthly Town Hall","Monthly company town hall is scheduled for Friday at 4:00 PM.",LocalDate.now(),"Company"));
   anns.save(new Announcement(null,"Attendance Reminder","Please ensure attendance records and daily work status are completed regularly.",LocalDate.now().minusDays(1),"HR"));
  }
 };}
}
