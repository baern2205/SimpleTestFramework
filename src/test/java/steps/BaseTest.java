package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import rest.RestProperties;
import utils.ScreenshotTaker;

import java.time.Duration;
import java.util.Locale;

@NoArgsConstructor
public class BaseTest {

    protected static WebDriver driver;

    private static final RestProperties restProperties = new RestProperties();


    @BeforeAll()
    public static void browserSetup() throws Exception {
        String browser = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        } else if (browser.equalsIgnoreCase("opera")) {
            driver = WebDriverManager.operadriver().create();
        } else {
            throw new Exception("Unsupported browser");
        }

        driver.manage()
                .window().maximize();
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(15))
                .scriptTimeout(Duration.ofSeconds(15))
                .implicitlyWait(Duration.ofSeconds(15));
        driver.get(restProperties.getBaseUri().toString());
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(MAIN_PAGE_SERVICE_DROPDOWN)));
//        assertEquals(driver.getTitle(), "Freshcode: IT Consulting and Software Development Company");
    }





    @AfterAll()
    public static void tearDown(TestInfo result) {
        ScreenshotTaker.takeScreenshot(result, driver);
        driver.quit();
    }


}
