package pl.CovidApp.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

//zadanie1
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    private static String ZIP_CODE_REGEX = "[0-9]{2}[\\-]{1}[0-9]{3}"; //warto się tego nauczyć

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern zipCodePattern = Pattern.compile(ZIP_CODE_REGEX);

        return zipCodePattern.matcher(value).matches();
    }
}
