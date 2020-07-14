package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

	public WebDriver driver;
	//By checkBox = By.xpath("//div[@id='bottom-block']//label[1]");
	
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
}
}
