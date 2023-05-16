import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void itemQuantityTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // assert item quantity equals 6
        assertEquals(6, inventoryPage.getItemsQuantity());
        assertTrue(inventoryPage.allItemsAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreNotEmpty());
        // all item names contains with "Sauce Labs"
        assertTrue("Not all names contains Sauce Labs", inventoryPage.allNamesStartWithSauceLabs());
        // тест должен упасть
    }

    // Price low to high (сортировка товаров на странице)
    @Test
    public void sortLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // choose "Price low to high"
        inventoryPage.choosePriceLowToHighSortOption();
        //check correct sort by "Price Low to High"
        assertTrue(inventoryPage.checkPriceSortFromLowToHigh());
    }

    @Test
    public void sortHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // choose "Price High to Low"
        inventoryPage.choosePriceHighToLowSortOption();
        //check correct sort by "Price High to Low"
        assertTrue(inventoryPage.checkPriceSortFromHighToLow());
    }

    //Sort by name (A-Z)
    //Sort by name (Z-A)

    @Test
    public void sortNameAToZ() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // choose "Name A to Z"
        inventoryPage.chooseNameAToZSortOption();
        //check correct sort by "Name A to Z"
        assertTrue(inventoryPage.checkNameSortFromAToZ());
    }

    @Test
    public void sortNameZToA() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // choose "Name Z to A"
        inventoryPage.chooseNameZToASortOption();
        //check correct sort by "Name Z to A"
        assertTrue(inventoryPage.checkNameSortFromZToA());
    }

}
