package com.sampleSelenumProject.utilities;

public class Common_Constants {
	
	static Reusable_Logic reu = new Reusable_Logic();
	
	public static String automation_Url = "http://automationpractice.com/index.php";
	
	public static String file_Path = "D:\\Workspace\\SampleSeleniumProject\\TestData.xlsx";
	
	
	public static String emailid = "test"+reu.getTime()+"@test.com";
	public static final String password = "sele1234";
	
	public static final String address1 = "AutomationTest";
	public static final String postal_Code = "22222";
	public static final String primary_Phone = "9999999999";
	public static final String f_name = "Name";
	public static final String l_name = "Last";
	public static final String aliasName = "alias";
	
	public static String companyName = "Test_Account"+reu.getTime();
	
}
