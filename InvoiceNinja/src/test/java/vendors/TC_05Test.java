package vendors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import genericLibrary.BaseTest;
import genericLibrary.JavascriptExecutorUtil;
import genericLibrary.PropertyFileUtil;
import pomRepository.ExpensesPage;
import pomRepository.HomePage;

public class TC_05Test extends BaseTest {
@Test
@Parameters({"Vendorname","Category","Amount","Currency","Client","Publicnotes","Privatenotes","Paymenttype","Trasnsaction"})
public void  test(String Vendorname,String Category,String Amount,String Currency,String Client,String Publicnotes,String Privatenotes,String Paymenttype,String Transaction) {
	HomePage homepage=new HomePage(driver);
	ExpensesPage expensepage =new ExpensesPage(driver);
	JavascriptExecutorUtil jscript=new JavascriptExecutorUtil(driver);
	
	homepage.getSearchBox().sendKeys("Expenses",Keys.ENTER);
	Assert.assertEquals("Expenses | Invoice Ninja", driver.getTitle());
	Reporter.log("Expense page is displayed",true);

	homepage.getEnterExpenses().click();
	Assert.assertEquals("Enter Expense | Invoice Ninja", driver.getTitle());
	Reporter.log("Expense Create page is displayed",true);

	expensepage.getVendor().sendKeys("ff",Keys.ENTER);
	expensepage.getCategory().sendKeys("acx",Keys.ENTER);
	expensepage.getAmount().sendKeys("451241",Keys.ENTER);
	expensepage.getCurrency().clear();
	expensepage.getCurrency().sendKeys("Albanian Lek",Keys.ENTER);
	expensepage.getClient().sendKeys("priya",Keys.ENTER);
	expensepage.getPublicnotes().sendKeys("This is a task");
	expensepage.getPrivatenotes().sendKeys("This is a book");

	expensepage.getMarkpaid().click();
	expensepage.getPaymentType().sendKeys("credit",Keys.ENTER);
	expensepage.getTransaction_reference().sendKeys("123",Keys.ENTER);
	expensepage.getSavebutton().click();
	Assert.assertEquals("Edit Expense | Invoice Ninja", driver.getTitle());
	Reporter.log("Expense  page is created",true);
}
}


