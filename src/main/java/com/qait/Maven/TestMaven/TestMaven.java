package com.qait.Maven.TestMaven;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestMaven {

	public void clickBasicCourseLink(WebDriver driver) {
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(4)")).click();
	}

	public void gridGate(WebDriver driver) {
		driver.findElement(By.className("greenbox")).click();
	}

	public void frameDungeon(WebDriver driver) {
		WebElement mainDiv = driver.findElement(By.id("main"));
		driver.switchTo().frame(mainDiv);
		String boxOneColor = driver.findElement(By.id("answer")).getAttribute("class");
		String boxTwoColor = "";
		Boolean condition = false;
		while (!condition) {
			WebElement childDiv = driver.findElement(By.id("child"));
			driver.switchTo().frame(childDiv);
			boxTwoColor = driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if (boxOneColor.equals(boxTwoColor)) {
				condition = true;
			} else {
				driver.findElement(By.cssSelector("body > center > a:nth-child(7)")).click();
			}
		}
		driver.findElement(By.cssSelector("body > center > a:nth-child(9)")).click();
		driver.switchTo().defaultContent();
	}

	public void dragAround(WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement drop = driver.findElement(By.cssSelector("#dropbox"));
		WebElement drag = driver.findElement(By.cssSelector("#dragbox"));
		actions.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.cssSelector("body > div > div.page > a")).click();
	}

	public void popupWindows(WebDriver driver) {
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(4)")).click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.findElement(By.cssSelector("#name")).sendKeys("Himanshu Sharma");
		driver.findElement(By.cssSelector("#submit")).click();
		driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(6)")).click();
	}

	public void cookieHandling(WebDriver driver) {
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(8)")).click();
		String token = driver.findElement(By.cssSelector("#token")).getText();
		String tokenValue = token.substring(7);
		Cookie name = new Cookie("Token", tokenValue);
		driver.manage().addCookie(name);
		driver.findElement(By.cssSelector("body > div > div.page > a:nth-child(10)")).click();
	}
}
