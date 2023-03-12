package com.example.favour.service;

import com.example.favour.dto.FavourRequest;
import com.example.favour.entity.Favour;

public interface FavourService {

    public Favour getById(int id);

    public String addFavour(FavourRequest favourRequest);

    public String deleteFavour(int id);
}
