package org.sopt.practice.controller.dto;

import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        @Size(max = 30 , message = "게시글 제목이 최대 글자 수(30자)를 초과했습니다.")
        String title,
        @Size(max = 1000 , message = "게시글 내용이 최대 글자 수(1000자)를 초과했습니다.")
        String content
) {
}
