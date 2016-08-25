package util;

/**
 * Created by navaneeth.basavaraj on 6/26/2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class WebDriverManager {

	WebDriver driver = null;

	public WebDriverManager(){
	}

	public WebDriver getNewBrowser(String browser, String testName){
		if(browser.equals("IE")){
			File internetExplorerFile = new File("src/test/resources/chromedriver");
			System.setProperty("webdriver.ie.driver",internetExplorerFile.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}else if(browser.equals("Chrome")){
			File chromeServerFile = new File("src/test/resources/chromedriver");
			System.setProperty("webdriver.chrome.driver",chromeServerFile.getAbsolutePath());
			driver = new ChromeDriver();
		}else if(browser.equals("Firefox")){
			FirefoxProfile profile = new FirefoxProfile();
			driver = new FirefoxDriver(profile);
		}
		return driver;

	}

	public void cleanUp(){
		driver.quit();
	}
}
