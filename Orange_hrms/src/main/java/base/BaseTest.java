package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	public static WebDriver driver;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) {
		
		try {
			FileReader file= new FileReader("./src/test/resources/config.properties");
			
			p= new Properties();
			p.load(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
			case "chrome":driver= new ChromeDriver();break;
			case "edge": driver= new EdgeDriver();break;
			default: System.out.println("Invalid browser ");break;
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown() {
		
		//driver.close();	
	}
	
	
}
