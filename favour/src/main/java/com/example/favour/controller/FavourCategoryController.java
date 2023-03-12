package com.example.favour.controller;

import com.example.favour.dto.FavourAddParentDto;
import com.example.favour.dto.FavourCategoryRequest;
import com.example.favour.entity.FavourCategory;
import com.example.favour.service.FavourCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/favour-category")
public class FavourCategoryController {

    private final FavourCategoryServiceImpl favourCategoryService;

    @Autowired
    public FavourCategoryController(FavourCategoryServiceImpl favourCategoryService) {
        this.favourCategoryService = favourCategoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavourCategory> getByIdFavourCategory(@PathVariable int id) {

        return ResponseEntity.status(200).body(favourCategoryService.getByIdFavourCategory(id));

    }

    @PostMapping
    public ResponseEntity<String> addFavourCategory(@RequestBody FavourCategoryRequest favourCategoryRequest) {

        return ResponseEntity.status(201).body(favourCategoryService.addFavourCategory(favourCategoryRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFavourCategory(@PathVariable int id) {

        return ResponseEntity.status(202).body(favourCategoryService.deleteFavourCategory(id));

    }

    @PutMapping("/update-favour-category-child/{id}")
    public void updateFavourCategoryChild(@RequestBody FavourAddParentDto favourAddParentDto,
                                          @PathVariable int id) {

        favourCategoryService.updateParentCategory(favourAddParentDto, id);

    }

    @DeleteMapping("/delete-favour-category-child/{id}")
    public void deleteFavourCategoryChild(@PathVariable int id) {
        favourCategoryService.removeParentCategory(id);
    }
}
