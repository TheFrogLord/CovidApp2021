package pl.CovidApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.CovidApp.api.model.NewVaccination;
import pl.CovidApp.repository.PatientEntity;
import pl.CovidApp.repository.PatientRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VaccinationService {

    private PatientRepository patientRepository;

    public void planVaccination(NewVaccination vaccination) {

    }

    public void removePlannedVaccination(Long patientId) {
        Optional<PatientEntity> patient = patientRepository.getById(patientId);

        if (!patient.isPresent()) {
            return;
        }


    }
}
