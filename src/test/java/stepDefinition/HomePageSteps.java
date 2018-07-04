package stepDefinition;



import pageObjects.HomePage;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {
	
	TestContext testContext;
	HomePage home ;

	public HomePageSteps(TestContext context){
		testContext=context;
		home=testContext.getPageObjectManager().getHomePage();
		
		
	}
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	
		 home.navigateTo_HomePage();
		
	}
 
	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product)  {
		
		home.perform_Search(product);
	

}
	
	
}
