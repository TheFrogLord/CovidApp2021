package pl.CovidApp.api.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import pl.CovidApp.api.validator.ZipCode;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    @Setter
    private Long id;
    @NotEmpty
    @Length(max = 30)
    private String name;
    @NotEmpty
    private String street;
    @NotEmpty
    @Length(max = 10)
    private String houseNumber;
    @ZipCode//zadanie1
    private String zipCode;
    @NotEmpty
    private String city;
    private String phoneNumber;

    @AssertTrue
    public boolean isPhoneNumberLegit() {
        return phoneNumber.startsWith("+48");
    }

}
