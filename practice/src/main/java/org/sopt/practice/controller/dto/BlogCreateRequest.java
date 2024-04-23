package org.sopt.practice.controller.dto;

public record BlogCreateRequest(
        String title,
        String description
) {
}
