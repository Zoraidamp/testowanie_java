package com.example.restservicedemo;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.CarManager;
import com.example.restservicedemo.service.PersonManager;
import com.jayway.restassured.RestAssured;

public class CarServiceTest {
	
	CarManager cm = new CarManager();
	PersonManager pm = new PersonManager();
	
	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo";
	}
	
	@Test
	public void getCar(){
		pm.addPerson(new Person(1,"Zoraida",1993));
		cm.addCar(new Car(1,"Opel","Corsa",1990, 1));
		
		get("/cars/1").then().assertThat().body("make", equalTo("Opel"));	
		get("/cars/1").then().assertThat().body("model", equalTo("Corsa"));	
		get("/cars/1").then().assertThat().body("yop", equalTo("1990"));
		get("/cars/1").then().assertThat().body("owner", equalTo("1"));
		
		Car aCar = get("/cars/1").as(Car.class);
		assertThat(aCar.getMake(), equalToIgnoringCase("Opel"));
		
	}
	
	@Test
	public void getPerson(){
		
		Person Antos = new Person(5,"Antos",1992);
		pm.addPerson(Antos);
		
		get("/persons/5").then().assertThat().body("yob", equalTo("1992"));
		get("/persons/5").then().assertThat().body("firstName", equalTo("Antos"));
		
		
		Person aPerson = get("/persons/5").as(Person.class);
		
		assertThat(aPerson.getFirstName(), equalToIgnoringCase("Antos"));
		
	}
		
	@AfterClass
	public static void clearUp(){
		CarManager cm = new CarManager();
		PersonManager pm = new PersonManager();
		pm.clearPersons();
		cm.clearCars();
	}	

}
