package pl.CovidApp.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Tworzę swój walidator
@Constraint(validatedBy = VaccineTypeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VaccineType {

    String message() default "Unknown vaccine type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
