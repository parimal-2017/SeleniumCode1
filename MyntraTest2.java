package basicTestNG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyntraTest2 {
	@Test
	public void MyntarPage() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String url = driver.getCurrentUrl();
		
		
		if(url.equals("https://www.facebook.com/p")) {
			System.out.println("URL is matching");
		}else {
			System.out.println("URL is not matching");
		}
		
		System.out.println(url);
		
		 String val1= driver.getTitle();
		 System.out.println(val1);

	}

}
