package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.AddNurseryObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.ListNurseryObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.ViewNurseryObject;
import com.bounceadmin.testdata.AddNurseryData;
import com.bounceadmin.testdata.TestDataImport;

public class AddNursery extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	AddNurseryObject addnurseryObj;
	AddNurseryData addnurserydataObj;
	TestDataImport tdImport;
	ListNurseryObject listnurseryObj;
	ViewNurseryObject viewnurseryObj;
	String[] addNurseryMandatoryData;
	String[] addNurseryNonMandatoryData;
	String[] addOwnerData;
	String[] attachmentData;
	String[] testData;
	String[] testData2;

	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			addnurseryObj = new AddNurseryObject(driver);
			tdImport = new TestDataImport();
			addnurserydataObj = new AddNurseryData();
			listnurseryObj = new ListNurseryObject(driver);
			viewnurseryObj = new ViewNurseryObject(driver);

			tdImport.readSheet("AddNursery");

			loginObj.logIn(userEmail,userPassword);
			waitForElementToLoad(loginObj.selectDarisniAdmin);
			loginObj.selectDarisniAdmin.click();
			loginObj.selectButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}


	@Test(priority=1)
	public void verifyMandatoryMsgVisible() // verify mandatory msg is present when adding nursery without filling them
	{
		try {
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered verifyMandatoryMsgVisible test");		
			eTest = eReports.createTest("Verify Mandatory Message");
			eTest.assignCategory("Add Nursery");
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			for (int i = 0; i < 10; i++) 
			{
				expectedBoolArray.add(true);
			}
			System.out.println(expectedBoolArray);
			dashboardObj.clickAddNurseries();
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurseryNameMandatoryMsg);
			actualBoolArray.add(isElementPresent(addnurseryObj.nurseryNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.addressLine1MandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.phoneNumberMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.logoMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateFromMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateToMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.contractTypeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ownerMandatoryMsg));
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}

	@Test(priority=2)
	public void verifyAddNurserywithMnadatoryOnly() //add a nursery by adding only mandatory data
	{
		try {
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered verifyAddNurserywithMnadatoryOnly test");		
			eTest = eReports.createTest("Add Nursery with Mandatory field Only");
			eTest.assignCategory("Add Nursery");	

			addnurserydataObj.generateFakeNurseryData();
			addNurseryMandatoryData = addnurserydataObj.addNurseryMandatoryTestData();
			testData = new String[5];
			testData[0] = addNurseryMandatoryData[0];
			testData[1] ="";
			testData[2] = addNurseryMandatoryData[2];
			testData[3] = addNurseryMandatoryData[3];
			testData[4] = addNurseryMandatoryData[4];
			for(int i=0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}
			for(int i=0;i<addNurseryMandatoryData.length;i++)
			{
				System.out.println(addNurseryMandatoryData[i]);
			}
			expectedArraylist.add("Institution Created Successfully");
			expectedArraylist.add(addNurseryMandatoryData[0]);
			expectedArraylist.add(addNurseryMandatoryData[1]);
			expectedArraylist.add(addNurseryMandatoryData[2]);
			expectedArraylist.add(addNurseryMandatoryData[3].replaceAll("[^\\d+]", "")+" "+addNurseryMandatoryData[4]);
			expectedArraylist.add(addNurseryMandatoryData[6]);
			expectedArraylist.add(addNurseryMandatoryData[7]);
			expectedArraylist.add(addNurseryMandatoryData[8]);
			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();
			addOwnerData = addnurserydataObj.addOwnerTestData();
			for(int i=0;i<addOwnerData.length;i++)
			{
				System.out.println(addOwnerData[i]);
			}
			expectedArraylist.add(addOwnerData[0]);
			expectedArraylist.add(addOwnerData[1]);
			expectedArraylist.add(addOwnerData[2].replaceAll("[^\\d+]", "")+" "+addOwnerData[3]);
			expectedArraylist.add(addOwnerData[4]);
			System.out.println(expectedArraylist);
			dashboardObj.clickAddNurseries();
			addnurseryObj.addNurseryMandatoryFields(addNurseryMandatoryData);
			addnurseryObj.addOwner(addOwnerData);
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurserySuccessMsg);

			actualArraylist.add(addnurseryObj.nurserySuccessMsg.getText());
			waitForElementToLoad(listnurseryObj.filterButton);
			driver.navigate().refresh();
			listnurseryObj.filterNursery(testData);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");

	}

	@Test(priority=3)
	public void verifyAddNurserywithAllFields() //add nursery by filling all the fields
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered verifyAddNurserywithAllFields test");
			eTest = eReports.createTest("Add Nursery with All Fields");
			eTest.assignCategory("Add Nursery");
			tdImport.readSheet("AddNursery");
			expectedArraylist.add("Institution Created Successfully");

			addnurserydataObj.generateFakeNurseryData();
			addNurseryMandatoryData = addnurserydataObj.addNurseryMandatoryTestData();

			addNurseryNonMandatoryData = addnurserydataObj.addNurseryNonMandatoryTestData();
			attachmentData = addnurserydataObj.attachments();
			for(int i=0;i<addNurseryMandatoryData.length;i++)
			{
				System.out.println(addNurseryMandatoryData[i]);
			}
			for(int i=0;i<addNurseryNonMandatoryData.length;i++)
			{
				System.out.println(i+" "+addNurseryNonMandatoryData[i]);
			}
			testData = addnurserydataObj.viewNurseryData();

			for(int i =0;i<testData.length;i++)
			{
				if(testData[i]=="")
				{
					testData[i] = "-";
					testData[i].trim();
				}
				expectedArraylist.add(testData[i]);
			}
			System.out.println(expectedArraylist);
			testData = addnurserydataObj.listNurseryData();

			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();

			addOwnerData = addnurserydataObj.addOwnerTestData();
			for(int i=0;i<addOwnerData.length;i++)
			{
				System.out.println(addOwnerData[i]);
			}
			testData2 = addnurserydataObj.viewOwnerData();
			for(int i =0;i<testData2.length;i++)
			{
				System.out.println(testData2[i]);
				expectedArraylist.add(testData2[i]);
			}
			System.out.println(expectedArraylist);

			dashboardObj.clickAddNurseries();
			addnurseryObj.addNurseryMandatoryFields(addNurseryMandatoryData);
			addnurseryObj.addOwner(addOwnerData);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment1, addnurseryObj.browseAttachments1, attachmentData, 1);
			addnurseryObj.addNurseryNonMandatoryFields(addNurseryNonMandatoryData);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment2, addnurseryObj.browseAttachments2, attachmentData, 1);
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurserySuccessMsg);

			actualArraylist.add(addnurseryObj.nurserySuccessMsg.getText());

			System.out.println();
			for(int i =0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}

			listnurseryObj.filterNursery(testData);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewZipcode.getText());
			actualArraylist.add(viewnurseryObj.viewState.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewCity.getText());
			actualArraylist.add(viewnurseryObj.viewEmail.getText());

			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewContractInfo.getText());
			actualArraylist.add(viewnurseryObj.viewFees.getText().replaceAll("KWD", "").trim());
			actualArraylist.add(viewnurseryObj.viewCollectionTerms.getText());
			actualArraylist.add(viewnurseryObj.viewAccountHolderName.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankName.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());
			actualArraylist.add(viewnurseryObj.viewAccountNumber.getText());
			actualArraylist.add(viewnurseryObj.viewIBAN.getText());
			actualArraylist.add(viewnurseryObj.viewAccountCurrency.getText());
			actualArraylist.add(viewnurseryObj.viewSwiftcode.getText());
			actualArraylist.add(viewnurseryObj.viewNotes.getText().trim());

			waitForElementToLoad(viewnurseryObj.viewpaymentGateway);
			actualArraylist.add(viewnurseryObj.viewpaymentGateway.getAttribute("innerText"));
			actualArraylist.add(viewnurseryObj.viewpaymentMethod.getText());
			actualArraylist.add(viewnurseryObj.viewFixed.getText().replaceAll("KWD", "").trim());
			actualArraylist.add(viewnurseryObj.viewVariable.getText().replace("%", ""));

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}

	@Test(priority=4)
	public void listandViewNurseryDetails() //list a nursery, view and verify all its data
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered listandViewNurseryDetails test");
			eTest = eReports.createTest("List and View Nursery Details");
			eTest.assignCategory("List and View Nursery");
			tdImport.readSheet("AddNursery");

			testData = addnurserydataObj.listNurseryData();
			for(int i =0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}
			dashboardObj.clickListNurseries();
			listnurseryObj.filterNursery(testData);
			testData = addnurserydataObj.viewNurseryData();

			for(int i =0;i<testData.length;i++)
			{
				expectedArraylist.add(testData[i]);
			}
			tdImport.readSheet("AddOwner");
			testData = addnurserydataObj.viewOwnerData();

			for(int i =0;i<testData.length;i++)
			{
				expectedArraylist.add(testData[i]);
			}
			System.out.println(expectedArraylist);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewZipcode.getText());
			actualArraylist.add(viewnurseryObj.viewState.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewCity.getText());
			actualArraylist.add(viewnurseryObj.viewEmail.getText());

			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewContractInfo.getText());
			actualArraylist.add(viewnurseryObj.viewFees.getText().replaceAll("KWD", "").trim());
			actualArraylist.add(viewnurseryObj.viewCollectionTerms.getText());
			actualArraylist.add(viewnurseryObj.viewAccountHolderName.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankName.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());
			actualArraylist.add(viewnurseryObj.viewAccountNumber.getText());
			actualArraylist.add(viewnurseryObj.viewIBAN.getText());
			actualArraylist.add(viewnurseryObj.viewAccountCurrency.getText());
			actualArraylist.add(viewnurseryObj.viewSwiftcode.getText());
			actualArraylist.add(viewnurseryObj.viewNotes.getText().trim());

			System.out.println(isElementPresent(viewnurseryObj.viewpaymentGateway));
			String check = viewnurseryObj.viewpaymentGateway.getText(); 
			if(check!=" ") {
				actualArraylist.add(check);
			}
			while(check == " ")
			{
				check = viewnurseryObj.viewpaymentGateway.getText();
				actualArraylist.add(check);
			}
			actualArraylist.add(viewnurseryObj.viewpaymentMethod.getText());
			actualArraylist.add(viewnurseryObj.viewFixed.getText().replaceAll("KWD", "").trim());
			actualArraylist.add(viewnurseryObj.viewVariable.getText().replace("%", ""));

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			System.out.println(actualArraylist);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

		Assert.assertEquals(actualArraylist, expectedArraylist);
	}

	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}

}
