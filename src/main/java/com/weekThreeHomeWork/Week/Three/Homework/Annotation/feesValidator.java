package com.weekThreeHomeWork.Week.Three.Homework.Annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class feesValidator implements ConstraintValidator<feesAnnotation, Integer> {

    @Override
    public boolean isValid(Integer inputFees, ConstraintValidatorContext constraintValidatorContext) {
        if(inputFees <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
