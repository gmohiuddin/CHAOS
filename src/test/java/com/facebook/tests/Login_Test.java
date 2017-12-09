package com.facebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Test {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		this.driver.close();
	}
	
	@Test
	public void loadPage() {
		
		driver.get("http://www.facebook.com");
		Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");
	}
	@Test(dependsOnMethods="loadPage")
	public void filloutEmailFld() {
		String email = "mail.golam@gmail.com";
		WebElement emailFld = driver.findElement(By.cssSelector("#email"));
		emailFld.sendKeys(email);
		Assert.assertEquals(emailFld.getAttribute("value"), email);
	}
	@Test(dependsOnMethods="filloutEmailFld")
	public void filloutPassFld() {
		String password = "gm2255";
		WebElement passwordFld = driver.findElement(By.cssSelector("#pass"));
		passwordFld.sendKeys(password);
		Assert.assertEquals(passwordFld.getAttribute("value"), password);
	}
}
