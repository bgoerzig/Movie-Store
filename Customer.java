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
	    	thisAmount = amountFor(each);
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
    
    /*Separated switch-statement, new function that consumes Rental instance 
    and returns the new amount*/
    private double amountFor(Rental each) {
    	double thisAmount = 0;
    	switch (each.getMovie().getPriceCode()) {
	    	case Movie.REGULAR:
	    		thisAmount += 2;
	    		if (each.getDaysRented() > 2)
	    			thisAmount += (each.getDaysRented() - 2) * 1.5;
	    		break;
	    	case Movie.NEW_RELEASE:
	    		thisAmount += each.getDaysRented() * 3;
	    		break;
	    	case Movie.CHILDRENS:
	    		thisAmount += 1.5;
	    		if (each.getDaysRented() > 3)
	    			thisAmount += (each.getDaysRented() - 3) * 1.5;
    		break;
    	}
    	return thisAmount;
    }
}
    