package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/cucumberOptions",
		glue="stepDefinitions",
		plugin="pretty")

public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
