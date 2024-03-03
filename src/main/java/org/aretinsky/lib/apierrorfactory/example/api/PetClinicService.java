package org.aretinsky.lib.apierrorfactory.example.api;

import org.aretinsky.lib.apierrorfactory.example.app.error.BusinessErrorCode;
import org.aretinsky.lib.apierrorfactory.lib.ErrorFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetClinicService {

    private final PetClinicRepository petClinicRepository;

    public PetClinicService(PetClinicRepository petClinicRepository) {
        this.petClinicRepository = petClinicRepository;
    }


    public PetClinic retrieveById(long clinicId) {
        return petClinicRepository.findById(clinicId).orElseThrow(
                () -> ErrorFactory.exceptionBuilder(
                                BusinessErrorCode.RETRIEVE_CLINIC_BY_ID
                        )
                        .arg("clinicId", clinicId)
                        .message("clinic not found")
                        .build()
        );
    }
}
