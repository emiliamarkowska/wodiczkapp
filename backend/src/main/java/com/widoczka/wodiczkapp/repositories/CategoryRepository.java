package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.CategoryLabel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryLabel, Integer> {
}
