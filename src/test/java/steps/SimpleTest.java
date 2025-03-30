package steps;

import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rest.RestProperties;

import java.time.Duration;

public class SimpleTest {

    private final WebDriverContainer driverContainer;
    private WebDriver driver;

    private static final RestProperties restProperties = new RestProperties();

    public SimpleTest(WebDriverContainer webDriverContainer) {
        this.driverContainer = webDriverContainer;
    }

    @Given("Open browser {string} and visit page")
    public void openBrowserAndVisitPage(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
            driverContainer.setDriver(WebDriverManager.chromedriver().create());
        } else if (browser.equalsIgnoreCase("edge")) {
            driverContainer.setDriver(WebDriverManager.edgedriver().create());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driverContainer.setDriver(WebDriverManager.firefoxdriver().create());
        } else if (browser.equalsIgnoreCase("safari")) {
            driverContainer.setDriver(WebDriverManager.safaridriver().create());
        } else if (browser.equalsIgnoreCase("opera")) {
            driverContainer.setDriver(WebDriverManager.operadriver().create());
        } else {
            throw new Exception("Unsupported browser");
        }

        driverContainer.getDriver().manage()
                .window().maximize();
        driverContainer.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(15))
                .scriptTimeout(Duration.ofSeconds(15))
                .implicitlyWait(Duration.ofSeconds(15));
        driverContainer.getDriver().get(restProperties.getBaseUri());

        this.driver = driverContainer.getDriver();
    }

    @When("Check {string} has text {string}")
    public void checkElementHasText(String elementType, String text) {
        driver.findElement(new By.ByXPath("//" + elementType + "[contains(text(), '" + text + "')]"))
                .isDisplayed();
    }
}
