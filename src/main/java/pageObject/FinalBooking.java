package pageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinalBooking {
	public WebDriver driver;
//	public Properties prop;

	By calender = By.xpath("//input[@placeholder='Choose your date']");
	
//	By calender = By.className("calendaricon");//By.className("js-dateselection form-control"); //("//input[@placeholder='Choose your date']");
	// js-dateselection form-control
	// By calender= By.xpath("//div[@id='tourSidebar']//div[8]");
	
	
	By booknowButton = By.xpath("//input[@id='book-now-button']");
	By form = By.xpath("//form[@id='booking_form']");
   By availableDates = By.xpath("//div[@id='ui-datepicker-div']//td[@class=' available']");
   By month= By.xpath("/html[1]/body[1]/div[8]/div[1]/div[1]/span[1]");
   By nextButton=By.xpath("//div[@id='ui-datepicker-div']//div//span[contains(text(),'Next')]");
   By radioButton=By.xpath("//body//div[@id='tourSidebar']//div//div//div//div//div//div[2]//i[1]");
	public FinalBooking(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFinalCalender() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		System.out.println(driver.getPageSource());
//		try {
			driver.findElement(calender).click();
//			driver.findElement(By.xpath("//input[@placeholder='Choose your date']")).click();
//			driver.findElement(calender).click();
//		} catch (NoSuchElementException e) {
//			e.printStackTrace();
//		}
		return driver.findElement(calender);
//		return null;
	}

	public WebElement getForm() {
		return driver.findElement(form);
	}
	public WebElement getAdultPerson() {
		return driver.findElement(radioButton);
	}
	public WebElement getNxtButton() {
		return driver.findElement(nextButton);
	}
	public WebElement getMonth() {
		return driver.findElement(month);
	}
	public int getCountAvailableDates() {
		 return driver.findElements(availableDates).size();
	}

	public List<WebElement> getavailableDates() {
		return driver.findElements(availableDates);
	}
	public WebElement getBookNowButton() {
		return driver.findElement(booknowButton);
	}
	public packageDetails getPackageDetailsPage()
	{
		driver.findElement(booknowButton).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		packageDetails pck=new packageDetails(driver);
		return pck;
	}

//	private WebDriver intializationDriver() throws IOException {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\Ajay\\eclipse-workspace\\TravelSite\\src\\main\\java\\resource\\data.properties");
//		prop.load(fis);
//		String browserName = prop.getProperty("browser");
//		System.out.println(browserName);
//
//		if (browserName.equals("chrome")) {
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("--disable-notifications");
//
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ajay\\Documents\\chromedriver.exe");
//
//			driver = new ChromeDriver(option);
//
//		}
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		return driver;
//	}
	
//	@BeforeTest
//	public void initialize() throws IOException {
//		driver = intializationDriver();
//		//log.info("driver is initialised");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//	}
//	
//	@Test
//	public void test() {
//		driver.get("https://www.thrillophilia.com/tours/long-weekend-trek-to-alang-madan-kulang-the-toughest-trek-in-the-sahyadri");
//		getFinalCalender();
//	}
}
