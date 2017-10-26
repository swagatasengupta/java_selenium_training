package basicTutorials;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampDemo {

	public static String getTimeStamp() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now); 
	}
	
	public static String getDateTimeInFormat(String format) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now); 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTimeStamp());
		System.out.println(getDateTimeInFormat("yyyy/MM/dd HH:mm:ss"));
		System.out.println(getDateTimeInFormat("dd-MM-yy HH.mm.ss"));
		System.out.println(getDateTimeInFormat("dd-MM-yy HH.mm.ss a"));
	}

}
