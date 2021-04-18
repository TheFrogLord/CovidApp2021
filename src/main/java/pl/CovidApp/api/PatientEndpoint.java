package pl.CovidApp.api;

import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.CovidApp.api.model.Errors;
import pl.CovidApp.api.model.NewPatient;
import pl.CovidApp.api.model.Patient;
import pl.CovidApp.api.model.UpdatePatient;
import pl.CovidApp.service.PatientService;

import javax.validation.Valid;
import java.util.List;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity registerPatient(@Valid @RequestBody NewPatient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorsMsgs = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            Errors errors = Errors.builder().errors(errorsMsgs).build();

            return ResponseEntity.status(400).body(errors);
        } else {
            patientService.registerPatient(patient);
            return ResponseEntity.status(201).build();
        }
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
