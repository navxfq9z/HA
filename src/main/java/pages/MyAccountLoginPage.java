package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/11/2016.
 */
public class MyAccountLoginPage extends PageBase{

	private static final String USERNAME = "#log";
	private static final String PASSWORD = "#pwd";
	private static final String LOGIN_BUTTON = "#login";

	public MyAccountLoginPage (WebDriver d){
		driver = d;
	}

	public MyAccountPage Login(String username, String password){
		findElementByCSS(USERNAME).sendKeys(username);
		findElementByCSS(PASSWORD).sendKeys(password);
		findElementByCSS(LOGIN_BUTTON).click();
		return new MyAccountPage(driver);
	}
}
