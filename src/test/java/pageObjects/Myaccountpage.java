package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends basepage {

	public Myaccountpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[text()='My Account']") //my account page heading
	WebElement msgheading;
	@FindBy(xpath="(//a[text()='Logout'])[1]")
	WebElement lnklogout;

	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

public void clicklogout()
{
	lnklogout.click();
}
}
