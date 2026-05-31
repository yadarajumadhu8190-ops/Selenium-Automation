package testbase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger; //log4j
	public Properties p;
	@BeforeClass (groups={"Sanity","Regression","Master","Datadriven"})
	@Parameters ({"os","browser"})
	 public void setup(String os, String br) throws IOException
	{  
		//loading conflict.properties file
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) 
		{
		case "Chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
        default : System.out.println("Invalid browser name.."); return;
		}
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().
	implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("app url1")); //reading url from properties 
	driver.manage().window().maximize();
	 
	}
@AfterClass (groups={"Sanity","Regression","Master","Datadriven"})
	public void teardown()
	{
		driver.quit();
	}

String randomeString()
{
	 String generatedString=RandomStringUtils.randomAlphabetic(5);
	 return generatedString;
}
public String randomeNumber()
{
String generatednumber=RandomStringUtils.randomNumeric(3);
return generatednumber;
}
public String randomeAlphaNumberic()
{
	 String generatedString=RandomStringUtils.randomAlphabetic(5);

String generatednumber=RandomStringUtils.randomNumeric(3);
return (generatedString+"@"+generatednumber);

}
public String captureScreen(String tname) throws IOException {
   // String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
TakesScreenshot takescreenshot=(TakesScreenshot) driver;
File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
String targetFilePath=System.getProperty("user,dir")+"\\screenshots\\"+tname+"_";
return targetFilePath;


}

	
}
