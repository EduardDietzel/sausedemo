import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

//    @Test
//    public void loginWithValidDate() {
//        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        userNameInputField.sendKeys("standard_user");
//        WebElement passwordInputField = driver.findElement(By.id("password"));
//        passwordInputField.sendKeys("secret_sauce");
//        WebElement loginButton = driver.findElement(By.id("login-button"));
//        loginButton.click();
//        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
//        assertTrue(inventoryList.isDisplayed());
//        // надо унифицировать тест
//        // паттерны Пейдж-Обджект
//    }


    @Test
    public void loginWithValidDataPO(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.clickOnLoginButton();
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
    }

    @Test
    public void loginWithLockedOutUser(){
        LoginPage loginPage = new LoginPage(driver);
        User lockedOutUser = new User("locked_out_user","secret_sauce");
        loginPage.enterValueToUserName(lockedOutUser);
        loginPage.enterValueToPassword(lockedOutUser);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Sorry, this user has been locked out"));
    }
    @Test
    public void loginWithInvalidData(){
        // check error message text
        // "Username and password do not match any user in this service"
        LoginPage loginPage = new LoginPage(driver);
        User invalidUser = new User("jgsacgjfkcdsgfc", "secret_sauce");
        loginPage.enterValueToUserName(invalidUser);
        loginPage.enterValueToPassword(invalidUser);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }


}
