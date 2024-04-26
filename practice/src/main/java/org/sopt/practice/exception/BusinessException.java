package org.sopt.practice.exception;

import lombok.Getter;
import org.sopt.practice.exception.message.ErrorMessage;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}

