/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc422assignment1ahnell;

import java.lang.reflect.Array;
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

        // Display menu to user to select pet database options
        boolean useDatabase = true;
        while (useDatabase) {
            displayMenu();
            
            // Take input from user for menu selection
            Scanner input = new Scanner(System.in);
            String menuChoice = input.nextLine();
            // Strings for search terms to come later
            
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
                            System.err.println("Unable to store this pet Data: " + petData.toString());
                            return;
                        }
                    }
                    break;
                case "3": // Update existing pet
                    break;
                case "4": // Remove existing pet
                    break;
                case "5": // Search by name
                    break;
                case "6": // Search by age
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
        //System.out.println("5) Search pets by name");
        //System.out.println("6) Search pets by age");
        System.out.println("7) Exit program\n");
        System.out.print("Your choice: ");
    }
    
}
