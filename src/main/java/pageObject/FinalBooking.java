package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalBooking {
	public WebDriver driver;
	By calender= By.xpath("//input[@placeholder='Choose your date']");
	//By calender= By.xpath("//div[@id='tourSidebar']//div[8]");
	By booknowButton= By.xpath("//input[@id='book-now-button']");
	By form = By.xpath("//form[@id='booking_form']");
	public FinalBooking(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getFinalCalender()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.findElement(calender);
	}

	public WebElement getForm()
	{
		return driver.findElement(form);
	}
	public WebElement getBookNowButton()
	{
		return driver.findElement(booknowButton);
	}
	
}
