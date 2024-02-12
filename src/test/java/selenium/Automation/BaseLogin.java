package selenium.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	
	WebDriver driver;
	String username = "John Doe";
	String password = "ThisIsNotAPassword";
	
	@BeforeMethod
	public void SetUp () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
	}
	
	@AfterMethod
	public void TeraDown() {
		driver.close();
	}

}
