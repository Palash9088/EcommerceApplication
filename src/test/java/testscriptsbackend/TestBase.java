package testscriptsbackend;//import java.util.*;

import base.PredefinedActions;
import constants.ConstantPaths;
import pages.Backend.BackendDashboardPage;
import pages.Backend.LoginPage;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class TestBase {

    private LoginPage loginPage;
    private BackendDashboardPage backendDashboardPage;

    @BeforeClass
    public void beforeClass() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        System.setProperty("current.date.time", sdf.format(new Date()));

        PropertyConfigurator.configure(ConstantPaths.LOG4J_PATH);

    }

    @BeforeMethod
    public void openBrowser() {
        PredefinedActions.initializeBrowser("http://live.techpanda.org/index.php/backendlogin/", "chrome",false);
    }

    protected LoginPage getLoginPageObj() {
        if (loginPage == null)
            loginPage = LoginPage.getLoginPage();
        return loginPage;
    }
    protected BackendDashboardPage getBackendDashboardPageObj() {
        if (backendDashboardPage == null)
            backendDashboardPage = BackendDashboardPage.getBackendDashboardPage();
        return backendDashboardPage;
    }

    //@AfterMethod
    public void closeBrowser(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            PredefinedActions.takeScreenshot(result.getName());
        PredefinedActions.closeBrowser();
    }
}
