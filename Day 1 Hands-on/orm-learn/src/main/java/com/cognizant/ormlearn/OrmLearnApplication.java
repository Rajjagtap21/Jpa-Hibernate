package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.Service.CountryService;
import com.cognizant.ormlearn.Service.Exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);

		LOGGER.info("main method starts");
		testGetAllCountries();
		testAddCountry();
		testFindCountryByCode();
		testDeleteCountry();
		testUpdateCountry();
		testSearchCountryName();
		testFindByNameContaining();
		//testFindByNameStartingWith();
		LOGGER.info("main method ends");
	}

	private static void testGetAllCountries() {

		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");

	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country c = new Country();
		c.setCode("NC");
		c.setName("NewCountry");
		countryService.addCountry(c);
		countryService.findCountryByCode("NC");
		LOGGER.info("End");

	}

	private static void testFindCountryByCode() throws CountryNotFoundException {

		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("NC");
		LOGGER.info("End");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start");
		countryService.updateCountry("IN", "Bhaarat");
		LOGGER.info("End");
	}

	private static void testSearchCountryName() {
		countryService.SearchCountry("In");
	}

	public static void testFindByNameContaining() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameContaining("in");
		for (Country c : countries) {
			System.out.println(c.getCode() + "  " + c.getName());
		}
		LOGGER.info("End");
	}

	public static void testFindByNameStartingWith() {
		List<Country> countries = countryService.findByNameStartingWith("I");
		for (Country c : countries) {
			System.out.println(c.getCode() + "  " + c.getName());
		}
	}

}
