import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void testSuccessCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // добавление 3 товаров в корзину и заход в корзину:
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnBoltTshirtAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Groll");
        checkoutStepOnePage.enterValueToZipCode("7676");
        checkoutStepOnePage.clickOnContinueButton();
        // попадаем на страницу 2
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.clickOnFinishButton();
        // assert text "Thank you for your order!" is displayed:
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        System.out.println("Text on finish page: " + checkoutCompletePage.getSuccessMessageText());
        assertEquals("Thank you for your order!", checkoutCompletePage.getSuccessMessageText());

    }
}
