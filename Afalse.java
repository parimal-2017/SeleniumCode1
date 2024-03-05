package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Afalse {
	@Test
	public void Myntra() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		WebElement searchtf = driver.findElement(By.className("desktop-searchBar"));
		
		
		//assertFalse(boolean condition)
		Assert.assertFalse(searchtf.isDisplayed());
		System.out.println("Good Morning");
		
		
		//searchtf.isEnabled()----True condition---Fail
		//searchtf.isSelected()---False condition---Pass
		//searchtf.isDisplayed()---True condition---fail

	}

}
