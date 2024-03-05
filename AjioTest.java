package basicTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AjioTest {

	
		// TODO Auto-generated method stub
		@Test(priority = 0, invocationCount = 2)
		public void Facebook() {
			//System.out.println("Facebook");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
	}
		@Test(priority = 2)
		public void Amezon() {
			//System.out.println("Amezon");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://amezon.com/");
	
		}
		
		@Test(priority = 1)
		public void Myntra() {
			//System.out.println("Amezon");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.myntra.com/");
	
		}
		

}
