package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class ViewNurseryObject extends SetUp {

	WebDriver driver;
	
	public ViewNurseryObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//label[contains(text(),'Nursery Name')]//following::p[1]")
	public WebElement viewNurseryName;
	@FindBy(xpath="//label[contains(text(),'Address Line1')]//following::p[1]")
	public WebElement viewAddressLine1;
	@FindBy(xpath="//label[contains(text(),'Address Line2')]//following::p[1]")
	public WebElement viewAddressLine2;
	@FindBy(xpath="//label[contains(text(),'Country')]//following::p[1]")
	public WebElement viewCountry;
	@FindBy(xpath="//label[contains(text(),'Zip Code')]//following::p[1]")
	public WebElement viewZipcode;
	@FindBy(xpath="//label[contains(text(),'State')]//following::p[1]")
	public WebElement viewState;
	@FindBy(xpath="//label[contains(text(),'Phone Number')]//following::p[1]")
	public WebElement viewPhoneNumber;
	@FindBy(xpath="//label[contains(text(),'City')]//following::p[1]")
	public WebElement viewCity;
	@FindBy(xpath="//label[contains(text(),'Email')]//following::p[1]")
	public WebElement viewEmail;
	@FindBy(xpath="//label[contains(text(),'Status')]//following::p[1]")
	public WebElement viewStatus;
	@FindBy(xpath="//label[contains(text(),'Contract Date From')]//following::p[1]")
	public WebElement viewContractDateFrom;
	@FindBy(xpath="//label[contains(text(),'Contract Date To')]//following::p[1]")
	public WebElement viewContractDateTo;
	@FindBy(xpath="//label[contains(text(),'Contract Type')]//following::p[1]")
	public WebElement viewContractType;
	@FindBy(xpath="//label[contains(text(),'Contract Info')]//following::p[1]")
	public WebElement viewContractInfo;
	@FindBy(xpath="//label[contains(text(),'Fees')]//following::p[1]")
	public WebElement viewFees;
	@FindBy(xpath="//label[contains(text(),'Collection Term')]//following::p[1]")
	public WebElement viewCollectionTerms;
	@FindBy(xpath="//label[contains(text(),'Account Holder Name')]//following::p[1]")
	public WebElement viewAccountHolderName;
	@FindBy(xpath="//label[contains(text(),'Beneficiary Address')]//following::p[1]")
	public WebElement viewBeneficaryAddress;
	@FindBy(xpath="//label[contains(text(),'Bank Name')]//following::p[1]")
	public WebElement viewBankName;
	@FindBy(xpath="//label[contains(text(),'Bank Address')]//following::p[1]")
	public WebElement viewBankAddress;
	@FindBy(xpath="//label[contains(text(),'Account Number')]//following::p[1]")
	public WebElement viewAccountNumber;
	@FindBy(xpath="//label[contains(text(),'IBAN')]//following::p[1]")
	public WebElement viewIBAN;
	@FindBy(xpath="//label[contains(text(),'Account currency')]//following::p[1]")
	public WebElement viewAccountCurrency;
	@FindBy(xpath="//label[contains(text(),'Swift code')]//following::p[1]")
	public WebElement viewSwiftcode;
	@FindBy(xpath="//label[contains(text(),'Notes')]//following::p[1]")
	public WebElement viewNotes;
	
	@FindBy(xpath="//th[contains(text(),'Name')]//following::tbody[1]//td[2]")
	public WebElement viewOwnerName;
	@FindBy(xpath="//th[contains(text(),'Name')]//following::tbody[1]//td[3]")
	public WebElement viewOwnerPhoneNo;
	@FindBy(xpath="//th[contains(text(),'Name')]//following::tbody[1]//td[4]")
	public WebElement viewOwnerEmail;
	@FindBy(xpath="//th[contains(text(),'Name')]//following::tbody[1]//td[5]")
	public WebElement viewOwnerNationality;
	@FindBy(xpath="//th[contains(text(),'Name')]//following::tbody[1]//td[6]")
	public WebElement viewOwnerStatus;
	
	@FindBy(xpath="//th[contains(text(),'Payment Gateway')]//following::tbody[1]//td[2]")
	public WebElement viewpaymentGateway;
	@FindBy(xpath="//th[contains(text(),'Payment Gateway')]//following::tbody[1]//td[3]")
	public WebElement viewpaymentMethod;
	@FindBy(xpath="//th[contains(text(),'Payment Gateway')]//following::tbody[1]//td[4]")
	public WebElement viewFixed;
	@FindBy(xpath="//th[contains(text(),'Payment Gateway')]//following::tbody[1]//td[5]")
	public WebElement viewVariable;
	
	@FindBy(xpath="//i[@class='far fa-trash-alt cursor']")
	public WebElement deleteOwner;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yesButton;
}
