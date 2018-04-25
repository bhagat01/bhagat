package crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amazon {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void hpLaptop (String browserName) {
		if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		
	}
	@Test
	public void hp() {
		driver.get("http://www.amazon.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hp spectre");
		driver.findElement(By.className("nav-input")).click();
		System.out.println(driver.getTitle());
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
