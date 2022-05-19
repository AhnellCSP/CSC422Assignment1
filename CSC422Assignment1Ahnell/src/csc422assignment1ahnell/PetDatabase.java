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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public PetDatabase(File file) {
        try {
            this.pets = loadPets(file);

        } catch (Exception ex) {
            System.out.println("Problem loading pets from file.");
        }
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
    
    public Pet findPetById(int id) {
        try {
            return this.pets.get(id);
        } catch (Exception ex) {
            //System.err.println("\nUnable to find pet with ID: " + id);
            return null;
        }     
    }
    
    /**
     * Remove pet with id(index) specified.
     * @param id 
     */
    public void removePet(int id) {
        try {
            if (0 <= id && id<= this.pets.size()) {
                // id is within bounds
                this.pets.remove(id);
            }
        } catch (Exception ex) {
            //System.err.println("\nUnable to remove pet with id: " + id);
        }
    }
    
    public Pet updatePet(int id, String name, int age) {
        try {
            if (0 <= id && id<= this.pets.size()) {
                Pet oldPetData = this.pets.get(id);
                // id is within bounds
                this.pets.get(id).setName(name);
                this.pets.get(id).setAge(age);
                
                return oldPetData;
            }    
        } catch (Exception ex) {
            //System.err.println("\nUnable to update pet with id: " + id);
            
        }
        return null;
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
        System.out.printf("%s%-3s%s%-10s%s%-3s%s", "| ", "ID", "| ", "NAME", "| ", "AGE", " |");
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
            System.out.printf("%s%3d%s%-10s%s%4d%s", "|", id, " | ", name, "|", age, " |");
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
        for (int i = 0; i <= width; i++) {
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();
    }
    
    /*
     * Method for reading file, processing lines from file into Pet
     * Pet name is a string, pet age is an int. 
     * Delimiter in file is "|".
     *
     * @param file - File object to read Pets from
     *
     * @return - ArrayList of Pets read from each line of the file
     *
     * @throws Exception - if the Scanner is not able to read the File
     */
    private static List<Pet> loadPets(File file) throws Exception {

        List<Pet> pets = new ArrayList<>();
        try (Scanner input = new Scanner(file)) {
           
            while (input.hasNext()) {
                // Process lines from the file into two data point, create new
                // Band object with those values, add to bands
                // Each line of file has band name | set time
                String currentLine = input.nextLine();
                String[] currentProperties = currentLine.split("\\|");

                // Create a Band with currentProperties[0] as bandName and
                // currentProperties[1] as setTime
                if (currentProperties.length == 2) {
                    Pet newPet = new Pet(currentProperties[0], Integer.parseInt(currentProperties[1]));
                    pets.add(newPet);
                }

            }
            input.close();
        } catch (java.io.IOException ex) {
            // Cannot load given file, report error
            System.out.println("I/0 errors: no such file");
            
        }
        return pets;
    }
    
    private void savePets(File file) {
        PrintWriter output = null;
        try {
            if (file.exists()) {
                System.out.println("Current pet data will be overwritten");
            }   
            output = new PrintWriter(file);
            // Write all Pets in PetDatabase to file
            for(Pet p: pets) {
                // Add name to file
                output.print(p.getName());
                // Add delimiter
                output.print("|");
                // Add age to file, end of line of pet data
                output.println(p.getAge());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, unable to save Pet data.");
        } finally {
            output.close();
        }
        
    }
    
}
