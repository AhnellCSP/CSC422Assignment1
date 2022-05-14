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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lisaahnell
 */
public class PetDatabase {
    private List<Pet> pets;

    public PetDatabase() {
        this.pets = new ArrayList<>();
    }
    public PetDatabase(List pets) {
        this.pets = pets;
    }
    
    /**
     * Add pet to petsArrayList. 
     * @param pet 
     */
    public void addPet(Pet pet) {
        this.pets.add(pet);
    }
    
    /**
     * Search PetDatabase for Pets with specified name, return a PetDatabase of matches.
     * Name search term is case insensitive.
     * @param name
     * @return PetDatabase nameMatches
     */
    public PetDatabase findPetByName(String name) {
        // List to hold Pets matching the search term
        PetDatabase nameMatches = new PetDatabase();
        
        // Check for matches in the Pet Database
        for (Pet p: pets) {
            if (p.getName().equalsIgnoreCase(name)) {
                // Match found, add to nameMatches
                nameMatches.addPet(p);
            }
        }
        // Return nameMatches
        return nameMatches;
        
    }
    
    /**
     * Search PetDatabase for Pets with specified age, return a PetDatabase of matches.
     * @param age
     * @return PetDatabase ageMatches
     */
    public PetDatabase findPetByAge(int age) {
        // List to hold Pets matching target age
        PetDatabase ageMatches = new PetDatabase();
        
        // Check for matches in the PetDatabase
        for (Pet p: pets) {
            if(p.getAge() == age) {
                // Match found, add to ageMatches
                ageMatches.addPet(p);
            }
        }
        return ageMatches;
    }
    /**
     * Display contents of PetDatabase in a formatted table.
     */
    public void showPets() {
        // Set width for the table
        int tableWidth = 21;
        // Display table header
        printHeader(tableWidth);
        // Display table rows
        printRows();
        // Display table footer
        printFooter(tableWidth);
    }
    
    private static void printHeader(int width) {
        printDivider(width);
        System.out.printf("%s%-3s%s%-10s%s%-4s%s", "|", "ID", "|", "NAME", "|", "AGE", "|");
        System.out.println();
        printDivider(width);
    }
    
    private void printRows() {
        for (int i = 0; i < this.pets.size(); i++) {
            // Gather the information about each Pet in the database
            int id = i;
            String name = pets.get(i).getName();
            int age = pets.get(i).getAge();
            
            // Display as a table row
            System.out.printf("%s%3d%s%10s%s%4d%s", "|", id, "|", name, "|", age, "|");
            System.out.println();
        }
    
    }
    
    private void printFooter(int width) {
        printDivider(width);
        int numRows = this.pets.size();
        System.out.printf("%d%s", numRows, " rows in set.");
        
    }
    
    private static void printDivider(int width) {
        System.out.print("+");
        for (int i = 0; i < width - 2; i++) {
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();
    }
    
}
