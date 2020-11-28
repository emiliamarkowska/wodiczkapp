package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.ActiveCategory;
import org.springframework.data.repository.CrudRepository;

public interface ActiveCategoryRepository extends CrudRepository<ActiveCategory, Integer> {
}