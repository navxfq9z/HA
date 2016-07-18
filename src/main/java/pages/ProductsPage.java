package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/6/2016.
 */
public class ProductsPage extends PageBase {

	private static final String CONTINUE_SHOPPING = "#fancy_notification_content a.continue_shopping";
	private static final String iPhone_4S_16G_BLK_ADD2CART = ".default_product_display.product_view_96.iphones.group input.wpsc_buy_button";
	private static final String Products_Page = "#default_products_page_container";
	private static final String CART_COUNT = "a.cart_icon>em.count";
	private static final String ADD2CART_DIALOG_CONFIRM = "#fancy_notification_content";
	private static final String GO_TO_CART_BUTTON = "a.go_to_checkout";
	private static final String iPhone_4S_16G_BLK_PRICE = ".currentprice.pricedisplay.product_price_96";

	public ProductsPage (WebDriver d){
		driver = d;
		findElementByCSS(Products_Page);
	}

	public ProductsPage addiPhone4S16GToCart(){
		findElementByCSS(iPhone_4S_16G_BLK_ADD2CART).click();
		String style = "none"; int count = 0;
		do {
			style = findElementByCSS(ADD2CART_DIALOG_CONFIRM).getAttribute("style");
			count++;
			findElementByCSS(GO_TO_CART_BUTTON);

		}while (style.contains("none") && count < 10);
		return this;
	}


	public ProductsPage clickContinueShopping(){
		findElementByCSS(CONTINUE_SHOPPING).click();
		return this;
	}

	public CartPage clickGoToCart(){
		findElementByCSS(GO_TO_CART_BUTTON).click();
		waitTime(5000);
		return new CartPage(driver);
	}

	public String getCartCount(){
		return findElementByCSS(CART_COUNT).getText();
	}

	public String getiPhone4S16GBlackPrice(){
		return findElementByCSS(iPhone_4S_16G_BLK_PRICE).getText();
	}

}
