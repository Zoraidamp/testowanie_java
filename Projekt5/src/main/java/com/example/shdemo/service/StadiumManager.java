package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Address;
import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Person;

public interface StadiumManager {
	
	void addPerson(Person person);
	List<Person> getAllPersons();
	void deletePerson(Person person);
	Person findPersonByPesel(String pesel);
	
	Long addNewCar(Car car);
	List<Car> getAvailableCar();
	Car findCarById(Long id);

	List<Car> getConnectedCars(Person person);
	void soldCar(Long personId, Long carId);
	
	Long addAddress(Address address);
	void deleteAddress(Address address);
	Address findAddressById(Long id);

}
