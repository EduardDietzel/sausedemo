import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void  checkAllLinksAreDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // нажимаем на кнопку бургер-меню
        inventoryPage.clickOnBurgerMenuBtn();
        SideBar sideBar = new SideBar(driver);
        // check All items About, Logout, Reset App State - are enabled
        assertTrue(sideBar.aboutIsEnabled());
        assertTrue(sideBar.allItemsIsEnabled());
        assertTrue(sideBar.logoutIsEnabled());
        assertTrue(sideBar.resetAppStateIsEnabled());
        sleep(3000);
        assertTrue(sideBar.allItemsIsDisplayed());
    }

    // logout - убедиться, что мы разлогинились, нажав на кнопку логаут
}
