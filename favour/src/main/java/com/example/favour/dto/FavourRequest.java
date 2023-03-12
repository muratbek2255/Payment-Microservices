package com.example.favour.dto;


import com.example.favour.entity.FavourCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class FavourRequest {

    private String favour;

    private String description;

    private FavourCategory favourCategoryRequest;
}
