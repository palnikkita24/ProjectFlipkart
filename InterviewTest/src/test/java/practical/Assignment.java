package practical;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment {
public static void main(String args[]) throws InterruptedException {
WebDriver driver;
String path = System.getProperty("user.dir");
String driverpath = path + "\\Driver\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver", driverpath);
driver = new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.findElement(By.cssSelector("button._2AkmmA._29YdH8")).click();
Actions actions = new Actions(driver);
   WebElement moveonmenu = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
WebElement subcategory = driver.findElement(By.xpath("//a[@title='Window ACs']"));
Thread.sleep(2000);
actions.moveToElement(moveonmenu).build().perform();
Thread.sleep(2000);
actions.moveToElement(subcategory).click().perform();
Thread.sleep(2000);
List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='_1UoZlX']/following::span[contains(text(),'Add to Compare')]"));
checkbox.get(1).click();
checkbox.get(2).click();
driver.findElement(By.xpath("//span[contains(text(),'COMPARE')]")).click();
Thread.sleep(2000);
WebElement chooseBrand = driver.findElement(By.xpath("(//div[text()='Choose Brand'])[1]"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", chooseBrand);
Thread.sleep(2000);
WebElement fromelement = driver.findElement(By.xpath("//div[@class='_3ozNsv']"));
WebElement toelement = driver.findElement(By.xpath("(//div[@class='_3ozNsv']//following-sibling::div[text()='Samsung'])[1]"));
Actions action = new Actions(driver);
action.dragAndDrop(fromelement, toelement).click().build().perform();
Thread.sleep(2000);
WebElement chooseProduct = driver.findElement(By.xpath("(//div[text()='Choose a Product'])[1]"));
JavascriptExecutor executor1 = (JavascriptExecutor)driver;
executor1.executeScript("arguments[0].click();", chooseProduct);
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='_3ozNsv']//following-sibling::div[contains(text(),'Split Triple Inverter Dura Series')])[1]")).click();
WebElement product1 = driver.findElement(By.xpath("(//a[@class='_3YNWH1'])[1]"));
System.out.println(product1.getText());
WebElement product2 = driver.findElement(By.xpath("(//a[@class='_3YNWH1'])[2]"));
System.out.println(product2.getText());
WebElement product3 = driver.findElement(By.xpath("(//a[@class='_3YNWH1'])[3]"));
System.out.println(product3.getText());
WebElement price1 = driver.findElement(By.xpath("(//div[@class='_1vC4OE'])[1]"));
System.out.println(price1.getText());
WebElement price2 = driver.findElement(By.xpath("(//div[@class='_1vC4OE'])[2]"));
System.out.println(price2.getText());
WebElement price3 = driver.findElement(By.xpath("(//div[@class='_1vC4OE'])[3]"));
System.out.println(price3.getText());
//driver.findElement(By.xpath("(//button[text()='BUY NOW'])[1]")).click();
//driver.findElement(By.xpath("(//button[text()='BUY NOW'])[2]")).click();
//driver.findElement(By.xpath("(//button[text()='BUY NOW'])[3]")).click();
Thread.sleep(2000);
driver.close();
}
}