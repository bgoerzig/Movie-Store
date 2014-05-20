package de.bitbizeps.MovieStore;

import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
 
    public String statement() {
    	Enumeration rentals = this.rentals.elements();
    	String result = "Rental Record for " + getName() + "\n";
    	while (rentals.hasMoreElements()) {
	    	Rental each = (Rental) rentals.nextElement();
	    	//show figures for this rental
	    	result += "\t" + each.getMovie().getTitle()+ "\t" +
	    	String.valueOf(each.getCharge()) + "\n";
    	}
    	//add footer lines
    	result += "Amount owed is " +
    	String.valueOf(getTotalCharge()) + "\n";
    	result += "You earned " +
    	String.valueOf(getTotalFrequentRenterPoints()) +
    	" frequent renter points";
    	return result;
    }

    private int getTotalFrequentRenterPoints(){
    	int result = 0;
    	Enumeration rentals = this.rentals.elements();
    	while (rentals.hasMoreElements()) {
	    	Rental each = (Rental) rentals.nextElement();
	    	result += each.getFrequentRenterPoints();
    	}
    	return result;
    }

    private double getTotalCharge() {
    	double result = 0;
    	Enumeration rentals = this.rentals.elements();
    	while (rentals.hasMoreElements()) {
    	Rental each = (Rental) rentals.nextElement();
    	result += each.getCharge();
    	}
    	return result;
    }
}
    