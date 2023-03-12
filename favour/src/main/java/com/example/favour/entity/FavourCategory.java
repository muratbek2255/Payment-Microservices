package com.example.favour.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "favour_categories")
public class FavourCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String title;

    @OneToMany(mappedBy = "parent")
    private List<FavourCategory> childs;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private FavourCategory parent;
}
