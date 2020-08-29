package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IOS {
	
public WebDriver driver;
	
	@FindBy(css=".we-customer-ratings__averages__display")
	private WebElement Ratings;
	
	@FindBy(css=".we-localnav__title__product")
	private WebElement apple;



	public WebElement getApple() {
		return apple;
	}


	public IOS(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getRatings() {
	return Ratings;
	}
	
	
	

}
