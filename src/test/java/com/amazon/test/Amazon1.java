package com.amazon.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\Drivers\\IEDriverServe.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.get("http://amazon.com");

		WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(element).perform();
		String firstCss = "//*[@id='nav-flyout-shopAll']/div[2]/span[";
		String secondCss = "]/span";
		
		for(int i = 1; i<21;i++) {
			
		System.out.println(driver.findElement(By.xpath(firstCss+i+secondCss)).getText());
		
//		Thread.sleep(3000);
		}
		System.out.println(driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/a/span")).getText());
		driver.close();
		
	}

}
