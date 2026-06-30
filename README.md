# Practical Task: Animal Shelter Console App

Starter project for M3A practical task: Create a simple Java console application for managing animals in an animal shelter.

## Task
Complete all of the 'TODO' portions of the code. Finished application should support:
- Adding a new animal - DONE
- Listing all animals - DONE
- Searching animals by species - DONE
- Marking an animal as adopted - DONE
- Displaying only available animals - DONE

## OOP Requirements
- Class anatomy: fields, constructors, methods - DONE
- Object instantiation and usage - DONE
- Constructor overloading - DONE
- Immutable class usage (AnimalId) - DONE
- Lombok usage for reducing boilerplate - DONE
- A basic sealed class hierarchy - DONE
- Generic (Shelter<T>) class that stores animals - DONE

## Project Structure
``` text
src
├── Main.java
├── menu/
│   └── ConsoleMenu.java
│   └── MenuOption.java
├── model/
│   ├── Animal.java
│   ├── Dog.java
│   ├── Cat.java
│   ├── Bird.java
│   ├── AnimalId.java
│   └── AdoptionStatus.java
└── shelter/
    └── Shelter.java
```
## Stretch goals
- Add a new animal type without modifying existing functionality
- Allow sorting animals by age or name - DONE
- Validate user input (no empty names, age cannot be negative etc.) - DONE
- Create a generic utility class for searching and filtering collections (Average animal age, Oldest animal, Number of animals of each species etc.)
- Add adoption history that tracks: - DONE
    - Animal
    - Adoption Date
    - Adopter Name
