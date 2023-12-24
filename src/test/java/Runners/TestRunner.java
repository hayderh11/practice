package Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue="step_def",
		tags="@etsySearchTest",
		plugin = {"pretty", "html:target/HtmlReports/index.html",
				"json:target/JSONReports/report.json",
				"junit:target/JUnitReports/report.xml"},
		// when it's true, cucumber only runs the scenario steps that have not been implemented.
		publish=true
		)

public class TestRunner {

}
