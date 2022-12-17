package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import Base_pakage.url_link;

public class login_test extends url_link
{
	 @Test(priority=1)
public void ltest()
 {
  hp=lp.login("standard_user","secret_sauce");
  String expectdURL="https://www.saucedemo.com/inventory.html";
  String actualURL=driver.getCurrentUrl();
  AssertJUnit.assertEquals(actualURL, expectdURL);
 }
}