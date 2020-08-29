package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	public Properties prop;
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		
		
		 prop = new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName= System.getProperty("browser");
		//String browserName= prop.getProperty("browser");
		
		
		
		if(browserName.contains("chrome")) {
			
			ChromeOptions op = new ChromeOptions();
			String path = System.getProperty("user.dir") + "//src//main//java//resources//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			if(browserName.contains("headless"))
				op.addArguments("headless");
			 driver = new ChromeDriver(op);
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			String path = System.getProperty("user.dir") + "//src//main//java//resources//geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path);
			
			 driver = new FirefoxDriver();
			
		}
		
		else {
			System.out.println("Browser not available");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void wait(WebElement element) {
		
		WebDriverWait w = new WebDriverWait(driver, 15);
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void scroll(WebElement element, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void windowhandles(WebDriver driver) {
		
		Set<String> ids= driver.getWindowHandles();
		
		Iterator<String>it=ids.iterator();
		
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
	}
	
	public String getScreenshot(String test, WebDriver driver) throws IOException {
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+test+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(destinationFile));
		return destinationFile;
		
	}

}
