package Testing.TravelSite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BookingPage;
import pageObject.Confirm;
import pageObject.FinalBooking;
import pageObject.LandingPage;
import pageObject.PaymentPage;
import pageObject.TravelerInformation;
import pageObject.packageDetails;
import resource.Base;

public class mainPage extends Base{
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
	public void Testingabc()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("driver is initialised yes");
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
		//bk.getbookNow().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Now land on final booking page
		FinalBooking f=bk.getFinalBookingPage();
		ArrayList<String> allWindows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(allWindows.get(1));
		System.out.println(driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(f.getFinalCalender()));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//int count= driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td[@class=' available']")).size();
		int count=f.getCountAvailableDates();
		System.out.println("available dates are:"+ count);
		//List<WebElement> days=driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td[@class=' available']"));
		List<WebElement> days=f.getavailableDates();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//while(!driver.findElement(By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/span[1]")).getText().contains("August"))
		while(!f.getMonth().getText().contains("August"))
		{
			//driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//div//span[contains(text(),'Next')]")).click();
			f.getNxtButton().click();
		}
		for(int i=0;i<count;i++)
		{
			//String text = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td[@class=' available']")).get(i).getText();
			String text =f.getavailableDates().get(i).getText();
		   if(text.equalsIgnoreCase("21"))
		   {
			   //driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td[@class=' available']")).get(i).click();
			   f.getavailableDates().get(i).click();
			   break;
		   }
			
		}
		f.getAdultPerson().click();
		f.getAdultPerson().click();
		packageDetails pck=f.getPackageDetailsPage();
		TravelerInformation TInfo=pck.getTravelerInfoPage();
		TInfo.getName().sendKeys("tester");
		TInfo.getEmail().sendKeys("test@gmail.com");
		TInfo.getPhnNumb().sendKeys("9878768790");
		Confirm c=TInfo.getConfirmPage();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			c.getCheckBox().click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", c.getCheckBox());
		  }
		
		PaymentPage p=c.getPaymentPage();

		
		
		

	}
}

