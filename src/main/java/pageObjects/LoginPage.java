package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	

	@FindBy(css="input[name='email']")
	private WebElement email;
	
	
	@FindBy(css="input[name='password']")
	private WebElement password;
	
	@FindBy(css="button[class='btn btn-primary next-step-button']")
	private WebElement submit;
	
	@FindBy(xpath="(//div[@class='signin']/a)[1]")
	private WebElement forgotPass;
	
	@FindBy(xpath="(//div[@class='signin']/a)[2]")
	private WebElement createAccount;
	

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public OrdersPage getSubmit() {
		submit.click();
		OrdersPage o= new OrdersPage(driver);
		return o;
	}

	public WebElement getForgotPass() {
		return forgotPass;
	}

	public WebElement getCreateAccount() {
		return createAccount;
	}
}
