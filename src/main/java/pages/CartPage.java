package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/10/2016.
 */
public class CartPage extends PageBase {

	private static final String CONTINUE_BUTTON = "a.step2";
	private static final String REMOVE_ITEM_BUTTON = "input[value='Remove']";
	private static final String EMPTY_CART_MESSAGE = ".entry-content";

	public CartPage(WebDriver d) {
		driver = d;
	}

	public CheckoutInfoPage continueShopping() {
		findElementByCSS(CONTINUE_BUTTON).click();
		return new CheckoutInfoPage(driver);
	}

	public String removeItemFromCart(){
		findElementByCSS(REMOVE_ITEM_BUTTON).click();
		return findElementByCSS(EMPTY_CART_MESSAGE).getText();
	}

}
