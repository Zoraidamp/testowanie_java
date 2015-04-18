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
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[2]/input")).sendKeys("User"+rand);
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[3]/input")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[4]/input")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/div[5]/input")).sendKeys("user"+rand+"@mail.com");
	    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/form/input")).click();
	    
	    //WebDriverWait wait = new WebDriverWait(driver, 3);
	    //WebElement element =
	    //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Zarejestruj się")));
	    
		try {
			FileUtils.copyFile(screenshot, new File("registation.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}
	

	@Test
	public void loginPage() throws InterruptedException{
		driver.get("http://0.0.0.0:3000/");
			    
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/div[2]/input")).sendKeys("pom");
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/div[3]/input")).sendKeys("P@ssword");
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
		assertTrue(true);
	}
	
	@Test
	public void sendMailPage() throws InterruptedException{
		driver.get("http://0.0.0.0:3000/");
			    
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/div[2]/input")).sendKeys("pom");
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/div[3]/input")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/form/input")).click();
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
	    driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li[3]/a"));
	    driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div[2]/p/a"));
	    
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement element =
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("manage")));
	    //driver.findElement(By.linkText("Wyślij wiadomość")).click();
	    
	    //driver.findElement(By.id("message_title"));
	    //WebDriverWait wait = new WebDriverWait(driver, 3);
	    //WebElement element =
	    //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Zarejestruj się")));
	    
		try {
			FileUtils.copyFile(screenshot, new File("login.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
