package pl.CovidApp.api.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BirthDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDateAndPesel {

    String message() default "Invalid pesel";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
