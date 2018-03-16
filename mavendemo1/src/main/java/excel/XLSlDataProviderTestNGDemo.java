package excel;

import java.io.File;
import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class XLSlDataProviderTestNGDemo {

	@DataProvider(name = "xls_provider")
	public Object[][] xlsDataProvider(){
		String excelFilePath = new File("resources/TestXLS.xls").getAbsolutePath();
		return ExcelUtil.getXLSTableDataProvider(excelFilePath, "Sheet1",1);
	}
	
	@DataProvider(name = "xlsx_provider")
	public Object[][] xlsxDataProvider(){
		String excelFilePath = new File("resources/TestXLSX.xlsx").getAbsolutePath();
		return ExcelUtil.getXLSXTableDataProvider(excelFilePath, "Sheet1",1);
	}
	
	@Test(dataProvider = "xls_provider")
	public void test01(String id, String name, double age, boolean enabled) {
		System.out.println("------------------");
		System.out.println("Data Set");
		System.out.println("ID: " + id + ", Name: "+ name + ", Age: " + (int)age + ", Enabled: " + enabled);
		System.out.println("------------------");
		
	}
	@Test(dataProvider = "xlsx_provider")
	public void test02(boolean enabled, double id, String userID, Date dob, Date today, double age) {
		System.out.println("------------------");
		System.out.println("Data Set");
		System.out.println("Enabled: " + enabled + ", ID: "+ id + ", userID: " + userID + ", DOB: " + dob + ", today: " + today + ", Age: " + age);
		System.out.println("------------------");
		
	}
	
}
