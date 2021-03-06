package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import config.WebDriverConfig;
import pages.GalacasinoPage;

public class GamesRegistrationTest extends WebDriverConfig{
	
	
	
	@Test(priority = 0)
	public void searchForWebsitePassingTest() {
		GalacasinoPage galacasinoPage= new GalacasinoPage();
		driver.get(p.getProperty("galacasino"));
		//galacasinoPage.clickOnSignUpBtn();
		galacasinoPage.enterDetailsOnFirstPage();
		galacasinoPage.enterDetailsOnSecondPage();
		galacasinoPage.enterDetailsOnThirdPage();
		
	}
	
	
}
