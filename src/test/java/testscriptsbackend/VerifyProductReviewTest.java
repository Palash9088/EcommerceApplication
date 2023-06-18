package testscriptsbackend;//import java.util.*;

import base.PredefinedActions;
import pages.Backend.BackendDashboardPage;
import pages.Backend.LoginPage;
import pages.DashboardPage;
import pages.MobileDetailPage;
import pages.MobilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class VerifyProductReviewTest {
    String reviewerName = "Kallu Ustad".toUpperCase();
    @Test(priority = -1)
    public void doReview()
    {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/","chrome",false);
        DashboardPage dashboardPage = DashboardPage.getDashboardPage();
        dashboardPage.clickOnMobileSection();
        MobilePage mobilePage = MobilePage.getMobilePage();
        mobilePage.clickOnMobile("Sony Xperia");

        MobileDetailPage mobileDetailPage = MobileDetailPage.getMobileDetailPage();
        mobileDetailPage.clickOnAddYourReview();
        mobileDetailPage.fillRating("5","Great Phone","A Must buy",reviewerName);
        mobileDetailPage.clickOnSubmitBtn();
        Assert.assertEquals(mobileDetailPage.getReviewConfirmation(),"Your review has been accepted for moderation.");
    }

    @Test
    public void reviewOnWebsite() {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/index.php/backendlogin","chrome",false);
        LoginPage loginPage = LoginPage.getLoginPage();
        loginPage.doLogin("user01","guru99com");
        loginPage.clickOnLoginBtn();
        BackendDashboardPage backendDashboardPage = BackendDashboardPage.getBackendDashboardPage();
        backendDashboardPage.clickOnCloseBtn();
        backendDashboardPage.goToPendingReviews();
        backendDashboardPage.sortTableByIdInPendingReviews();
        backendDashboardPage.selectFirstCommentInPendingReviews();
        backendDashboardPage.clickOnEditBtnInPendingReviews();
        backendDashboardPage.selectStatus("Approved");
        backendDashboardPage.saveReviewInEditReviews();

        PredefinedActions.navigateToUrl("http://live.techpanda.org/");
        DashboardPage dashboardPage = DashboardPage.getDashboardPage();
        dashboardPage.clickOnMobileSection();
        MobilePage mobilePage = MobilePage.getMobilePage();
        mobilePage.clickOnMobile("Sony Xperia");

        MobileDetailPage mobileDetailPage = MobileDetailPage.getMobileDetailPage();
        mobileDetailPage.clickOnReviews();
        System.out.println(mobileDetailPage.isReviewVisible(reviewerName));
        //Assert.assertTrue(mobileDetailPage.isReviewVisible(reviewerName));


    }
}
