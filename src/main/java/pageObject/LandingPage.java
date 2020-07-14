package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;

	By sigIn = By.xpath("//span[contains(text(),'Log')]");
	By title = By.xpath("//h1[@class='intro-heading__caption']");
	By header = By.xpath("//div[@class='intro-heading__title']");
	By Adventuretab = By.xpath("//a[contains(text(),'Adventure Excursions')]");
	By weekendtab = By.xpath("//a[contains(text(),'Weekend Experiences')]");
	By toursAndTraveltab = By.xpath("//a[contains(text(),'Tours and Activities')]");
	By allTab = By.xpath("//body//div[@id='home-banner-search']//div//button[1]");
	By activitiesTab = By.xpath("//body//button[2]");
	By toursTab = By.xpath("//body//button[3]");
	By rentalsTab = By.xpath("//body//button[4]");
	By stacationsTab = By.xpath("//body//button[5]");
	By searchTab = By
			.xpath("//div[@id='home-banner-search']//input[@placeholder='Search Destinations, Tours, Activities']");
	By puneTour = By.xpath("//div[contains(text(),'Tours in')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getlogIn() {
		return driver.findElement(sigIn);
	}

	public WebElement getallTab() {
		return driver.findElement(allTab);
	}

	public WebElement getsearchTab() {
		return driver.findElement(searchTab);
	}

	public BookingPage getBookingPage() {
		driver.findElement(puneTour).click();
		BookingPage bk = new BookingPage(driver);
		return bk;

	}
}
