package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends basepage {
	public Loginpage(WebDriver driver)

	{
	
		super(driver);
	}
	
@FindBy(xpath="//input[@name='email']")
	WebElement linkEmail;

@FindBy(xpath="//input[@name='password']")
WebElement linkpassword;

@FindBy(xpath="//input[@value='login']")
WebElement linkLogin;




public void setEmail(String email)
{
	linkEmail.click();	
}
public void setPassword(String Password)
{
	linkpassword.click();
}
public void clickLogin()
{
	linkLogin.click();
}


}
