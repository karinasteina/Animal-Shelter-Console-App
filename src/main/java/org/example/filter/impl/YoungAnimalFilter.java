package org.example.filter.impl;

import org.example.filter.FilterCriteria;
import org.example.model.Animal;

// Now I can make different types of criterias also for different type of objects
public class YoungAnimalFilter implements FilterCriteria<Animal> {

    // future improvement - not a hardcoded value for the age
    @Override
    public boolean matches(Animal animal) {
       return animal.getAge() < 5;
    }
}
