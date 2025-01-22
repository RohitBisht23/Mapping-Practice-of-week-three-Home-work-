package com.weekThreeHomeWork.Week.Three.Homework.Annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {feesValidator.class}
)
public @interface feesAnnotation {

    String message() default "{jakarta.validation.constraints.PositiveOrZero.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
