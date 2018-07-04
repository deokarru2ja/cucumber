package manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;

public class DriverManager {
	
	private WebDriver driver;
	private DriverType browser;
	
	public DriverManager(){
		
				browser=FileReaderManager.getInstance().getConfFileReader().getBrowser();
	}
	
	public WebDriver getDriver()
	{
		if(driver==null) driver=createDriver();
		
		return driver;
		
	}
	private WebDriver createDriver() {
        switch (browser) {	    
        case FIREFOX : 
        	System.setProperty("webdriver.gecko.driver", FileReaderManager.getInstance().getConfFileReader().getDriverPath(browser));
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfFileReader().getDriverPath(browser));
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : 
        	driver = new InternetExplorerDriver();
    		break;
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
	
	
}
