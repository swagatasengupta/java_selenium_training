package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

	private static List<String> filesListInDir = new ArrayList<String>();
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

	public static boolean moveFile(String sourceFilePath, String destinationFolder, boolean overWrite) {
		return moveFile(sourceFilePath, destinationFolder, null, overWrite);
	}

	public static boolean moveFile(String sourceFilePath, String destinationFolder, String renameTo,
			boolean overWrite) {
		File srcFile = new File(sourceFilePath);
		// If source file is not a file or does not exist, exit
		if (!srcFile.isFile() || !srcFile.exists()) {
			System.out.println(sourceFilePath + " either does not exist or is not a file. Cannot move.");
			return false;
		}
		File destDir = new File(destinationFolder);
		// if destination directory does not exist, create it
		if (!destDir.exists()) {
			System.out.println(destinationFolder + " does not exist. Creating...");
			if (createFolderHierarchy(destinationFolder) == false) {
				System.out.println("Could not create directory path: " + destinationFolder);
				return false;
			}
		}
		// if destination directory is not a directory, exit
		if (!destDir.isDirectory()) {
			System.out.println(destinationFolder + " is not a directory. Cannot move.");
			return false;
		}
		// if a file need not be renamed, use same file name, else rename
		// in either case, check if overwrite is true and handle accordingly
		if (renameTo == null) {
			try {
				if (overWrite) {
					Files.move(srcFile.toPath(),
							new File(destinationFolder + File.separator + srcFile.getName()).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					srcFile.delete();
				} else {
					Files.move(srcFile.toPath(),
							new File(destinationFolder + File.separator + srcFile.getName()).toPath());
					srcFile.delete();
				}

			} catch (java.nio.file.FileAlreadyExistsException ex) {
				System.out.println(destinationFolder + File.separator + srcFile.getName()
						+ " already exists. Cannot move. You may use overwrite flag as appropriate.");
				return false;
			} catch (IOException e) {
				System.out.println("Error Occured: " + e.toString());
				return false;
			}

		} else {
			try {
				if (overWrite) {
					Files.move(srcFile.toPath(), new File(destinationFolder + File.separator + renameTo).toPath(),
							StandardCopyOption.REPLACE_EXISTING);
					srcFile.delete();
				} else {
					Files.move(srcFile.toPath(), new File(destinationFolder + File.separator + renameTo).toPath());
					srcFile.delete();
				}

			} catch (java.nio.file.FileAlreadyExistsException ex) {
				System.out.println(destinationFolder + File.separator + renameTo
						+ " already exists. Cannot move. You may use overwrite flag as appropriate.");
				return false;
			} catch (IOException e) {
				System.out.println("Error Occured: " + e.toString());
				return false;
			}

		}

		return true;
	}

	/*
	 * The function moves all the files and (from sub-directories also) to target directory
	 * But the source folder structure is not deleted through files are removed after they are moved successfully.
	 * 
	 */
	public static boolean moveAllFiles(String sourceFolder, String destinationFolder, boolean overWrite) {
		boolean retVal = true;
		//if source directory does not exist or is not a directory, exit
		File srcDir = new File(sourceFolder);
		if (!srcDir.exists() || !srcDir.isDirectory()) {
			System.out.println(sourceFolder + " either does not exist or is not a directory. Cannot move.");
			return false;
		}
		//if destination directory does not exist, create 
		File destDir = new File(destinationFolder);
		if (!destDir.exists()) {
			System.out.println(destinationFolder + " does not exist. Creating...");
			if (createFolderHierarchy(destinationFolder) == false) {
				System.out.println("Could not create directory path: " + destinationFolder);
				return false;
			}
		}
		//move each file one by one using reusable function above.
		//if there is a sub directory, call this function recursively to move files from there too.
		System.out.println("Moving all files from: " + sourceFolder);
		try {
			resetFilesListInDir();
			populateFilesList(srcDir);
		for (String file : filesListInDir) {
			String targetFileAbsPath = destinationFolder + File.separator + file.substring(sourceFolder.length() + 1, file.length());
			moveFile(file,
					new File(targetFileAbsPath).getParent(), null, overWrite);
		}
		} catch (Exception e) {
			retVal = false;
			e.printStackTrace();
		}

		return retVal;
	}

	public static boolean createFolder(String dir){
		boolean retVal = true;
		File fDir = new File(dir);
		if(fDir.exists()) {
			System.out.println(dir + " already exists.");
			return false;
		} else {
			retVal = fDir.mkdir();
		}
		return retVal;
	}

	public static boolean createFolderHierarchy(String folder) {

		boolean retVal = true;
		try {
			File allDirs = new File(folder);

			if (allDirs.exists()) {
				System.out.println("Directory: " + folder + " already exists");
				return retVal;
			} else if (allDirs.mkdirs()) {

				System.out.println("created all directories successfully");
				return retVal;
			}

		} catch (Exception e) {
			System.out.println(e.toString());
			retVal = false;
		}
		return retVal;
	}

	/*
	 * This function zips the content of a directory and its sub-directories into
	 * the absolute zip file path mentioned in its parameters
	 */
	public static boolean zipFolderContents(String dirToZip, String zipFileAbsolutePath) {
		boolean retval = true;

		// If the directory to zip is not a directory or does not exist, exit
		File fDirToZip = new File(dirToZip);
		if (!fDirToZip.exists() || !fDirToZip.isDirectory()) {
			System.out.println(dirToZip + " is either not a directory or does not exist.");
			return false;
		}
		// If the zip file already exists, exit
		File zipFile = new File(zipFileAbsolutePath);
		if (zipFile.exists()) {
			System.out.println("Zip file: \'" + zipFileAbsolutePath + "\' already exists.");
			return false;
		}
		// If the zip file's parent folder does not exist, create the required folder
		// hierarchy
		String zipFileParentFolder = zipFile.getParent();
		File zipFileParent = new File(zipFile.getParent());
		if (!zipFileParent.exists()) {
			System.out.println("The parent directory: \'" + zipFileParentFolder + "\' does not exist. Creating...");
			createFolderHierarchy(zipFileParentFolder);
		}
		try {
			// Get list of files to in directory that is to be zipped
			System.out.println("Zipping contents of \'" + dirToZip + "\' into \'" + zipFileAbsolutePath + "\'");

			// in case this static variable was used before, reset it.
			resetFilesListInDir();
			populateFilesList(fDirToZip);

			// now zip files one by one
			// create ZipOutputStream to write to the zip file
			FileOutputStream fos = new FileOutputStream(zipFileAbsolutePath, false);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (String filePath : filesListInDir) {
				System.out.println("Zipping " + filePath);
				// for ZipEntry we need to keep only relative file path, so, using substring on
				// absolute path
				ZipEntry ze = new ZipEntry(
						filePath.substring(fDirToZip.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				// read the file and write to ZipOutputStream
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
			System.out.println(
					"Successfully zipped contents of \'" + dirToZip + "\' into \'" + zipFileAbsolutePath + "\'");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			retval = false;
		}
		return retval;
	}

	/*
	 * This function recursively adds content of any directory and its
	 * sub-directories into the static ArrayList filesListInDir variable defined in
	 * this class
	 */
	private static void populateFilesList(File dir) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile())
				filesListInDir.add(file.getAbsolutePath());
			else
				populateFilesList(file);
		}
	}

	private static void resetFilesListInDir() {
		for (int i = 0; i < filesListInDir.size(); i++) {
			filesListInDir.remove(i);
		}
	}
	


}
