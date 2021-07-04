package vendors;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * @author Sukanya
 *
 */
public class TC_04Test {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.invoiceninja.com/login");
		driver.findElement(By.id("email")).sendKeys("sumanth.l@testyantra.com");
		driver.findElement(By.id("password")).sendKeys("admin@123");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("search")).sendKeys("List Expenses",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Enter Expense ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("vendor_name")).sendKeys("aa",Keys.ENTER);
		driver.findElement(By.id("expense_category_name")).sendKeys("ab",Keys.ENTER);
		driver.findElement(By.id("amount")).sendKeys("300",Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='US Dollar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='US Dollar']")).sendKeys("Albanian Lek",Keys.ENTER);
		LocalDateTime ldt = LocalDateTime.now();
		int DayOfMonth=ldt.getDayOfMonth();
		String monthName=ldt.getMonth().toString();
		int year=ldt.getYear();
		driver.findElement(By.id("payment_date")).click();
		driver.findElement(By.xpath("//th[text()='"+monthName+" "+year+"']")).click();
		driver.findElement(By.xpath("//td[text()='"+DayOfMonth+"']")).click();


		driver.findElement(By.xpath("//label[text()='Client']/..//input[@autocomplete='off'] ")).sendKeys("ans",Keys.ENTER);
		driver.findElement(By.id("public_notes")).sendKeys("This is the task");
		driver.findElement(By.id("private_notes")).sendKeys("This is the expenses");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1400)");
		driver.findElement(By.xpath("//label[text()='Mark paid']")).click();
		driver.findElement(By.xpath("//label[text()='Payment Type']/../..//input[@autocomplete='off']")).sendKeys("credit",Keys.ENTER);
		driver.findElement(By.id("transaction_reference")).sendKeys("123",Keys.ENTER);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}



