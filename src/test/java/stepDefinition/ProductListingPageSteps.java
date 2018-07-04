package stepDefinition;

import pageObjects.ProductListingPage;
import cucumber.TestContext;
import cucumber.api.java.en.When;

public class ProductListingPageSteps {
	TestContext testContext;
	ProductListingPage productListingPage;
	
	public ProductListingPageSteps(TestContext context){
		
		testContext=context;
		productListingPage=testContext.getPageObjectManager().getProductListingPage();
		
	}
	
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() {
		 
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();		
	}
 

}
