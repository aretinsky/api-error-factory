package org.aretinsky.lib.apierrorfactory.example.api;

import java.util.Objects;
import java.util.Set;

public record ShowPetClinicResponse(
        long clinicId,
        String clinicName,
        Set<Pet> pets
) {

    public ShowPetClinicResponse(long clinicId, String clinicName, Set<Pet> pets) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.pets = pets;
    }

    public record Pet(
            long id,
            String name
    ) {

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Pet pet = (Pet) object;
            return id == pet.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
