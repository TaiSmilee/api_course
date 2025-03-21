package com.example.course.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private final Integer errorCode;
    private final String errorMessage;
}
