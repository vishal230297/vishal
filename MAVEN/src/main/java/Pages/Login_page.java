package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_pakage.url_link;

public class Login_page extends url_link

{
  @FindBy(id="user-name")
  WebElement email;
  @FindBy(id="password")
  WebElement pass;
  @FindBy(id="login-button")
  WebElement click;

public Login_page()
 {
  PageFactory.initElements(driver,this);
 }

public Home_page login(String user, String pwd)
 {
  email.sendKeys(user);
  pass.sendKeys(pwd);
  click.click();	
  return new Home_page();
 }
}

