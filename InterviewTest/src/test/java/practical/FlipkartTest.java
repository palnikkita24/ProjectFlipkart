package practical;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testPages.HomePages;

public class FlipkartTest {
	
	WebDriver driver;
	
  @Test
  public void ComapreProductOnFilpkart() throws InterruptedException {
	  HomePages page = new HomePages(driver);
	  page.searchFlipkart();
	  page.navigateToFilpkart();
	  page.closePopUp();
	  page.selectProduct();
	  page.selectAddToComapare();
	  page.addThirdProduct();
	  page.getProductName();;
	  page.addProductToCart();
	  page.checkAvailablitlityOfProduct();
  }
  
  @BeforeTest
		@Parameters("browser")
		public void beforeTest(String browser) throws Exception{
	
	  if(browser.equalsIgnoreCase("firefox")){	
		  System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	
		else if(browser.equalsIgnoreCase("chrome")){	
			System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");				
			driver = new ChromeDriver();
		}	
		else{
		
			throw new Exception("Browser is not correct");
		}
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
