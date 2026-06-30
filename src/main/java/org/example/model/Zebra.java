package org.example.model;

public final class Zebra extends Animal {
    public Zebra(AnimalId id, String name, int age){
        super(id,name,age);
    }

    public Zebra(String name, int age){
        this(new AnimalId(), name, age);
    }

    @Override
    public String getSpecies() {
        return "Zebra";
    }
}
