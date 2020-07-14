package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class packageDetails {
	public WebDriver driver;
	By proceed = By.xpath("//a[@name='variant_selection_done']");
	public packageDetails(WebDriver driver) {
		this.driver = driver;
	}
	/*public WebElement getProceedButton() {
		
		return driver.findElement(proceed);
	}*/
	public TravelerInformation getTravelerInfoPage()
	{
		driver.findElement(proceed).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		TravelerInformation TInfo=new TravelerInformation(driver);
		return TInfo;
	}
}
