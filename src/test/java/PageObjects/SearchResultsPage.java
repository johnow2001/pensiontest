package PageObjects;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPensionProviderInList(String providerName) {

        List<WebElement> providerList = driver.findElements(By.partialLinkText(providerName));
        assertTrue(providerList.size() > 0);

        for (WebElement e : providerList) {
            if (e.getText().contains(providerName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpecificProvidersListed(DataTable table) {

        String value;
        int counter = 0;
        boolean result = true;

        List<Map<String, String>> map = table.asMaps(String.class, String.class);
        List<WebElement> aTag = driver.findElements(By.tagName("a"));


        /*
        for(WebElement e : aTag){
            for (Map<String, String> l : map) {
                value = l.get("name");
                if (value.equalsIgnoreCase(e.getText())){
                    counter++;
                    if(counter == aTag.size()){
                        return true;
                    }
                }
            }
        } */


        for(Map<String, String> m : map){
            String v = m.get("name");
            System.out.println(m.keySet());
            System.out.println(m.toString() + "size = " + m.size());
        }

        String expected[] = new String[map.size()];
        int i =0;
        for(Map<String, String> m : map) {
            value = m.get("name");
            expected[i] = value;
            i++;
        }

        int j = 0;
        String got[] = new String[aTag.size()];
        for(WebElement e : aTag ){
            got[j] = e.getText();
            j++;
        }

        assertArrayEquals(expected, got);
        return result;

        /*
        for (Map<String, String> l : map) {
            value = l.get("name");
            try{
            driver.findElement(By.linkText(value));
            }
            catch (NoSuchElementException e){
                System.out.println("EXCEPTION FOUND \n" + e.getMessage());
                return false;
            }
        }
        return true;
        */

    }


}
