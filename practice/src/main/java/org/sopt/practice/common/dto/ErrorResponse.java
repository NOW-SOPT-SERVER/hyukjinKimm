package org.sopt.practice.common.dto;

import org.sopt.practice.exception.message.ErrorMessage;

import javax.swing.plaf.PanelUI;

public record ErrorResponse(
        int status,
        String message
) {
    public static ErrorResponse of(int status, String message) {
        return new ErrorResponse(status, message);
    }

    public static ErrorResponse of(ErrorMessage errorMessage) {
        return new ErrorResponse(errorMessage.getStatus(), errorMessage.getMessage());
    }
}