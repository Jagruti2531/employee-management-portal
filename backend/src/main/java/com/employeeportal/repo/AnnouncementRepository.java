package com.employeeportal.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employeeportal.model.Announcement;
import java.util.*;
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> { java.util.List<Announcement> findAllByOrderByPublishedOnDesc(); }
