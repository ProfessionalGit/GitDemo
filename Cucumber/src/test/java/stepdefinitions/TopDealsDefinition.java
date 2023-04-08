package stepdefinitions;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestContext;

public class TopDealsDefinition 
{
	
	public TestContext session;
	public TopDealsDefinition(TestContext testContext)
	{
		this.session = testContext;
	}
	
	@When("User clicks on top deals link")
	public void user_clicks_on_top_deals_link()
	{
		this.session.driver.findElement(By.linkText("Top Deals")).click();
	}

	@When("User search for the same shortname {string} in offers page to check if product exists")
	public void user_search_for_the_same_shortname_in_offers_page_to_check_if_product_exists(String string) throws InterruptedException
	{
		Thread.sleep(2000);
	   ArrayList<String> l = new ArrayList<String>( this.session.driver.getWindowHandles());
	   this.session.driver.switchTo().window(l.get(1));
	   this.session.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	   this.session.offerPageProductName =  this.session.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}

	@Then("User validate product name in offer page matches with search page")
	public void user_validate_product_name_in_offer_page_matches_with_search_page()
	{
	  assertEquals(this.session.searchPageProductName, this.session.offerPageProductName);
	}
	
}
