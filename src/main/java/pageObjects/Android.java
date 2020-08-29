package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Android {
	public WebDriver driver;
	
	
	@FindBy(css="div[class='BHMmbe'] ")
	private WebElement Ratings;



	public Android(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	public WebElement getRatings() {
		return Ratings;
	}

}
