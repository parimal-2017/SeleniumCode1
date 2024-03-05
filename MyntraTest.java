package basicTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyntraTest {
	
	@Test
	public void youTube() {
		System.out.println("YouTube");
	}
	@AfterMethod
	public void AM() {
		System.out.println("After method");
	}
	
	
	
	@Test
	public void Facebook() {
		System.out.println("Facebbok");
	}
	
	@BeforeMethod
	public void BM() {
		System.out.println("Before method");
	}
	
	@BeforeClass
	public void BC() {
		System.out.println("Before class");
	}
	@AfterSuite
	public void AS() {
		System.out.println("After suit");
	}
	
	@AfterClass
	public void AC() {
		System.out.println("After class");
	}
	
	@BeforeSuite
	public void BS() {
		System.out.println("Before suit");
	}
	@BeforeTest
	public void BT() {
		System.out.println("Before test");
	}
	@AfterTest
	public void AT() {
		System.out.println("After test");
	}
}
