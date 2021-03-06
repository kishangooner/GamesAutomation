package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.WebDriverConfig;
import pages.SearchPage;

public class GoogleSearchPassingTestClass extends WebDriverConfig {
	SearchPage searchPage ;
	@BeforeMethod
	public void beforeTest()
	{
		searchPage = new SearchPage();
		driver.get("https://www.google.com/");
	}
	
	
	@Test(priority = 0,dataProvider = "searchData",dataProviderClass =dataprovider.SearchData.class)
	public void searchForWebsitePassingTest(String searchText) {

		searchPage.searchKeywordOnGoogle(searchText+"\n");
		assertEquals(WebDriverConfig.driver.getTitle(), searchText+" - Google Search");

	}
	
	@Test(priority = 1)
	public void searchForWebsiteFailingTest() {
		searchPage.assertFailureTest();
	}
}
