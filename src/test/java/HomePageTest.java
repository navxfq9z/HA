/**
 * Created by navaneeth.basavaraj on 6/27/2016.
 */

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.HomePage;
import pages.MyAccountLoginPage;
import pages.MyAccountPage;
import pages.ProductsPage;

import java.util.Date;

public class HomePageTest extends BaseTest{

//	@Test
//	public void verifyBuyNow(){
//		HomePage homePage = new HomePage();
//		homePage.startTest(webDriverManager.get().getNewBrowser("Chrome", "Test Home"));
//		ProductPage productPage = homePage.clickBuyNow();
//		productPage.verifySingleProductPage();
//	}
//
//	@Test
//	public void search(){
//		HomePage homePage = new HomePage();
//		homePage.startTest(webDriverManager.get().getNewBrowser("Firefox", "Search iPhone-5 from home page"));
//		PLP plp = homePage.search("iPhone");
//	}

	@Test
	public void addToCartFromProductPage(){
		//Assuming tax is $12
		double tax = 12;
		HomePage homePage = new HomePage();
		homePage.startTest(webDriverManager.get().getNewBrowser("Chrome", "Add iPhone-4S 16G to cart"));
		ProductsPage productsPage = homePage.clickProductMenu().clickProductMenuiPhones();
		double price = Float.parseFloat(productsPage.getiPhone4S16GBlackPrice().replace("$","").trim());
		System.out.println(price);
		CartPage cartPage = productsPage.addiPhone4S16GToCart().clickGoToCart();
		CheckoutInfoPage infoPage = cartPage.continueShopping();
		double totalPrice = Float.parseFloat(infoPage.fillCheckoutInfo().getTotalPrice().replace("$","").trim());
		System.out.println(totalPrice);
		price = price + tax;
		Assert.assertEquals(price, totalPrice, "Price Mismatch!");
	}

	@Test
	public void verifyEmptyCartMessage(){
		HomePage homePage = new HomePage();
		homePage.startTest(webDriverManager.get().getNewBrowser("Chrome", "Add iPhone-4S 16G to cart"));
		ProductsPage productsPage = homePage.clickProductMenu().clickProductMenuiPhones();
		CartPage cartPage = productsPage.addiPhone4S16GToCart().clickGoToCart();
		String message = cartPage.removeItemFromCart().trim();
		Assert.assertEquals(message,"Oops, there is nothing in your cart.", "Empty cart message not found!");
	}

	@Test
	public void verifyProfileSave(){
		HomePage homePage = new HomePage();
		homePage.startTest(webDriverManager.get().getNewBrowser("Chrome", "Add iPhone-4S 16G to cart"));
		MyAccountLoginPage myAccountLoginPage = homePage.clickMyAccount();
		MyAccountPage myAccountPage = myAccountLoginPage.Login("navaneeth3","HomeAway$1!2)3.");
		String newAddress = "New Address " + new Date().getTime();
		myAccountLoginPage = myAccountPage.clickYourDetailsLink().editAddress(newAddress).saveProfile().logout();

		myAccountPage = myAccountLoginPage.Login("navaneeth3","HomeAway$1!2)3.");
		Assert.assertEquals(newAddress, myAccountPage.clickYourDetailsLink().getAddress(), "Save profile failed!");
	}

}


