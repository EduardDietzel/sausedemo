import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(className = "inventory_list")
    WebElement inventoryList;
    @FindBy(className = "inventory_item")
    List<WebElement> inventoryItems;

    @FindBy(css = "img[class=\'inventory_item_img\']")
    List<WebElement> inventoryItemsImages;

    @FindBy(className = "inventory_item_name")
    List<WebElement> inventoryNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;
    // находим иконку бургера и находим её локатор по id

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTshirtAddToCart;

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

    public boolean allItemsAreDisplayed() {
        boolean displayed = true;
        for (WebElement item : inventoryItems){ // проверка всех карточек на видимость
            if (!item.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNamesAreDisplayed(){
        boolean displayed = true;
        // 1. is displayed = true
        // 2. not empty
        for (WebElement name : inventoryNames) {
            if (!name.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNamesAreNotEmpty(){
        boolean notEmpty = true;
        // 1. is displayed = true
        // 2. not empty
        for (WebElement name : inventoryNames) {
            if (name.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allNamesStartWithSauceLabs(){
        boolean allContains = true;
        int index = 1;
        for (WebElement name : inventoryNames) {
            if (!name.getText().startsWith("Sauce Labs")) {
                allContains = false;
                System.out.println("Item with index "+ (inventoryNames.indexOf(name)+1) +" does not start with Sauce Labs");
                // System.out.println("Item with index "+ index +" does not start with Sauce Labs");
            }
            // index++;
        }
        return allContains;
    }

    public void clickOnBurgerMenuBtn(){
        // заставляем драйвер ожидать 10 секунд перед нажатием на кнопку бургер
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn));
        burgerMenuBtn.click();
    }

    public void clickOnBackpackAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCart));
        backpackAddToCart.click();
    }

    public void clickOnBikeLightAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAddToCart));
        bikeLightAddToCart.click();
    }

    public void clickOnBoltTshirtAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(boltTshirtAddToCart));
        boltTshirtAddToCart.click();
    }

    public void clickOnCartItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }

    public String getPriceOfFirstItem(){
        return inventoryPrices.get(0).getText();
    }
}
