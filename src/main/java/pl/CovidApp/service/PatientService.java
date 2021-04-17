package pl.CovidApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.CovidApp.api.model.NewPatient;
import pl.CovidApp.api.model.Patient;
import pl.CovidApp.api.model.UpdatePatient;
import pl.CovidApp.api.model.Vaccination;
import pl.CovidApp.repository.PatientEntity;
import pl.CovidApp.repository.PatientRepository;
import pl.CovidApp.repository.VaccinationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public void registerPatient(NewPatient newPatient) {
        PatientEntity entity = PatientEntity.builder()
                .firstName(newPatient.getFirstName())
                .lastName(newPatient.getLastName())
                .pesel(newPatient.getPesel())
                .vaccinations(new HashSet<>())
                .build();
        patientRepository.create(entity);
    }

    public void updatePatient(UpdatePatient updatePatient) {
        patientRepository.getById(updatePatient.getId())
                .map(pat -> pat.updatePatient(updatePatient.getFirstName(), updatePatient.getLastName()))
                .orElseThrow(() -> new IllegalStateException("Patient doesn't exist"));
    }

    public Patient getPatient(Long id) {
        return patientRepository.getById(id)
                .map(this::mapToPatient)
                .orElseThrow(() -> new IllegalStateException("Patient doesn't exist"));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAll()
                .stream()
                .map(this::mapToPatient)
                .collect(Collectors.toList());
    }

    public void deletePatient(Long id) {
        patientRepository.delete(id);
    }

    private Patient mapToPatient(PatientEntity entity) {
        return Patient.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .pesel(entity.getPesel())
                .plannedVacs(entity.getVaccinations().stream()
                        .filter(vac -> !vac.isDone())
                        .map(vac -> new Vaccination(vac.getDate(), vac.getAddress(), vac.getVacType()))
                        .collect(Collectors.toList()))
                .doneVacs(entity.getVaccinations().stream()
                        .filter(VaccinationEntity::isDone)
                        .map(vac -> new Vaccination(vac.getDate(), vac.getAddress(), vac.getVacType()))
                        .collect(Collectors.toList()))
                .build();
    }
}
