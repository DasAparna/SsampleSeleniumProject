package com.sampleSeleniumProject.TestScripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sampleSeleniumProject.PageObjects.LoginPage;
import com.sampleSelenumProject.utilities.Data_Reader;
import com.sampleSelenumProject.utilities.Initiate_Driver;

public class LoginPage_Test extends Initiate_Driver {
	public static String email_ID;

	@BeforeTest
	public void signup() throws InterruptedException {
		Initiate_Driver driver = new Initiate_Driver();
		driver.Initiate_driver("Chrome");
	}

	@Test(dataProvider = "ReadAutomation_Data", dataProviderClass = Data_Reader.class)
	public void LoginCustomer(String date, String month, String year)
			throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.newuserAccount();
		lp.accountDetails(date, month, year);
	}

	@Test(dataProvider = "ReadAutomation_Data", dataProviderClass = Data_Reader.class)
	public void LoginCustomerDetails(String city, String state, String country)
			throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.contactDetails(city, state, country);
	}
}
