package org.aretinsky.lib.apierrorfactory.example.api;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PetClinicRepository {

    private final List<PetClinic> petClinics = new ArrayList<>();

    public PetClinicRepository() {
        this.petClinics.addAll(
                List.of(
                        new PetClinic(1L, "Кошачья вип клиника", Set.of(
                                new PetClinic.Pet(
                                        1L,
                                        "кот степан"
                                ))
                        ),
                        new PetClinic(1L, "Клиника123", Set.of(
                                new PetClinic.Pet(2L, "кот шарик"),
                                new PetClinic.Pet(3L, "кот задрот"),
                                new PetClinic.Pet(4L, "котasdqweqwrasdasfasf")
                        ))
                )
        );
    }

    public Optional<PetClinic> findById(long clinicId) {
        return petClinics.stream()
                .filter(petClinic -> petClinic.getId() == clinicId).findFirst();
    }

    public List<PetClinic> findAll() {
        return new ArrayList<>(petClinics);
    }
}
