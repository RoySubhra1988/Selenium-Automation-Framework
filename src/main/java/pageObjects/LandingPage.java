package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class LandingPage {	
	
public WebDriver driver;

public static Logger log =LogManager.getLogger(Base.class.getName());
	
    @FindBy(xpath="//span[normalize-space()='Login']")
	private WebElement signin;
    
    @FindBy(css=".text-center>h2")
    private	WebElement title;
    
    @FindBy(css=".nav.navbar-nav.navbar-right>li>a")
  	private WebElement NavBar;
    
  
 
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public WebElement getNavigationBar()
	{
		log.info("NavBar is called");
		return NavBar;
	}
	public WebElement getTitle()
	{
		log.info("Title is called");
		return title;
	}
	

	public LoginPage getLogin() {
		signin.click();
		return  new LoginPage(driver);
		 
	}
	
	

}
