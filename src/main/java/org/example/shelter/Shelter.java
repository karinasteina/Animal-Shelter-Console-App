package org.example.shelter;

import org.example.model.AdoptionHistory;
import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();
    private final List<AdoptionHistory> adoptionHistories = new ArrayList<>();

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        return new ArrayList<>(animals);
    }

    public List<T> findBySpecies(String species) throws Exception{
        if(species == null || species.isBlank()){
            throw new Exception("Incorrect params");
        }

        List<T> results = new ArrayList<>();

        for(T animal : animals){
            if(animal.getSpecies().toLowerCase().equals(species)){
                results.add(animal);
            }
        }

        return results;
    }

    public List<T> findAvailableAnimals(){
        List<T> results = new ArrayList<>();

        for (T animal : animals) {
            if (animal.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE)) {
                results.add(animal);
            }
        }

        return results;
    }

    public void markAsAdopted(String id, String adoptersName) throws Exception{
        if(id == null || adoptersName == null || adoptersName.isBlank()){
            throw new Exception("Incorrect params");
        }

        for(T animal: animals){
            if(animal.getId().toString().equals(id)){
                animal.markAsAdopted();
                adoptionHistories.add(new AdoptionHistory(animal, LocalDate.now(), adoptersName));
            }
        }
    }

    public List<AdoptionHistory> getAdoptionHistory(){
        return new ArrayList<>(adoptionHistories);
    }
}
