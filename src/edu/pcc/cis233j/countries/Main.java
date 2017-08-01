package edu.pcc.cis233j.countries;

import java.util.List;

/**
 * Read from the Country database and print data on the countries
 * @author Jacob Perrine
 * @version 2017.07.31
 *
 * @modifications
 * - Changed the country data print statements in main() to iterate over the whole collection.
 */
public class Main {
	public static void main(String[] args) {
		CountryDB cdb = new CountryDB();
		List<Country> countries = cdb.getCountries();

		int counter = 0;
		while(counter <= (countries.size() - 1)) {
			Country country = countries.get(counter);
			System.out.println("Country " + (counter + 1) + ":");
			System.out.println("Name: " + country.getName()
					+ "  Population: " + country.getPopulation()
					+ "  Median Age: " + country.getMedianAge());
			counter++;
		}
	}
}
