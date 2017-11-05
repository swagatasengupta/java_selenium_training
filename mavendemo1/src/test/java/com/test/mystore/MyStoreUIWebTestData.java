package com.test.mystore;

import org.testng.annotations.DataProvider;

public class MyStoreUIWebTestData {
	@DataProvider(name="test_createAddress")
	public Object[][] getData() {
		return new Object[][] {
			{"Fname", "LName", "Addr1", "City1", "Alaska", "12345", "United States", "1234567890", "1234567890","ADD_ALIAS"},
			//{"Fname2", "LName2", "Addr2", "City1", "Alaska", "12345", "United States", "1234567890", "1234567890","ADD_ALIAS"},
		};
	}

}
