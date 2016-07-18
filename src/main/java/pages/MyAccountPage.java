package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/11/2016.
 */
public class MyAccountPage extends PageBase{

	private static final String YOUR_DETAILS_LINK = "//a[text()='Your Details']";
	private static final String BILLING_ADDRESS = "billingaddress";
	private static final String SAVE_PROFILE_BUTTON = "input[value='Save Profile']";
	private static final String LOGOUT_BUTTON = "#account_logout";

	public MyAccountPage (WebDriver d){
		driver = d;
	}

	public MyAccountPage clickYourDetailsLink(){
		findElementByXpath(YOUR_DETAILS_LINK).click();
		return this;
	}

	public MyAccountPage editAddress(String newAddress){
		findElementByTitle(BILLING_ADDRESS).clear();
		findElementByTitle(BILLING_ADDRESS).sendKeys(newAddress);
		return this;
	}

	public String getAddress(){
		return findElementByTitle(BILLING_ADDRESS).getText();
	}

	public MyAccountPage saveProfile(){
		findElementByCSS(SAVE_PROFILE_BUTTON).click();
		return this;
	}

	public MyAccountLoginPage logout(){
		findElementByCSS(LOGOUT_BUTTON).click();
		return new MyAccountLoginPage(driver);
	}

}
