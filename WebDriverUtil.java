package commonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.Advice.Return;

public class WebDriverUtil {

 
		// TODO Auto-generated method stub
		
		
		public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
		}

		public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		public void handleddropdown(WebElement element,String targetedelement) {
			Select s = new Select(element);
			s.selectByVisibleText(targetedelement);
		}
		
		public void mousehover(WebDriver driver,WebElement image) {
			Actions a = new Actions(driver);
			a.moveToElement(image);
			a.perform();
			
		}
		
		public void switchWindow(WebDriver driver,String expectedurl) {
			Set<String> ids = driver.getWindowHandles();
			for(String e : ids) {
				String actualurl = driver.switchTo().window(e).getCurrentUrl();
				
				if(actualurl.contains(expectedurl)) {
					break;
					
				}
			}
			
		}
		
		public File screenshot(WebDriver driver,String ScreenshotName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File tempfile = ts.getScreenshotAs(OutputType.FILE);
			File destinationdFile = new File("./Screenshot/"+ScreenshotName+".png");
			FileUtils.copyFile(tempfile, destinationdFile);
			return destinationdFile;
			
		}
}
