package com.example.logmonitor.service;

import com.example.logmonitor.model.Alert;
import com.example.logmonitor.model.LogEntry;
import com.example.logmonitor.repository.AlertRepository;
import com.example.logmonitor.repository.LogEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogEntryRepository logRepo;
    private final AlertRepository alertRepo;

    public LogService(LogEntryRepository logRepo, AlertRepository alertRepo) {
        this.logRepo = logRepo;
        this.alertRepo = alertRepo;
    }

    // Save log entry and generate alert if level is ERROR
    public LogEntry saveLog(LogEntry log) {
        LogEntry saved = logRepo.save(log);

        if ("ERROR".equalsIgnoreCase(log.getLevel())) {
            Alert alert = Alert.builder()
                    .service(log.getService())
                    .level(log.getLevel())
                    .message(log.getMessage())
                    .timestamp(log.getTimestamp())
                    .build();
            alertRepo.save(alert);
        }
        return saved;
    }

    // Fetch logs with optional filters
    public List<LogEntry> getLogs(String level, String service) {
        if (level != null && service != null) return logRepo.findByLevelAndService(level, service);
        if (level != null) return logRepo.findByLevel(level);
        if (service != null) return logRepo.findByService(service);
        return logRepo.findAll();
    }

    // Fetch all alerts
    public List<Alert> getAlerts() {
        return alertRepo.findAll();
    }
}
