package com.example.sidecar_pattern_proxy.mapper;

import com.example.sidecar_pattern_proxy.dto.LogEntry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogEntryMapper {

    void insertLogEntry(LogEntry logEntry);

    List<LogEntry> getLogs();
}
