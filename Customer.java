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
    	double totalAmount = 0;
    	int frequentRenterPoints = 0;
    	Enumeration rentals = this.rentals.elements();
    	String result = "Rental Record for " + getName() + "\n";
    	while (rentals.hasMoreElements()) {
	    	Rental each = (Rental) rentals.nextElement();
	    	//Extracted the method, moving it to the correct class Rental
	    	frequentRenterPoints += each.getFrequentRenterPoints();
	    	result +=	"\t" + each.getMovie().getTitle()+ "\t" +
	    				String.valueOf(each.getCharge()) + "\n";
	    	totalAmount += each.getCharge();
    	}
    	result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    	result += "You earned " + String.valueOf(frequentRenterPoints)
    	+ " frequent renter points";
    	return result;
   	}
    
    private double amountFor(Rental aRental) {
    	return aRental.getCharge();
    }
}
    