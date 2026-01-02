package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.logging.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;

public class BaseTest {

	public static WebDriver driver;
	public Properties p;
	public Logger logger;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) {

		logger= LogManager.getLogger(this.getClass());
		try {
			FileReader file = new FileReader("./src/main/resources/config/config.properties");

			p = new Properties();
			p.load(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid browser ");
				break;
			}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {

		driver.close();

	}
	
	public  String captureScreenShot(String name) {
		
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File srcfile= screenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+  name + "_"+ timeStamp + ".png";
		
		File targetFile= new File(targetFilePath);
		srcfile.renameTo(targetFile);
		
		return targetFilePath;
		
		

	}

}
