package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by navaneeth.basavaraj on 7/10/2016.
 */
public class CheckoutInfoPage extends PageBase{

	private static final String CONTINUE_BUTTON = "a.step2";
	private static final String BILLING_EMAIL = "billingemail";
	private static final String FIRSTNAME = "billingfirstname";
	private static final String LASTNAME = "billinglastname";
	private static final String BILLING_ADDRESS = "billingaddress";
	private static final String BILLING_CITY = "billingcity";
	private static final String BILLING_POSTALCODE = "billingpostcode";
	private static final String BILLING_PHONE = "billingphone";
	private static final String BILLING_COUNTRY = "#uniform-wpsc_checkout_form_7";
	private static final String BILLING_COUNTRY_OPTION = "//div[@id='uniform-wpsc_checkout_form_7']//option[text()='USA']";
	private static final String SAME_ADDRESS_AS_BILLING = "#shippingSameBilling";

	private static final String SHIPPING_COUNTRY_OPTION = "//form[@id='change_country']//option[text()='USA']";
	private static final String SHIPPING_RATE_COUNTRY = "#uniform-current_country";
	private static final String SHIPPING_RATE_CALCULATE_BUTTON = "input[value='Calculate']";
	private static final String MAKE_PURCHASE = ".input-button-buy";
	private static final String TOTAL_PRICE = "#checkout_total>.pricedisplay";

	public CheckoutInfoPage (WebDriver d){
		driver = d;
		findElementByCSS(SHIPPING_RATE_CALCULATE_BUTTON);
	}

	public CheckoutInfoPage fillCheckoutInfo(){
		setClassAttribute(findElementByCSS(SHIPPING_RATE_COUNTRY), "selector hover focus");
		findElementByXpath(SHIPPING_COUNTRY_OPTION).click();
		findElementByCSS(SHIPPING_RATE_CALCULATE_BUTTON).click();

		findElementByTitle(BILLING_EMAIL).sendKeys("ab@gmail.com");
		findElementByTitle(FIRSTNAME).sendKeys("FirstName");
		findElementByTitle(LASTNAME).sendKeys("LastName");
		findElementByTitle(BILLING_ADDRESS).sendKeys("Address");
		findElementByTitle(BILLING_CITY).sendKeys("Austin");
		findElementByTitle(BILLING_POSTALCODE).sendKeys("78758");
		findElementByTitle(BILLING_PHONE).sendKeys("8313322138");

		setClassAttribute(findElementByCSS(BILLING_COUNTRY), "selector hover focus");

		findElementByXpath(BILLING_COUNTRY_OPTION).click();
		findElementByCSS(SAME_ADDRESS_AS_BILLING).click();
		return this;
	}

	public void clickPurchase(){
		findElementByCSS(MAKE_PURCHASE).click();
	}

	public String getTotalPrice(){
		return findElementByCSS(TOTAL_PRICE).getText();
	}

	//HomeAway$1!2)3.
}
