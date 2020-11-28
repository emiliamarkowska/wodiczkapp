package com.wodiczka.wodiczkapp.repositories;

import com.wodiczka.wodiczkapp.model.ActiveCategory;
import com.wodiczka.wodiczkapp.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActiveCategoryRepository extends CrudRepository<ActiveCategory, Integer> {
    @Query(value = "select categories.id, name, rate from active_categories\n" +
            "join categories on categories.id = active_categories.category_id", nativeQuery = true)
    List<Category> getActiveCategories();
}