package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dropdowns {

	public WebDriver driver;
	
	

	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[1]/span")
	private WebElement SuppliersCount;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[2]/span")
	private WebElement AboutCount;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[3]/span")
	private WebElement DownloadCount;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[3]/a")
	private WebElement Download;
	
	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[3]/span/a[1]")
	private WebElement IOS;
	

	@FindBy(xpath="(//span[@class='Header-nav-item Header-nav-item--folder'])[3]/span/a[2]")
	private WebElement Android;
		
	
	public Dropdowns(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDownload() {
		return Download;
	}


	public int getSuppliersCount() {
		return SuppliersCount.findElements(By.tagName("a")).size();
	}

	public int getAboutCount() {
		return AboutCount.findElements(By.tagName("a")).size();
	}

	public int getDownloadCount() {
		return DownloadCount.findElements(By.tagName("a")).size();
	}
	
	public WebElement getIOS() {
		return IOS;
	}

	public WebElement getAndroid() {
		return Android;
	}

}
