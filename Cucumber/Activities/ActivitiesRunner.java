package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@SmokeTest",
	    plugin = {"pretty"},
	    monochrome = true
	)

public class ActivitiesRunner {
    //empty
}