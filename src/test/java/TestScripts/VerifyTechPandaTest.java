package TestScripts;//import java.util.*;

import Pages.*;
import com.google.common.base.Stopwatch;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifyTechPandaTest extends TestBase {
    static Logger log = Logger.getLogger(VerifyTechPandaTest.class);

    //Verify item in Mobile List page can be sorted by 'Name'
    @Test
    public void verifySortTest() {

        DashboardPage dashboardPage = getDashboardObj();
        String actualTitle = dashboardPage.getTitle();
        Assert.assertEquals(actualTitle, "Home page");
        boolean isPageHeadingVisible = dashboardPage.isPageHeadingVisible();
        Assert.assertTrue(isPageHeadingVisible);


        MobilePage mobilePage = dashboardPage.clickOnMobileSection();
        boolean isHeadVisible = mobilePage.isHeadingVisible();
        Assert.assertTrue(isHeadVisible);
        String actualTitleMobilePage = mobilePage.getTitle();
        Assert.assertEquals(actualTitleMobilePage, "Mobile");

        mobilePage.productSortByName();
        boolean sorted = mobilePage.isListSortedByName();
        Assert.assertTrue(sorted);

    }

    //Verify that cost of product in list page and details page are equal
    @Test
    public void verifyPriceOfProduct() {
        DashboardPage dashboardPage = getDashboardObj();
        MobilePage mobilePage = dashboardPage.clickOnMobileSection();
        MobileDetailPage mobileDetailPage = getMobileDetailPageObj();

        String valueInMobileListPage = mobilePage.productValueInMobileListPage();
        log.info(valueInMobileListPage);

        mobilePage.clickOnMobile("Sony");
        String valueInMobileDetailPage = mobileDetailPage.getMobilePrice();
        log.info(valueInMobileDetailPage);
        Assert.assertEquals(valueInMobileDetailPage, valueInMobileListPage);
    }

    //Verify that you cannot add more product in cart than the product available in store
    @Test
    public void verifyCart() {
        DashboardPage dashboardPage = getDashboardObj();
        MobilePage mobilePage = dashboardPage.clickOnMobileSection();
        MobileCartPage mobileCartPage = getMobileCartPageObj();

        mobilePage.addToCartBtn();
        mobileCartPage.updateCartValue("1000");
        String actualErrorMsg = mobileCartPage.getErrorMsg();
        log.info("Actual error msg :- " + actualErrorMsg);
        String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

        mobileCartPage.clickOnEmptyCart();

        String actualEmptyCartMsg = mobileCartPage.getEmptyCartMsg();
        log.info(actualEmptyCartMsg);
        String expectedEmptyCartMsg = "Shopping Cart is Empty".toUpperCase();
        Assert.assertEquals(actualEmptyCartMsg, expectedEmptyCartMsg);
    }

    //Verify that you are able to compare two product
    @Test
    public void verifyTwoProducts() {
        getDashboardObj().clickOnMobileSection();

        MobilePage mobilePage = getMobilePageObj();
        mobilePage.clickOnAddToCompare("Sony Xperia");
        mobilePage.clickOnAddToCompare("IPhone");
        mobilePage.clickOnCompareProduct();
        String heading = mobilePage.getHeadingOfCompareWindow();
        log.info(heading);
        Assert.assertEquals(heading, "COMPARE PRODUCTS");
        String firstProduct = mobilePage.getFirstCompareProductName();
        log.info(firstProduct);
        Assert.assertEquals(firstProduct, "SONY XPERIA");
        String secondProduct = mobilePage.getSecondCompareProductName();
        log.info(secondProduct);
        Assert.assertEquals(secondProduct, "IPHONE");
        mobilePage.afterAct();
    }

    /*verify you can create account in E-commerce
        site and can hare wishlist to
        other people using email*/
    @Test(priority = 1)
    public void verifyRegistration() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        DashboardPage dashboardPage = getDashboardObj();
        dashboardPage.clickOnMyAccount();

        LoginOrCreateAccountPage loginOrCreateAccountPage = getLoginOrCreatePageObj();
        List<String> credList = loginOrCreateAccountPage.getCredList();
        loginOrCreateAccountPage.clickOnCreateAccountBtn();

        CreateAccountPage createAccountPage = getCreateAccountObj();
        createAccountPage.enterRegistrationDetail("Palash", "Soni", credList.get(0), credList.get(1));

        AccountDashboardPage accountDashboardPage = getAccountDashboardPageObj();
        String actualMsg = accountDashboardPage.getSuccessMsg();
        String expectedMsg = "Thank you for registering with Main Website Store.";
        Assert.assertEquals(actualMsg, expectedMsg);

        dashboardPage.clickOnTv();

        TVPage tvPage = getTvPageObj();
        tvPage.addToWishlist("LG LCD");

        accountDashboardPage.clickOnShareWishlist();
        String actualWishlistSuccessMsg = accountDashboardPage.shareWishlist("Palashsoni55@gmail.com", "Hello I have shared my wishlist");
        String expectedWishlistSuccessMsg = "Your Wishlist has been shared.";
        Assert.assertEquals(actualWishlistSuccessMsg, expectedWishlistSuccessMsg);
        stopwatch.stop();
        log.info("Time Elapsed " + stopwatch.elapsed(TimeUnit.SECONDS));
    }

    /*Verify user is able to purchase
      product using registered email
       id(USE CHROME BROWSER)*/
    @Test(priority = 2)
    public void verifyUserIsAbleToPurchase() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        DashboardPage dashboardPage = getDashboardObj();
        dashboardPage.clickOnMyAccount();

        LoginOrCreateAccountPage loginOrCreateAccountPage = getLoginOrCreatePageObj();
        List<String> credList = loginOrCreateAccountPage.getCredList();
        loginOrCreateAccountPage.loginIntoAccount(credList.get(0),credList.get(1));
        loginOrCreateAccountPage.clickOnLoginBtn();

        AccountDashboardPage accountDashboardPage = getAccountDashboardPageObj();
        accountDashboardPage.clickOnMyWishlist();
        accountDashboardPage.clickOnAddToCartBtn();

        ShoppingCartPage shoppingCartPage = getShoppingCartPageObj();
        shoppingCartPage.fillShippingInformation("United States","New York","542896");
        shoppingCartPage.clickOnEstimateBtn();

        int flatShippingRate = shoppingCartPage.getFlatRate();
        int subTotal = shoppingCartPage.getSubTotal();
        int expectedSubTotalWithShipping = subTotal+flatShippingRate;
        int grandTotal = shoppingCartPage.getGrandTotal();
        Assert.assertEquals(expectedSubTotalWithShipping,grandTotal);
        shoppingCartPage.clickOnCheckOutBtn();

        CheckoutPage checkoutPage = getCheckoutPageObj();
        checkoutPage.fillBillingInformation("ABC","New York","New York","542896","United States","123456789");
        checkoutPage.clickOnContinueBtn();
        checkoutPage.confirmShippingMethod();
        checkoutPage.confirmPaymentMethod();
        checkoutPage.confirmOrder();
        String expectedOrderMsg = "Your order has been received.".toUpperCase();
        String actualOrderMsg = checkoutPage.getOrderConfirmation();
        Assert.assertEquals(actualOrderMsg,expectedOrderMsg);
        log.info(checkoutPage.getOrderId());

        stopwatch.stop();
        log.info("Time Elapsed " + stopwatch.elapsed(TimeUnit.SECONDS));
    }
}