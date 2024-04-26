package org.sopt.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.controller.dto.BlogCreateRequest;
import org.sopt.practice.controller.dto.PostCreateRequest;
import org.sopt.practice.controller.dto.SuccessMessage;
import org.sopt.practice.controller.dto.SuccessStatusResponse;
import org.sopt.practice.service.PostService;
import org.sopt.practice.service.dto.MemberFindDto;
import org.sopt.practice.service.dto.PostFindDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostFindDto> findMemberById(@PathVariable("postId") Long postId){
        return ResponseEntity.ok(postService.findPostById(postId));
    }
    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader(value = "blogId") Long blogId,
            @RequestHeader(value = "memberId") Long memebrId,
            @Valid @RequestBody PostCreateRequest postCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).header(
                        "Location",
                        postService.create(memebrId, blogId, postCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREATE_SUCCESS));
    }


}
