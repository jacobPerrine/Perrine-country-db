package edu.pcc.cis233j.countries;

import java.util.ArrayList;

/**
 * A country in the world
 * @author Jacob Perrine & Cara Tang
 * @version 2017.07.31
 *
 * @modifications
 * - Added ArrayList<String> language as a field. Included the import statement.
 * - Initialized language as a null list in the class constructor.
 * - Created addLanguage() to add languages to the language ArrayList.
 * - Added a getter, getLanguage(), to access a country's language(s).
 */
public class Country {
	private int id;
	private String name;
	private long population;
	private double medianAge;
	private ArrayList<String> language;
	
	/**
	 * Create a Country object with the given properties
	 */
	public Country(int id, String name, long population, double medianAge) {
		this.id = id;
		this.name = name;
		this.population = population;
		this.medianAge = medianAge;
		this.language = new ArrayList<>();
	}

	/**
	 * Add a language to a country
	 * @param language The language to be added
	 */
	public void addLanguage(String language) {
		this.language.add(language);
	}

	/**
	 * @return a list of the languages spoken in a country, or NULL if none
	 * have been assigned.
	 */
	public ArrayList<String> getLanguage() {
		return language;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPopulation() {
		return population;
	}

	public double getMedianAge() {
		return medianAge;
	}
}
