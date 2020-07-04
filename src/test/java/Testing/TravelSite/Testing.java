package Testing.TravelSite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import resource.Base;

public class Testing {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void login()
	{
		
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ajay\\Documents\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver(option);
		log.info("driver is initialised");
		driver.get("https://www.thrillophilia.com/tours/long-weekend-trek-to-alang-madan-kulang-the-toughest-trek-in-the-sahyadrin");
		log.info("driver Navigate to home page");
		
	
		/*driver.findElement(By.xpath("//input[@id='consumer_email']")).sendKeys("testng@gmail.com");
		driver.findElement(By.xpath("//input[@id='consumer_password']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		log.info("test data printed successfully");
		driver.close();
		log.info("browser is closed");*/
		driver.findElement(By.xpath("By.xpath(\"/html[1]/body[1]/div[4]/div[3]/div[1]/div[2]/div[1]/form[1]/div[8]/div[1]/div[1]/input[1]")).click();
	}
	
}
