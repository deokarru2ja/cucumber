
package runners;
import java.io.File;

import manager.FileReaderManager;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\functionalTests" ,
		glue = {"stepDefinition"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		
		)
public class TestRunner {
	
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfFileReader().getReportConfigPath()));
		Reporter.setSystemInfo("UserName", System.getProperty("user.name"));
		Reporter.setSystemInfo("TimeZone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("OS", "Windows 7 64 bit");
		
	
	
	
	}
}
	

