package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirm {
	public WebDriver driver;
	By checkBox = By.cssSelector("div.varient:nth-child(8) div.container div.col-md-8.col-md-offset-2.info_block_full_width div.info_block.info_block-bottom.visible div.row div.col-md-12 div.others.coupon-block div.terms > label.one:nth-child(2)");
	By AgreeBttn=By.xpath("//input[@id='js-proceed-payments']");
	public Confirm(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getCheckBox() {
		
		return driver.findElement(checkBox);
	}
	public PaymentPage getPaymentPage() {
		try {
			driver.findElement(AgreeBttn).click();
			
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(AgreeBttn));
		  }
		PaymentPage pp = new PaymentPage(driver);
		return pp;
		
	}
		
	}

