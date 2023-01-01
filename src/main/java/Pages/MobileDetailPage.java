package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

public class MobileDetailPage extends PredefinedActions {
    private static MobileDetailPage mobileDetailPage;
    PropertyReading mobileDetailPageProp;

    private MobileDetailPage() {
        //Private Constructor for Singleton Design Pattern
        mobileDetailPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "MobileDetailPageProp.properties");
    }

    public static MobileDetailPage getMobileDetailPagePage() {
        if (mobileDetailPage == null)
            mobileDetailPage = new MobileDetailPage();
        return mobileDetailPage;
    }

    public String getMobilePrice() {
        return getElementText(getElement(mobileDetailPageProp.getValue("productPriceInPage"), true));
    }

}
