package com.cognizant.ormlearn.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.CountryRepository;
import com.cognizant.ormlearn.Service.Exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();

	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);

		if (!result.isPresent()) {
			throw new CountryNotFoundException();
		}
		return result.get();

	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void deleteCountry(String countryCode) {
		countryRepository.deleteById(countryCode);
	}

	@Transactional
	public void updateCountry(String countryCode, String countryName) {

		Optional<Country> country = countryRepository.findById(countryCode);
		Country c1 = country.get();
		c1.setName(countryName);
		countryRepository.save(c1);

	}

	@Transactional
	public List<Country> SearchCountry(String name) {
		return countryRepository.findByNameContainingOrderByNameAsc(name);
	}
	
	@Transactional
	public List<Country> findByNameContaining(String word)
	{
		List<Country> countries =countryRepository.findByNameContainingOrderByNameAsc(word);
		return countries;
	}
	
	@Transactional
	public List<Country> findByNameStartingWith(String letter)
	{
		List<Country> countries =countryRepository.findByNameStartingWith(letter);
		return countries;
	}
}
