package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/6/2016.
 */
public class ProductPage extends PageBase {

	private static final String SINGLE_PRODUCT_PAGE = "#single_product_page_container";

	public ProductPage (WebDriver d){
		driver = d;
	}

	public ProductPage verifySingleProductPage(){
		findElementByCSS(SINGLE_PRODUCT_PAGE);
		return this;
	}
}
