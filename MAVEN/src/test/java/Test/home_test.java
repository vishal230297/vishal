package Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import Base_pakage.url_link;

public class home_test extends url_link
{
@Test(priority=2) 
public void AddProducts() throws InterruptedException
	{
	hp = lp.login("standard_user","secret_sauce");
	hp.add_products();
	Thread.sleep(2000);
	String expectdURL="https://www.saucedemo.com/cart.html";
	String actualURL=driver.getCurrentUrl();
	AssertJUnit.assertEquals(actualURL, expectdURL);
	}
}
