package com.bounceadmin.objectrepository;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bounceadmin.baseclass.SetUp;

public class AddNurseryObject extends SetUp {

	WebDriver driver;

	public AddNurseryObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Nursery Name']//following::small[1]")
	public WebElement nurseryNameMandatoryMsg;
	@FindBy(xpath="//input[@placeholder='Address Line1']//following::small[1]")
	public WebElement addressLine1MandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='countryId']//following::small[1]")
	public WebElement countryMandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='phonenumber_code']//following::small[1]")
	public WebElement countryCodeMandatoryMsg;
	@FindBy(xpath="//input[@placeholder='Phone Number']//following::small[1]")
	public WebElement phoneNumberMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Logo')]//following::small[1]")
	public WebElement logoMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date From')]//following::small[1]")
	public WebElement dateFromMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date To')]//following::small[1]")
	public WebElement dateToMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Type')]//following::small[1]")
	public WebElement contractTypeMandatoryMsg;
	@FindBy(xpath="//div[@role='alertdialog'][@aria-label='Please add owner details']")
	public WebElement ownerMandatoryMsg;

	@FindBy(xpath="//input[@formcontrolname='nameEn']")
	public WebElement nurseryName;
	@FindBy(xpath="//input[@placeholder='Address Line1']")
	public WebElement addressLine1;
	@FindBy(xpath="//select[@formcontrolname='countryId']")
	public WebElement country;
	@FindBy(xpath="//select[@formcontrolname='phonenumber_code']")
	public WebElement countryCode;
	@FindBy(xpath="//input[@formcontrolname='phonenumber']")
	public WebElement phoneNumber;
	@FindBy(xpath="//input[@id='fileInputField1']")
	public WebElement browseLogo;
	@FindBy(xpath="//label[contains(text(),'Logo')]//following::img")
	public WebElement logoPreView;
	@FindBy(xpath="//div[@role='alertdialog'][@aria-label='File uploaded successfully']")
	public WebElement logosucessMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date From')]//following::input[1]")
	public WebElement contractDateFrom;
	@FindBy(xpath="//label[contains(text(),'Contract Date To')]//following::input[1]")
	public WebElement contractDateTo;
	@FindBy(xpath="//select[@formcontrolname='contractType']")
	public WebElement contractType;
	@FindBy(xpath="//button[contains(text(),'ADD')]")
	public WebElement addButton;

	@FindBy(xpath="//input[@placeholder='Address Line2']")
	public WebElement addressLine2;
	@FindBy(xpath="//input[@placeholder='Zip Code']")
	public WebElement zipCode;
	@FindBy(xpath="//select[@formcontrolname='stateId']")
	public WebElement state;
	@FindBy(xpath="//select[@formcontrolname='cityId']")
	public WebElement city;
	@FindBy(xpath="//input[@formcontrolname='email']")
	public WebElement email;
	@FindBy(xpath="//textarea[@formcontrolname='contractInfo']")
	public WebElement contractInfo;
	@FindBy(xpath="//input[@formcontrolname='transactionFees']")
	public WebElement fees;
	@FindBy(xpath="//select[@formcontrolname='collectionTerm']")
	public WebElement collectionTerm;

	@FindBy(xpath="//tbody/tr[1]/td[1]/input[1]")
	public WebElement paymentGateway1CheckBox;
	@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/input[1]")
	public WebElement fixed1;
	@FindBy(xpath="//tbody/tr[1]/td[6]/div[1]/input[1]")
	public WebElement variable1;

	@FindBy(xpath="//a[contains(text(),'Add Attachment')]")
	public WebElement addAttachment1;
	@FindBy(xpath="//input[@id='fileInputField2']")
	public WebElement browseAttachments1;

	@FindBy(xpath="//span[contains(text(),'Add Attachment')]")
	public WebElement addAttachment2;
	@FindBy(xpath="//input[@id='fileInputField3']")
	public WebElement browseAttachments2;

	@FindBy(xpath="//input[@formcontrolname='accountName']")
	public WebElement accountHolderName;
	@FindBy(xpath="//input[@placeholder='Beneficiary Address']")
	public WebElement beneficiaryAddress;
	@FindBy(xpath="//input[@placeholder='Bank Name']")
	public WebElement bankName;
	@FindBy(xpath="//input[@placeholder='Bank Address']")
	public WebElement bankAddress;
	@FindBy(xpath="//input[@placeholder='Account Number']")
	public WebElement accountNumber;
	@FindBy(xpath="//input[@placeholder='Confirm Account Number']")
	public WebElement confirmAccountNumber;
	@FindBy(xpath="//input[@placeholder='IBAN']")
	public WebElement IBAN;
	@FindBy(xpath="//select[@formcontrolname='accountCurrency']")
	public WebElement accountCurrency;
	@FindBy(xpath="//input[@formcontrolname='swiftCode']")
	public WebElement swiftCode;
	@FindBy(xpath="//textarea[@formcontrolname='notes']")
	public WebElement notes;

	@FindBy(xpath="//span[contains(text(),'Add Owner/Manager')]")
	public WebElement addOwner;
	@FindBy(xpath="//input[@formcontrolname='name']")
	public WebElement ownerName;
	@FindBy(xpath="//label[contains(text(),'Nationality')]//following::select[1]")
	public WebElement ownerNationality;
	@FindBy(xpath="//select[@formcontrolname='phone_code']")
	public WebElement ownerCountrycode;
	@FindBy(xpath="//input[@formcontrolname='phone_number']")
	public WebElement ownerPhoneNumber;
	@FindBy(xpath="//input[@id='inputEmail']")
	public WebElement ownerEmail;
	@FindBy(xpath="//div[@class='form-group']//button[contains(text(),'ADD')]")
	public WebElement ownerAddButton;


	@FindBy(xpath="//div[@aria-label='Institution Created Successfully']")
	public WebElement nurserySuccessMsg;
	@FindBy(xpath="//div[@aria-label='Institution Updated Successfully']")
	public WebElement nurseryUpdateMsg;
	@FindBy(xpath="//i[@class='far fa-trash-alt cursor']")
	public WebElement deleteOwner;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yes;

	public void addNurseryMandatoryFields(String[] test) //sending data to mandatory fields only
	{
		try {
			log.info("Entered addNursery method");
			waitForElementToLoad(nurseryName);
			nurseryName.sendKeys(test[0]);
			addressLine1.sendKeys(test[1]);
			country.sendKeys(test[2]);
			countryCode.sendKeys(test[3]);
			phoneNumber.sendKeys(test[4]);
			browseLogo.sendKeys(projectFolder+test[5]);
			waitForElementToLoad(logoPreView);
			String msg = logosucessMsg.getText();
			log.info(msg);
			System.out.println("logo"+msg);
			contractDateFrom.sendKeys(test[6]);
			Thread.sleep(500);
			waitForElementToLoad(contractDateTo);
			contractDateTo.sendKeys(test[7]);
			Thread.sleep(500);
			waitForElementToLoad(contractType);
			contractType.sendKeys(test[8]);

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

	}

	public void addNurseryNonMandatoryFields(String[] test) //sending data to non mandatory fields only
	{
		try
		{
			log.info("Entered addNurseryNonMandatoryFields Method");		
			waitForElementToLoad(addressLine2);
			addressLine2.sendKeys(test[0]);
			zipCode.sendKeys(test[1]);
			state.sendKeys(test[2]);

			email.sendKeys(test[4]);
			contractInfo.sendKeys(test[5]);
			fees.sendKeys(test[6]);
			collectionTerm.sendKeys(test[7]);

			if(isElementPresent(paymentGateway1CheckBox)==true)
			{
				paymentGateway1CheckBox.click();
				fixed1.clear();
				fixed1.sendKeys(test[8]);
				variable1.clear();
				variable1.sendKeys(test[9]);
			}


			waitForElementToLoad(accountHolderName);
			accountHolderName.sendKeys(test[10]);
			beneficiaryAddress.sendKeys(test[11]);
			bankName.sendKeys(test[12]);
			bankAddress.sendKeys(test[13]);
			accountNumber.sendKeys(test[14]);
			confirmAccountNumber.sendKeys(test[14]);
			IBAN.sendKeys(test[15]);
			accountCurrency.sendKeys(test[16]);
			swiftCode.sendKeys(test[17]);
			waitForElementToLoad(city);
			city.sendKeys(test[3]);
			notes.sendKeys(test[18]);


		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}


	public void addOwner(String[] test) //add owner details
	{
		try {
			log.info("Entered addOwner Method");
			waitForElementToLoad(addOwner);
			//addOwner.click();
			autoScrollandClick(addOwner);
			waitForElementToLoad(ownerName);
			ownerName.sendKeys(test[0]);
			ownerNationality.sendKeys(test[1]);
			waitForElementToLoad(ownerCountrycode);
			ownerCountrycode.sendKeys(test[2]);
			ownerPhoneNumber.sendKeys(test[3]);
			ownerEmail.sendKeys(test[4]);
			waitForElementToLoad(ownerAddButton);
			ownerAddButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

	}

	public void addAttachments(WebElement element1, WebElement element2, String[] test, int n ) //add attachments, n=no.of attachments(max=10)
	{
		try
		{
			String one;
			if(element1==addAttachment1) {
				one = "//a[contains(text(),'Add Attachment')]";
			}
			else {
				one="//span[contains(text(),'Add Attachment')]";
			}
			wait600Sec = new WebDriverWait(driver, 600);
			for(int i=1;i<=n;i++)
			{

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();", element1);

				element2.sendKeys(projectFolder+test[i - 1]);

				wait600Sec.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(one+"//following::img["+i+"]")));
				WebElement attachmentName = driver.findElement(By.xpath(one+"//following::input[@placeholder='Attachment Name']["+i+"]"));
				//waitForElementToLoad(logosucessMsg);
				log.info (logosucessMsg.getText()+", "+i);
				waitForElementToLoad(attachmentName);
				attachmentName.sendKeys(test[9+i]);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
}
