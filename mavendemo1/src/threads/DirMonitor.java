package threads;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DirMonitor extends Thread {

	String dirToMonitor;
	long timeToMonitorInSecs;
	long timeIntervalInSecs;
	int lastCountOfFiles;
	int lastCountOfDirs;
	Thread fileMon;

	public static String getTimeStamp() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return ("[" + dtf.format(now) + "] ");
	}

	public DirMonitor(String folderToMonitor, long timeToMonitorInSecs, long timeIntervalInSecs) {
		this.dirToMonitor = folderToMonitor;
		this.timeToMonitorInSecs = timeToMonitorInSecs;
		this.timeIntervalInSecs = timeIntervalInSecs;
		fileMon = new Thread(this);
		try {
			fileMon.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		File dir = new File(dirToMonitor);
		if (!dir.exists()) {
			System.out.println("Thread id: " + Thread.currentThread().getId() + "==> Exiting thread, \'" + dirToMonitor
					+ "\' does not exist. Cannot monitor");
			return;

		} else if (!dir.isDirectory()) {
			System.out.println("Thread id: " + Thread.currentThread().getId() + "==> Exiting thread, \'" + dirToMonitor
					+ "\' is not a folder. Cannot monitor");
			return;
		}
		System.out.println("Thread id: " + Thread.currentThread().getId() + "==> Starting to monitor: " + dirToMonitor
				+ " for " + timeToMonitorInSecs + " seconds" + " with " + timeIntervalInSecs + " seconds frequency.");

		File[] fileList = dir.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				lastCountOfDirs++;
			}
			if (fileList[i].isFile()) {
				lastCountOfFiles++;
			}
		}
		System.out.println("Thread id: " + Thread.currentThread().getId() + ": In " + dirToMonitor + " there are "
				+ lastCountOfDirs + " existing directories" + " and " + lastCountOfFiles + " existing files");

		long currTime = System.currentTimeMillis();
		long targetEndTime = currTime + (timeToMonitorInSecs * 1000);

		long timeRemainingInmillis = targetEndTime - System.currentTimeMillis();
		while (timeRemainingInmillis > 0) {
			int currentDirCount = 0;
			int currentFileCount = 0;
			System.out.println(getTimeStamp() + "Thread id: " + Thread.currentThread().getId() + "==> Monitoring: "
					+ dirToMonitor + ". Time remaining: " + (int) (timeRemainingInmillis / 1000) + " seconds");

			fileList = dir.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) {
					currentDirCount++;
				}
				if (fileList[i].isFile()) {
					currentFileCount++;
				}
			}

			int diff = 0;

			if (currentDirCount > lastCountOfDirs) {
				diff = currentDirCount - lastCountOfDirs;
				FolderMonitorDemo.updateTotalDirsAddedCount(diff);
				System.out.println("Thread id: " + Thread.currentThread().getId() + "==> In Directory " + dirToMonitor
						+ ": " + diff + " directory(ies) got added");
			} else if (currentDirCount < lastCountOfDirs) {
				diff = lastCountOfDirs - currentDirCount;
				FolderMonitorDemo.updateTotalDirsRemovedCount(diff);
				System.out.println("Thread id: " + Thread.currentThread().getId() + "==> In Directory " + dirToMonitor
						+ ": " + diff + " directory(ies) got removed");
			}
			lastCountOfDirs = currentDirCount;

			if (currentFileCount > lastCountOfFiles) {
				diff = currentFileCount - lastCountOfFiles;
				FolderMonitorDemo.updateTotalFilesAddedCount(diff);
				System.out.println("Thread id: " + Thread.currentThread().getId() + "==> In Directory " + dirToMonitor
						+ ": " + diff + " file(s) got added");
			} else if (currentFileCount < lastCountOfFiles) {
				diff = lastCountOfFiles - currentFileCount;
				FolderMonitorDemo.updateTotalFilesRemovedCount(diff);
				System.out.println("Thread id: " + Thread.currentThread().getId() + "==> In Directory " + dirToMonitor
						+ ": " + diff + " file(s) got removed");
			}
			lastCountOfFiles = currentFileCount;

			try {
				Thread.sleep(timeIntervalInSecs * 1000);
			} catch (InterruptedException e) {
				e.toString();
			}

			timeRemainingInmillis = targetEndTime - System.currentTimeMillis();
		}

		System.out.println(getTimeStamp() + "Thread id: " + Thread.currentThread().getId() + "==> End Monitoring: "
				+ dirToMonitor);

	}

}
