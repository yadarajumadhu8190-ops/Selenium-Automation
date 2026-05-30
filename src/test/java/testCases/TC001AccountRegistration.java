package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testbase.BaseClass;

public class TC001AccountRegistration extends BaseClass {
	public WebDriver driver;
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		Homepage hp=new Homepage(driver); 
		hp.clickMyAccount();
		hp.clickRegister(); 
		
		Account RegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.enterFirstName("Madhu");
		regpage.enterLastName("kumar");
		regpage.enterEmail("madhu@test.com");
		regpage.enterTelephone("9876543210");
		regpage.enterPassword("Test@123");
		regpage.enterConfirmPassword("Test@123");

  String cofmsg=regpage.getConfirmationMsg();
  
  Assert.assertEquals(cofmsg,"Your Account Has Been Created");
	}
	
}
