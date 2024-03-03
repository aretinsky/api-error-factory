package org.aretinsky.lib.apierrorfactory.example.api;

import java.util.Objects;
import java.util.Set;

public class PetClinic {

    private Long id;
    private String name;
    private Set<Pet> pets;

    public PetClinic(Long id, String name, Set<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public static class Pet {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Pet(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PetClinic petClinic = (PetClinic) object;
        return Objects.equals(id, petClinic.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
