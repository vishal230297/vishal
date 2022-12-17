package Sign_up;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Excel_utility_01.Excel_utility_01;

public class Data_driver {
	
WebDriver driver;
	
	@BeforeClass
	public void launch_browser()
	{
	System.setProperty ("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.facebook.com/login/");
	driver.manage().window().maximize();
	}
	
	@Test(dataProvider="login data")
	public void details(String email, String pwd)
	{
		WebElement user = driver.findElement(By.name("email"));
		user.sendKeys(email);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.name("Login")).clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
	//	driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
	//	driver.findElement(By.name("pass")).sendKeys("Biriyani@150");
	//	driver.findElement(By.name("login")).click();
	}
	
	@DataProvider(name = "login data")
	 public String [][] getdata() throws IOException
	 
	 {
		
		String path = "F:\\Excel_files\\data_01.xlsx";
		Excel_utility_01 utilis = new Excel_utility_01(path);
		int totalrows = utilis.getRowCount("Data");
		int totalcols = utilis.getCellCount("Data",1);
		String loginData[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) //1
		{
		for(int j=0;j<totalcols;j++) //0
		{
		loginData[i-1][j]=utilis.getCellData("Data", i, j);
		}
		}
		return loginData;
	 }
			
	@AfterClass
	public void close()
	{
		driver.quit();
	}

}
