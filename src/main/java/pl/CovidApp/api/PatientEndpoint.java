package pl.CovidApp.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.CovidApp.api.model.NewPatient;
import pl.CovidApp.api.model.Patient;
import pl.CovidApp.api.model.UpdatePatient;
import pl.CovidApp.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientEndpoint {

    private PatientService patientService;

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getOne(@PathVariable Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPatient(@RequestBody NewPatient patient) {
        patientService.registerPatient(patient);
    }

    @PutMapping
    public void updatePatient(@RequestBody UpdatePatient patient) {
        patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
