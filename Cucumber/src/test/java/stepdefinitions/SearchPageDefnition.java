package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TestContext;

public class SearchPageDefnition 
{
	public String searchPageProductName;
	public String offerPageProductName;
	public TestContext session;
	
	
	public SearchPageDefnition(TestContext testContext)
	{
		this.session = testContext;
	}
	
	@Given("User is on the greenkart landing page")
	public void user_is_on_the_greenkart_landing_page() 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		this.session.driver = new ChromeDriver(chromeOptions); // life = testcontext driver
		this.session.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		this.session.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("User searched with shortname {string} and extract full name of the product")
	public void user_searched_with_shortname_and_extract_full_name_of_the_product(String string) throws InterruptedException
	{
		this.session.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(string);
	   Thread.sleep(2000);
	   this.session.searchPageProductName = this.session.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	   Thread.sleep(2000);
	}
	//life
}
