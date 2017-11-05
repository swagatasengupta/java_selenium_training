

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.lib.util.TimeUtil;

import com.lib.util.FileUtil;


public class Temp {

	public static void main(String[] args) {
		//System.out.println(TimeUtil.getTimeStamp());
		//System.out.println(TimeUtil.getTimeStamp("HH-mm-ss-SS, dd/MMM/yyyy"));
		FileUtil.copyAllFiles("E:\\test_e", "F:\\Music\\Mashups", false);
/*		FileUtil.moveFile("E:\\test_e\\test1.txt", "F:\\Music\\Mashups", true);
		FileUtil.moveFile("E:\\test_e\\test2.txt", "F:\\Music\\Mashups", "test123.txt", true);
		FileUtil.moveFile("E:\\test_e\\test3.txt", "F:\\Music\\Mashups", true);*/
		
		//FileUtil.moveAllFiles("E:\\test_e", "F:\\Music\\Mashups", true);
		//cleanUpEmptyDirectoryHeirarchy("E:\\test_e");
/*		try {
			deleteRecursive(new File("E:\\test_e"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println(new File("F:\\Music\\Mashups\\folder1").isDirectory());
		
/*		System.out.println(System.getProperty("os.name").toLowerCase().contains("windows"));
		System.out.println(File.separator);
*/
/*		System.out.println("encodedBytes "+ Base64.getEncoder().encodeToString("12345".getBytes()));
		byte[] decodedPwd = Base64.getDecoder().decode("MTIzNDU=");
		System.out.println(new String(decodedPwd));*/
/*		File allDirs = new File("C:\\Users\\Swagat\\Desktop\\Dir1\\Dir2\\Dir3");
		if(allDirs.mkdirs()) {
			System.out.println("created all directories successfully");
		
		}	
*/
	}

}
