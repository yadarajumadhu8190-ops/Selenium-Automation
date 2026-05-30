package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Myaccountpage;
import testbase.BaseClass;
import utilities.DataProviders;


	//data is valid --login success- test pass--logout
	//Data is valid --login failed--test fail
	//Data is invalid -- login success --test fail--logout
	//Data is invalid --login failed--test pass
public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")

	public void verify_loginDDT(String email,String pwd, String exp) {
		logger.info("****stating Tc003_login DDT****");
		try {
	Homepage hp=new  Homepage(driver); 
	hp.clickMyAccount();
	hp.clickLogin();
	
Loginpage lp=new Loginpage(driver);		
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin(); 
	
	//My Account
	Myaccountpage macc =new Myaccountpage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	//data is valid --login success- test pass--logout
	//Data is valid --login failed--test fail
	//Data is invalid -- login success --test fail--logout
	//Data is invalid --login failed--test pass

	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetPage=true)
		{
			macc.clicklogout();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
			
		}
		if (exp.equalsIgnoreCase("Invalid"))
				{
			if(targetPage=true)
			{
				macc.clicklogout();
				Assert.assertTrue(false);
				
			}
			else
			{
			Assert.assertTrue(true);	
			}
			
				}
	}
		}
	catch(Exception e)
		
	{
		Assert.fail();
	}
		
	
	logger.info("****Finished Tc003_login DDT****");

	
	
		
	
}
}


