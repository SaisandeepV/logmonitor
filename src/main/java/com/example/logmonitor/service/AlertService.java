package com.example.logmonitor.service;

import com.example.logmonitor.model.Alert;
import com.example.logmonitor.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getAlertsByService(String service) {
        return alertRepository.findByService(service);
    }

    public List<Alert> getAlertsByLevel(String level) {
        return alertRepository.findByLevel(level);
    }
}
