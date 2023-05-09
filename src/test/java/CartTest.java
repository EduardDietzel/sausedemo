import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void successAdding1Item(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(1, cartPage.getItemsQuantity());
        // assert price from inventory == price from cart
        assertEquals(inventoryPage.getPriceOfFirstItem(), cartPage.getPriceOfFirstAddedItem());

    }

    @Test
    public void successAdding3Item(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnBoltTshirtAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getItemsQuantity());
    }

    // написать тест на проверку пустой корзины, если мы зашли в корзину, ничего туда не добавив
    @Test
    public void emptyCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty());
    }

}
