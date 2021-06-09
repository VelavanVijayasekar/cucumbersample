package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/Features/FeatureFile.feature", glue = {
		"stepDefenition" }, plugin = { "pretty", "html:target/CucumberReports/report.html",
				"json:target/CucumberReports/report.json",
				"junit:target/CucumberReports/report.xml" }, monochrome = true

)

public class Runner {

}
