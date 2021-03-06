package config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentITestListenerClassAdapter;
import pages.BasePage;


@Listeners({ ExtentITestListenerClassAdapter.class })
public class WebDriverConfig {
	public static WebDriver driver;
	public WebDriverWait wait;
	public static Properties p;

	@BeforeSuite
	public static void initialization() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		p=BasePage.getData();
	}
	
	@AfterSuite
	public void tearDown() {

		WebDriverConfig.driver.close();
		WebDriverConfig.driver.quit();
	}

}
