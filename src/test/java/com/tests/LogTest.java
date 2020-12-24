package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogTest {
	
	Logger log = Logger.getLogger(LogTest.class);

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.driver.chrome", "C:\\Selenium\\SeleniumJars\\NewDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("*****************Launch Chrome Browser*********************");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		log.info("*****************Opening Google*********************");

	}

	@Test(priority = 1)
	public void title() {
		String title = driver.getTitle();
		System.out.println(title);
		log.info("*****************Verify Page Title*********************");
	}

	@Test(priority = 2)
	public void logo() {

		boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();

		Assert.assertTrue(b);
	}

	/*
	@Test(priority = 3)
	public void searchBtn() {
		boolean c = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).isDisplayed();

		Assert.assertTrue(c);
	}

	@Test(priority = 4)
	public void testFour() {
		System.out.println("Four");
	}

	@Test(priority = 5)
	public void testFive() {
		System.out.println("Five");
	}

	@Test(priority = 6)
	public void testSix() {
		System.out.println("Six");
	} */

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
