package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Careers {
	public WebDriver driver;
	

	@FindBy(linkText="QA Engineer")
	private WebElement QAEngineer;
	

	@FindBy(linkText="Product Designer (UI/UX)")
	private WebElement productDesigner;
	
	@FindBy(xpath="//div[@class='ATS-position-description']/p[2]")
	private WebElement duration;


	

	public WebElement getDuration() {
		return duration;
	}

	public Careers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getQAEngineer() {
		return QAEngineer;
	}

	public WebElement getProductDesigner() {
		return productDesigner;
	}
}
