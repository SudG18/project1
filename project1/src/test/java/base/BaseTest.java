package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

		public static WebDriver driver;
		public static Properties prop = new Properties();
		public static Properties loc = new Properties();
		public static FileReader fr;
		public static FileReader fr1;
		
		
		@BeforeMethod
		public void setUp() throws IOException{
			if(driver==null) {
				fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
				fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\locators.properties");
				prop.load(fr);
				loc.load(fr1);
			}
			if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(prop.getProperty("testurl"));
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("testurl"));
			}
			else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.chromedriver().setup();
				driver = new EdgeDriver();
				driver.get(prop.getProperty("testurl"));
			}
		}
		
		@AfterMethod
		public void tearDown() {
			driver.close();
			System.out.println("tear down complete");
			
		}

	}

