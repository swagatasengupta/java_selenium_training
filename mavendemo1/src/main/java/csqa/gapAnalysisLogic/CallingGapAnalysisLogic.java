package csqa.gapAnalysisLogic;

import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class CallingGapAnalysisLogic {
	
	public static final String ANSWER_JSON_REL_PATH = "resources/gap_analysis_answer.json";
	
	public static void main(String[] args) {
		
		String jsonFilePath = new File(ANSWER_JSON_REL_PATH).getAbsolutePath();
		
		String[] buildmgmtAnswers = { "BQ1Y", "BQ2Y", "BQ3Y", "BQ4N", "BQ5N", "BQ6N", "BQ7E", "BQ8Y" };
		String[] envAnswers = { "EQ1Y", "EQ2Y", "EQ3Y", "EQ4Y", "EQ5Y" };
		// String[] releaseAnswers = { "RQ1Y", "RQ2Y", "RQ3N", "RQ4Y", "RQ5N" };
		String[] releaseAnswers = { "RQ1N", "RQ2N", "RQ3N", "RQ4N", "RQ5N" };

		String[] testAnswers = { "TQ1S", "TQ2N", "TQ3Y", "TQ4Y", "TQ5N", "TQ6Y" };
		GapAnalysisBusinessLogic code = new GapAnalysisBusinessLogic();
		Map<String, HashMap> analysis = code.analyzeGap(buildmgmtAnswers, envAnswers, releaseAnswers, testAnswers, jsonFilePath);
/*		System.out.println(analysis.toString());*/

		
		HashMap<String, String> buildMaturity = analysis.get("buildMaturityAnalysis");
		System.out.println("-------------------");
		System.out.println("Build Management Maturity");
		System.out.println("You are at level: " + buildMaturity.get("finalLevel"));
		System.out.println("What you are doing well: ");
		System.out.println(buildMaturity.get("finalDoingWell"));
		System.out.println("What you can do better: ");
		System.out.println(buildMaturity.get("finalImprovements"));
		
		HashMap<String, String> envMaturity = analysis.get("envMaturityAnalysis");
		System.out.println("-------------------");
		System.out.println("Environment Management Maturity");
		System.out.println("You are at level: " + envMaturity.get("finalLevel"));
		System.out.println("What you are doing well: ");
		System.out.println(envMaturity.get("finalDoingWell"));
		System.out.println("What you can do better: ");
		System.out.println(envMaturity.get("finalImprovements"));
		
		HashMap<String, String> releaseMaturity = analysis.get("releaseMaturityAnalysis");
		System.out.println("-------------------");
		System.out.println("Release Management Maturity");
		System.out.println("You are at level: " + releaseMaturity.get("finalLevel"));
		System.out.println("What you are doing well: ");
		System.out.println(releaseMaturity.get("finalDoingWell"));
		System.out.println("What you can do better: ");
		System.out.println(releaseMaturity.get("finalImprovements"));

		HashMap<String, String> testMaturity = analysis.get("testMaturityAnalysis");
		System.out.println("-------------------");
		System.out.println("Test Management Maturity");
		System.out.println("You are at level: " + testMaturity.get("finalLevel"));
		System.out.println("What you are doing well: ");
		System.out.println(testMaturity.get("finalDoingWell"));
		System.out.println("What you can do better: ");
		System.out.println(testMaturity.get("finalImprovements"));
		System.out.println("-------------------");


	}

}
