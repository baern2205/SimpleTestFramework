package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.stream.Stream;

public class WebDriverFactory {

    enum Driver {
        CHROME,
        FIREFOX
    }

    public static WebDriver get( final Driver driver ) {
        return switch (driver) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("No '" + driver + "' driver available.");
        };
    }

    public static Stream<WebDriver> getAll() {
        return Arrays.stream( Driver.values() ).map( WebDriverFactory::get );
    }
}
