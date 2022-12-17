package Base_pakage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import Pages.Home_page;
import Pages.Login_page;

public class url_link 
{
  public static WebDriver driver;
  public Home_page hp;
  public Login_page lp;
	  
	@BeforeMethod
	public void First_Step()
	{
	  System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  lp=new Login_page();
	}
	
	//@AfterMethod
	/*public void close()
	{
		driver.quit();
	}*/
}
