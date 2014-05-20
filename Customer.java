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
	    	double thisAmount = 0;
	    	Rental each = (Rental) rentals.nextElement();
	    	/* Extraction of switch-statement to avoid overly long function,
	    	new method amountFor(Rental) implemented */
	    	thisAmount = each.getCharge();
	    	frequentRenterPoints ++;
	    	if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
	    	each.getDaysRented() > 1) frequentRenterPoints ++;
	    	result += "\t" + each.getMovie().getTitle()+ "\t" +
	    	String.valueOf(thisAmount) + "\n";
	    	totalAmount += thisAmount;
    	}
    	//add footer lines
    	result += "Amount owed is " + String.valueOf(totalAmount) +
    	"\n";
    	result += "You earned " + String.valueOf(frequentRenterPoints) +
    	" frequent renter points";
    	return result;
    }
    //delegate to the new method
    private double amountFor(Rental aRental) {
    	return aRental.getCharge();
    }
}
    