package com.bounceadmin.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class AddNurseryData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public void generateFakeNurseryData()
	{
	   String name =  fake.educator().campus().replaceFirst("Campus", "Nursery")+" Automation";
	   tdImport.writeCell(1, 0, name); 
	   tdImport.writeCell(1, 1, fake.address().fullAddress());
	   tdImport.writeCell(1, 2, fake.address().streetAddress());
	   tdImport.writeCell(1, 4, fake.address().zipCode());
	   tdImport.writeCell(1, 7, fake.numerify("9#######"));
	   tdImport.writeCell(1, 9, fake.bothify("????????#?#?@email.com"));
	   tdImport.writeCell(1, 15, fake.numerify("5##.###"));
	   tdImport.writeCell(1, 17, fake.numerify("1##.###"));
	   tdImport.writeCell(1, 18, fake.numerify("1#.##"));
	   tdImport.writeCell(1, 19, fake.name().fullName());
	   tdImport.writeCell(1, 20, fake.address().fullAddress());
	   tdImport.writeCell(1, 21, fake.letterify("??? international Bank", true));
	   tdImport.writeCell(1, 22, fake.address().fullAddress());
	   tdImport.writeCell(1, 23, fake.numerify("############"));
	   tdImport.writeCell(1, 24, fake.bothify("??#######??######", true));
	   tdImport.writeCell(1, 26, fake.letterify("?????????", true));
	   tdImport.writeCell(1, 27, fake.letterify("???????????????"));
		
	}
	
	public void generateFakeOwnerData()
	{
		String name = fake.name().firstName();
		tdImport.writeCell(1, 0, name+fake.bothify(" ??##"));
		tdImport.writeCell(1, 3, fake.numerify("9#######"));
		tdImport.writeCell(1, 4, fake.bothify(name+"####??@gmail.com"));
		
	}
	
	public String[] addNurseryMandatoryTestData()
	{
		testData = new String[9];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 3);
		testData[3] = tdImport.getCellData(1, 6);
		testData[4] = tdImport.getCellData(1, 7);
		testData[5] = tdImport.getCellData(2, 10);
		testData[6] = tdImport.getCellData(1, 11);
		testData[7] = tdImport.getCellData(1, 12);
		testData[8] = tdImport.getCellData(1, 13);
		return testData;
		
	}
	
	public String[] addNurseryNonMandatoryTestData()
	{
		testData = new String[19];
		testData[0] = tdImport.getCellData(1, 2);
		testData[1] = tdImport.getCellData(1, 4);
		testData[2] = tdImport.getCellData(1, 5);
		testData[3] = tdImport.getCellData(1, 8);
		testData[4] = tdImport.getCellData(1, 9);
		testData[5] = tdImport.getCellData(1, 14);
		testData[6] = tdImport.getCellData(1, 15);
		testData[7] = tdImport.getCellData(1, 16);
		testData[8] = tdImport.getCellData(1, 17);
		testData[9] = tdImport.getCellData(1, 18);
		
		testData[10] = tdImport.getCellData(1, 19);
		testData[11] = tdImport.getCellData(1, 20);
		testData[12] = tdImport.getCellData(1, 21);
		testData[13] = tdImport.getCellData(1, 22);
		testData[14] = tdImport.getCellData(1, 23);
		testData[15] = tdImport.getCellData(1, 24);
		testData[16] = tdImport.getCellData(1, 25);
		testData[17] = tdImport.getCellData(1, 26);
		testData[18] = tdImport.getCellData(1, 27);
		return testData;
		
	}
	
	public String[] addOwnerTestData()
	{
		testData = new String[5];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		return testData;
	}
	
	public String[] attachments()
	{
		testData = new String[20];
		testData[0] = tdImport.getCellData(1, 29);
		testData[1] = tdImport.getCellData(2, 29);
		testData[2] = tdImport.getCellData(3, 29);
		testData[3] = tdImport.getCellData(4, 29);
		testData[4] = tdImport.getCellData(5, 29);
		testData[5] = tdImport.getCellData(6, 29);
		testData[6] = tdImport.getCellData(7, 29);
		testData[7] = tdImport.getCellData(8, 29);
		testData[8] = tdImport.getCellData(9, 29);
		testData[9] = tdImport.getCellData(10, 29);
		
		testData[10] = tdImport.getCellData(1, 30);
		testData[11] = tdImport.getCellData(2, 30);
		testData[12] = tdImport.getCellData(3, 30);
		testData[13] = tdImport.getCellData(4, 30);
		testData[14] = tdImport.getCellData(5, 30);
		testData[15] = tdImport.getCellData(6, 30);
		testData[16] = tdImport.getCellData(7, 30);
		testData[17] = tdImport.getCellData(8, 30);
		testData[18] = tdImport.getCellData(9, 30);
		testData[19] = tdImport.getCellData(10, 30);
		return testData;
		
	}
	
	public String[] listNurseryData()
	{
		testData = new String[6];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 9);
		testData[2] = tdImport.getCellData(1, 3);
		testData[3] = tdImport.getCellData(1, 6);
		testData[4] = tdImport.getCellData(1, 7);
		//testData[5] = tdImport.getCellData(1, 28);
		return testData;
		
	}
	
	public String[] viewNurseryData()
	{
		testData = new String[28];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		testData[5] = tdImport.getCellData(1, 5);
		testData[6] = tdImport.getCellData(1, 6).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 7);
		testData[7] = tdImport.getCellData(1, 8);
		testData[8] = tdImport.getCellData(1, 9);
	
		testData[9] = tdImport.getCellData(1, 11);
		testData[10] = tdImport.getCellData(1, 12);
		testData[11] = tdImport.getCellData(1, 13);
		testData[12] = tdImport.getCellData(1, 14);
		testData[13] = tdImport.getCellData(1, 15);
		testData[14] = tdImport.getCellData(1, 16);
		testData[15] = tdImport.getCellData(1, 19);
		testData[16] = tdImport.getCellData(1, 20);
		testData[17] = tdImport.getCellData(1, 21);
		testData[18] = tdImport.getCellData(1, 22);
		testData[19] = tdImport.getCellData(1, 23);
		testData[20] = tdImport.getCellData(1, 24);
		testData[21] = tdImport.getCellData(1, 25);
		testData[22] = tdImport.getCellData(1, 26);
		testData[23] = tdImport.getCellData(1, 27);
		
		testData[24] = tdImport.getCellData(1, 31);
		testData[25] = tdImport.getCellData(1, 32);
		testData[26] = tdImport.getCellData(1, 17);
		testData[27] = tdImport.getCellData(1, 18);
		return testData;
		
	}
	
	
	public String[] viewOwnerData()
	{
		testData = new String[4];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 2).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 3);
		testData[2] = tdImport.getCellData(1, 4);
		testData[3] = tdImport.getCellData(1, 1);
		return testData;
	}

	public String[] editNurseryData()
	{
		testData = new String[8];
		testData[0] = tdImport.getCellData(1, 0)+"__edited";
		testData[1] = tdImport.getCellData(1, 1)+"__edited";
		testData[2] = tdImport.getCellData(1, 2)+"__edited";
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 19)+"__edited";
		testData[5] = tdImport.getCellData(1, 20)+"__edited";
		testData[6] = tdImport.getCellData(1, 21)+"__edited";
		testData[7] = tdImport.getCellData(1, 22)+"__edited";
		return testData;
	}
	
	public String[] nurseryFilterData()
	{
		testData = new String[7];
		testData[0] = tdImport.getCellData(20, 0);
		testData[1] = tdImport.getCellData(20, 1);
		testData[2] = tdImport.getCellData(20, 2);
		testData[3] = tdImport.getCellData(20, 3);
		testData[4] = tdImport.getCellData(20, 4);
		testData[5] = tdImport.getCellData(20, 5);
		testData[6] = tdImport.getCellData(20, 6);
		return testData;
	}
}
