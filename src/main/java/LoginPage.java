import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;


    @Step("Enter value to username")
    public void enterValueToUserName(User user){
        // enterTextToElement(user.getUsername(), userNameInputField);
        userNameInputField.sendKeys(user.getUsername());
    }

    @Step("Enter value to password")
    public void enterValueToPassword(User user){
        // enterTextToElement(user.getPassword(), passwordInputField);
        passwordInputField.sendKeys(user.getPassword());
    }

    @Step("Push the Login button")
    public void clickOnLoginButton(){
        // clickOnElement(loginButton);
        loginButton.click();
    }

    public void errorMessageTextIsCorrect(String expectedText) {
        assertEquals(expectedText, errorMessage.getText());
    }

    public String getErrorMessageText(){
        // return getTxtOfElement(errorMessage);
        return errorMessage.getText();
    }

    public void successLogin(User user){
        userNameInputField.sendKeys(user.getUsername());
        passwordInputField.sendKeys(user.getPassword());
        loginButton.click();
    }

    public boolean loginButtonIsDisplayed(){
        return loginButton.isDisplayed();
    }
}
