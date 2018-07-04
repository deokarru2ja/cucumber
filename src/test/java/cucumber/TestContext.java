package cucumber;

import manager.DriverManager;
import manager.PageObjectManager;

public class TestContext {

	private DriverManager driverManager;
	private PageObjectManager pageObjectManager ;
	
	
	
	public TestContext(){
		System.out.println("in test context constructor");
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		
	}
	
	
	public DriverManager getDriverManager(){
		
		System.out.println("in getDriverManager");
		
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager(){
		
		System.out.println("in getPageObjectManager");
		
		return pageObjectManager;
	}
}
