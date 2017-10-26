package exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ReadConfigFileIODemo {

	public static FileReader fReader;
	public static BufferedReader buffRdr;

	public static FileWriter fWriter;
	public static BufferedWriter buffWrtr;

	public static Properties prop;
	public static FileInputStream fis;

	public static String frwBasePath;
	public static final String masterConfigRelPath = "\\com\\config\\master_config.properties";

	/*
	 * This function returns local date time as per required pattern. The pattern
	 * has to be changed in the code if needed
	 */
	public static String getTimeStamp() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static void main(String[] args) {

		String configFilePath;
		String fileToReadPath;
		String fileToWritePath;
		String LineContent;
		boolean appendMode = false;

		try {
			// get Framework base path from system variable.
			frwBasePath = System.getenv("LXR_TEST_AUT_FRW");

			// Construct the path of master_config.properties file using the static variable
			// and the content of system variable read above
			// Once path is constructed load the properties file.
			configFilePath = frwBasePath + masterConfigRelPath;
			System.out.println("Loading properties file from: " + configFilePath);
			fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
			System.out.println("Loaded properties file successfully");

			// Construct the path of the file to be read.
			// Once path is constructed, use buffered reader object to read it

			fileToReadPath = frwBasePath + prop.getProperty("FILE1_PATH");
			System.out.println("Reading file from: " + fileToReadPath);
			fReader = new FileReader(fileToReadPath);
			buffRdr = new BufferedReader(fReader);

			// Construct the path of the file to be write contents into.
			// Note that the file name is getting generated dynamically based on system
			// time.
			// once buffered writer object to write the contents.
			fileToWritePath = frwBasePath + prop.getProperty("RESULT_PATH") + "\\" + getTimeStamp() + ".txt";
			System.out.println("Writing to file: " + fileToWritePath);
			fWriter = new FileWriter(fileToWritePath, appendMode);
			buffWrtr = new BufferedWriter(fWriter);

			System.out.println("Reading file content...");

			// Keep reading the file line by line and keep writing the contents to another
			// file
			while ((LineContent = buffRdr.readLine()) != null) {
				// Uncomment the below if you want to see file content printed on console output
				// System.out.println(LineContent);
				buffWrtr.write(LineContent + "\r\n");
			}

			System.out.println("Writing content successful!");

		} catch (Exception ex) {
			System.out.println("Error occured. Details: " + ex.toString());
			// ex.printStackTrace();
		} finally {
			try {
				if (buffRdr != null)
					buffRdr.close();
				if (buffWrtr != null)
					buffWrtr.close();
				if (fReader != null)
					fReader.close();
				if (fWriter != null)
					fWriter.close();

			} catch (IOException e) {
				System.out.println("Error while closing one of the file objects. Details: " + e.toString());
			}
		}

	}

}
