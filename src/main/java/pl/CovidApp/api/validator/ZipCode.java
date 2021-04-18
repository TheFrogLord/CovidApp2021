package pl.CovidApp.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//zadanie1
@Constraint(validatedBy = ZipCodeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {

    String message() default "Invalid zipCode format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
