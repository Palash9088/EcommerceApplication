package TestScripts;//import java.util.*;

import Pages.DashboardPage;
import Pages.MobileDetailPage;
import Pages.MobilePage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyMobileListSortTest extends TestBase {
    static Logger log = Logger.getLogger(VerifyMobileListSortTest.class);
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

    @Test
    public void verifyPriceOfProduct() {
        DashboardPage dashboardPage = getDashboardObj();
        MobilePage mobilePage = dashboardPage.clickOnMobileSection();

        String valueInMobileListPage = mobilePage.productValueInMobileListPage();
        log.info(valueInMobileListPage);

        MobileDetailPage mobileDetailPage = mobilePage.clickOnMobile("Sony");
        String valueInMobileDetailPage = mobileDetailPage.getMobilePrice();
        log.info(valueInMobileDetailPage);
        Assert.assertEquals(valueInMobileDetailPage,valueInMobileListPage);
    }
}
