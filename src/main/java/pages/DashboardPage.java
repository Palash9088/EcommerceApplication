package pages;//import java.util.*;

import base.PredefinedActions;
import constants.ConstantPaths;
import utils.PropertyReading;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class DashboardPage extends PredefinedActions {
    private static DashboardPage dashboardPage;
    private final PropertyReading dashboardPageProp;

    private DashboardPage() {
        //Private Constructor for Singleton Design Pattern
        dashboardPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "DashboardPageProp.properties");
    }

    public static DashboardPage getDashboardPage() {
        if (dashboardPage == null)
            dashboardPage = new DashboardPage();
        return dashboardPage;
    }

    public String getTitle() {
        return getWebpageTitle();
    }

    public MobilePage clickOnMobileSection()
    {
        clickOnElement(dashboardPageProp.getValue("mobileMenu"),true );
        return MobilePage.getMobilePage();
    }
    public boolean isPageHeadingVisible()
    {
        return getElementText(getElement(dashboardPageProp.getValue("pageHeadingTitle"),true)).contains("DEMO");
    }

    public void clickOnMyAccount()
    {
        clickOnElement(dashboardPageProp.getValue("myAccountBtn"),true);
    }
    public void clickOnTv()
    {
        clickOnElement(dashboardPageProp.getValue("tvMenu"),true);
    }

    public void clickOnAdvanceSearch()
    {
        clickOnElement(dashboardPageProp.getValue("advanceSearch"),true);
    }
}
