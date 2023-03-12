package com.example.favour.service;

import com.example.favour.dto.FavourCategoryRequest;
import com.example.favour.entity.FavourCategory;


public interface FavourCategoryService {

    public FavourCategory getByIdFavourCategory(int id);

    public String addFavourCategory(FavourCategoryRequest favourCategoryRequest);

    public String deleteFavourCategory(int id);
}
