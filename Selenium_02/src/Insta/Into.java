package Insta;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Into 
{
  WebDriver driver;
  
@BeforeClass  
public void Fitst_Step()
{
  System.setProperty("WebDriver.chrome.Driver","F:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.get("https://www.instagram.com/accounts/login/");
  driver.manage().window().maximize();
}

@Test(dataProvider="login data")
public void Second_Step(String username,String pwd)
{
  WebElement user = driver.findElement(By.name("username"));
  user.sendKeys(username);
  WebElement pass = driver.findElement(By.name("password"));
  pass.sendKeys(pwd);
  driver.findElement(By.id("loginForm")).click();
}

@DataProvider(name = "login data")
public String [][] getdata() throws IOException
{
  String path = "F:\\Excel_files\\Insta.xlsx";
  Ecxel_utility eu = new Ecxel_utility(path);
  int totalrows = eu.getRowCount("Data");
  int totalcols = eu.getCellCount("Data",1);
  String loginData[][]=new String[totalrows][totalcols];
  for(int i=1;i<=totalrows;i++) //1
  {
  for(int j=0;j<totalcols;j++) //0
  {
  loginData[i-1][j]=eu.getCellData("Data", i, j);
  }
  }
  return loginData;
}
}