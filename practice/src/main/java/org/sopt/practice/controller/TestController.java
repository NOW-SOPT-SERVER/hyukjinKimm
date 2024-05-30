package org.sopt.practice.controller;

import lombok.AllArgsConstructor;
import org.sopt.practice.auth.redis.domain.Token;
import org.sopt.practice.controller.dto.ApiResponse;
import org.sopt.practice.repository.RedisTokenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {

    private final RedisTokenRepository redisTokenRepository;
    @GetMapping("/test")
    public String test() {
        return "1차 세미나 테스트 API 입니다!";
    }
    @GetMapping("/test/json")
    public ApiResponse testJson() {
        return ApiResponse.create("1차 세미나 테스트 API - JSON");
    }

    @GetMapping("/api/v1/settoken")
    public String redisSetTokenTest() {
        Token token = Token.builder().id(1L).refreshToken("refreshTokentest").build();
        Token token1 = Token.builder().id(2L).refreshToken("refreshTokentesttwo").build();

        redisTokenRepository.save(token);
        redisTokenRepository.save(token1);
        return "레디스 컨트롤러";
    }

    @GetMapping("/api/v1/findtoken")
    public ResponseEntity redisfindTokenTest() {
        Token token1 = redisTokenRepository.findByRefreshToken("refreshTokentest").get();
        Token token2 = redisTokenRepository.findByRefreshToken("refreshTokentest").get();
        return ResponseEntity.status(200).body(token1);
    }

    @GetMapping("/api/v1/deletetoken")
    public ResponseEntity redisdeleteTokenTest() {
        Token token1 = redisTokenRepository.findByRefreshToken("refreshTokentest").get();
        redisTokenRepository.delete(token1);

        return ResponseEntity.status(200).body("삭제완료");
    }

}