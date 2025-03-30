package hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import steps.WebDriverContainer;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.Getter;
import rest.RestProperties;
import utils.ScreenshotTaker;


@Getter
public class Hooks {

    public Hooks(WebDriverContainer webDriverContainer) {
        this.driverContainer = webDriverContainer;
    }

    private final WebDriverContainer driverContainer;

//    private WebDriver driver;

    private static final RestProperties restProperties = new RestProperties();

//    @Before
//    public void before(Scenario scenario) {
//        this.driver = driverContainer.getDriver();
//    }

    @After
    public void after(Scenario scenario) {
        ScreenshotTaker.takeScreenshot(scenario, driverContainer.getDriver());
        driverContainer.getDriver().quit();
    }
}
