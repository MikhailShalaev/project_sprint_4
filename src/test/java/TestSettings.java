import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectmodel.HomePage;
import testdata.Constants;

import java.time.Duration;

abstract class TestSettings {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Constants.TEST_URL);
        HomePage homePage = new HomePage(driver);
        homePage.cookieMonster();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}