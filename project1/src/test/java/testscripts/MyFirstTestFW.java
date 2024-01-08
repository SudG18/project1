package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;

public class MyFirstTestFW extends BaseTest {
		
		@Test(dataProviderClass=ReadXLSData.class, dataProvider="data")
		public static void simpleFormValidation(String msg,String a, String b) throws InterruptedException {
		driver.manage().window().maximize();
		driver.findElement(By.xpath(loc.getProperty("input_forms_link"))).click();
		driver.findElement(By.linkText(loc.getProperty("simple_form_demo"))).click();
		driver.findElement(By.id(loc.getProperty("enter_user_message"))).sendKeys(msg);
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("show_message"))).click();
		String text = driver.findElement(By.cssSelector(loc.getProperty("your_message"))).getText();
		Assert.assertEquals(text, msg);
		driver.findElement(By.id(loc.getProperty("value1"))).sendKeys(a);
		driver.findElement(By.id(loc.getProperty("value2"))).sendKeys(b);
		driver.findElement(By.xpath(loc.getProperty("get_total"))).click();
		String sum= driver.findElement(By.id(loc.getProperty("total_value"))).getText();
		System.out.println(sum);
		System.out.println("It is Done!");

		}
		
	/*
	 * @DataProvider(name="inputdata") public Object[]inputData(){ return new
	 * Object[][] { {"Creating FW!"}, {"Validating FW!"}, {"Finalized FW!"} }; }
	 */
	/*
	 * @DataProvider(name="testdata") public Object[][] testData(){ return new
	 * Object[][] { {"45","54"}, {"23","32"}, {"4","16"} }; }
	 */
}
