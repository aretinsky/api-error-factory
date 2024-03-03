package org.aretinsky.lib.apierrorfactory.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class PetRestController {

    private final PetClinicService petClinicService;

    public PetRestController(PetClinicService petClinicService) {
        this.petClinicService = petClinicService;
    }

    @GetMapping("/{id}")
    public ShowPetClinicResponse showPetClinic(@PathVariable("id") long id) {
        PetClinic petClinic = petClinicService.retrieveById(id);
        return new ShowPetClinicResponse(
                petClinic.getId(),
                petClinic.getName(),
                petClinic.getPets().stream().map(
                        pet -> new ShowPetClinicResponse.Pet(
                                pet.getId(), pet.getName()
                        )
                ).collect(Collectors.toSet())
        );
    }
}
