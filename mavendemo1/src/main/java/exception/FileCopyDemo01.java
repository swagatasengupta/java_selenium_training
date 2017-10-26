package exception;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDemo01 {

	private static void copyFileUsingJava7Files(String source, String destFolder) {
		try {
		Path src = Paths.get(source);
		Path dest = Paths.get(destFolder+"\\"+src.getFileName());
		Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("copyFileUsingJava7Files> Copied successfully!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void copyFileUsingChannel(String source, String dest) {
	    
		FileChannel sourceChannel = null;
	    FileChannel destChannel = null;

	    try {
			File fSource = new File(source);
			File fDest = new File(dest);
			
	        sourceChannel = new FileInputStream(fSource).getChannel();
	        destChannel = new FileOutputStream(fDest).getChannel();
	        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	        System.out.println("copyFileUsingChannel> Copy Successful!");
	       }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    finally{
	           try {
	    		sourceChannel.close();
	    		destChannel.close();
	           } catch(Exception e) {
	        	   e.printStackTrace();
	           }
	   }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceFile = "E:\\eclipse\\Work-Space\\JavaTutorial_Swagat\\src\\exception\\source\\test.txt";
		String destFile = "E:\\eclipse\\Work-Space\\JavaTutorial_Swagat\\src\\exception\\destination\\copiedTest.txt";
		String destFolder = "E:\\eclipse\\Work-Space\\JavaTutorial_Swagat\\src\\exception\\destination2";
		copyFileUsingChannel(sourceFile, destFile);
		copyFileUsingJava7Files(sourceFile, destFolder);
	}

}
