package TestScriptsBackend;//import java.util.*;

import Pages.Backend.BackendDashboardPage;
import Pages.Backend.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class VerifyInvoiceDateSortTest extends TestBase {

    @Test
    public void verifyInvoiceSort() throws ParseException, InterruptedException {
        LoginPage loginPage = getLoginPageObj();
        loginPage.doLogin("user01","guru99com");
        loginPage.clickOnLoginBtn();

        BackendDashboardPage backendDashboardPage = getBackendDashboardPageObj();
        backendDashboardPage.clickOnCloseBtn();
        backendDashboardPage.clickOnSales();
        backendDashboardPage.clickOnInvoice();
        Assert.assertTrue(backendDashboardPage.isInvoiceDateInDescending());
        backendDashboardPage.clickOnInvoiceHeader();
        Thread.sleep(800);
        Assert.assertTrue(backendDashboardPage.isInvoiceDateInAscending());

    }

}
