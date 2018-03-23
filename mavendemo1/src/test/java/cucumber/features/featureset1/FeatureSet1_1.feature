@feature1
Feature: FeatureSet 1 feature 1
  Cucumber Demo - Feature1.1

  @DemoTestScenarioF1
  Scenario: demo scenario for feature1
    Given feature1 scenario1 precondition

  @DemoTestScenarioF1
  Scenario Outline: Demo scenario outline for feature1
    Given feature1 scenario outline precondition <name>
	Examples: 
	| name  |
	| F1name1 |
	| F1name2 |
