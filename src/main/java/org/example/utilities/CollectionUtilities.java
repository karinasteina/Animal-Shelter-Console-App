package org.example.utilities;


import org.example.filter.FilterCriteria;

import java.util.ArrayList;
import java.util.List;

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
}
