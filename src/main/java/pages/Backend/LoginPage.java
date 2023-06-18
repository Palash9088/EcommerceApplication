package pages.Backend;//import java.util.*;

import base.PredefinedActions;
import utils.PropertyReading;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class LoginPage extends PredefinedActions {
    private final PropertyReading loginPageProp;
    private static LoginPage loginPage;
    private LoginPage ()
    {
        loginPageProp = new PropertyReading("src/main/resources/BackendConfig/LoginPageProp.properties");
    }

    public static LoginPage getLoginPage()
    {
        if(loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }
    public void doLogin(String username, String password)
    {
        enterText(getElement(loginPageProp.getValue("usernameBackend"),true),username);
        enterText(getElement(loginPageProp.getValue("passwordBackend"),true),password);
    }
    public void clickOnLoginBtn()
    {
        clickOnElement(loginPageProp.getValue("loginBtnBackend"),true);
    }

}
