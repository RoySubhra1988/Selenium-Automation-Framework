package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");

//Users/subhraroy/eclipse-workspace/E2EProject/src/main/java/resources/data.properties

prop.load(fis);
//String browserName=prop.getProperty("browser");

String browserName=System.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDriver//chromedriver");
	  ChromeOptions options = new ChromeOptions();
	  
	  options.addArguments("--headless");
	 
	driver= new ChromeDriver(options);
	
	
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//BrowserDriver//geckodriver");
	 driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("edge"))
{
	System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"//BrowserDriver//msedgedriver");

    driver = new EdgeDriver();
}else {
	System.out.println("Fix the Browser Name");
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"/ExtentReports/"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;


}

}
