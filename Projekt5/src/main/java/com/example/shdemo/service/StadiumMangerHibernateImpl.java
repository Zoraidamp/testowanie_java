package com.example.shdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Address;
import com.example.shdemo.domain.Car;
import com.example.shdemo.domain.Person;

@Component
@Transactional
public class StadiumMangerHibernateImpl implements StadiumManager {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addPerson(Person person) {
		person.setId(null);
		sessionFactory.getCurrentSession().persist(person);
	}
	
	@Override
	public void deletePerson(Person person) {
		person = (Person) sessionFactory.getCurrentSession().get(Person.class,
				person.getId());
		
		for (Car car : person.getCars()) {
			car.setSold(false);
			sessionFactory.getCurrentSession().update(car);
		}
		sessionFactory.getCurrentSession().delete(person);
	}

	@Override
	public List<Car> getConnectedCars(Person person) {
		person = (Person) sessionFactory.getCurrentSession().get(Person.class,
				person.getId());
		// lazy loading here
		List<Car> cars = new ArrayList<Car>(person.getCars());
		return cars;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return sessionFactory.getCurrentSession().getNamedQuery("person.all")
				.list();
	}

	@Override
	public Person findPersonByPesel(String pesel) {
		return (Person) sessionFactory.getCurrentSession().getNamedQuery("person.byPesel").setString("pesel", pesel).uniqueResult();
	}


	@Override
	public Long addNewCar(Car car) {
		car.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(car);
	}

	@Override
	public void soldCar(Long personId, Long carId) {
		Person person = (Person) sessionFactory.getCurrentSession().get(
				Person.class, personId);
		Car car = (Car) sessionFactory.getCurrentSession()
				.get(Car.class, carId);
		car.setSold(true);
		person.getCars().add(car);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> getAvailableCar() {
		return sessionFactory.getCurrentSession().getNamedQuery("car.unsold")
				.list();
	}

	@Override
	public Car findCarById(Long id) {
		return (Car) sessionFactory.getCurrentSession().get(Car.class, id);
	}

	@Override
	public Long addAddress(Address address) {
		address.setId(null);
		return (Long) sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		address = (Address) sessionFactory.getCurrentSession().get(Address.class,
				address.getId());

		sessionFactory.getCurrentSession().delete(address);
	}
	
	@Override
	public Address findAddressById(Long id) {
		return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
	}

}
