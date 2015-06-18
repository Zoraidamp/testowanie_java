package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Address;
import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SellingManagerTest {

	@Autowired
	StadiumManager stadiumManager;

	private final String NAME_1 = "Chrees";
	private final int AGE_1 = 22;
	private final String PESEL_1 = "930505234567";

	private final String NAME_2 = "Sth";
	private final int AGE_2 = 25;
	private final String PESEL_2 = "901005234564";

	
	private final String MAKE_1 = "Make2";
	private final String MODEL_1 = "Model2";
	private final int YOP_1 = 2010;

	private final String MAKE_2 = "Make3";
	private final String MODEL_2 = "Model3";
	private final int YOP_2 = 2011;

	
	private final String CITY_1 = "Warszawa";
	private final String STREET_1 = "Wiejska";
	private final String NUMBER_1 = "2";
	private final String POSTAL_CODE_1 = "45-799";

	@Test
	public void addAndDeleteAddressCheck() {
		Address address = new Address();
		address.setCity(CITY_1);
		address.setStreet(STREET_1);
		address.setNumber(NUMBER_1);
		address.setPostalCode(POSTAL_CODE_1);

		Long addressId = stadiumManager.addAddress(address);

		Address retrievedAddress = stadiumManager.findAddressById(addressId);
		
		assertEquals(CITY_1, retrievedAddress.getCity());
		assertEquals(STREET_1, retrievedAddress.getStreet());
		assertEquals(NUMBER_1, retrievedAddress.getNumber());
		assertEquals(POSTAL_CODE_1, retrievedAddress.getPostalCode());
		
		stadiumManager.deleteAddress(retrievedAddress);
		
		retrievedAddress = stadiumManager.findAddressById(addressId);
		
		assertNull(retrievedAddress);
	}
	
	@Test
	public void addPersonCheck() {
		List<Person> retrievedPersons = stadiumManager.getAllPersons();

		for (Person person : retrievedPersons) {
			if (person.getPesel().equals(PESEL_1)) {
				stadiumManager.deletePerson(person);
			}
		}

		Person person = new Person();
		person.setFirstName(NAME_1);
		person.setAge(AGE_1);
		person.setPesel(PESEL_1);
		
		Address address = new Address();
		address.setCity(CITY_1);
		address.setStreet(STREET_1);
		address.setNumber(NUMBER_1);
		address.setPostalCode(POSTAL_CODE_1);
		
		Long addressId = stadiumManager.addAddress(address);
		
		person.setAddress(address);

		stadiumManager.addPerson(person);

		Person retrievedPerson = stadiumManager.findPersonByPesel(PESEL_1);

		Address retrievedAddress = stadiumManager.findAddressById(addressId);
		
		assertEquals(NAME_1, retrievedPerson.getFirstName());
		assertEquals(AGE_1, retrievedPerson.getAge());
		assertEquals(PESEL_1, retrievedPerson.getPesel());
		
		assertEquals(retrievedPerson.getAddress().getId(), retrievedAddress.getId());
	}

	@Test
	public void addCarCheck() {
		Car car = new Car();
		car.setMake(MAKE_1);
		car.setModel(MODEL_1);
		car.setYop(YOP_1);

		Long carId = stadiumManager.addNewCar(car);

		Car retrievedCar = stadiumManager.findCarById(carId);
		assertEquals(MAKE_1, retrievedCar.getMake());
		assertEquals(MODEL_1, retrievedCar.getModel());
		assertEquals(YOP_1, retrievedCar.getYop());
		assertEquals(false, retrievedCar.getSold());

	}

	@Test
	public void soldCarCheck() {
		System.out.println("********************* soldCarCheck");
		Person artist = new Person();
		artist.setFirstName(NAME_2);
		artist.setAge(AGE_2);
		artist.setPesel(PESEL_2);

		stadiumManager.addPerson(artist);

		Person retrievedPerson = stadiumManager.findPersonByPesel(PESEL_2);

		Car car = new Car();
		car.setMake(MAKE_2);
		car.setModel(MODEL_2);
		car.setYop(YOP_2);

		Long carId = stadiumManager.addNewCar(car);

		stadiumManager.soldCar(retrievedPerson.getId(), carId);

		List<Car> connectedCar = stadiumManager.getConnectedCars(retrievedPerson);

		assertEquals(1, connectedCar.size());
		assertEquals(MAKE_2, connectedCar.get(0).getMake());
		assertEquals(MODEL_2, connectedCar.get(0).getModel());
		assertEquals(YOP_2, connectedCar.get(0).getYop());
		assertEquals(true, connectedCar.get(0).getSold());
	}
	

}
