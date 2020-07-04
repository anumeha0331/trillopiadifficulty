package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {
	public WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FinalBooking fb=new FinalBooking(driver);
		return fb;
	}
	
	public WebElement getFinalCalender()
	{
		return driver.findElement(calender);
	}
}