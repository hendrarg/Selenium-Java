package selenium.Automation;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

 class MakeAppointment extends BaseLogin {
		@Test
		public void inputValidAppointment () {
			
			//for loop 3x
			for (int i=0; i<3; i++) {
			//setup random drop down
			WebElement facilitysDropdown = driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"));
			Select facility = new Select(facilitysDropdown);
			int dropdownValueCount = driver.findElements(By.tagName("option")).size();
			Random randomFacilitys = new Random();
			int indexFacilitys = randomFacilitys.nextInt(dropdownValueCount);
			facility.selectByIndex(indexFacilitys);
			
			driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
			
			//setup random radio button
			List<WebElement> option = driver.findElements(By.xpath("(//*[@class=\"radio-inline\"])"));
			Random random = new Random();
			int index = random.nextInt(option.size());
			option.get(index).click();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");
			Date date = new Date();
			String dateNow = dateFormat.format(date);
			
			driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys(dateNow);
			driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Test" + dateNow);
			driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
			
			String expectedResult = "Appointment Confirmation";
			String actualResult = driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[1]/h2")).getText();
			assertEquals(expectedResult, actualResult);
			
			System.out.println("facility : " + driver.findElement(By.xpath("//*[@id=\"facility\"]")).getText());
			System.out.println("Healthcare Program : " + driver.findElement(By.xpath("//*[@id=\"program\"]")).getText());
			
			driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a")).click();
			}
		}

}
