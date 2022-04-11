package testOptions;

import io.cucumber.testng.*;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions"},
        tags = "@MediumPriority or @LowPriority",
        monochrome = true
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
