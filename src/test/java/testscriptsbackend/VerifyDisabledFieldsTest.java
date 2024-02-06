package TestScriptsBackend;//import java.util.*;

import Pages.Backend.BackendDashboardPage;
import Pages.Backend.LoginPage;
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
