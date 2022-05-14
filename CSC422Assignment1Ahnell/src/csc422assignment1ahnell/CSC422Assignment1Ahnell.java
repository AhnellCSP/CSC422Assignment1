/*
 * CSC 422 Software Engineering
 * Concordia University-St Paul
 * Summer 2022
 * Instructor: James Tucker
 *
 * Assignment 1
 * Pet Database
 * Lisa Ahnell
 * ahnelll@csp.edu
 * 05/15/2022
 */
package csc422assignment1ahnell;

import java.util.Scanner;

/**
 *
 * @author lisaahnell
 */
public class CSC422Assignment1Ahnell {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Statement of authorship
        System.out.println("Submitted by Lisa Ahnell - ahnelll@csp.edu\n"
                + "I certify that this is my own work\n\n");

        // New Pet Database for the program
        PetDatabase myPets = new PetDatabase();
        
        // Sample Pet data, hard coded for simplicity
        myPets.addPet(new Pet("Piggles", 4));
        myPets.addPet(new Pet("Socrates", 12));
        myPets.addPet(new Pet("Jake", 4));
        myPets.addPet(new Pet("Bonnie", 12));
        myPets.addPet(new Pet("Bonnie", 3));
        myPets.addPet(new Pet("Saul", 18));
        myPets.addPet(new Pet("Pasha", 1));


        // Display menu to user to select pet database options
        boolean useDatabase = true;
        while (useDatabase) {
            displayMenu();
            
            // Take input from user for menu selection
            Scanner input = new Scanner(System.in);
            String menuChoice = input.nextLine();
            
            // Direct program according to menuChoice
            switch (menuChoice) {
                case "1": // View all pets
                    // Implemented for release 1
                    System.out.println();
                    myPets.showPets();
                    System.out.println();
                    break;
                case "2": // Add more pets to database
                    // Implemented for release 1
                    boolean addPets = true;
                    int petCount = 0;
                    while(addPets){
                        System.out.print("add pet (name, age): ");
                        // New Pet info from user input
                        String petInfo = input.nextLine();
                        // Check to see if user has entered done
                        if (petInfo.equalsIgnoreCase("done")) {
                            // finished adding pets
                            System.out.printf("%d%s", petCount, " pets added\n");
                            addPets = false;
                            break;
                        }
                        // Divide user input into tokens
                        String[] petData = petInfo.split(" ", 2);
                        // try to create new Pet from tokens
                        try {
                            Pet newPet = new Pet(petData[0], Integer.parseInt(petData[1]));
                            myPets.addPet(newPet);
                            petCount++;
                        } catch (Exception ex) {
                            System.err.println("\nUnable to store this pet Data: " + petData.toString());
                            break;
                        }
                    }
                    break;
                case "3": // Update existing pet
                    break;
                case "4": // Remove existing pet
                    break;
                case "5": // Search by name
                    // Implemented for release 2
                    System.out.print("\nEnter a name to search: ");
                    // Name to search for
                    String targetName = input.nextLine();
                    try {
                        PetDatabase nameMatches = myPets.findPetByName(targetName);
                        nameMatches.showPets();
                    } catch (Exception ex) {
                        System.err.println("\nUnable to search for pet name: " + targetName);
                        break;
                    }
                    
                    break;
                case "6": // Search by age
                    // Implemented for release 2

                    System.out.print("\nEnter age to search: ");
                    String searchTerm = input.nextLine();
                    try {
                        // Age to search for
                        int targetAge = Integer.parseInt(searchTerm);
                        PetDatabase ageMatches = myPets.findPetByAge(targetAge);
                        ageMatches.showPets();

                    } catch (Exception ex) {
                        System.err.println("\nUnable to search for pet age: " + searchTerm);
                        break;
                    }
                    
                    break;
                case "7": // Exit
                    // Implemented for release 1
                    System.out.println("\nThank you for using the Pet Database! \n");
                    useDatabase = false;
                    break;
                default: // unuseable menu choice
                    // Implemented for release 1
                    System.out.println("Invalid menu choice. Please select a number from the list.\n");
                    break;
            }
                        
            
        }
    }
    
    public static void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) View all pets");
        System.out.println("2) Add more pets");
        //System.out.println("3) Update an existing pet");
        //System.out.println("4) Remove an existing pet");
        System.out.println("5) Search pets by name");
        System.out.println("6) Search pets by age");
        System.out.println("7) Exit program\n");
        System.out.print("Your choice: ");
    }
    
}
