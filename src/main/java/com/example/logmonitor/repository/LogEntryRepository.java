package com.example.logmonitor.repository;

import com.example.logmonitor.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {
    List<LogEntry> findByLevel(String level);
    List<LogEntry> findByService(String service);
    List<LogEntry> findByLevelAndService(String level, String service);
}
