package TestScripts;//import java.util.*;

import Pages.DashboardPage;
import Pages.MobileCartPage;
import Pages.MobileDetailPage;
import Pages.MobilePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyMobileListSortTest extends TestBase {
    static Logger log = Logger.getLogger(VerifyMobileListSortTest.class);

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
        Assert.assertEquals(valueInMobileDetailPage,valueInMobileListPage);
    }

    //Verify that you cannot add more product in cart than the product available in store
    @Test
    public void verifyCart()
    {
        DashboardPage dashboardPage = getDashboardObj();
        MobilePage mobilePage = dashboardPage.clickOnMobileSection();
        MobileCartPage mobileCartPage = getMobileCartPageObj();

        mobilePage.addToCartBtn();
        mobileCartPage.updateCartValue("1000");
        String actualErrorMsg = mobileCartPage.getErrorMsg();
        log.info("Actual error msg :- " + actualErrorMsg);
        String expectedErrorMsg = "Some of the products cannot be ordered in requested quantity.";
        Assert.assertEquals(actualErrorMsg,expectedErrorMsg);

        mobileCartPage.clickOnEmptyCart();

        String actualEmptyCartMsg = mobileCartPage.getEmptyCartMsg();
        log.info(actualEmptyCartMsg);
        String expectedEmptyCartMsg = "Shopping Cart is Empty".toUpperCase();
        Assert.assertEquals(actualEmptyCartMsg,expectedEmptyCartMsg);
    }
}
