package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
