package vendors;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import genericLibrary.JavascriptExecutorUtil;
import pomRepository.ExpensePage;
import pomRepository.ExpensesPage;
import pomRepository.HomePage;
/**
 * 
 * @author Sukanya
 *
 */
	public class TC_02Test extends BaseTest{
		@Test
		public void newExpense() {
		HomePage homepage=new HomePage(driver);
		ExpensesPage expensepage =new ExpensesPage(driver);
		JavascriptExecutorUtil jscript=new JavascriptExecutorUtil(driver);
	
		
			homepage.getSearchBox().sendKeys("List Expenses",Keys.ENTER);
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
		}
	
	
	}
	
	
	
			
		