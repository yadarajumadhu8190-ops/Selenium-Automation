package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class AccountRegistrationPage extends basepage{
		public AccountRegistrationPage (WebDriver driver)
		{
		
			super(driver);
		}
		
	    @FindBy(name = "firstname")
	    WebElement txtfirstName;

	    @FindBy(name = "lastname")
	    WebElement txtlastName;

	    @FindBy(name = "email")
	    WebElement txtemail;

	    @FindBy(name = "telephone")
	    WebElement txttelephone;

	    @FindBy(name = "password")
	    WebElement txtpassword;

	    @FindBy(name = "confirm")
	    WebElement txtconfirmPassword;

	    @FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	    WebElement newsletterNo;

	    @FindBy(name = "agree")
	    WebElement privacyPolicy;

	    @FindBy(xpath = "//input[@value='Continue']")
	    WebElement continueBtn;
	    
	    @FindBy(xpath="yourxpath")
	    WebElement msgConfirmation;
	    
	    public void enterFirstName(String fname) {
	        txtfirstName.sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	       txtlastName.sendKeys(lname);
	    }

	    public void enterEmail(String mail) {
	        txtemail.sendKeys(mail);
	    }

	    public void enterTelephone(String phone) {
	        txttelephone.sendKeys(phone);
	    }

	    public void enterPassword(String pwd) {
	        txtpassword.sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String cpwd) {
	        txtconfirmPassword.sendKeys(cpwd);
	    }
	   
	    
	    public String getConfirmationMsg() {
	    	try {
	    		return (msgConfirmation.getText());
	    	} catch (Exception e) {
	    		return (e.getMessage());
	    	}
	    }
	
	}

	  
	

	


