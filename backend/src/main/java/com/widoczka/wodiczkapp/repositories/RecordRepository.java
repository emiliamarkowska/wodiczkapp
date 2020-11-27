package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Integer> {
}
