package com.sampleSeleniumProject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sampleSelenumProject.utilities.Common_Constants;
import com.sampleSelenumProject.utilities.Reusable_Logic;

public class LoginPage extends Reusable_Logic {

	// WebElement ele;
	//initialcheckin
	
	//Checkingg

	@FindBy(xpath = "//div/a[contains(@class,'login')]")
	private WebElement signin;
	@FindBy(xpath = "//div/form/h3[contains(text(),'Create an account')]")
	private WebElement createAccText;
	@FindBy(xpath = "//div/input[contains(@type,'text')]")
	private WebElement emailAddField;
	@FindBy(xpath = "//button/span/i[contains(@class,'icon-user left')]")
	private WebElement createAnAccBtn;
	@FindBy(xpath = "//div/h3[contains(text(),'Your personal information')]")
	private WebElement personalInfoTxt;
	@FindBy(xpath = "//div/label[contains(@for,'id_gender2')]")
	private WebElement Fgender;
	@FindBy(xpath = "//div/label[contains(@for,'id_gender1')]")
	private WebElement Mgender;
	@FindBy(xpath = "//div/input[contains(@id,'customer_firstname')]")
	private WebElement firstName;
	@FindBy(xpath = "//div/input[contains(@id,'customer_lastname')]")
	private WebElement lastName;
	@FindBy(xpath = "//div/input[contains(@id,'email')]")
	private WebElement registeredEmail;
	@FindBy(xpath = "//div/input[contains(@id,'passwd')]")
	private WebElement enterPassword;
	@FindBy(xpath = "//select[contains(@id,'days')]")
	private WebElement dateDD;
	@FindBy(xpath = "//select[contains(@id,'months')]")
	private WebElement monthDD;
	@FindBy(xpath = "//select[contains(@id,'years')]")
	private WebElement yearDD;
	@FindBy(xpath = "//p/input[contains(@id,'firstname')]")
	private WebElement addressFirstName;
	@FindBy(xpath = "//p/input[contains(@id,'lastname')]")
	private WebElement addressLastName;
	@FindBy(xpath = "//p/input[contains(@id,'company')]")
	private WebElement companyName;
	@FindBy(xpath = "//p/input[contains(@id,'address1')]")
	private WebElement address1;
	@FindBy(xpath = "//p/input[contains(@id,'address2')]")
	private WebElement address2;
	@FindBy(xpath = "//p/input[contains(@id,'city')]")
	private WebElement addCity;
	@FindBy(xpath = "//select[contains(@id,'id_state')]")
	private WebElement stateDD;
	@FindBy(xpath = "//p/input[contains(@id,'postcode')]")
	private WebElement addZip;
	@FindBy(xpath = "//select[contains(@id,'id_country')]")
	private WebElement addCountry;
	@FindBy(xpath = "//p/input[contains(@id,'phone_mobile')]")
	private WebElement phoneNum;
	@FindBy(xpath = "//p/input[contains(@id,'alias')]")
	private WebElement adddressAlias;
	@FindBy(xpath = "//button[contains(@id,'submitAccount')]")
	private WebElement registerBtn;
	@FindBy(xpath = "//div/ol/li | //a/span[contains(text(),' Home')]")
	private WebElement errorMsgOrHomePage;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void newuserAccount() {
		try {
			loadUrl();
			this.signin.click();
			wait_Till_PageLoad();
			if (createAccText.isDisplayed() && emailAddField.isDisplayed()) {
				this.emailAddField.sendKeys(Common_Constants.emailid);
				this.createAnAccBtn.click();
				wait_Till_PageLoad();
			} else {
				System.out.println("fields are not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void accountDetails(String date, String month, String year) {

		String emailid = emailAddField.getText();

		if (emailid.contentEquals(Common_Constants.emailid)) {
			System.out.println(emailid);
		}

		if (personalInfoTxt.isDisplayed() && this.Fgender.isDisplayed()) {

			this.Fgender.click();
			this.firstName.sendKeys(Common_Constants.f_name);
			this.lastName.sendKeys(Common_Constants.l_name);
			this.enterPassword.sendKeys(Common_Constants.password);

			WebElement ele = dateDD;
			Select s1 = new Select(ele);
			s1.selectByValue(date);

			WebElement ele2 = monthDD;
			Select s2 = new Select(ele2);
			s2.selectByValue(month);

			WebElement ele3 = yearDD;
			Select s3 = new Select(ele3);
			s3.selectByValue(year);
		}
	}

	public void contactDetails(String city, String state, String country) {
		try {
			addressFirstName.sendKeys(Common_Constants.f_name);
			addressLastName.sendKeys(Common_Constants.l_name);
			companyName.sendKeys(Common_Constants.companyName);
			address1.sendKeys(Common_Constants.address1);
			addCity.sendKeys(city);
			WebElement ele4 = stateDD;
			Select sl4 = new Select(ele4);
			sl4.selectByValue(state);
			this.addZip.sendKeys(Common_Constants.postal_Code);
			this.addCountry.sendKeys(country);
			this.phoneNum.sendKeys(Common_Constants.primary_Phone);
			this.adddressAlias.clear();
			this.adddressAlias.sendKeys(Common_Constants.aliasName);
			this.registerBtn.click();
			wait_Till_PageLoad();
			String error = errorMsgOrHomePage.getText();
			errorMsgOrHomePage.click();
			wait_Till_PageLoad();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
