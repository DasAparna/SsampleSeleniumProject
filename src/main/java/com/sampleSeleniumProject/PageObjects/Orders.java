package com.sampleSeleniumProject.PageObjects;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sampleSelenumProject.utilities.Data_Reader;
import com.sampleSelenumProject.utilities.Reusable_Logic;

public class Orders extends Reusable_Logic {

	@FindBy(xpath = "(//li/a[contains(text(),'Women')])[1]")
	private WebElement womenSection;
	@FindBy(xpath = "(//ul/li[@class]/a[contains(@title,'Casual Dresses')])[1]")
	private WebElement casualDresses;
	@FindBy(xpath = "//select[contains(@id,'selectProductSort')]")
	private WebElement sortByAscOrderDD;
	@FindBy(xpath = "(//a/span[contains(text(),'Add to cart')])[1]")
	private WebElement addToCartBeforeSize;
	@FindBy(xpath = "(//a/span[contains(text(),'More')])[1]")
	private WebElement moreOptn;
	@FindBy(xpath = "//select[contains(@id,'group_1')]")
	private WebElement sizeDD;
	@FindBy(xpath = "(//li/a[contains(@class,'color_pick')])[1]")
	private WebElement chooseClr;
	@FindBy(xpath = "//button/span[contains(text(),'Add to cart')]")
	private WebElement addTOCart;
	@FindBy(xpath = "//a[contains(@title,'Proceed to checkout')]")
	private WebElement proceedToChkOut;
	@FindBy(xpath = "//span[contains(@id,'total_price')]")
	private WebElement totalAmount;
	@FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
	private WebElement proceedAfterTotalPrice;
	@FindBy(xpath = "//span/input[contains(@type,'checkbox')]")
	private WebElement ChkBox;
	@FindBy(xpath = "//p/div[contains(@class,'checker')]")
	private WebElement ChkBox2;
	@FindBy(xpath = "(//tbody/tr/td)[3]")
	private WebElement myCarier;
	@FindBy(xpath = "//p[contains(@class,'fancybox-error')]")
	private WebElement fancyMsg;
	@FindBy(xpath = "//a[contains(@title,'Close')]")
	private WebElement close;
	@FindBy(xpath = "//p/a[contains(@class,'bankwire')]")
	private WebElement payByBankWire;
	@FindBy(xpath = "//p/a[contains(@class,'cheque')]")
	private WebElement payByBankCheque;
	@FindBy(xpath = "//div[contains(@class,'box cheque-box')]")
	private WebElement orderSummary;
	@FindBy(xpath = "(//button[contains(@type,'submit')])[2]")
	private WebElement confirmAndChkOut;
	@FindBy(xpath = "//p/strong[contains(@class,'dark')]")
	private WebElement confimationMsg;
	@FindBy(xpath = "(//a/img[contains(@itemprop,'image')])[1]")
	private WebElement item;

	Data_Reader dr = new Data_Reader();

	public Orders(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void womenAppearalOrder() throws InterruptedException, IOException,
			EncryptedDocumentException, InvalidFormatException {
		try {
			String sort = dr.getValuesFromExcel("Sheet1", 1, 6);
			String size = dr.getValuesFromExcel("Sheet1", 1, 7);

			this.womenSection.click();
			wait_Till_PageLoad();
			scrollDown();

			WebElement ele = sortByAscOrderDD;
			Select sl = new Select(ele);
			sl.selectByValue(sort);
			wait(1000);
			WebElement ele2 = item;
			Actions act = new Actions(driver);
			act.moveToElement(ele2).build().perform();
			wait_Till_PageLoad();
			if (this.moreOptn.isDisplayed()) {
				this.moreOptn.click();

				WebElement ele1 = sizeDD;
				Select sl2 = new Select(ele1);
				sl2.selectByValue(size);

				this.chooseClr.click();
				wait_Till_PageLoad();
				this.addTOCart.click();
				wait_Till_PageLoad();
				wait_Till_ElementisVisible();
				this.proceedToChkOut.click();

				if (this.totalAmount.isDisplayed()) {
					String total = totalAmount.getText();
					System.out.println("Total Price " + "" + total);
				}
				this.proceedAfterTotalPrice.click();
				if (this.ChkBox.isSelected()) {
					this.proceedAfterTotalPrice.click();
					String mycarierDay = myCarier.getText();
					System.out.println(mycarierDay);
					wait_Till_PageLoad();
					this.proceedAfterTotalPrice.click();
				}
				if (fancyMsg.isDisplayed()) {
					String msg = fancyMsg.getText();
					System.out.println("Fancy Msg : " + msg);
					wait_Till_PageLoad();
					this.close.click();
					wait(1000);
					ChkBox.click();
					System.out.println("Clicked");
					wait(1000);
					this.proceedAfterTotalPrice.click();
				}
				this.payByBankWire.click();
				String ordersummary = this.orderSummary.getText();
				System.out.println("Order Summery : " + ordersummary);
				this.confirmAndChkOut.click();
				String confrmMsg = this.confimationMsg.getText();
				System.out.println("Confirmation Msg : " + confrmMsg);
			}
		} catch (IOException e) {
			e.getMessage();
		}

	}
}
