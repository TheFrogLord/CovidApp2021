package pl.CovidApp.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.CovidApp.api.validator.VaccineType;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewVaccination {

    private Long patientId;
    private String address;
    //Sprawdzam po stworzonej przez siebie walidacji
    @VaccineType
    private String vacType;
    private LocalDate date;


}
