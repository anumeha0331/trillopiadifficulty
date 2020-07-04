package Testing.TravelSite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BookingPage;
import pageObject.FinalBooking;
import pageObject.LandingPage;
import resource.Base;

public class mainPage extends Base{
public WebDriver driver;
//public static Logger log = LogManager.getLogger(Base.class.getName());
@BeforeTest
public void initialize() throws IOException {
	driver = intializationDriver();
	//log.info("driver is initialised");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
	@Test
	public void Testingabc()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//log.info("driver is initialised");
			driver.get(prop.getProperty("url"));
		
		LandingPage lp= new LandingPage(driver);
		
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.moveToElement(lp.getallTab()).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.moveToElement(lp.getsearchTab()).click().sendKeys("pune").build().perform();
		//Now land on booking page
		BookingPage bk = lp.getBookingPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		bk.getbookNow().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		bk.getFinalCalender().click();
		//Now land on final booking page
		/*FinalBooking f=bk.getFinalBookingPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//f.getForm().click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(f.getFinalCalender()));
		Actions action1 = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action1.moveToElement(f.getFinalCalender()).click().build().perform();
		//f.getFinalCalender().click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/* WebDriverWait wait6 = new WebDriverWait(driver, 10);
		    WebElement radio_name = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='book-now-button']")));*/
		//driver.findElement(By.xpath("//a[contains(text(),'Show All')]"));
		   // f.getBookNowButton();
		//To know the total number of frames in the page
		/*
		 * int size = driver.findElements(By.tagName("iframe")).size();
		 * System.out.println("total frame are:"+size);
		 * 
		 * //If the frame is not known for the webelement, then the output isin terms of
		 * 1's or 0's. and when the 1 comes that position number is //the index of the
		 * frams where the frame lies for that particular webelement for(int i=0;
		 * i<=size; i++){ driver.switchTo().frame(i); int
		 * total=driver.findElements(By.xpath("//form[@id='booking_form']")).size();
		 * System.out.println(total); driver.switchTo().defaultContent(); }
		 */	

	}
}
