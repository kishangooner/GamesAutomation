package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.WebDriverConfig;

public class SearchPage {

	public SearchPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(WebDriverConfig.driver,this);
	}
	
	@FindBy(name="q")
	private WebElement searchTextBox;
	
	
	public void  assertFailureTest()
	{
		searchTextBox.sendKeys("Selenium\n");
		assertEquals(WebDriverConfig.driver.getTitle(), "Selenium - Google");
	}
	
	public void searchKeywordOnGoogle(String searchText)
	{
		searchTextBox.sendKeys(searchText);
	}
}
