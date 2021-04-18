package pl.CovidApp.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.CovidApp.api.model.*;
import pl.CovidApp.service.FacilityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facility")
@AllArgsConstructor
public class FacilityEndpoint {

    private final FacilityService facilityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //@valid sprawdza czy spełnione są warunki, które określiłem w FacilityEntity
    public void create(@Valid @RequestBody Facility facility) {
        facilityService.create(facility);
    }

    @PutMapping
    public void update(@Valid @RequestBody Facility facility) {
        facilityService.update(facility);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facilityService.remove(id);
    }

    @GetMapping
    public List<Facility> getAll() {
        return facilityService.getAll();
    }

    @PostMapping("/search")
    public List<Facility> searchByParams(@RequestBody FacilitySearchParams searchParams) {
        return facilityService.findByParams(searchParams);
    }
}
