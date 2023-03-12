package com.example.favour.repository;


import com.example.favour.entity.Favour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FavourRepository extends JpaRepository<Favour, Integer> {

    @Query(value = "SELECT * FROM favours WHERE favours.id = ?1", nativeQuery = true)
    Favour getById(@Param("id") int id);

}
