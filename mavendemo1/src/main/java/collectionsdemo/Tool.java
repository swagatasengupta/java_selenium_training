package collectionsdemo;

import java.util.ArrayList;

public class Tool {
	int cost;
	String name;
	ArrayList<String> primePurpose;
	ArrayList<String> supportedProgLangs;
	ArrayList<String> supportedOSs;
	ArrayList<String> supportedBrowsers;
	ArrayList<String> supportedCITools;
	ArrayList<String> supportedTechnologies;
	int easeOfLearning;
	int easeOfCollaboration;
	int levelOfDocumentationAvail;
	
	boolean primaryRecommendation;
	boolean secondaryRecommendation;

	public boolean isProgLangSupported(String lang){
		return true;
	}
}
