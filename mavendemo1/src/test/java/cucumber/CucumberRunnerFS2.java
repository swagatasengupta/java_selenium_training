package cucumber;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		strict=true,
		features = "src/test/java/cucumber/features/featureset2",
		glue = "cucumber.stepdefs",
		plugin = {"pretty", "html:target/cucumber-html-report2",
				"rerun:target/rerun2.txt",
				"json:target/cucumber2.json",
				"testng:target/testNG2.xml"},
				tags = {"@DemoTestScenarioF2","@feature2"}
		)


public class CucumberRunnerFS2 {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass
	public void setUp() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups = "cucumber", description = "Runs Cucumber Feature Set 2", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
	@DataProvider(name = "features")
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
        
    }
	@AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
	
}
