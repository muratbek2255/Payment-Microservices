package com.example.favour.service;


import com.example.favour.dto.FavourAddParentDto;
import com.example.favour.dto.FavourCategoryRequest;
import com.example.favour.entity.FavourCategory;
import com.example.favour.repository.FavourCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FavourCategoryServiceImpl implements FavourCategoryService {

    private final FavourCategoryRepository favourCategoryRepository;

    @Autowired
    public FavourCategoryServiceImpl(FavourCategoryRepository favourCategoryRepository) {
        this.favourCategoryRepository = favourCategoryRepository;
    }

    @Override
    public FavourCategory getByIdFavourCategory(int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        return favourCategory;
    }

    @Override
    public String addFavourCategory(FavourCategoryRequest favourCategoryRequest) {

        FavourCategory favourCategory = new FavourCategory();

        favourCategory.setTitle(favourCategoryRequest.getTitle());

        favourCategoryRepository.save(favourCategory);

        return "Favour Category Created";
    }

    @Override
    public String deleteFavourCategory(int id) {

        favourCategoryRepository.deleteById(id);

        return "Favour Category Deleted";
    }

    public void updateParentCategory(FavourAddParentDto favourAddParentDto, int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        FavourCategory favourCategory1 = getByIdFavourCategory(favourAddParentDto.getFavourCategory().getId());

        favourCategory.setParent(favourCategory1);

        favourCategoryRepository.save(favourCategory);
    }

    public void removeParentCategory(int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        favourCategory.setParent(null);

        favourCategoryRepository.save(favourCategory);

    }
}
