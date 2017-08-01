package edu.pcc.cis233j.countries;

import java.util.List;

/**
 * Read from the Country database and print data on the countries
 * @author Your Name
 */
public class Main {
	public static void main(String[] args) {
		CountryDB cdb = new CountryDB();
		List<Country> countries = cdb.getCountries();
		
		Country firstCountry = countries.get(0);
		System.out.println("First country:");
    	System.out.println("Name: " + firstCountry.getName()
				           + "  Population: " + firstCountry.getPopulation()
				           + "  Median Age: " + firstCountry.getMedianAge());
	}
}
