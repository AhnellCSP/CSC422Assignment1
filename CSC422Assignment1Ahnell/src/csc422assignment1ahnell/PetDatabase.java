/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
