package org.sopt.practice.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sopt.practice.controller.dto.BlogCreateRequest;
import org.sopt.practice.controller.dto.PostCreateRequest;
import org.sopt.practice.domain.Blog;
import org.sopt.practice.domain.Post;
import org.sopt.practice.domain.Member;
import org.sopt.practice.exception.NotFoundException;
import org.sopt.practice.exception.message.ErrorMessage;
import org.sopt.practice.repository.BlogRepository;
import org.sopt.practice.repository.MemberRepository;
import org.sopt.practice.repository.PostRepository;
import org.sopt.practice.service.dto.MemberFindDto;
import org.sopt.practice.service.dto.PostFindDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final BlogRepository blogRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public PostFindDto findPostById(Long postId){
        return PostFindDto.of(postRepository.findById(postId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.POST_NOT_FOUND_BY_ID_EXCEPTION)
        ));

    }


    @Transactional
    public String create(Long memberId, Long blogId, PostCreateRequest postCreateRequest) {
        //Blog찾기
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND_BY_ID_EXCEPTION)
        );

        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND_BY_ID_EXCEPTION)
        );

        if (blog.getMember().getId() != memberId) {
            throw new NotFoundException(ErrorMessage.BLOG_NOT_MATCH_BY_MEMBER_ID_EXCEPTION);
        }

        Post post = postRepository.save(Post.create(blog, postCreateRequest.title(), postCreateRequest.content()));
        return post.getId().toString();
    }
}


