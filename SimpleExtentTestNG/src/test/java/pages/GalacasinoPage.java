package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.util.concurrent.Uninterruptibles;

import config.WebDriverConfig;

public class GalacasinoPage extends BasePage{
	public GalacasinoPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(WebDriverConfig.driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Join Now')]")
	WebElement joinNowBtn;
	
	@FindBy(xpath="//button[@id='continue']")
	WebElement firstPagecontinueBtn;
	
	@FindBy(xpath="(//button[@id='continue'])[2]")
	WebElement secondPagecontinueBtn;
	
	@FindBy(name="addresscountrycode")
	WebElement addresscountrycodeSel;
	
	@FindBy(name="emailaddress")
	WebElement emailaddressTxt;
	

	@FindBy(id="focusPassword")
	WebElement passwordTxt;
	
	@FindBy(xpath="//label[@for='Male']")
	WebElement genderBtn;
	
	@FindBy(name="firstname")
	WebElement firstnameTxt;
	
	@FindBy(name="lastname")
	WebElement lastnameTxt;
	
	@FindBy(name="day")
	WebElement dayTxt;
	
	@FindBy(name="month")
	WebElement monthTxt;
	
	@FindBy(name="year")
	WebElement yearTxt;

	@FindBy(name="addressline1")
	WebElement addressline1Txt;

	@FindBy(name="addresscity")
	WebElement addresscityTxt;
	
	@FindBy(name="addressstate")
	WebElement addressstateSel;

	@FindBy(name="addresszip")
	WebElement addresszipTxt;
	
	@FindBy(name="mobilenumber")
	WebElement mobilenumberTxt;
	
	@FindBy(xpath="//input[@value='Email']")
	WebElement emailChk;
	
	public void clickOnSignUpBtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(joinNowBtn));
		joinNowBtn.click();
	}
	
	
	public void enterDetailsOnFirstPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addresscountrycodeSel));
		new Select(addresscountrycodeSel).selectByIndex(1);
		emailaddressTxt.sendKeys(randomEmailGenerator());
		sendKeys(passwordTxt, "Kishan26SK");
		Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);
		click(firstPagecontinueBtn);
	}
	
	
	public void enterDetailsOnSecondPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(genderBtn));
		genderBtn.click();
		firstnameTxt.sendKeys(faker.name().firstName());
		lastnameTxt.sendKeys(faker.name().lastName());
		dayTxt.sendKeys("22");
		monthTxt.sendKeys("12");
		yearTxt.sendKeys("1994");
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
		click(secondPagecontinueBtn);
	}
	
	public void enterDetailsOnThirdPage()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addressline1Txt));
		addressline1Txt.sendKeys("4000 Park Avenue, Dove Valley Park");
		addresscityTxt.sendKeys("Derby");
		new Select(addressstateSel).selectByIndex(3);
		addresszipTxt.sendKeys("45677332");
		mobilenumberTxt.sendKeys("232323233");
		Uninterruptibles.sleepUninterruptibly(2,TimeUnit.SECONDS);
	}
	
	
	
}
