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

    public void enterValueToUserName(User user){
        userNameInputField.sendKeys(user.getUsername());
    }

    public void enterValueToPassword(User user){
        passwordInputField.sendKeys(user.getPassword());
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void errorMessageTextIsCorrect(String expectedText) {
        assertEquals(expectedText, errorMessage.getText());
    }

    public String getErrorMessageText(){
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
