package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intializationDriver() throws IOException 
	{
		 prop= new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\Ajay\\eclipse-workspace\\TravelSite\\src\\main\\java\\resource\\data.properties");
		 prop.load(fis);
		 String browserName=prop.getProperty("browser");
		 System.out.println(browserName);
		 
		 if (browserName.equals("chrome"))
		 {
			ChromeOptions option= new ChromeOptions();
			option.addArguments("--disable-notifications");
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe");
		
			driver= new ChromeDriver(option);
			 
		 }
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 return driver;	 
	}
		/*prop= new Properties();
		 FileInputStream fis = new FileInputStream("C:\\Users\\Ajay\\eclipse-workspace\\TravelSite\\src\\main\\java\\resource\\data.properties");
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName= prop.getProperty("browser");
		
		
		System.out.println(browserName);
		if (browserName.equals("chrome"))
		{
			ChromeOptions option= new ChromeOptions();
			option.addArguments("--disable-notifications");
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe");
		
			driver= new ChromeDriver(option);
			

		}
		
		if (browserName.contains("chrome"))
		
		{//System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe");
			ChromeOptions option= new ChromeOptions();
			if (browserName.contains("headless"))
				{option.addArguments("headless");}
			 driver = new ChromeDriver(option);
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Ajay\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\Ajay\\Documents\\IE-REDIST.exe");
		 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		return driver;
		}*/
	
	public String getScreenShotPath(String testcasename, WebDriver driver) throws IOException
	{
	TakesScreenshot	ts = (TakesScreenshot) driver;
	System.out.println(testcasename);
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports"+testcasename+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
	
	}
}
