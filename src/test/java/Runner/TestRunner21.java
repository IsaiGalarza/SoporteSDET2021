package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/Features/AdminTest.feature", glue =  "com.numeral21" )
public class TestRunner21 extends AbstractTestNGCucumberTests {

}
