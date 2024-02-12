package selenium.Automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	@Test
	public void Login () {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		
		String expectedResult = "Make Appointment";
		String actualResult = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")).getText();
		assertEquals(expectedResult, actualResult);
		
		driver.close();
	}
		@Test
	public void invalidLogin () {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		
		String expectedResult = "Login failed! Please ensure the username and password are valid.";
		String actualResult = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText();
		assertEquals(expectedResult, actualResult);
		
		driver.close();
	}
}

