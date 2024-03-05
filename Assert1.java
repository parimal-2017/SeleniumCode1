package basicTestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Assert1 {
	
		@Test
		public void MyntraPage() {
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.myntra.com/");
			/*String url = driver.getCurrentUrl();
			String expectedurl = "https://www.myntra.com/";*/
			
			//call asserEquals(boolean actual,boolean expected)
			//Assert.assertEquals(url, expectedurl);
			//System.out.println(url);
			
			String actualtitle = driver.getTitle();
			String expectedtitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
			
			assertEquals(actualtitle, expectedtitle);
			
			 System.out.println(actualtitle);
			}
	}

