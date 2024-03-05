package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Atrue {
	@Test
	public void MyntraPage() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		WebElement searchtf = driver.findElement(By.className("desktop-searchBar"));
		
		//call assertTrue(boolean condition)
		Assert.assertTrue(searchtf.isEnabled());
		
		System.out.println("Good morning");
		
		
		//serchtf.isEnabled()---True condition---pass
		//serchtf.isDisplayed()---True condition---pass
		//serchtf.isDisplayed()---False condition---fail
		
	}

}
