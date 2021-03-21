package dz5;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber-reports/CucumberTests.json",
                "junit:target/cucumber-reports/CucumberTests.xml",
                "html:target/cucumber-reports/index.html"},
        glue = {"dz5/TestClass", "dz5/Hooks"},
        features = "src/test/java/dz5/FeatureFiles",
        tags = "@TestR"
)
public class RunCucumber {
    public RunCucumber() {
    }

}
