package testscriptsbackend;//import java.util.*;

import pages.Backend.BackendDashboardPage;
import pages.Backend.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
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
