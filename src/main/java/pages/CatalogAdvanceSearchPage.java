package Pages;//import java.util.*;

import Base.PredefinedActions;
import Constants.ConstantPaths;
import Utils.PropertyReading;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CatalogAdvanceSearchPage extends PredefinedActions {

    private static final CatalogAdvanceSearchPage catalogAdvanceSearchPage = new CatalogAdvanceSearchPage();
    private final PropertyReading catalogAdvanceSearchProp;

    private CatalogAdvanceSearchPage() {
        catalogAdvanceSearchProp = new PropertyReading(ConstantPaths.PROP_PATH + "CatalogAdvanceSearchProp.properties");
    }

    public static CatalogAdvanceSearchPage getCatalogAdvanceSearch() {
        return catalogAdvanceSearchPage;
    }

    public void enterSearchValues(String price_From, String price_To) {
        clearElementField(catalogAdvanceSearchProp.getValue("price_From"), true);
        enterText(getElement(catalogAdvanceSearchProp.getValue("price_From"), true), price_From);
        clearElementField(catalogAdvanceSearchProp.getValue("price_To"), true);
        enterText(getElement(catalogAdvanceSearchProp.getValue("price_To"), false), price_To);
    }

    public void clickOnSearchBtn() {
        clickOnElement(catalogAdvanceSearchProp.getValue("searchBtn"), false);
    }

    public Map<String, String> getProductMapAfterSearch() {
        List<String> nameList = getWebElementListInString(catalogAdvanceSearchProp.getValue("productName"), true);
        List<String> priceList = getWebElementListInString(catalogAdvanceSearchProp.getValue("productPrice"), true);
        priceList.remove(1);
        Map<String, String> productMap = new LinkedHashMap<>();

        for (int i = 0; i < priceList.size(); i++)
            productMap.put(nameList.get(i), priceList.get(i));
        return productMap;
    }
    public void clickOnModifySearch()
    {
        clickOnElement(catalogAdvanceSearchProp.getValue("modifySearch"),true);
    }
}
