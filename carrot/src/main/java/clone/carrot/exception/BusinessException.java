package clone.carrot.exception;

import clone.carrot.exception.message.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private ErrorMessage errorMessage;
    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}

