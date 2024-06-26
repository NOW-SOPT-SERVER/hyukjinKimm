package org.sopt.practice.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    POST_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 포스트가 존재하지 않습니다."),
    BLOG_NOT_MATCH_BY_MEMBER_ID_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "잘못된 BLOG IG 입니다."),

    ;
    //BLOG_NOT_FOUND(Http)
    private final int status;
    private final String message;
}
