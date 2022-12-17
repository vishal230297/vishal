package Sel_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sel_001 {
	
	WebDriver driver;
	
	@BeforeClass
	public void Sign_up()
	{
		System.setProperty ("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void details()
	{
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("assfQ34dg");
		driver.findElement(By.name("login")).click();
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	}
	