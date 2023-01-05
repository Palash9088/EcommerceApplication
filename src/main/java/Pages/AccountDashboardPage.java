package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class AccountDashboardPage extends PredefinedActions {
    private static AccountDashboardPage accountDashboardPage;
    private final PropertyReading accountDashboardPageProp;

    private AccountDashboardPage() {
        //Private Constructor for Singleton Design Pattern
        accountDashboardPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "AccountDashboardPageProp.properties");
    }

    public static AccountDashboardPage getAccountDashboardPage() {
        if (accountDashboardPage == null)
            accountDashboardPage = new AccountDashboardPage();
        return accountDashboardPage;
    }

    public String getSuccessMsg() {
        return getElementText(getElement(accountDashboardPageProp.getValue("msgElement"), true));
    }

    public void clickOnShareWishlist() {
        clickOnElement(accountDashboardPageProp.getValue("shareWishlistBtn"), true);
    }

    public String shareWishlist(String email, String msg) {
        enterText(getElement(accountDashboardPageProp.getValue("enterEmail"), true), email);
        enterText(getElement(accountDashboardPageProp.getValue("enterMsg"), true), msg);
        clickOnElement(accountDashboardPageProp.getValue("shareWishlistBtn2"), true);
        return getElementText(getElement(accountDashboardPageProp.getValue("successMsgWishlist"), true));
    }
    public void clickOnMyWishlist()
    {
        clickOnElement(accountDashboardPageProp.getValue("myWishlist"),true);
    }
    public void clickOnAddToCartBtn()
    {
        clickOnElement(accountDashboardPageProp.getValue("addToCartBtn"),true);
    }
}
