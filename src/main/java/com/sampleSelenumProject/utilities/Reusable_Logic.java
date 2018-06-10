package com.sampleSelenumProject.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Reusable_Logic extends Initiate_Driver {

	public void loadUrl() {
		driver.get(Common_Constants.automation_Url);
		driver.manage().window().maximize();
		wait_Till_PageLoad();
	}

	public void wait_Till_PageLoad() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void wait_Till_ElementisVisible() {
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated((By
						.xpath("//a[contains(@title,'Proceed to checkout')]"))));
	}

	public void wait(int time) throws InterruptedException {
		Thread.sleep(1000);
	}

	public String getUniqueName() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH-mm-ss");
		return dateFormat.format(date).toString();
	}

	public String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm_ss");
		return dateFormat.format(date).toString();
	}

	public void select_ByText(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);

	}

	public void select_ByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void scrollDown() {
		JavascriptExecutor js1 = ((JavascriptExecutor) driver);
		js1.executeScript("window.scrollBy(0,400)");
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

}
