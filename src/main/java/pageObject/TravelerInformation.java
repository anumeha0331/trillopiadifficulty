package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelerInformation {
	public WebDriver driver;
	By name = By.xpath("//input[@id='booking_name']");
	By email = By.xpath("//input[@id='booking_email']");
	By phoneNumb = By.xpath("//input[@id='booking_phone']");
	
	By ContinueBttn = By.cssSelector("div.varient:nth-child(8) div.container div.col-md-8.col-md-offset-2.info_block_full_width form.simple_form.edit_booking div.info_block.contact-information-block:nth-child(3) div.block.block-top.visible div.form div.button-submit-contact-information.button:nth-child(4) > input.btn.next_step.btn_req");
	public TravelerInformation(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getName() {
		
		return driver.findElement(name);
	}
public WebElement getEmail() {
		
		return driver.findElement(email);
	}
public WebElement getPhnNumb() {
	
	return driver.findElement(phoneNumb);
}
/*public WebElement getContButton() {
	
	return driver.findElement(ContinueBttn);
}*/
public Confirm getConfirmPage() {
	try {
		driver.findElement(ContinueBttn).click();
		//Confirm cfm= new Confirm(driver);
	//return cfm;
	  } catch (Exception e) {
	     JavascriptExecutor executor = (JavascriptExecutor) driver;
	     executor.executeScript("arguments[0].click();", driver.findElement(ContinueBttn));
	  }
	Confirm cfm= new Confirm(driver);
	return cfm;
	
}
}
