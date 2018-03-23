@feature2
Feature: FeatureSet 2 feature 1
  Cucumber Demo - Feature2.1

  @DemoTestScenarioF2
  Scenario: demo scenario for feature1
    Given feature2 scenario1 precondition

  @DemoTestScenarioF2
  Scenario Outline: Demo scenario outline for feature1
    Given feature2 scenario outline precondition <name>
	Examples: 
	| name  |
	| F2 name1 |
	| F2 name2 |
