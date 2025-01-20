package com.weekThreeHomeWork.Week.Three.Homework.Advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    //@JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this(); //calling default constructor
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this(); //calling default constructor
        this.error = error;
    }
}
