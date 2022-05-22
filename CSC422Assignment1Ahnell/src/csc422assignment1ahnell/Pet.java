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
 * 5/20/2022: Added error handling.
 */
package csc422assignment1ahnell;

import java.util.Objects;

/**
 *
 * @author lisaahnell
 */
public class Pet {
    private String name;
    private int age;
    private static final int minAge = 1;
    private static final int maxAge = 20;

    /**
     * Constructor for Pet class. Create instance of Pet with given name and age.
     * @param name
     * @param age 
     */
    public Pet(String name, int age) {

        this.name = name;
        //this.age = age;
        this.setAge(age);
        
    }

    /**
     * Return name value of calling Pet object.
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Set name value of calling Pet object to passed String.
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Check if specified value for age is within age limits of Pet
     * @param age
     * @return true if within age range, false if not
     */
    public boolean checkAge(int age) {
        if (Pet.minAge <= age && age <= Pet.maxAge) {
            return true;
        } else {
            System.err.println("Error: " + age + " is not a valid age.");
            return false;
        }
        //return (minAge <= age && age <= maxAge);
    }
    /**
     * Return age value of calling Pet object.
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age value of calling Pet object to passed int value.
     * @param age 
     */
    public void setAge(int age) {

            this.age = age;

    }

    /**
     * Generate hash code based on name and age values of calling Pet object.
     * Default hashCode function from NetBeans.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.age;
        return hash;
    }

    /**
     * Return true if calling Pet equals passed object, false if not equal
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pet other = (Pet) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    /**
     * Return string version of Pet object.
     * @return 
     */
    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", age=" + age + '}';
    }
    
    
}
