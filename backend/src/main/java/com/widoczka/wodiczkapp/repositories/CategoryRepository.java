package com.widoczka.wodiczkapp.repositories;

import com.widoczka.wodiczkapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
