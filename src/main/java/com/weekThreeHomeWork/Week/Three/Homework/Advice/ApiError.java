package com.weekThreeHomeWork.Week.Three.Homework.Advice;


import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;
    List<String> subErrors;
}
