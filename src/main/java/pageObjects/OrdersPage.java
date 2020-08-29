package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	
	public WebDriver driver;
	
	

	@FindBy(css="span[class='accountholder']")
	private WebElement accountHolder;
	
	@FindBy(xpath="//div[@class='buyer-switcher']/span")
	private WebElement restaurant;
	
	@FindBy(xpath="//div[@class='add-supplier-box']")
	private WebElement addSupplier;
		
	
	public OrdersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	public WebElement getAccountHolder() {
		return accountHolder;
	}


	public WebElement getRestaurant() {
		return restaurant;
	}
	
	public WebElement getAddSupplier() {
		return addSupplier;
	}




		
}
