package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/Features/DirectoryTest.feature", glue = { "com.numeral23" })
public class TestRunner23 extends AbstractTestNGCucumberTests {

}
