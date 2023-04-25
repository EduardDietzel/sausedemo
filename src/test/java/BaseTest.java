import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

    @After
    public void TearDown(){
        driver.quit();
    }

    String validUserNameValue = "standard_user";
    String validUSerPasswordValue = "secret_sauce";
    User validUser = new User(validUserNameValue,validUSerPasswordValue);
    User lockedOutUser = new User("locked_out_user","secret_sauce");
    User invalidUser = new User("jgsacgjfkcdsgfc", "secret_sauce");
}
