package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ForgotPassword {

	public  WebDriver driver;
	
	
	@FindBy(css="[id='user_email']")
	private WebElement email;
	
	
	@FindBy(css="input[value='Send Me Instruction']")
	private WebElement sendMeInstructions;
	
	
	public ForgotPassword(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getEmail()
	{
		return email;
	}
	
	public WebElement sendMeInstructions()
	{
		return sendMeInstructions;
	}
}
