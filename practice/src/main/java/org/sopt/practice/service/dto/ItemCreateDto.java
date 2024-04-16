package org.sopt.practice.service.dto;

import org.sopt.practice.domain.Part;

public record ItemCreateDto(
        String title,

        int price,
        String description


) {
}