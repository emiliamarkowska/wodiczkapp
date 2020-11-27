package com.widoczka.wodiczkapp.controllers;

import com.widoczka.wodiczkapp.model.Record;
import com.widoczka.wodiczkapp.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping(value = "/add-record",
            consumes = "application/json",
            produces = "application/json")
    public void addRecord(){
        Record record = new Record(LocalDateTime.now());
        recordService.addRecord(record);
    }
}
