package testPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import utils.CommonUtils;




public class HomePages {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@title='Search']")
	private WebElement searchTextBox;

	@FindBy(how = How.XPATH, using = ".//a[@class='dropdown-toggle'][contains(text(),'My Home')]")
	private WebElement MyHomeTab;
	


	public void searchFlipkart() throws InterruptedException {
		searchTextBox.sendKeys("Flipkart");
		Thread.sleep(3000);	
		List<WebElement> listOfOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li/div/div/div/span"));
		for(WebElement listOfOption :listOfOptions ){
		Thread.sleep(3000);
		System.out.println(listOfOption.getText());
		}
	}
	
	public void navigateToFilpkart() {
		searchTextBox.submit();
		driver.findElement(By.xpath("//h3[contains(text(),'Flipkart')]")).click();
	}
	
	public void closePopUp() {
		driver.findElement(By.cssSelector("button._2AkmmA._29YdH8")).click();
	}
	
	public void selectProduct() throws InterruptedException {
		Actions actions = new Actions(driver);
	      WebElement moveonmenu = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		  WebElement subcategory = driver.findElement(By.xpath("//a[@title='Window ACs']"));
		  Thread.sleep(2000);		 
		  actions.moveToElement(moveonmenu).build().perform();
		  Thread.sleep(2000);		
		  actions.moveToElement(subcategory).click().perform();
			Thread.sleep(2000);	
	} 
	
	public void selectAddToComapare() throws InterruptedException {
	
		List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='_1UoZlX']/following::span[contains(text(),'Add to Compare')]"));
		checkbox.get(1).click();
		checkbox.get(2).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'COMPARE')]")).click();
		Thread.sleep(2000);
	}
	
	public void addThirdProduct() throws InterruptedException {
	
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement textfield = driver.findElement(By.xpath("//div[@class='_3092M2 LykW5d']"));
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='_3ozNsv']"));
        action.moveToElement(textfield);
        action.click();
        action.sendKeys("Samsung");
        Thread.sleep(2000);
        action.moveToElement(dropdown).click().build().perform();
        
        Thread.sleep(2000);
        
        WebElement chooseProduct = driver.findElement(By.xpath("(//div[text()='Choose a Product'])[1]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", chooseProduct);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='_3ozNsv']//following-sibling::div[contains(text(),'Split Triple Inverter Dura Series')])[1]")).click();
	}
	
	public void getProductName() {
		List<WebElement> productname=driver.findElements(By.xpath(".//a[@class='_3YNWH1']"));
		List<WebElement> productprice=driver.findElements(By.xpath(".//div[@class='_1vC4OE']"));
		for(WebElement productnamelist :productname ){
			System.out.println(productnamelist.getText());
			}
		for(WebElement productpricelist :productprice ){
			System.out.println(productpricelist.getText());
			}
	}
	
	public void addProductToCart() throws InterruptedException {
		List<WebElement> addCart=	driver.findElements(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU']"));
		addCart.get(0).click();

		Thread.sleep(2000);
		 ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
		Thread.sleep(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2300)", "");
		Thread.sleep(2000);
       WebElement ele = driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK e1kKGU']/following::div/button"));
		
        ele.click();
       Thread.sleep(2000);
		}

	public void checkAvailablitlityOfProduct() throws InterruptedException {
	
	driver.findElement(By.xpath("//input[@placeholder='Enter delivery pincode']")).sendKeys("380009");
	driver.findElement(By.xpath("//span[@class='_2m9c-p']")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='bzD9az']")).isDisplayed());
	String deliveryOption = driver.findElement(By.xpath("//div[@class='bzD9az']")).getText();
    System.out.println("delivery massage:"+deliveryOption);;
	}

	public HomePages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

}
