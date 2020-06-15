package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CommonUtils {

	static WebDriver driver ;

	public CommonUtils(WebDriver driver2) {
		CommonUtils.driver = driver2;
	}
	 

	   public static void waitForPageLoad() {
		    ExpectedCondition<Boolean> expectation = new   ExpectedCondition<Boolean>() {
		                public Boolean apply(WebDriver driver) {
		                    return (((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete")&&((Boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active == 0")));
		                }
		            };
		    
	   }
}
