package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// set cucumber options 
@CucumberOptions(
		features = "src/test/resources/feature" ,
		glue = "stepdefinations",
		plugin = {
				"pretty", 
				"html:target/cucumber-reports.html",	
		},
		monochrome = true, // for formatted console
		tags = "(@Auth or @BookingAPI) and (not @ignore)" // include tags 
)

// extend AbstractTestNGCucumberTests class
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests 
{

}
