package pl.CovidApp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.CovidApp.api.model.NewVaccination;

@RestController
@RequestMapping("/vaccination")
@AllArgsConstructor
public class VaccinationEndpoint {

    @PostMapping
    public void planVaccination(@RequestBody NewVaccination vaccination) {

    }

    @DeleteMapping
    public void removePlannedVaccination(@RequestParam Long patientId) {

    }

}
