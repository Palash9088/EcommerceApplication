package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class ShoppingCartPage extends PredefinedActions {
    private static ShoppingCartPage shoppingCartPage;
    private final PropertyReading shoppingCartPageProp;


    private ShoppingCartPage() {
        //Private Constructor for Singleton Design Pattern
        shoppingCartPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "ShoppingCartPageProp.properties");
    }

    public static ShoppingCartPage getShoppingCartPage() {
        if (shoppingCartPage == null)
            shoppingCartPage = new ShoppingCartPage();
        return shoppingCartPage;
    }

    public void fillShippingInformation(String country, String state, String zipCode) {
        selectElementByVisibleText(getElement(shoppingCartPageProp.getValue("selectByCountry"), true), country);
        selectElementByVisibleText(getElement(shoppingCartPageProp.getValue("selectByState"), true), state);
        enterText(getElement(shoppingCartPageProp.getValue("zipCodeBox"), true), zipCode);
    }

    public void clickOnEstimateBtn() {
        clickOnElement(shoppingCartPageProp.getValue("estimateBtn"), true);
    }

    public int getFlatRate() {
        clickOnElement(shoppingCartPageProp.getValue("flatRateRadio"), true);
        clickOnElement(shoppingCartPageProp.getValue("flatRateUpdateBtn"),true);
        return Integer.parseInt(getElementText(getElement(shoppingCartPageProp.getValue("flatRateInDollar"), true)).replace("$", "").replace(".", ""));
    }

    public int getSubTotal() {
        return Integer.parseInt(getElementText(getElement(shoppingCartPageProp.getValue("subTotal"), true)).replace("$", "").replace(".", ""));
    }

    public int getGrandTotal() {
        return Integer.parseInt(getElementText(getElement(shoppingCartPageProp.getValue("grandTotal"), true)).replace("$", "").replace(".", ""));
    }

    public void clickOnCheckOutBtn() {
        clickOnElement(shoppingCartPageProp.getValue("proceedToCheckOutBtn"), true);
    }


}
