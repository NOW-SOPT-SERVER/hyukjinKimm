package clone.carrot.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND_BY_ID_EXCEPTION(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    CITY_NOT_FOUND_BY_NAME_EXCEPTION(HttpStatus.NOT_FOUND.value(), "해당 도시명이 존재하지 않습니다."),
    ;
    //BLOG_NOT_FOUND(Http)
    private final int status;
    private final String message;
}
