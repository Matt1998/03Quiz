package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Integration UI test for PHP App.
 */
public class AppTest
{
	WebDriver driver; 
	WebDriverWait wait; 
	String url = "http://192.168.0.78:5000/";
	String validPassword = "Aon301niQ(0r2@0b";
	String invalidPassword = "password";

    @Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 10); 
	} 

	@After
    public void tearDown() { 
		driver.quit(); 
	}	 
	
    @Test
    public void testLoginWithValidPassword() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Login Page |")); 

		//enter input
		driver.findElement(By.name("password")).sendKeys(validPassword);
		//click submit
		driver.findElement(By.name("submit")).submit();
	
		//check result 
		String expectedResult = "Welcome |"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}
		
	@Test
    public void testLoginWithInvalidPassword() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Login Page |")); 

		//enter input
		driver.findElement(By.name("password")).sendKeys(invalidPassword);
		//click submit
		driver.findElement(By.name("submit")).submit();
	
		//check result
		String expectedResult = "Welcome |"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains(expectedResult)); 
		assertTrue(isResultCorrect == true); 
	}

}