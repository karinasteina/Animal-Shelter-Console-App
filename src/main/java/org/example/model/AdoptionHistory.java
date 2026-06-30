package org.example.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdoptionHistory {

    private Animal animal;
    private LocalDate adoptionDate;
    private String adopterName;

    @Override
    public String toString(){
        return "Animal name: " + animal.getName() + " | Adopter's name: " + adopterName
                + " | Adoption date: " + adoptionDate.getDayOfMonth() + " "
                + adoptionDate.getMonth() + " " + adoptionDate.getYear();
    }
}
