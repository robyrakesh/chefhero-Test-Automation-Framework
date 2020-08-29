package UI.chefhero;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrdersPage;
import resources.base;

public class validateLoginPage extends base {
	
	public WebDriver driver;
	HomePage h;
	
	
	
	
	
	
	@Test(dataProvider="getData")
	public void validatelogin(String username, String pass) throws IOException, InterruptedException {
			driver= initializeDriver();			
			driver.get(prop.getProperty("url"));		
			 h= new HomePage(driver);
			
		LoginPage p=h.getLogin();
		Thread.sleep(2000);
		p.getEmail().sendKeys(username);
		p.getPassword().sendKeys(pass);
		OrdersPage o = p.getSubmit();
		Assert.assertTrue(o.getAddSupplier().isDisplayed());
		System.out.println(o.getAddSupplier().isDisplayed());
		System.out.println(o.getAccountHolder().getText());
			
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	
	

	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][2];
		
		data[0][0]= "rakeshroby@yahoo.com";
		data[0][1]= "tokyorty123@";
		
		
		data[1][0]= "robyrakesh1@gmail.com";
		data[1][1]= "tokyorty123@";
		
		
		return data;
		
	}

}
