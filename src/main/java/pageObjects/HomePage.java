package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="(//div[@class='Header-nav-inner']/a)[1]")
	private WebElement navHome;
	
	
	@FindBy(xpath="//div[@class='Header-nav-inner']/a[2]")
	private WebElement navBlog;
	
	@FindBy(xpath="(//div[@class='Header-nav-inner']/span/a)[1]")
	private WebElement navSuppliers;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder']/a)[2]")
	private WebElement navAbout;
	
	@FindBy(xpath="(//a[@class='Header-nav-item'])[3]")
	private WebElement navPricing;
	
	@FindBy(xpath="(//a[@class='Header-nav-item'])[4]")
	private WebElement navContact;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder']/a)[3]")
	private WebElement navDownload;
	
	@FindBy(xpath="(//div[@class='Header-nav-inner'])[2]")
	private WebElement login;
	
	
	@FindBy(xpath="//a[@class='Header-branding']")
	private WebElement title;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[2]/span/a[2]")
	private WebElement Careers;

	public WebElement getCareers() {
		return Careers;
	}

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getNavHome() {
		return navHome;
	}

	public WebElement getNavBlog() {
		return navBlog;
	}

	public WebElement getNavSuppliers() {
		return navSuppliers;
	}

	public WebElement getNavAbout() {
		return navAbout;
	}

	public WebElement getNavPricing() {
		return navPricing;
	}

	public WebElement getNavContact() {
		return navContact;
	}

	public WebElement getNavDownload() {
		return navDownload;
	}
	public LoginPage getLogin() {
		login.click();
		LoginPage p = new LoginPage(driver);
		return p;
	}

	public WebElement getTitle() {
		return title;
	}


	
	
	
	
	

}
