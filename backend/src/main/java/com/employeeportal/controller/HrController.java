package com.employeeportal.controller;
import com.employeeportal.model.*; import com.employeeportal.repo.*; import org.springframework.web.bind.annotation.*; import java.time.*; import java.util.*;
@RestController @RequestMapping("/api/hr") public class HrController{
 final UserRepository users;final AttendanceRepository attendance;final LeaveRepository leaves;final PayslipRepository payslips;final DailyStatusRepository statuses;final AnnouncementRepository anns;
 HrController(UserRepository u,AttendanceRepository a,LeaveRepository l,PayslipRepository p,DailyStatusRepository s,AnnouncementRepository n){users=u;attendance=a;leaves=l;payslips=p;statuses=s;anns=n;}
 @GetMapping("/dashboard") Map<String,Object> dashboard(){return Map.of("employees",users.findByRoleOrderByEmployeeCodeAsc("EMPLOYEE"),"attendance",attendance.findAll(),"pendingLeaves",leaves.findByStatusOrderByStartDateDesc("PENDING"),"payslips",payslips.findAll(),"dailyStatuses",statuses.findAll(),"announcements",anns.findAllByOrderByPublishedOnDesc());}
 @GetMapping("/employees") List<User> employees(){return users.findByRoleOrderByEmployeeCodeAsc("EMPLOYEE");}
 @PostMapping("/attendance") Attendance addAttendance(@RequestBody Attendance a){a.setId(null);return attendance.save(a);}
 @PutMapping("/attendance/{id}") Attendance updateAttendance(@PathVariable Long id,@RequestBody Attendance a){Attendance x=attendance.findById(id).orElseThrow();x.setWorkDate(a.getWorkDate());x.setStatus(a.getStatus());x.setCheckIn(a.getCheckIn());x.setCheckOut(a.getCheckOut());x.setHours(a.getHours());return attendance.save(x);}
 @PostMapping("/payslips") Payslip addPayslip(@RequestBody Payslip p){p.setId(null);return payslips.save(p);}
 @PostMapping("/announcements") Announcement addAnnouncement(@RequestBody Announcement a){return anns.save(a);}
 @GetMapping("/daily-status") List<DailyStatus> daily(){return statuses.findAll();}
}
