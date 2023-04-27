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
        // assert item quantity equals
        assertEquals(6, inventoryPage.getItemsQuantity());

        assertTrue(inventoryPage.allItemsAreDisplayed());
        //
        assertTrue(inventoryPage.allItemNamesAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreNotEmpty());

        assertTrue("Not all names contains Sauce Labs", inventoryPage.allNamesStartWithSauceLabs());
    }
}
