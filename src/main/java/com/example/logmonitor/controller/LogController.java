package com.example.logmonitor.controller;

import com.example.logmonitor.model.Alert;
import com.example.logmonitor.model.LogEntry;
import com.example.logmonitor.service.LogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    // POST API to create a log
    @PostMapping("/logs")
    public LogEntry createLog(@RequestBody LogEntry log) {
        return logService.saveLog(log);
    }

    // GET API to fetch logs (optional filters)
    @GetMapping("/logs")
    public List<LogEntry> getLogs(@RequestParam(required = false) String level,
                                  @RequestParam(required = false) String service) {
        return logService.getLogs(level, service);
    }

    
}
