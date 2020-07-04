package Testing.TravelSite;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LogInPage;

import resource.Base;



public class HomePage extends Base{

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializationDriver();
		log.info("driver is initialised");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void basenavigationpage() throws IOException
	{driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("driver Navigate to home page");
		LandingPage l = new LandingPage(driver);
		l.getlogIn().click();
		LogInPage lp= new LogInPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		//Actions action = new Actions(driver);
		//action.moveToElement(lp.password()).click().sendKeys("test@gmail.com").perform();
		//List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
        // print your number of frames
      //  System.out.println(iframes.size());
       // driver.findElement(By.xpath("//input[@id='consumer_email']")).sendKeys("testng@gmail.com");
		//driver.switchTo().frame("google_conversion_frame");
        //driver.switchTo().defaultContent();
       // driver.switchTo().parentFrame();
		lp.emailId().sendKeys("abecd@gmail.com");
		lp.password().sendKeys("1234");
		//driver.findElement(By.xpath("//input[@id='consumer_email']")).sendKeys("abc@gmail.com");
		lp.getlogIn().click();
        log.info("test data printed successfully");
driver.close();
log.info("browser2 is closed");
	}

	
	
}
