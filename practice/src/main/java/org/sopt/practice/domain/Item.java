package org.sopt.practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity @Getter @NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int price;

    private String description;

    public static Item create(String title, int price, String description) {
        return Item.builder()
                .title(title)
                .price(price)
                .description(description)
                .build();
    }

    @Builder
    private Item(String title, int price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;

    }

}
