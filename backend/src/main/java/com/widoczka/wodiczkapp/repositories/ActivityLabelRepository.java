package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.ActivityLabel;
import com.widoczka.wodiczkapp.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLabelRepository extends CrudRepository<ActivityLabel, Integer> {
}
