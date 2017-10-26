package basicTutorials;

public class TestCampaignsToPrint {
	//This class evaluates if a campaign gets printed based on
	// impressions value and conversion values passed on to it
	int impressionsValue;
	int conversionValue;
	String campaignName;
	
	//constructor should have 3 values passed on to it
	TestCampaignsToPrint(int impressionsValue, int conversionValue, String campaignName){
		this.impressionsValue = impressionsValue;
		this.conversionValue = conversionValue;
		this.campaignName = campaignName;
	}
	//this function evaluates if a campaign should get printed based on the value of
	// impressions and conversions
	void evaluateCampaignsToPrint() {
		if(impressionsValue > 0) {
			//rule 1-part 1: If impressions value is greater than 0 campaign is printed for sure
			System.out.println("Print campaign: " + campaignName);
			// rule 1.1: If conversion value is also greater than 0 campaign is
			// printed on sheet 1 else sheet 2
			if(conversionValue > 0) {
				System.out.println("Print " + campaignName + " in sheet 1");
			} else {
				System.out.println("Print " + campaignName + " in sheet 2");
			}
		} else {
			// rule 1 - part 2: If impressions value is not greater than 0,
			// do not print campaign and filter it out
			System.out.println("Filter out campaign " + campaignName);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		//Define test data in a two dimensional array
		String[][] testCampaignTestData = {{"1","1","C1"},{"0","1","C2"},{"5","0","C3"},{"2","4","C4"}};
		//define array object of the test campaign class = length of test data
		TestCampaignsToPrint[] TestCampaign = new TestCampaignsToPrint[testCampaignTestData.length];

		//iteratively initialize the test campaign object array elements
		//passing value from test data array
		// and call function to evaluate the test conditions
		for (int i=0; i < testCampaignTestData.length; i++) {
			// convert integer values from string input 
			int impressionsValue = Integer.parseInt(testCampaignTestData[i][0]);
			int conversionValue = Integer.parseInt(testCampaignTestData[i][1]);
			String campaignName = testCampaignTestData[i][2];
			
			TestCampaign[i] = new TestCampaignsToPrint(impressionsValue, conversionValue, campaignName);
			System.out.println("Test " + (i+1));
			TestCampaign[i].evaluateCampaignsToPrint();
			
		}
		
	}

}
