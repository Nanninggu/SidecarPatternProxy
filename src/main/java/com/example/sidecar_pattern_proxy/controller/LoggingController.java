package com.example.sidecar_pattern_proxy.controller;

import com.example.sidecar_pattern_proxy.dto.LogEntry;
import com.example.sidecar_pattern_proxy.mapper.LogEntryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoggingController {

    @Autowired
    private LogEntryMapper logEntryMapper;

    @GetMapping("/log")
    public List<LogEntry> log() {
        return logEntryMapper.getLogs();
    }

    @PostMapping("/log")
    public void log(@RequestBody String errorLog) {
        LogEntry logEntry = new LogEntry();
        logEntry.setMessage(errorLog);
        logEntryMapper.insertLogEntry(logEntry);
        System.out.println("Received error log: " + errorLog);
    }
}
