package edu.pcc.cis233j.countries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read data from the Countries database
 * @author Jacob Perrine & Cara Tang
 * @version 2017.07.31
 *
 * @modifications
 * - Changed name of readCountries() to readCountriesBasic().
 * - Added a new readCountries() method to use readCountriesBasic() as well as
 * to query country languages.
 * - Created readLanguages() to query the DB for each country's language(s).
 * - Added a constant,GET_LANGUAGES_SQL, to hold the SQL query for readLanguages().
 *       (then got thoroughly stuck)
 */
public class CountryDB {
	private static final String DB_NAME = "Countries";
	private static final String DB_URL = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/" + DB_NAME;
	private static final String USERNAME = "233jstudent";
	private static final String PASSWORD = "tnedutsj332";
	private static final String GET_COUNTRIES_SQL = "SELECT * FROM COUNTRY";
	private static final String GET_LANGUAGES_SQL = "SELECT Language FROM COUNTRY_LANGUAGE WHERE " +
													"CountryId = ?"; // I really don't understand why this isn't working

	private List<Country> countries;

	/**
	 * Create a CountryDB object
	 * Read from the Countries database and populate the countries list
	 */
	public CountryDB() {
		countries = readCountries();
	}

	/**
	 * Create and return a connection to the database
	 * @return connection to the countries database
	 */
	private Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		return connection;
	}

	/**
	 * Read a list of countries from the CIS Country database, including basic and language info
	 * @return The list of countries with their info
	 */
	public List<Country> readCountries() {
		List<Country> countries = readCountriesBasic();
		//readLanguages(countries); disabling my SQL addition, since it doesn't work
		return countries;
	}

	/**
	 * Read country languages from the COUNTRY_LANGUAGE table and append them to basic country info.
	 * If an error occurs, a stack trace is printed to standard error and an empty list is returned.
	 * @param countries A list of countries with their basic info
	 * @return the list of country info including languages
	 */
	private void readLanguages(List<Country> countries) {
		try (
				Connection connection = getConnection();
				PreparedStatement stmt = connection.prepareStatement(GET_LANGUAGES_SQL);
				) {
			for (Country country: countries) {
				stmt.setInt(1, country.getId());
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					country.addLanguage(rs.getString("CountryId"));
				}
			}
		}
		catch (SQLException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Read country info from the Country table.
	 * If an error occurs, a stack trace is printed to standard error and an empty list is returned.
	 * @return the list of countries read
	 */
	private List<Country> readCountriesBasic() {
		List<Country> countries = new ArrayList<>();
		try (
				Connection connection = getConnection();
				PreparedStatement stmt = connection.prepareStatement(GET_COUNTRIES_SQL);
				ResultSet rs = stmt.executeQuery()
				) {
			while (rs.next()) {
				countries.add(new Country(rs.getInt("Id"),
						rs.getString("Name"),
						rs.getLong("Population"),
						rs.getDouble("MedianAge")));
			}
		}
		catch (SQLException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		return countries;
	}

	/**
	 * @return list of countries read from the country database
	 */
	public List<Country> getCountries() {
		return countries;
	}
}
