package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample1 {

	//private static final String FILENAME = "E:\\eclipse\\Work-Space\\JavaTutorial_Swagat\\src\\exception\\ReadFileExample1.txt";
	private static final String FILENAME = "E:\\eclipse\\Work-Space\\JavaTutorial_Swagat\\src\\exception\\demo.properties";
	
	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			//br = new BufferedReader(new FileReader(FILENAME)); // another way to initialize
			String sCurrentLine;
			
			boolean fileNotEmpty = false;
			
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				
				if(!fileNotEmpty) {//checks if the fileNot empty flag is false, it sets it to true
					fileNotEmpty = true;
				}
			}
			if(!fileNotEmpty) {
				System.out.println("Empty file!");
			}

		} catch (IOException e) {
			System.out.println("Please check that the file: " + FILENAME + " exists. \n" + e.toString());
			//e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}