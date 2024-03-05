package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {
	@Test
	public void MyntraPage() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		String actualurl = driver.getCurrentUrl();
		
		String expectedurl ="https://www.myntra.com/p";
		
		//Create the object of softassert
		SoftAssert sa = new SoftAssert();
		
		//Call assertEqual(boolean actual, boolean expected)
		sa.assertEquals(actualurl, expectedurl);
		
		System.out.println("Good Morning");
		
		sa.assertAll();
		
	}

}
