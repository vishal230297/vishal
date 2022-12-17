package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Base_pakage.url_link;

public class Home_page extends url_link
{
  @FindBy(name="add-to-cart-sauce-labs-backpack")
  WebElement p1;
  @FindBy(name="add-to-cart-sauce-labs-onesie")
  WebElement p2;
  @FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
  WebElement cart;
 
public Home_page()
 {
 PageFactory.initElements(driver,this);
 }
 
public Users_page add_products()
 {
  p1.click();
  p2.click();
  cart.click();
  return new Users_page();
 }
}


