package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

		public class Homepage extends basepage{
			public Homepage(WebDriver driver)

		{
		
			super(driver);
		}
		
	@FindBy(xpath="//span[text()='My Account']")
		WebElement linkMyaccount;
	
    @FindBy(xpath="//a[text()='Register']")
    WebElement linkRegister;
    
    @FindBy(xpath="//a[text()='Login']")
    WebElement linkLogin;
    
    
    
    
    public void clickMyAccount()
    {
    	linkMyaccount.click();	
	}
    public void clickRegister()
    {
    	linkRegister.click();
    }
    public void clickLogin()
    {
    	linkLogin.click();
    }
		}
	
		
