package com.example.favour.repository;


import com.example.favour.entity.FavourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FavourCategoryRepository extends JpaRepository<FavourCategory, Integer> {

    @Query(value = "SELECT * FROM favour_categories WHERE favour_categories.id = ?1", nativeQuery = true)
    FavourCategory getById(@Param("id") int id);

}
