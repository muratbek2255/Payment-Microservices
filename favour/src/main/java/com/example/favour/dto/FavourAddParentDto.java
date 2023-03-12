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
public class FavourAddParentDto {

    private FavourCategory favourCategory;
}
