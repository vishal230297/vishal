package Sign_up;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Excel_utility_01.Excel_utility_01;

public class New
{
	WebDriver driver;
	
	@BeforeClass  
	public void Fitst_Step()
	{
	System.setProperty ("webdriver.chrome.driver","F:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/signup/");
	driver.manage().window().maximize();
    }

	@Test(dataProvider="login data")
	public void Second_Step(String fname,String lname)
	{
	  WebElement user1 = driver.findElement(By.name("firstname"));
	  user1.sendKeys(fname);
	  WebElement user2 = driver.findElement(By.name("lastname"));
	  user2.sendKeys(lname);
	 // driver.findElement(By.id("loginForm")).click();
	}

	@DataProvider(name = "login data")
	public String [][] getdata() throws IOException
	{
	  String path = "F:\\Excel_files\\FB.xlsx";
	  Excel_utility_01 eu = new Excel_utility_01(path);
	  int totalrows = eu.getRowCount("info");
	  int totalcols = eu.getCellCount("info",1);
	  String loginData[][]=new String[totalrows][totalcols];
	  for(int i=1;i<=totalrows;i++) //1
	  {
	  for(int j=0;j<totalcols;j++) //0
	  {
	  loginData[i-1][j]=eu.getCellData("info", i, j);
	  }
	  }
	  return loginData;
}
}
