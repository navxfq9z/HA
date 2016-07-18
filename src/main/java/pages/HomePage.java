package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by navaneeth.basavaraj on 6/27/2016.
 */
public class HomePage extends PageBase{

	protected static final String SEARCH_BOX = "#main-nav .search";
	protected static final String NAVBAR_PRODUCT_MENU = "ul#menu-main-menu li.menu-item-object-wpsc_product_category ul.sub-menu";
	protected static final String NAVBAR_PRODUCT_MENU_XPATH = "//a[text()='Product Category']";
	protected static final String MENU_ITEM_IPHONES = "iPhones";
	protected static final String BUY_NOW_BUTTON = ".slide a.buynow";

	public HomePage(){
	}

	public HomePage(WebDriver d){
		driver = d;
	}

	public HomePage startTest(WebDriver d){
		driver = d;
		driver.navigate().to("http://store.demoqa.com");
		driver.manage().window().maximize();
		return this;
	}

	public PLP search(String keyword){
		findElementByCSS(SEARCH_BOX).sendKeys(keyword);
		findElementByCSS(SEARCH_BOX).sendKeys(Keys.ENTER);
		return new PLP(driver);
	}

	public HomePage clickProductMenu(){
		WebElement element = findHiddenElement(NAVBAR_PRODUCT_MENU);
		System.out.println(element.getAttribute("style"));
		setAttribute(element);
		return this;
	}

	public ProductsPage clickProductMenuiPhones(){
		findElementByLinkText(MENU_ITEM_IPHONES).click();
		return new ProductsPage(driver);
	}

	public ProductPage clickBuyNow(){
		findElementByLinkText("Buy Now").click();
		return new ProductPage(driver);
	}

	public MyAccountLoginPage clickMyAccount(){
		findElementByTitle("My Account").click();
		return new MyAccountLoginPage(driver);
	}

}
