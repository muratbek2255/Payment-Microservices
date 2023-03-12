package com.example.favour.controller;


import com.example.favour.dto.FavourRequest;
import com.example.favour.entity.Favour;
import com.example.favour.service.FavourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/favour")
public class FavourController {

    private final FavourServiceImpl favourService;

    @Autowired
    public FavourController(FavourServiceImpl favourService) {
        this.favourService = favourService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favour> getByIdFavor(@PathVariable int id) {

        return ResponseEntity.status(200).body(favourService.getById(id));

    }

    @PostMapping
    public ResponseEntity<String> createFavor(@RequestBody FavourRequest favourRequest) {

        return ResponseEntity.status(201).body(favourService.addFavour(favourRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delFavor(@PathVariable int id) {

        return ResponseEntity.status(202).body(favourService.deleteFavour(id));

    }
}
