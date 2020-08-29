package UI.chefhero;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Android;
import pageObjects.Dropdowns;
import pageObjects.HomePage;
import pageObjects.IOS;
import pageObjects.LoginPage;
import pageObjects.OrdersPage;
import resources.base;

public class validateUserReviews extends base {
	
	public WebDriver driver;
	HomePage h;
	Dropdowns d;
	Actions a;
	
	
	
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void validateIOSReview() throws InterruptedException, IOException{
		
			 d= new Dropdowns(driver);
			  a= new Actions(driver);
			a.moveToElement(d.getDownload());
			
			a.moveToElement(d.getIOS()).click().build().perform();
			IOS i= new IOS(driver);			
			windowhandles(driver);
			scroll(i.getRatings(), driver);
			Assert.assertEquals(i.getRatings().getText(), "5.0" );
				
		
	}

	@Test
	public void validateAndroidReview() throws IOException{
			
			d= new Dropdowns(driver);
			a= new Actions(driver);
			a.moveToElement(d.getDownload());
			a.moveToElement(d.getAndroid()).click().build().perform();
			Android an= new Android(driver);	
			windowhandles(driver);
			scroll(an.getRatings(), driver);
			Assert.assertEquals(an.getRatings().getText(), "4" );
			
			
				
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

	
	

}
