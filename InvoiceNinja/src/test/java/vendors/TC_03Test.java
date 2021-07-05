package vendors;


import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericLibrary.BaseTest;
/**
 * 
 * @author Sukanya
 *
 */
public class TC_03Test extends BaseTest {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.invoiceninja.com/login");
		driver.findElement(By.id("email")).sendKeys("sumanth.l@testyantra.com");
		driver.findElement(By.id("password")).sendKeys("admin@123");
		driver.findElement(By.id("loginButton")).click();
	
		driver.findElement(By.id("search")).sendKeys("List Expenses",Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Enter Expense ']")).click();
		
		System.out.println(driver.getTitle());
		driver.findElement(By.id("vendor_name")).sendKeys("arun",Keys.ENTER);
		driver.findElement(By.id("expense_category_name")).sendKeys("ab",Keys.ENTER);
		driver.findElement(By.id("amount")).sendKeys("300",Keys.ENTER);
		WebElement currency = driver.findElement(By.xpath("//input[@placeholder='US Dollar']"));
		currency.clear();
	/*	Select select=new Select(currency);
		select.deselectByVisibleText("Algerian Dinar");*/
	//	driver.findElement(By.xpath("//input[@placeholder='US Dollar']")).sendKeys("Albanian Lek",Keys.ENTER);
		driver.findElement(By.xpath("//label[text()='Client']/..//input[@autocomplete='off'] ")).sendKeys("priya",Keys.ENTER);
		driver.findElement(By.id("public_notes")).sendKeys("This is the task");
		driver.findElement(By.id("private_notes")).sendKeys("This is the expenses");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1400)");
		driver.findElement(By.xpath("//label[text()='Mark billable']")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println(driver.getTitle());


	}
}



