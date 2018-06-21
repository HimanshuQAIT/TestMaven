package com.qait.Maven.TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;
	TestMaven testMaven;
	@Test
	public void f() {
		testMaven.clickBasicCourseLink(driver);
		testMaven.gridGate(driver);
		testMaven.frameDungeon(driver);
		testMaven.dragAround(driver);
		testMaven.popupWindows(driver);
		testMaven.cookieHandling(driver);
	}

	@BeforeTest
	public void beforeTest() {
		testMaven = new TestMaven();
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
