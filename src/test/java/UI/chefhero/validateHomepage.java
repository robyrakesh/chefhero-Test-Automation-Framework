package UI.chefhero;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Dropdowns;
import pageObjects.HomePage;
import resources.base;

public class validateHomepage extends base {
	public WebDriver driver;
	HomePage h;
	
	
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver= initializeDriver();		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@Test
	public void validateNavBarItems() {
		 h= new HomePage(driver);
		Assert.assertTrue(h.getNavHome().isDisplayed());
		//System.out.println(h.getNavHome().getText());
		Assert.assertTrue(h.getNavBlog().isDisplayed());		
		//System.out.println(h.getNavBlog().getText());
		Assert.assertTrue(h.getNavSuppliers().isDisplayed());		
		//System.out.println(h.getNavSuppliers().getText());
		Assert.assertTrue(h.getNavAbout().isDisplayed());		
		Assert.assertTrue(h.getNavPricing().isDisplayed());		
		Assert.assertTrue(h.getNavContact().isDisplayed());		
		Assert.assertTrue(h.getNavDownload().isDisplayed());		
		Assert.assertTrue(h.getTitle().isDisplayed());
		
		
	}
	
	@Test
	public void validateDropdownCount() {
		Dropdowns d= new Dropdowns(driver);
		
		Assert.assertEquals(d.getSuppliersCount(), 10);		
		Assert.assertEquals(d.getAboutCount(), 3);		
		Assert.assertEquals(d.getDownloadCount(), 2);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}
	
	
}
