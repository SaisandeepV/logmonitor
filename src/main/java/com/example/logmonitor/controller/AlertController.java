package com.example.logmonitor.controller;

import com.example.logmonitor.model.Alert;
import com.example.logmonitor.service.AlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public List<Alert> getAlerts(
            @RequestParam(required = false) String service,
            @RequestParam(required = false) String level
    ) {
        if (service != null) {
            return alertService.getAlertsByService(service);
        } else if (level != null) {
            return alertService.getAlertsByLevel(level);
        } else {
            return alertService.getAllAlerts();
        }
    }
}
