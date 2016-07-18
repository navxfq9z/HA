package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/1/2016.
 */



//PLP - Product Landing Page
public class PLP extends PageBase{

	private static final String PLP_CONTAINER = "#grid_view_products_page_container";

	public PLP (WebDriver d){
		driver = d;
		findElementByCSS(PLP_CONTAINER);
	}
}
