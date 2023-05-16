import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;

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

    @FindBy(className = "product_sort_container")
    private WebElement sortDropDown;

    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;

    @FindBy(css = "[value='hilo']")
    private WebElement highToLow;

    @FindBy(css = "[value='az']")
    private WebElement aToZ;

    @FindBy(css = "[value='za']")
    private WebElement zToA;


    // constructor
    //class = inventory_list
    // element is displayed

    @Step("Inventory page is open")
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
        // 1. is displayed == true (for all items)
        // 2. not empty (for all items)
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

    // пишем метод для нажатия списка фильтра выбора товаров
    public void choosePriceLowToHighSortOption(){
        // используем метод clickOnElement из класса BasePage
        clickOnElement(sortDropDown);
        clickOnElement(lowToHigh);
    }

    public void choosePriceHighToLowSortOption(){
        clickOnElement(sortDropDown);
        clickOnElement(highToLow);
    }

    public void chooseNameAToZSortOption(){
        clickOnElement(sortDropDown);
        clickOnElement(aToZ);
    }

    public void chooseNameZToASortOption(){
        clickOnElement(sortDropDown);
        clickOnElement(zToA);
    }

    // метод для выборки прайсов товаров
    public boolean checkPriceSortFromLowToHigh(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().replaceAll("[^0-9.]", "")));
            // теперь надо перевести Строку в Дабл
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        // теперь надо отсортировать список с помощью Джавы
        Collections.sort(expectedPrices);
        // сравниваем реальное с ожидаемым
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkPriceSortFromHighToLow(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().replaceAll("[^0-9.]", "")));
            // теперь надо перевести Строку в Дабл
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        // теперь надо отсортировать список с помощью Джавы в обратном порядке
        Collections.sort(expectedPrices, Collections.reverseOrder());
        // сравниваем реальное с ожидаемым
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkNameSortFromAToZ(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        // теперь надо отсортировать список с помощью Джавы
        // Джава автоматически сортирует текст по алфавиту, отсекая повторяющиеся буквы сначала
        Collections.sort(expectedNames);
        // сравниваем реальное с ожидаемым
        return actualNames.equals(expectedNames);
    }

    public boolean checkNameSortFromZToA(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        // теперь надо отсортировать список с помощью Джавы в обратном порядке
        Collections.sort(expectedNames, Collections.reverseOrder());
        // сравниваем реальное с ожидаемым
        return actualNames.equals(expectedNames);
    }

}
