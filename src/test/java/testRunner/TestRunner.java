package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@cucumberOptions(
		//features={.//Features/"},
		//features={.//Features/Login.feature"},
		//features={.//Features/LoginDDTExcel.feature"},
		features= {"@target/rerun.txt"},
		glue="StepsDefinations",
		plugin= {"pretty,"html:reports/myreport.html","rerun:target/rerun.txt","
				+ "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true;
		publish=true
				//tags="@sanity"
				//tags="@regression"
				//tags="@sanity and @regression"
				//tags="@sanity and not @regression"
				//tags="@sanity or @regression"
		)
public class TestRunner {

}
