package threads;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * This class reads a configuration file and reads which directories are to be monitored,
 * Till what time and in what frequency.
 * Based on this information, this class starts thread of monitor (DirMonitor), one for each folder
 * The monitor threads monitor the respective folders for any file addition, deletion
 * and directory addition and deletion
 * in the end, the total files and directories added or removed are reported
*/

public class FolderMonitorDemo {

	public static int TotalFilesAdded;
	public static int TotalFilesRemoved;
	public static int TotalDirsAdded;
	public static int TotalDirsRemoved;
	public static final String CONFIG_FILE_PATH = "C:\\Users\\Swagat\\Desktop\\DirsToMonitor.txt";

	// The below define the information structure in configuration file
	// example: "c:\\users\\me\\desktop;120;5"
	// first entry is folder which is to be monitored, delimited by a character and
	// then the monitoring time is specified
	// and lastly, the frequency in which the

	public static final String CONFIG_FILE_DELIM_CHAR = ";";
	public static final int CONFIG_FILE_POS_FOLDER = 0;
	public static final int CONFIG_FILE_POS_DURATION = 1;
	public static final int CONFIG_FILE_POS_INTERVAL = 2;

	// The synchronized functions below ensure that the threads access the functions
	// one at a time
	// These functions are used to aggregate monitoring results from all the threads
	public static synchronized void updateTotalDirsAddedCount(int num) {
		TotalDirsAdded += num;
	}

	public static synchronized void updateTotalFilesAddedCount(int num) {
		TotalFilesAdded += num;
	}

	public static synchronized void updateTotalDirsRemovedCount(int num) {
		TotalDirsRemoved += num;
	}

	public static synchronized void updateTotalFilesRemovedCount(int num) {
		TotalFilesRemoved += num;
	}

	public FolderMonitorDemo() {
		TotalFilesAdded = 0;
		TotalFilesRemoved = 0;
		TotalDirsAdded = 0;
		TotalDirsRemoved = 0;
	}

	public static void main(String[] args) {

		BufferedReader buffRdr = null;
		//Define an array of monitors but as the number of monitors will be known only after reading configuration file
		//the array will be initialized later. 
		DirMonitor mon[];
		try {
			//Get line count from config file 
			FileInputStream fstream = new FileInputStream(CONFIG_FILE_PATH);
			buffRdr = new BufferedReader(new InputStreamReader(fstream));
			int configFileLineCount = (int) buffRdr.lines().count();
			System.out.println("Total lines in config life \'" + CONFIG_FILE_PATH + "\' is " + configFileLineCount);

			//reposition reading marker at the beginning of file to read lines one by one now,
			// validate the lines and initiate a thread if everything is ok
			//The assumption is that all line elements could be
			//a valid entry and initiate monitor array with the size.
			//But since there can be bad entries too, every entry will be validated.
			
			fstream.getChannel().position(0);
			buffRdr = new BufferedReader(new InputStreamReader(fstream));
			mon = new DirMonitor[configFileLineCount];
			String currLine;
			String[] currLineElems;

			//This will be used for tracking how many threads successfully get created.
			//later in the code, it will be used to join the threads to main to wait for all of them to finish.
			int monitorThreadCounter = 0;

			buffRdr = new BufferedReader(new FileReader(CONFIG_FILE_PATH));

			while ((currLine = buffRdr.readLine()) != null) {
				//Check for blank line and skip if any. Continue the loop.
				if (currLine.trim().length() == 0) {
					System.out.println("Blank line encountered in config file. Skipping...");
					continue;
				}
				//split the line content into desired components
				currLineElems = currLine.trim().split(CONFIG_FILE_DELIM_CHAR);

				try {
					//try to initialize new thread with values read. if everything is OK, thread will get started
					//or else exception will be caught
					mon[monitorThreadCounter] = new DirMonitor(currLineElems[CONFIG_FILE_POS_FOLDER].trim(),
							Long.parseLong(currLineElems[CONFIG_FILE_POS_DURATION].trim()),
							Long.parseLong(currLineElems[CONFIG_FILE_POS_INTERVAL].trim()));
					mon[monitorThreadCounter].start();
					monitorThreadCounter++;
				} catch (NumberFormatException e) {
					System.out.println("Number format exception occured in line: \'" + currLine
							+ "\' bad entry in config file. Skipping...");
					continue;//skip the bad entry and continue the loop.
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Array out of bound exception occured in line: \'" + currLine
							+ "\' bad entry in config file. Skipping...");
					continue;//skip the bad entry and continue the loop.
				}
			}

			{
				//join all the threads using a loop.
				for (int i = 0; i < monitorThreadCounter; i++) {
					mon[i].join();

				}

				//display the values of total files and directories added or removed.
				System.out.println("Total Files Added: " + FolderMonitorDemo.TotalFilesAdded);
				System.out.println("Total Files Removed: " + FolderMonitorDemo.TotalFilesRemoved);
				System.out.println("Total Directories Added: " + FolderMonitorDemo.TotalDirsAdded);
				System.out.println("Total Directories Removed: " + FolderMonitorDemo.TotalDirsRemoved);

			}

		} catch (Exception e) {
			e.toString();
		} finally {
			try {
				//close buffered reader
				if (buffRdr != null)
					buffRdr.close();
			} catch (IOException e) {
				e.toString();
			}
		}

	}

}
