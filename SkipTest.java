package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SkipTest {
	
	
	@Test(dependsOnMethods = "Facebook")
	public void Zomato() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/");
		
		
		
	}
	@Test
	public void Facebook() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actualurl= driver.getCurrentUrl();
		String expectedurl = "https://www.facetbook.com/";
		Assert.assertEquals(actualurl, expectedurl);
		
		
	}
	@Test(dependsOnMethods = "Facebook")
	public void Swiggy() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
		
		
	}

}
