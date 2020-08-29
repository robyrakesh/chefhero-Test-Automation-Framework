package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Careers;
import pageObjects.HomePage;
import resources.base;

public class stepDefinition extends base {
	WebDriver driver;
	HomePage p;
	Actions a;
	Careers c;
	
	@Given("User is on chefhero landing page and naviagtes to Careers Page")
	public void user_is_on_chefhero_landing_page_and_naviagtes_to_careers_page() throws IOException {
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		 p= new HomePage(driver);
		 a = new Actions(driver);
		a.moveToElement(p.getNavAbout());
		a.moveToElement(p.getCareers()).click().build().perform();
	}

	@When("User clicks on QA Engineer Job Posting")
	public void user_clicks_on_qa_engineer_job_posting() {
		c=new Careers(driver);
	  c.getQAEngineer().click();
	  
	}

	@Then("Job duration should be {string}")
	public void job_duration_should_be(String string) {
	  Assert.assertEquals(string, c.getDuration().getText());
	}
	
	@Then("Close the browser")
	public void close_the_browser() {
	   driver.close();
	}
}
