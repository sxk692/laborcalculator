//package com.sw.service.rest.validators;
//
//import com.sherwin.exercise.laborcalculator.rest.validators.AcceptedValueValidator;
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = {AcceptedValueValidator.class})
//@Documented
//public @interface AcceptedValue {
//    /**
//     * Default message when validation fails.
//     *
//     * @return default message.
//     */
//    String message() default "Value not accepted";
//
//    /**
//     * returns the groups the constraint belongs to.
//     * @return the groups the constraint belongs to
//     */
//    Class<?>[] groups() default {};
//
//    /**
//     * returns the payload associated to the constraint.
//     * @return the payload associated to the constraint.
//     */
//    Class<? extends Payload>[] payload() default {};
//
//    /**
//     * returns the array of values from which payload needs to be validated from.
//     * @return the array of values from which payload needs to be validated from.
//     */
//    String[] values();
//}