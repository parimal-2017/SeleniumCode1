package vtigerCRM;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplimentation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplimentation.class)

public class Contacts {
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutils = new JavaUtil();
	
	@Test
	public void organizationTest() throws IOException, InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	
	//maximize the window
	wutil.maximize(driver);
	
	//To apply wait for the element
	wutil.implicitWait(driver);
	
	//To read data from property file
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME = putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	//To read the data from excel sheet
	String FIRSTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
	String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
	String GROUPS = eutil.getDataFromExcel("Contacts", 2, 1);
	String ORGNAME = eutil.getDataFromExcel("Contacts", 3, 1);
	
	
	//To launch the applicatiom
		driver.get(URL);
		
	//log in toapplication
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click on plus icon
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//pass the first name
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		
		//pass the last name
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		
		//To fail the testscript
		/*WebElement notifycheakbox = driver.findElement(By.name("notify_owner"));
		Assert.assertTrue(notifycheakbox.isSelected());*/
		
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://localhost:8888/indexes.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualurl, expectedurl);
		
		//In assign to click on group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//In the dropdown select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handleddropdown(dropdown, GROUPS);
		
		//click on plus(+)
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//Transfer the driver control from parent window to child window
		wutil.switchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//Enter organization name in searchtf
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		
		//To click on search now button
		driver.findElement(By.name("search")).click();
		
		//Click on organization name
		driver.findElement(By.xpath("//a[text()='Parsh']")).click();
		
		//Transfer the driver control from parent window to child window
		wutil.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
	
		//To click on save button
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(2000);
		//To take screenshot of contact
		//wutil.screenshot(driver, "Contacts1");
		
		
		//It is mandatory to add thread.sleep before mousehovering
		Thread.sleep(2000);
		//mousehover on img
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, image);
		
		//Click on sign out 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
