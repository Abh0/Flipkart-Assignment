package com.flipkart_Assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import recordingTest.ScreenRecorderUtil;

public class FlipkartTest     {

	WebDriver driver;
	
	@BeforeClass
	 void setup() throws Exception {  
		
		

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();

		
		
		
		
		driver.get("https://www.flipkart.com"); // enter url
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
		@Test
		void searchToAdd() throws Exception {
		
			ScreenRecorderUtil.startRecord("searchToAdd");
			
			
		Thread.sleep(3000);
		// remove login page
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();

//enter ipad in search box
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("ipad");
		// click on search icon
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();

		// scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

		// click on Brand
		driver.findElement(By.xpath("//div[contains(text(),'Brand')]")).click();
		Thread.sleep(3000);

		// click on dropdown value checkbox Apple
		driver.findElement(By.xpath("//div[@title='APPLE']//div[@class='_24_Dny']")).click();
		Thread.sleep(3000);

		// click on first suggestion
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]"))
				.click();

		// switch to next window
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// click on Add to cart button
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")))
				.click();

		Thread.sleep(3000);

		// place order
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();

		// enter mobile number or email address
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("7774937322");

		// click on countinue button
		driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']")).click();

		
		
		ScreenRecorderUtil.stopRecord();
		
		}
	
		@AfterClass
		void tearDown() {
		
		driver.quit();

		
		
	}}

