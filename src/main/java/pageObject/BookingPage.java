package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingPage {
	public WebDriver driver;
	private Properties prop;
	/*By sendEnquiry= By.xpath("//body/div/div[@id='wrapper']/main[@id='main-collection-content']/section/div/div/div/div[2]/div[3]/div[2]/span[1]");
	By bookNow=By.xpath("//div[13]//div[3]//div[2]//a[1]");*/
	By bookNow = By.xpath("//span[1]//div[3]//div[1]//div[4]//button[1]");
	By calender= By.xpath("/html[1]/body[1]/div[4]/div[3]/div[1]/div[2]/div[1]/form[1]/div[8]/div[1]/div[1]/input[1]");
	
	
	public BookingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getbookNow()
	{
		return driver.findElement(bookNow);
	}
	
	
	public FinalBooking getFinalBookingPage()
	{
		driver.findElement(bookNow).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		FinalBooking fb=new FinalBooking(driver);
		return fb;
	}
	
//	public WebElement getFinalCalender()
//	{
//		return driver.findElement(calender);
//	}
	
	/*private WebDriver intializationDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Ajay\\eclipse-workspace\\TravelSite\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajay\\Documents\\chromedriver.exe");

			driver = new ChromeDriver(option);

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = intializationDriver();
//		log.info("driver is initialised");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get("https://www.thrillophilia.com/cities/pune/tours");
//		getFinalCalender();		
		FinalBooking fb = getFinalBookingPage();
	}*/
}