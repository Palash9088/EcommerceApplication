package testscriptsbackend;//import java.util.*;

import pages.Backend.BackendDashboardPage;
import pages.Backend.LoginPage;
import org.testng.annotations.Test;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class VerifyDisabledFieldsTest extends TestBase{

    @Test
    public void verifyDisabledFields()
    {
        LoginPage loginPage = getLoginPageObj();
        loginPage.doLogin("user01","guru99com");
        loginPage.clickOnLoginBtn();

        BackendDashboardPage backendDashboardPage = getBackendDashboardPageObj();
        backendDashboardPage.clickOnCloseBtn();
        backendDashboardPage.clickOnCustomerMenu();
        backendDashboardPage.clickOnManageCustomerSubmenu();


    }
}
