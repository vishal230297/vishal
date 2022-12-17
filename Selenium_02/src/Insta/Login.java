package Insta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login 
{
	
	public static void main(String[] args) 
	{		
	  System.setProperty("webdriver.chrome.Driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  WebDriver Driver = new ChromeDriver();
	  Driver.get("https://www.instagram.com/accounts/login/");
	  Driver.manage().window().maximize();
	}
}
