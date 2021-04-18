package pl.CovidApp.api.model;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Facility {

    private Long id;
    private String name;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String phoneNumber;

}
