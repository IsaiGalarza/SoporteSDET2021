package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/Features/JobTests.feature", glue = { "com.numeral22" })
public class TestRunner22 extends AbstractTestNGCucumberTests {

}
