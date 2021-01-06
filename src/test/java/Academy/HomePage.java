package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");

	}
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{

		//one is inheritance

		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		log.info("Url is launched");
		LandingPage l=new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		LoginPage lp=l.getLogin(); //driver.findElement(By.css()
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);
		
		lp.getLogin().click();
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().clear();
		fp.getEmail().sendKeys("Taipaicai");
		fp.sendMeInstructions().click();
		log.info("Send me Instraction is clicked");
		
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";
		
		return data;
		
	}

}
