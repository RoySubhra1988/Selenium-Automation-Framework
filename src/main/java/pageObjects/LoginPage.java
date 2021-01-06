package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
	
@FindBy(css="[id='user_email']")
private WebElement email;
	
@FindBy(css="[type='password']")
private WebElement pass;

@FindBy(css="[value='Log In']")
private WebElement login;
	
@FindBy(css="[href*='password/new']")
private WebElement forgotPassword;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getEmail()
	{
		
		return email;
	}
	

	public WebElement getPassword()
	{
		return pass;
	}
	
	public WebElement getLogin()
	{
		return login;
	}

public ForgotPassword forgotPassword()
{
	forgotPassword.click();
	return  new ForgotPassword(driver);
	
}

}
