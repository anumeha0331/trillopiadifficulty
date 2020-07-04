package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
public WebDriver driver;

By email= By.xpath("//input[@id='consumer_email']");
//By email= By.cssSelector("#consumer_email");
By pass= By.xpath("//input[@id='consumer_password']");
By forgotpass = By.xpath("//a[contains(text(),'Forgot your password?')]");
By logIn= By.xpath("//input[@name='commit']");

public LogInPage(WebDriver driver) {
	this.driver=driver;
}

public WebElement emailId()
{
	return driver.findElement(email);
}

public WebElement password()
{
	return driver.findElement(pass);
}

public WebElement forgetpassword()
{
	return driver.findElement(forgotpass);
}

public WebElement getlogIn()
{
	return driver.findElement(logIn);
}
}
