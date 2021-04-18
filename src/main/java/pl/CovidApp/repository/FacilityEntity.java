package pl.CovidApp.repository;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FacilityEntity {

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
    @Length(min = 5, max = 6)
    private String zipCode;
    @NotEmpty
    private String city;
    private String phoneNumber;

    @AssertTrue
    public boolean isPhoneNumberLegit() {
        return phoneNumber.startsWith("+48");
    }
}

