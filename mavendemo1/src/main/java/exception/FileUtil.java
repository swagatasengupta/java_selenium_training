package exception;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtil {

	/*
	 * The Copy File function copies the files to a directory
	 */

	public static boolean copyFile(String completeSourceFilePath, String destinationFolder, boolean overWrite) {
		try {
			// If source file does not exist or is a directory, return false
			File f = new File(completeSourceFilePath);
			if (!f.exists()) {
				System.out.println("Error: file does not exist");
				return false;
			}
			if (f.isDirectory()) {
				System.out.println("Error: cannot coppy directory using this function");
				return false;
			}
			// otherwise try to copy the file from source to destination using overwrite
			// flag if provided
			Path src = Paths.get(completeSourceFilePath);

			Path dest = Paths.get(destinationFolder + File.separator + src.getFileName());
			if (overWrite) {
				Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.copy(src, dest);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

		return true;
	}

	/*
	 * The Copy All Files function copies only the files under a folder and not its
	 * subdirectories please use accordingly
	 */

	public static boolean copyAllFiles(String sourceFolder, String destinationFolder, boolean overWrite) {
		boolean isSuccessful = true;
		try {
			// If source file does not exist or is a directory, return false
			File srcDir = new File(sourceFolder);
			if (!srcDir.exists()) {
				System.out.println("Error: directory does not exist");
				return false;
			}
			if (!srcDir.isDirectory()) {
				System.out.println("Error: source directory path provided is a file. Cannot proceed");
				return false;
			}
			// If source file does not exist or is a directory, return false
			File destDir = new File(sourceFolder);
			if (!destDir.exists()) {
				System.out.println("Error: destination directory does not exist");
				return false;
			}
			if (!destDir.isDirectory()) {
				System.out.println("Error: destination directory provided is a file. Cannot proceed");
				return false;
			}
			// copy all files in the source folder to destination folder
			File[] fileList = srcDir.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) {
					continue;
				}
				if (fileList[i].isFile()) {
					boolean retVal = copyFile(fileList[i].getPath(), destinationFolder, overWrite);
					if (retVal == false && isSuccessful)
						isSuccessful = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}

		return isSuccessful;
	}

	public static boolean moveFile(String sourceFilePath, String destinationFolder, boolean overWrite)
			throws IOException {
		return true;
	}

	public static boolean moveFile(String sourceFilePath, String destinationFolder, String renameTo, boolean overWrite)
			throws IOException {
		return true;
	}

	public static boolean moveAllFiles(String sourceFolder, String destinationFolder, boolean overWrite)
			throws IOException {
		return true;
	}

	public static boolean createFolder(String folder) throws IOException {
		return true;
	}

	public static boolean createFolderHierarchy(String folder) throws IOException {
		return true;
	}

	public static boolean zipFolderContents(String folder) throws IOException {
		return true;
	}
}
