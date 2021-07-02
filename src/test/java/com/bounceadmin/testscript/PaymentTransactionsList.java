package com.bounceadmin.testscript;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;

import com.bounceadmin.objectrepository.DashboardObject;

import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.PaymentTransactionListObject;


public class PaymentTransactionsList extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	PaymentTransactionListObject paytransactionObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		loginObj = new LogInObject(driver);
		dashboardObj = new DashboardObject(driver);
	
		paytransactionObj = new PaymentTransactionListObject(driver);
		
		driver.navigate().refresh();
		loginObj.logIn(userEmail,userPassword);
		waitForElementToLoad(loginObj.selectDarisniAdmin);
		loginObj.selectDarisniAdmin.click();
		loginObj.selectButton.click();
	}
	
	@Test(priority=1)
	public void filterByDate() //filter PaymentTransactionsList by from and to date
	{
		try
		{
			log.info("Entered filterByDate test");
			eTest = eReports.createTest("filterByDate");
			eTest.assignCategory("Payment Transaction");
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			expectedMsg="19/3/2021";
			waitForElementToLoad(paytransactionObj.fromDate);
			paytransactionObj.fromDate.sendKeys("19/03/2021");
			Thread.sleep(500);
			waitForElementToLoad(paytransactionObj.toDate);
			paytransactionObj.toDate.sendKeys("19/03/2021");
			paytransactionObj.filterButton.click();
			Thread.sleep(2000);
			WebElement date = driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper[1]//datatable-body-cell[6]"));
			System.out.println(date.getText());
			actualMsg = date.getText();
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=2)
	public void filterByPayMode() //filter PaymentTransactionsList by payment mode
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPayMode test");
			eTest = eReports.createTest("filterByPayMode");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			waitForElementToLoad(dashboardObj.paymentTransactions);
			dashboardObj.paymentTransactions.click();
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.paymentMode);
			paytransactionObj.paymentMode.sendKeys("Online");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[13]//span[contains(text(),'Online')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=3)
	public void filterByPaymentGateway() //filter PaymentTransactionsList by paymentGateway
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPaymentGateway test");
			eTest = eReports.createTest("filterByPaymentGateway");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;

			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.paymentGateway);
			paytransactionObj.paymentGateway.sendKeys("MyFaroorah");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[11]//span[contains(text(),'MYFATOORAH')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=4) 
	public void filterByPaymentMethod() //filter PaymentTransactionsList by payment method
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByPaymentMethod test");
			eTest = eReports.createTest("filterByPaymentMethod");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.paymentMethod);
			paytransactionObj.paymentMethod.sendKeys("KNET");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[12]//span[contains(text(),'KNET')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=5) 
	public void filterByNurseryName() //filter PaymentTransactionsList by nursery name
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByNurseryName test");
			eTest = eReports.createTest("filterByNurseryName");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.nurseryName);
			paytransactionObj.nurseryName.sendKeys("Oman nursery");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[5]//a[contains(text(),'Oman nursery')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=6) 
	public void filterByTransactionStatus() //filter PaymentTransactionsList by transaction status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByTransactionStatus test");
			eTest = eReports.createTest("filterByTransactionStatus");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.transactionStatus);
			paytransactionObj.transactionStatus.sendKeys("Payment Completed");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[8]//span[contains(text(),'Payment Completed')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=7) 
	public void filterByReconciliationStatus() //filter PaymentTransactionsList reconciliation status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByReconciliationStatus test");
			eTest = eReports.createTest("filterByReconciliationStatus");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.reconciliationStatus);
			paytransactionObj.reconciliationStatus.sendKeys("To Do");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[9]//span[contains(text(),'To Do')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=8) 
	public void filterByTransferStatus() //filter PaymentTransactionsList by transfer status
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered filterByTransferStatus test");
			eTest = eReports.createTest("filterByTransferStatus");
			eTest.assignCategory("Payment Transaction");
			boolean condition=false;
			int c=0;
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			waitForElementToLoad(paytransactionObj.transferStatus);
			paytransactionObj.transferStatus.sendKeys("In Progress");
			paytransactionObj.filterButton.click();
			
			Thread.sleep(1500);
			waitForElementToLoad(paytransactionObj.totalRecords);
			System.out.println(paytransactionObj.totalRecords.getText());
			String countstring=paytransactionObj.totalRecords.getText().replaceAll("[^\\d]", "").trim();
			System.out.println(countstring);
			int count = Integer.parseInt(countstring);
			System.out.println(count);
			
			for(int i=0;i<count;i++)
			{
				expectedBoolArray.add(true);
			}
			while(condition==false)
			{
				condition = isElementPresent(paytransactionObj.lastpagecheck);
				for(int i =1;i<=10;i++)
				{
					if(c+i<=count)
					{
						boolean value =isElementPresent(driver.findElement(By.xpath("//datatable-body[@class='datatable-body']//datatable-row-wrapper["+i+"]//datatable-body-cell[10]//span[contains(text(),'In Progress')]")));
						actualBoolArray.add(value);
					}
				}
				
				if(!isElementPresent(paytransactionObj.lastpagecheck))
				{
					waitIfElementClickIsIntercepted(paytransactionObj.goToNextPage, "click", "");
				}
				c=c+10;
			}
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@Test(priority=9) 
	public void filterByPaymentGatewayRefId() //filter PaymentTransactionsList by payment gateway reference id
	{
		try
		{
			
			log.info("Entered filterByPaymentGatewayRefId test");
			eTest = eReports.createTest("filterByPaymentGatewayRefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
            
			waitForElementToLoad(paytransactionObj.paymentGatewayRefId);
			expectedMsg = "5988557391301880";
			paytransactionObj.paymentGatewayRefId.sendKeys("5988557391301880");
			paytransactionObj.filterButton.click();
			Thread.sleep(1500);
			
			waitForElementToLoad(paytransactionObj.getpatmentGatewayRefId);
			actualMsg = paytransactionObj.getpatmentGatewayRefId.getText();
			
			waitForElementToLoad(paytransactionObj.resetButton);
			autoScrollandClick(paytransactionObj.resetButton);
			autoScrollandClick(dashboardObj.paymentTransactions);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Test(priority=10) 
	public void verifyPrintClickPrint() //verify print page is loaded when print button clicked and click print
	{
		try
		{
			log.info("Entered verifyPrintClickPrint test");
			eTest = eReports.createTest("verifyPrintClickPrint");
			eTest.assignCategory("Payment Transaction");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			dashboardObj.paymentTransactionsList.click();
			
			waitForElementToLoad(paytransactionObj.printButton);
			paytransactionObj.printButton.click();
			
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=11)
	public void verifyPrintClickCancel() //verify print page is loaded when print button clicked and click cancel
	{
		try
		{
			log.info("Entered verifyPrintClickCancel test");
			eTest = eReports.createTest("verifyPrintClickCancel");
			eTest.assignCategory("Payment Transaction");
			
			expectedMsg = "PRINT";
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");
			
			waitForElementToLoad(paytransactionObj.printButton);
			paytransactionObj.printButton.click();
			actualMsg = driver.switchTo().activeElement().getAttribute("innerText");
			
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
	}
	
	@Test(priority=12)
	public void verifySortForCustomerRefId()
	{
		try
		{
			
			log.info("Entered verifySortForCustomerRefId test");
			eTest = eReports.createTest("verifySortForCustomerRefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.customerRefIdSortButton, paytransactionObj.sortedCustomerRefId);
			actualMsg = paytransactionObj.sortedCustomerRefId.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=13)
	public void verifySortForBounceId()
	{
		try
		{
			
			log.info("Entered verifySortForBounceId test");
			eTest = eReports.createTest("verifySortForBounceId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.bouncePayIdSortButton, paytransactionObj.sortedBouncePayId);
			actualMsg = paytransactionObj.sortedBouncePayId.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=14)
	public void verifySortForNurseryName()
	{
		try
		{
			
			log.info("Entered verifySortForNurseryName test");
			eTest = eReports.createTest("verifySortForNurseryName");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.nurseryNameSortButton, paytransactionObj.sortedNurseryName);
			actualMsg = paytransactionObj.sortedNurseryName.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=15)
	public void verifySortForPayDate()
	{
		try
		{
			
			log.info("Entered verifySortForPayDate test");
			eTest = eReports.createTest("verifySortForPayDate");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.payDateSortButton, paytransactionObj.sortedPayDate);
			actualMsg = paytransactionObj.sortedPayDate.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=16)
	public void verifySortForAmount()
	{
		try
		{
			
			log.info("Entered verifySortForAmount test");
			eTest = eReports.createTest("verifySortForAmount");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			expectedMsg = verifySortButton(paytransactionObj.AmountSortButton, paytransactionObj.sortedAmount);
			actualMsg = paytransactionObj.sortedAmount.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=17)
	public void verifySortForPayGateway()
	{
		try
		{
			
			log.info("Entered verifySortForPayGateway test");
			eTest = eReports.createTest("verifySortForPayGateway");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.paygatewaySortButton);
			expectedMsg = verifySortButton(paytransactionObj.paygatewaySortButton, paytransactionObj.sortedGateway);
			actualMsg = paytransactionObj.sortedGateway.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=18)
	public void verifySortForPayMethod()
	{
		try
		{
			
			log.info("Entered verifySortForPayMethod test");
			eTest = eReports.createTest("verifySortForPayMethod");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payMethodSortButton);
			expectedMsg = verifySortButton(paytransactionObj.payMethodSortButton, paytransactionObj.sortedMethod);
			actualMsg = paytransactionObj.sortedMethod.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}

	@Test(priority=19)
	public void verifySortForPayMode()
	{
		try
		{
			
			log.info("Entered verifySortForPayMode test");
			eTest = eReports.createTest("verifySortForPayMode");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payModeSortButton);
			expectedMsg = verifySortButton(paytransactionObj.payModeSortButton, paytransactionObj.sortedMode);
			actualMsg = paytransactionObj.sortedMode.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}

	@Test(priority=20)
	public void verifySortForGatewayRefId()
	{
		try
		{
			
			log.info("Entered verifySortForGatewayRefId test");
			eTest = eReports.createTest("verifySortForGatewayRefId");
			eTest.assignCategory("Payment Transaction");
			
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactionsList, "click", "");

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paytransactionObj.payGatewayRefSortButton);
			expectedMsg = verifySortButton(paytransactionObj.payGatewayRefSortButton, paytransactionObj.sortedGatewayRef);
			actualMsg = paytransactionObj.sortedGatewayRef.getText();
			waitIfElementClickIsIntercepted(dashboardObj.paymentTransactions, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedMsg);
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}

	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}

}
