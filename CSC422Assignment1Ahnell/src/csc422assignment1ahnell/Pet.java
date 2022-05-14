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

import java.util.Objects;

/**
 *
 * @author lisaahnell
 */
public class Pet {
    private String name;
    private int age;

    /**
     * Constructor for Pet class. Create instance of Pet with given name and age.
     * @param name
     * @param age 
     */
    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
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
