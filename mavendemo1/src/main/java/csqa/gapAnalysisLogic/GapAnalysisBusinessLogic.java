package csqa.gapAnalysisLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class GapAnalysisBusinessLogic {

	private final String BULLET_UTF = "\u2022";
	private final boolean DEBUG_MODE = false;

	private HashMap<String, Integer> levelThresholdMap = new HashMap<String, Integer>();
	private HashMap<String, Double> levelAdjustmentMap = new HashMap<String, Double>();
	private HashMap<String, String> doingWellMap = new HashMap<String, String>();
	private HashMap<String, String> improvementMap = new HashMap<String, String>();

	private void prepareMapsFromJSON(String jsonFilePath) {
		JSONTokener tokener = null;
		JSONArray jArr = null;
		if (DEBUG_MODE)
			System.out.println("preparing map from JSON");
		try {
			// Read Answers JSONFile using JSON tokener
			tokener = new JSONTokener(new FileReader(jsonFilePath));

			// Get JSONArray of answers and their attributes
			// Store answerKey : <Attribute> in various Maps
			jArr = new JSONArray(tokener);
			for (int i = 0; i < jArr.length(); i++) {
				JSONObject ansJSONObj = (JSONObject) jArr.get(i);
				String ansKey = (String) ansJSONObj.keys().next();
				JSONObject ansAttribs = ansJSONObj.getJSONObject(ansKey);

				levelThresholdMap.put(ansKey, ansAttribs.getInt("lvl_threshold"));
				levelAdjustmentMap.put(ansKey, ansAttribs.getDouble("lvl_adjustment"));
				doingWellMap.put(ansKey, ansAttribs.getString("doing_well"));
				improvementMap.put(ansKey, ansAttribs.getString("improvement"));

				if (DEBUG_MODE) {
					displayAllMapContents();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException: " + e.getMessage());
		} catch (JSONException e) {
			System.out.println("JSONException: " + e.getMessage());
		}
	}

	private void displayAllMapContents() {
		System.out.println(levelThresholdMap.toString());
		System.out.println(levelAdjustmentMap.toString());
		System.out.println(doingWellMap.toString());
		System.out.println(improvementMap.toString());
	}

	public Map<String, HashMap> analyzeGap(String[] buildmgmtAnswers, String[] envAnswers, String[] releaseAnswers,
			String[] testAnswers, String jsonFilePath) {

		Map<String, HashMap> analysisAndRecomm = new HashMap<String, HashMap>();

		if (buildmgmtAnswers.length == 0 || envAnswers.length == 0 || releaseAnswers.length == 0
				|| testAnswers.length == 0 || jsonFilePath.isEmpty()) {
				System.out.println("At least one of the inputs is a blank array. Cannot proceed.");
			return null;
		}

		// Load JSON, parse it into various Map variables
		prepareMapsFromJSON(jsonFilePath);

		// get analysis Map for each area, put it in Map and return
		analysisAndRecomm.put("buildMaturityAnalysis", getAnalysisMap(buildmgmtAnswers));
		analysisAndRecomm.put("envMaturityAnalysis", getAnalysisMap(envAnswers));
		analysisAndRecomm.put("releaseMaturityAnalysis", getAnalysisMap(releaseAnswers));
		analysisAndRecomm.put("testMaturityAnalysis", getAnalysisMap(testAnswers));

		return analysisAndRecomm;
	}

	private HashMap<String, String> getAnalysisMap(String[] answerKeys) {

		double level = 0;
		double levelAdj = 0.0;
		String doingWellList = "";
		String improvementList = "";

		HashMap<String, String> analysisMap = new HashMap<String, String>();

		for (String answerKey : answerKeys) {
			double currLevel = (double) levelThresholdMap.get(answerKey);
			if (currLevel > level) {
				level = currLevel;
			}
			levelAdj += levelAdjustmentMap.get(answerKey);
			String currDoingWell = doingWellMap.get(answerKey).trim();
			if (!currDoingWell.isEmpty()) {
				doingWellList += BULLET_UTF + "\t" + currDoingWell + "\r\n";
			}
			String currImprovement = improvementMap.get(answerKey).trim();
			if (!currImprovement.isEmpty()) {
				improvementList += BULLET_UTF + "\t" + currImprovement + "\r\n";
			}
		}

		level += levelAdj;
		// If final adjusted level is < = 0, bring it to 1.0
		if (level <= 1.0) {
			level = 1.0;
		}

		if (doingWellList.isEmpty()) {
			doingWellList = "Well, it seems like you really need to focus in this particular area within your"
					+ " Continuous Integration / Continuous Delivery process maturity."
					+ " Please go through the list of what you can do better";
		}

		if (improvementList.isEmpty()) {
			improvementList = "Just sustain what you are doing. Keep up the great work!";
		}

		analysisMap.put("finalLevel", (long) (Math.round(level)) + "");
		analysisMap.put("finalDoingWell", doingWellList);
		analysisMap.put("finalImprovements", improvementList);

		return analysisMap;
	}

}
