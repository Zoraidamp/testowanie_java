package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("http://0.0.0.0:3000/");
		
		element = driver.findElement(By.linkText("Zarejestruj się"));
		assertNotNull(element);
	}
	
	@Test
	public void registrationPage() throws InterruptedException{
		driver.get("http://0.0.0.0:3000/");
		driver.findElement(By.linkText("Zarejestruj się")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
	    
	    
	    Random r = new Random();
	    int rand = r.nextInt(998958);
	    driver.findElement(By.name("user[login]")).sendKeys("User"+rand);
	    driver.findElement(By.name("user[password]")).sendKeys("P@ssword");
	    driver.findElement(By.name("user[password_confirmation]")).sendKeys("P@ssword");
	    driver.findElement(By.name("user[email]")).sendKeys("user"+rand+"@mail.com");
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/input")).click();
	    //WebDriverWait wait = new WebDriverWait(driver, 3);
	    //WebElement element =
	    //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Zarejestruj się")));
	}
	

	@Test
	public void loginPage() throws InterruptedException{
		driver.get("http://0.0.0.0:3000/");
			    
	    driver.findElement(By.id("session_login")).sendKeys("pom");
	    driver.findElement(By.id("session_password")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/input")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li[5]/a")).click();
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/input"));
	    //WebDriverWait wait = new WebDriverWait(driver, 3);
	    //WebElement element =
	    //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Zarejestruj się")));
	    
		try {
			FileUtils.copyFile(screenshot, new File("c:\\tmp\\selenium\\login.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void sendMailPage() throws InterruptedException{
		driver.get("http://0.0.0.0:3000/");
	    
	    driver.findElement(By.id("session_login")).sendKeys("pom");
	    driver.findElement(By.id("session_password")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/input")).click();
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li[3]/a")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
	   
	    driver.findElement(By.linkText("Wyślij wiadomość")).click();
	    Random r = new Random();
	    int rand = r.nextInt(998958);
	    driver.findElement(By.name("message[title]")).sendKeys("Title"+rand);
	    driver.findElement(By.name("message[body]")).sendKeys("Sth here it is");
	    driver.findElement(By.xpath("/html/body/section[1]/div/div/div/form/div[5]/input")).click();
	    driver.findElement(By.xpath("/html/body/section[1]/div/div/div/a")).click();
	    driver.findElement(By.linkText("Wysłane wiadomości")).click();
	    driver.findElement(By.linkText("Title"+rand));
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li[5]/a")).click();
	    
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
