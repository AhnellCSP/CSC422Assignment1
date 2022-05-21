/*
 * CSC 422 Software Engineering
 * Concordia University-St Paul
 * Summer 2022
 * Instructor: James Tucker
 *
 * Assignment 1
 * Assignment 2
 * Pet Database
 * Lisa Ahnell
 * ahnelll@csp.edu
 * 05/15/2022
 * Modified:
 * 05/19/2022: Added load from file functionality
 */
package csc422assignment1ahnell;

import java.io.File;
import java.io.IOException;
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


        
        /*
         * Added for Week 2: Load pet data from file. 
         * 
         * Attempt to read data from PetData.txt file.
         * If file does not exist, create file with that name.
         */
        
        String filename = "PetData.txt";
        File file = new File(filename);
        // if the file does not exist, create a new one
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Unable to create new file with name " + filename);
            }
        }
        
        // Testing checks for file
        //System.out.println("Does PetData.txt exist?" + file.exists());
        //System.out.println("Can PetData.txt be read?" + file.canRead());
        //1System.out.println("Can PetData.txt be written?" + file.canWrite());


        // New Pet Database for the program--Changed to read data from file
        PetDatabase myPets = new PetDatabase(file);
        
        // Display menu to user to select pet database options
        boolean useDatabase = true;
        while (useDatabase) {
            displayMenu();
            
            // Take input from user for menu selection
            Scanner input = new Scanner(System.in);
            String menuChoice = input.nextLine();
            String searchTerm;
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
                            if (myPets.addPet(newPet)) {
                                petCount++;
                            }

                        } catch (Exception ex) {
                            System.out.println("\nError: Unable to store this pet Data: " + petInfo);
                            //System.err.println("\nError: Unable to store this pet Data: " + petInfo);

                            break;
                        }
                    }
                    break;
                    
                    // Update function commented out for Week 2 update
                    
//                case "3": // Update existing pet
//                    // Implemented for release 3
//
//                    myPets.showPets();
//                    System.out.print("\nEnter the pet ID to update: ");
//                    searchTerm = input.nextLine();
//                    try {
//                        // ID to search for
//                        int targetID = Integer.parseInt(searchTerm);
//                        String oldName = myPets.findPetById(targetID).getName();
//                        int oldAge = myPets.findPetById(targetID).getAge();
//                        //Pet targetPet = myPets.findPetById(targetID);
//                        
//                        // New name and age
//                        // New Pet info from user input
//                        System.out.print("\nEnter the new name and new age: ");
//
//                        String petInfo = input.nextLine();
//                        
//                        String[] petData = petInfo.split(" ", 2);
//                        try {
//                            myPets.updatePet(targetID, petData[0], Integer.parseInt(petData[1]));
//                        } catch (Exception ex) {
//                            System.out.println("\nUnable to add new information: " + petInfo);
//                            break;
//                        }
//                        
//                        System.out.printf("%s%d%s", oldName + " ", oldAge, " is changed to " + petData[0] + " " + petData[1] + ".\n");
//                       
//                    } catch (Exception ex) {
//                        System.out.println("\nUnable to update pet with ID: " + searchTerm);
//                        break;
//                    }
//                    break;
                    
                // Remove Pet function changed to case 3 for Week 2 update
                case "3": // Remove existing pet
                    // Implemented for release 3

                    myPets.showPets();
                    System.out.print("\nEnter the pet ID to remove: ");
                    searchTerm = input.nextLine();
                    try {
                        // Pet to search for
                        int targetID = Integer.parseInt(searchTerm);
                        Pet targetPet = myPets.findPetById(targetID);
                        myPets.removePet(targetID);
                        System.out.printf("%s%d%s", targetPet.getName() + " ", targetPet.getAge(), " is removed.\n");
                        //break;
                       
                    } catch (Exception ex) {
                        /*
                         * Update for Week 2: ID input must be an index of the array
                         * If user inputs invalid ID value, notify them of error. 
                         * Error message updated to match example.
                         */
                        System.out.println("\nError: ID " + searchTerm + " does not exist.");
                        break;
                    }
                    break;
                    
                // Commented out for Week 2 update    
//                case "5": // Search by name
//                    // Implemented for release 2
//                    System.out.print("\nEnter a name to search: ");
//                    // Name to search for
//                    String targetName = input.nextLine();
//                    try {
//                        PetDatabase nameMatches = myPets.findPetByName(targetName);
//                        nameMatches.showPets();
//                    } catch (Exception ex) {
//                        System.err.println("\nUnable to search for pet name: " + targetName);
//                        break;
//                    }
//                    
//                    break;
//                case "6": // Search by age
//                    // Implemented for release 2
//
//                    System.out.print("\nEnter age to search: ");
//                    searchTerm = input.nextLine();
//                    try {
//                        // Age to search for
//                        int targetAge = Integer.parseInt(searchTerm);
//                        PetDatabase ageMatches = myPets.findPetByAge(targetAge);
//                        ageMatches.showPets();
//
//                    } catch (Exception ex) {
//                        System.out.println("\nUnable to search for pet age: " + searchTerm);
//                        break;
//                    }
//                    
//                    break;
                    
                // Case changed to 4 for Week 2 update    
                case "4": // Exit
                    // Save current pet data to file
                    myPets.savePets(file);
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
        
// Switched numbers for Week 2 update
        System.out.println("3) Remove an existing pet");
        //System.out.println("4) Remove an existing pet");
        //System.out.println("5) Search pets by name");
        //System.out.println("6) Search pets by age");
        //System.out.println("7) Exit program\n");
        
        // Switched numbers for Week 2 update
        System.out.println("4) Exit program\n");
        System.out.print("Your choice: ");
    }
    
}
