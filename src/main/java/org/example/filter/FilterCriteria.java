package org.example.filter;

// implementation of some filtering functionality
// it was not asked in the requirements so this is for learning purposes

public interface FilterCriteria<T> {
    boolean matches(T object);
}
