import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public int getItemsQuantity() {
        return items.size();
    }

    public boolean cartIsEmpty(){
        boolean empty = false;
        try{ // если мы не смогли достучаться до искомого элемента в корзине, значит его там нет
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(items.get(0)));
        } //  Exception прерывает работу, а нам надо продолжить и перехватить Exception с помощью catch (е - переменная)
        // заводим новый класс catch (Exception e)
        catch (Exception e) {
            empty = true;
        }
        return empty;
    }

    public String getPriceOfFirstAddedItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(itemPrices.get(0)));
        return itemPrices.get(0).getText();
    }

    public void clickOnCheckoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    // ндо проверить цену всех товаров в корзине и сложить их
    public double getTotalPriceOfItems(){
        double total = 0;
        for (WebElement price : itemPrices) {
            // сначала мы получим строку, но там есть знак $ его надо убрать и получить число из строки
            // метод parseDouble превращает строку в число
            total+=parseDouble(price.getText().substring(1));
        }
        return total;
    }

}
