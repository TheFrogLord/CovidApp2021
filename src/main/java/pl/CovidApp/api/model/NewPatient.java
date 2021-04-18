package pl.CovidApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.CovidApp.api.validator.BirthDateAndPesel;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@BirthDateAndPesel //daje walidacje w tym miejscu bo tyczy sie porównania daty urodzenia z peselem
public class NewPatient {

    @NotNull(message = "First name must not be null")
    private String firstName;
    @NotNull(message = "Last name must not be null")
    private String lastName;
    private LocalDate birthDate;
    @PESEL (message = "Invalid pesel")
    private String pesel;

    @AssertTrue
    public boolean isBirthDateInPast() {
        return birthDate.isBefore(LocalDate.now());
    }
}

