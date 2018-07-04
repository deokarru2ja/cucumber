package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	TestContext testContext;

	
	public Hooks(TestContext context){
		
		testContext=context;
		
		
	}
	
	@Before
	public void BeforeScenario(Scenario scenario){
		
		if(scenario.getName().equalsIgnoreCase("Customer place an order by purchasing an item from search")){
			Reporter.assignAuthor("Hrutuja");
		}
		
//		Set up DB connection
		// launch driver
		//set up test data
		//browser cookies
		
	}
	@After(order=1)
	public void afterScenario(Scenario scenario){
		if(scenario.isFailed()){
			String screenShotName=scenario.getName().replace(" ","_");
			File sourcePath=((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
			
			
			File destinationPath=new File("A:/Workspace/CucumberFramework/CucumberFramework/target/cucumber-reports/screenshots/"+screenShotName +".png");
			
			try {
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	@After(order=0)
	public void afterScenario(){
		
		testContext.getDriverManager().getDriver().quit();
	}
}
