package com.travel;

import com.travel.entities.*;
import com.travel.repositories.AirportRepository;
import com.travel.repositories.CityRepository;
import com.travel.repositories.ContinentRepository;
import com.travel.repositories.CountryRepository;
import com.travel.services.RoleService;
import com.travel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

// the database of continents countries, cities, airports and hotels should be preconfigured

@SpringBootApplication
public class TravelAgencyApplication implements CommandLineRunner {

	@Autowired
	private ContinentRepository continentRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inserting roles in database");
		Role userRole = new Role();
		userRole.setName(RoleTypes.USER);
		userRole.setDescription("This role is designed for users");

		try {
			roleService.save(userRole);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

		Role userRole1 = new Role();
		userRole1.setName(RoleTypes.USER);
		userRole1.setDescription("Duplicate role");

		try {
			roleService.save(userRole1);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}


		Role adminRole = new Role();
		adminRole.setName(RoleTypes.ADMIN);
		adminRole.setDescription("This role can add hotels and trips");

		try {
			roleService.save(adminRole);
		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}

		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("admin");

		Role adminRoleInDatbase = roleService.findByName(RoleTypes.ADMIN);
		adminUser.setRole(adminRoleInDatbase);

		try {
			userService.save(adminUser);
		} catch (RuntimeException ex) {
			System.out.println("User admin is already in the database");
//		}
		}

		User secondUser = new User();
		secondUser.setUsername("user");
		secondUser.setPassword("user");

		Role user = roleService.findByName(RoleTypes.USER);
		secondUser.setRole(user);

		try {
			userService.save(secondUser);
		} catch (RuntimeException ex) {
			System.out.println("User admin is already in the database");
//		}
		}
		ContinentName[] continentNames = ContinentName.values();
		for(ContinentName c : continentNames) {
			if (continentRepository.findByContinentName(c) == null) {
				Continent continent = new Continent();
				continent.setContinentName(c);
				continentRepository.save(continent);
			}
		}

		List<Country> countryList = new ArrayList<>();
		countryList.add(new Country(continentRepository.findByContinentName(ContinentName.EUROPE), "Romania"));
		countryList.add(new Country(continentRepository.findByContinentName(ContinentName.EUROPE), "Spania"));
		countryList.add(new Country(continentRepository.findByContinentName(ContinentName.EUROPE), "Franta"));

		for(Country c : countryList) {
			if (countryRepository.findByName(c.getName()) == null) {
				countryRepository.save(c);
			}
		}

		List <City> cityList = new ArrayList<>();
		cityList.add(new City(countryRepository.findByName("Romania"),"Oradea" ));
		cityList.add(new City(countryRepository.findByName("Romania"),"Bucuresti" ));
		cityList.add(new City(countryRepository.findByName("Spania"),"Madrid" ));
		cityList.add(new City(countryRepository.findByName("Spania"),"Barcelona" ));

		for(City c : cityList) {
			if (cityRepository.findByName(c.getName()) == null) {
				cityRepository.save(c);
			}
		}

		List <Airport> airportList = new ArrayList<>();
		airportList.add(new Airport(cityRepository.findByName("Oradea"), "OMR"));
		airportList.add(new Airport(cityRepository.findByName("Bucuresti"), "OTP"));
		airportList.add(new Airport(cityRepository.findByName("Madrid"), "MAD"));
		airportList.add(new Airport(cityRepository.findByName("Barcelona"), "BCN"));

		for(Airport a : airportList) {
			if (airportRepository.findByName(a.getName()) == null) {
				airportRepository.save(a);
			}
		}
	}
}
