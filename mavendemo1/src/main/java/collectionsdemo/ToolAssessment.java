package collectionsdemo;

import java.util.ArrayList;
import java.util.List;


public class ToolAssessment {

	
	public static void main(String[] args) {
		Tool testNG = new Tool();
		ToolGroup unitTestingTools = new ToolGroup();
		unitTestingTools.toolList.add(testNG);
		unitTestingTools.toolList.remove(testNG);
	}

}
