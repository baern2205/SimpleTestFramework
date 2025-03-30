import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Cucumber
@Suite
@SelectPackages("src.test.java")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "src.test.java")
public class CucumberRunner {
}
