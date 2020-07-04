package Testing.TravelSite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BookingPage;
import pageObject.LandingPage;
import resource.Base;

public class bookingPuneTour extends Base {

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
			log.info("driver is initialised");
				driver.get(prop.getProperty("url"));
				LandingPage lp = new LandingPage(driver);
				BookingPage bk = lp.getBookingPage();
				//BookingPage bk2= new BookingPage(driver);
				bk.getbookNow().click();
}
}