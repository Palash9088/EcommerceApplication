package pages;//import java.util.*;

import base.PredefinedActions;
import constants.ConstantPaths;
import utils.PropertyReading;
/**
 * @author Palash Soni
 * https://github.com/Palash9088
 * https://www.linkedin.com/in/Palash9088
 * */
public class TVPage extends PredefinedActions {
    private static TVPage tvPage;
    private final PropertyReading tvPageProp;


    private TVPage() {
        //Private Constructor for Singleton Design Pattern
        tvPageProp = new PropertyReading(ConstantPaths.PROP_PATH + "TvPageProp.properties");
    }

    public static TVPage  getTvPage() {
        if (tvPage == null)
            tvPage = new TVPage();
        return tvPage;
    }
    public void addToWishlist(String brand) {
        String element = String.format(tvPageProp.getValue("addToWishListBtn"), brand);
        clickOnElement(element, true);
    }
}
