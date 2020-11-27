package com.widoczka.wodiczkapp.services;

import com.widoczka.wodiczkapp.model.Record;
import com.widoczka.wodiczkapp.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void addRecord(Record record){
        recordRepository.save(record);
    }
    public void deleteRecord(int id) {
        recordRepository.deleteById(id);
    }
}
