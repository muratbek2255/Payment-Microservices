package com.example.favour.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class FavourCategoryRequest {

    private Integer id;

    private String title;
}
