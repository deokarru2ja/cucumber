package pageObjects;


 
import manager.FileReaderManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfFileReader;
 
public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(FileReaderManager.getInstance().getConfFileReader().getUrl()+"/?s=" + search + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfFileReader().getUrl());
	}
 
}