package org.example.utilities;

import org.example.filter.FilterCriteria;
import org.example.model.Animal;

import java.util.*;

public final class CollectionUtilities{
    public <T> List<T> find(List<T> objects, FilterCriteria<T> criteria){
        List<T> results = new ArrayList<>();

        for (T obj : objects){
            if(criteria.matches(obj)){
                results.add(obj);
            }
        }

        return results;
    }

    public <T extends Animal> T findOldest(List<T> objects){
        T max = objects.get(0);

        for (T current : objects) {
            if (current.getAge() > max.getAge()) {
                max = current;
            }
        }

        return max;
    }

    public <T extends Animal> Map<String, Integer> countBySpecies(List<T> objects){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();

        for(T obj: objects){
            String species = obj.getSpecies();

            if (counts.containsKey(species)){
                int currentCount = counts.get(species);
                counts.put(species, currentCount + 1);
            }else {
                counts.put(species, 1);
            }

        }

        return counts;
    }

    public <T extends Animal> double getAgeAvg(List<T> objects){
        double result = 0;

        for(T obj: objects){
            result += obj.getAge();

        }

        return result / objects.size();
    }


}
