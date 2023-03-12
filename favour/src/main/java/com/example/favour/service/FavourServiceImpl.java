package com.example.favour.service;


import com.example.favour.dto.FavourRequest;
import com.example.favour.dto.PaymentRequest;
import com.example.favour.entity.Favour;
import com.example.favour.entity.FavourCategory;
import com.example.favour.repository.FavourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class FavourServiceImpl implements FavourService {

    private final FavourRepository favourRepository;

    private final FavourCategoryServiceImpl favourCategoryService;

    private final WebClient.Builder webClient;

    @Autowired
    public FavourServiceImpl(FavourRepository favourRepository, FavourCategoryServiceImpl favourCategoryService, WebClient.Builder webClient) {
        this.favourRepository = favourRepository;
        this.favourCategoryService = favourCategoryService;
        this.webClient = webClient;
    }

    @Override
    public Favour getById(int id) {

        Favour favour = favourRepository.getById(id);

        return favour;
    }

    @Override
    public String addFavour(FavourRequest favourRequest) {

        Favour favour = new Favour();

        FavourCategory favourCategory = favourCategoryService.getByIdFavourCategory(favourRequest.getFavourCategoryRequest().getId());

        favour.setTitle(favourRequest.getFavour());
        favour.setDescription(favourRequest.getDescription());
        favour.setFavourCategory(favourCategory);

        PaymentRequest paymentRequest = webClient.build().
                post().uri("http://payment-service/api/v1/payment", uriBuilder -> uriBuilder.
                        queryParam("favour", favourRequest.getFavour()).build())
                .retrieve()
                .bodyToMono(PaymentRequest.class).block();

        favourRepository.save(favour);

        return "Favour Created";
    }

    @Override
    public String deleteFavour(int id) {

        favourRepository.deleteById(id);

        return "Favour Deleted";
    }
}
