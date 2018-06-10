package com.sampleSeleniumProject.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sampleSeleniumProject.PageObjects.Orders;
import com.sampleSelenumProject.utilities.Data_Reader;
import com.sampleSelenumProject.utilities.Initiate_Driver;

public class OrderPage_Test extends Initiate_Driver {

	@Test
	public void orderPlaced() throws InterruptedException,
			EncryptedDocumentException, InvalidFormatException, IOException {
		Orders order = new Orders(driver);
		order.womenAppearalOrder();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
