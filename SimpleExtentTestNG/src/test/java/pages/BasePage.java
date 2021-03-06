package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.Uninterruptibles;

import config.WebDriverConfig;

public class BasePage {
	
	public static WebDriverWait wait = new WebDriverWait(WebDriverConfig.driver,10);
	protected static JavascriptExecutor js= (JavascriptExecutor) WebDriverConfig.driver;
	public Faker faker = new Faker();
	
	 public static Properties getData()
	    {
	        Properties properties=null;
	        String propFileName = "src/test/resources/Configuration/config.properties";

	        try
	        {
	            FileInputStream inputStream = new FileInputStream(new File(propFileName));
	            properties = new Properties();
	            if (inputStream != null)
	            {
	                properties.load(inputStream);
	                inputStream.close();
	            }
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return properties;
	    }
	 
	 public String randomEmailGenerator()
		{
			Random randomGenerator = new Random();  
			int randomInt = randomGenerator.nextInt(1000);  
			return "username"+ randomInt +"@gmail.com";  
		}
	 
	 public static WebElement getElement(final WebElement element) {
			final long startTime = System.currentTimeMillis();
			boolean found = false;
			WebElement we = null;
			while ((System.currentTimeMillis() - startTime) < 20000) {
				try {
					we = wait.until(ExpectedConditions.visibilityOf(element));
					we = wait.until(ExpectedConditions.elementToBeClickable(element));
					found = true;
					break;
				} catch (TimeoutException e) {
					Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
				}
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			if (found) {
				// Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
			} else {
				Assert.fail("Element not found" + element + " it took " + totalTime + " milliseconds");
			}
			return we;
		}
	 
	 public void sendKeys(WebElement element, String text) {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);
		}
	 
	 public void click(WebElement element) {
		 wait.until(ExpectedConditions.elementToBeClickable(element));
			js.executeScript("arguments[0].click()", element);
		}
}
