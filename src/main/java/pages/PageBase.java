package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by navaneeth.basavaraj on 7/1/2016.
 */
public abstract class PageBase {

	public WebDriver driver;
	public WebDriverWait wait;


	public WebElement findElementByCSS(String cssSelector){
		return findElement(By.cssSelector(cssSelector));
	}

	public WebElement findElementByXpath(String xPath){
		return findElement(By.xpath(xPath));
	}

	private WebElement findElement(By query){
		wait = new WebDriverWait(driver,10,50);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(query));
	}

	public WebElement findHiddenElement(String cssSelector){
		wait = new WebDriverWait(driver,10,50);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
	}

	public WebElement findElementByLinkText(String link){
		return findElement(By.linkText(link));
	}

	public void setAttribute(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].removeAttribute('style', 'display: none;')", element);
		executor.executeScript("arguments[0].setAttribute('style', 'display: block;')", element);
	}

	public void setClassAttribute(WebElement element, String className) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('class', '" + className +"')", element);
	}

	public void waitTime(long timeInMillis){
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement findElementByTitle(String title){
		title = "[title='" + title +"']";
		wait = new WebDriverWait(driver,10,50);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(title)));
	}

}
