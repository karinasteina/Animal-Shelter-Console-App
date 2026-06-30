package org.example.menu;

import org.example.filter.impl.YoungAnimalFilter;
import org.example.model.*;
import org.example.shelter.Shelter;
import org.example.utilities.CollectionUtilities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    private final CollectionUtilities collectionUtilities = new CollectionUtilities();
    private final List<MenuOption> menuOptions = List.of(
            new MenuOption(1, "Add animal"),
            new MenuOption(2, "List all animals"),
            new MenuOption(3, "Find animals by species"),
            new MenuOption(4, "List available animals"),
            new MenuOption(5, "Mark animal as adopted"),
            new MenuOption(6, "Sort animals by age"),
            new MenuOption(7, "Sort animals by name"),
            new MenuOption(8, "Get adoption history"),
            new MenuOption(9, "Filter young animals"),
            new MenuOption(10, "Find oldest animal"),
            new MenuOption(11, "Count by species"),
            new MenuOption(12, "Get average age"),
            new MenuOption(0, "Exit")
    );

    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){
        while (true){
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("What animal do you want to add? Bird, Cat, Dog or Zebra");
                    String animalType = scanner.nextLine().trim().toLowerCase();

                    System.out.println("Enter name: ");
                    String name = scanner.nextLine().trim();

                    System.out.println("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    try{
                        Animal animal = createAnimalHelper(animalType, name, age);

                        if(animal == null){
                            System.out.println("Animal type does not exist");
                            System.out.println("----------------------------");

                            break;
                        }
                        shelter.addAnimal(animal);

                        System.out.println("Animal created successfully!");
                        System.out.println("----------------------------");

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("----------------------------");
                    }

                    break;

                case 2:
                    printHelper(shelter.getAllAnimals());
                    System.out.println("----------------------------");

                    break;

                case 3:
                    System.out.println("What specie are we looking for? Bird, Cat, Dog or Zebra? ");
                    String specie = scanner.nextLine().trim().toLowerCase();

                    try{
                        List<Animal> result = shelter.findBySpecies(specie);

                        if(result.isEmpty()){
                            System.out.println("No animals of that sort were found");
                            System.out.println("----------------------------");

                            break;
                        }

                        printHelper(result);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("----------------------------");
                    }

                    break;

                case 4:
                    List<Animal> result = shelter.findAvailableAnimals();

                    if(result.isEmpty()){
                        System.out.println("No available animals were found");
                        System.out.println("----------------------------");
                        break;
                    }

                    printHelper(result);
                    System.out.println("----------------------------");

                    break;

                case 5:
                    System.out.println("Please enter animalId that got adopted: ");
                    String id = scanner.nextLine().trim();

                    System.out.println("Please enter adopter's name: ");
                    String adoptersName = scanner.nextLine().trim();

                    try{
                        shelter.markAsAdopted(id, adoptersName);
                        System.out.println("Animal successfully adopted!");
                        System.out.println("----------------------------");

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("----------------------------");
                    }

                    break;

                case 6:
                    printHelper(sortByAge(shelter.getAllAnimals()));
                    System.out.println("----------------------------");

                    break;
                case 7:
                    printHelper(sortByName(shelter.getAllAnimals()));
                    System.out.println("----------------------------");

                    break;
                case 8:
                    List<AdoptionHistory> adoptionHistories = shelter.getAdoptionHistory();

                    if(adoptionHistories.isEmpty()){
                        System.out.println("No histories found");
                        break;
                    }

                    printHelper(adoptionHistories);
                    System.out.println("----------------------------");

                    break;
                case 9:
                    printHelper(collectionUtilities.find(shelter.getAllAnimals(), new YoungAnimalFilter()));
                    System.out.println("----------------------------");

                    break;
                case 10:
                    System.out.println("Oldest animal is: " + collectionUtilities.findOldest(shelter.getAllAnimals()));
                    System.out.println("----------------------------");

                    break;
                case 11:
                    System.out.println("Count by species: " + collectionUtilities.countBySpecies(shelter.getAllAnimals()));
                    System.out.println("----------------------------");

                    break;
                case 12:
                    System.out.println("Average age: " + collectionUtilities.getAgeAvg(shelter.getAllAnimals()));
                    System.out.println("----------------------------");

                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrect input try again!");
                    System.out.println("----------------------------");
            }

        }
    }

    private void printMenu(){
      for (MenuOption option : menuOptions){
          System.out.println(option.number() + ". " + option.label());
      }
    }

    private Animal createAnimalHelper(String choice, String name, int age) throws Exception{
        if(choice == null || name == null || name.isBlank() || age < 0){
            throw new Exception("Incorrect params");
        }

        switch (choice.toLowerCase()){
            case "bird":
                return new Bird(name, age);
            case "cat":
                return new Cat(name, age);
            case "dog":
                return new Dog(name, age);
            case "zebra":
                return new Zebra(name, age);
            default:
                return null;
        }

    }

    private void printHelper(List<?> list){
        for (Object element: list) {
            System.out.println(element);
        }
    }

    private List<Animal> sortByAge(List<Animal> animals){
        return animals.stream().sorted(Comparator.comparing(Animal::getAge)).toList();
    }

    private List<Animal> sortByName(List<Animal> animals){
        return animals.stream().sorted(Comparator.comparing(Animal::getName)).toList();
    }
}
