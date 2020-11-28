package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CategoryLabel;
import com.widoczka.wodiczkapp.model.Record;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryLabel, Integer> {
}
