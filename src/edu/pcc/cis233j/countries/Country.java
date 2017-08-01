package edu.pcc.cis233j.countries;

/**
 * A country in the world
 * @author Your Name & Cara Tang
 */
public class Country {
	private int id;
	private String name;
	private long population;
	private double medianAge;
	
	/**
	 * Create a Country object with the given properties
	 */
	public Country(int id, String name, long population, double medianAge) {
		this.id = id;
		this.name = name;
		this.population = population;
		this.medianAge = medianAge;
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
