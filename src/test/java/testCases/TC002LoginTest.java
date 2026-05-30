package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.BaseClass;

public class TC002LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	
	public void verify_login()
	{
		logger.info("***Starting TC_002_LoginTest***");
		//login
		try {
		Homepage hp=new Homepage(driver); 
		hp.clickMyAccount();
		hp.clickLogin();
		
    Loginpage lp=new Loginpage(driver);		
		lp.setEmail(p.getProperty("Email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account
		Myaccountpage macc=new Myaccountpage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();   
		}
		logger.info("***Finished TC002Logintest****");
	
		
	 
	
	}
}
