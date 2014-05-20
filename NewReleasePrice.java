package de.bitbizeps.MovieStore;

class NewReleasePrice extends Price {
	int getFrequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2: 1;
	}
	double getCharge(int daysRented){
		return daysRented * 3;
	}
	
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
}
