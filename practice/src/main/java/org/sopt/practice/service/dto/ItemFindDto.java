package org.sopt.practice.service.dto;

import org.sopt.practice.domain.Item;
import org.sopt.practice.domain.Member;
import org.sopt.practice.domain.Part;

public record ItemFindDto(
        String title,
        int price
){
    public static ItemFindDto of(
            Item item
    ) {
        return new ItemFindDto(item.getTitle(), item.getPrice());
    }
}
