//package com.sherwin.exercise.laborcalculator.rest.validators;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import com.sw.service.rest.validators.AcceptedValue;
//
//import java.util.Arrays;
//
//public class AcceptedValueValidator implements ConstraintValidator<AcceptedValue, Integer> {
//
//    private String[] acceptedValues;
//
//    @Override
//    public void initialize(AcceptedValue constraintAnnotation) {
//        this.acceptedValues = constraintAnnotation.values();
//    }
//
//    @Override
//    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
//        if (integer == null) {
//            return true;
//        }
//        return Arrays.asList(acceptedValues).contains(integer);
//    }
//
//
//}
