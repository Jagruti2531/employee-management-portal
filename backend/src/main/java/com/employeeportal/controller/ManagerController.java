package com.employeeportal.controller;
import com.employeeportal.model.*; import com.employeeportal.repo.*; import org.springframework.web.bind.annotation.*; import java.time.LocalDate; import java.util.*;
@RestController @RequestMapping("/api/manager") public class ManagerController{
 final UserRepository users;final LeaveRepository leaves;final DailyStatusRepository statuses;final AttendanceRepository attendance;
 ManagerController(UserRepository u,LeaveRepository l,DailyStatusRepository s,AttendanceRepository a){users=u;leaves=l;statuses=s;attendance=a;}
 @GetMapping("/dashboard") Map<String,Object> dashboard(){return Map.of("employees",users.findByRoleOrderByEmployeeCodeAsc("EMPLOYEE"),"pendingLeaves",leaves.findByStatusOrderByStartDateDesc("PENDING"),"dailyStatuses",statuses.findAll(),"attendance",attendance.findAll());}
 @PutMapping("/leaves/{id}") LeaveRequest action(@PathVariable Long id,@RequestBody Map<String,String> b){LeaveRequest r=leaves.findById(id).orElseThrow();r.setStatus(b.getOrDefault("status","PENDING"));r.setManagerComment(b.get("comment"));r.setActionDate(LocalDate.now());return leaves.save(r);}
}
