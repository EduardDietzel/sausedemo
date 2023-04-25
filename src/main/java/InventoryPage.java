import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_list")
    WebElement inventoryList;
    @FindBy(className = "inventory_item")
    List<WebElement> inventoryItems;

    // constructor
    //class = inventory_list
    // element is displayed

    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }

    // выводим количество карточек на странице с товарами (их там 6 штук)
    // в классе InventoryTest мы в методе itemQuantityTest() сравниваем полученное количество с ожидаемым в assertEquals
    public int getItemsQuantity() {
        return inventoryItems.size();
    }
}
