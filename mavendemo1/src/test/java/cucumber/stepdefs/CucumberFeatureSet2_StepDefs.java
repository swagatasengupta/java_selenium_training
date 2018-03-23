package cucumber.stepdefs;

import cucumber.api.java.en.Given;

public class CucumberFeatureSet2_StepDefs {
	@Given("^feature2 scenario1 precondition$")
	public void feature_scenario_precondition() {
	   	System.out.println("feature 2, scenario 1 executed");
	}

	@Given("^feature2 scenario outline precondition (.+)$")
	public void feature_scenario_outline_precondition_name(String name) {
		System.out.println("feature 2, scenario outline executed for " + name);
	}
	@Given("^feature2 scenario2 precondition$")
	public void feature1_scenario2_precondition() {
	   	System.out.println("feature 2, scenario 2 executed");
	}

	@Given("^feature2.2 scenario outline precondition (\\d+)$")
	public void feature_scenario_outline_precondition_name(int val) {
		System.out.println("feature 2.2, scenario outline executed for " + val);
	}

}
