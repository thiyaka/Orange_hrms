package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();	
	}
	
	
}
