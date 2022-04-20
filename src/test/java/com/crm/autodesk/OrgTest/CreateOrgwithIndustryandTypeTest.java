package com.crm.autodesk.OrgTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OraganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.genericUtility.BaseClass;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateOrgwithIndustryandTypeTest extends BaseClass{
	
	@Test(groups="regressionSuite")
	public void createOrgwithIndustryandTypeTest() throws Throwable {


		//get random Number
		int randomNumber = jLib.getRandomNum();

		// Get the Data from Excel
		String orgName = eLib.getDataFromExcel("Sheet1", 4, 1)+randomNumber;
		String industry = eLib.getDataFromExcel("Sheet1", 4, 2);
		String type =eLib.getDataFromExcel("Sheet1", 4, 3);

		//Navigate to Organization Tab
		HomePage hp=new HomePage(driver);
		hp.clicOrganizationsLink();

		//click on Create Organization
		OraganizationPage op=new OraganizationPage(driver);
		op.clickCreateOrganizationLookupImg();
		
		//Enter the details and click on save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrganizationWithIndustryAndType(orgName, industry, type);

		//Get the Confirmation Message
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String confirmation_message=oip.fetchConfirmationMessage();
		System.out.println("Confirmataion Message====>> "+confirmation_message);
		
		//Get the Account Type
		String Account_type=oip.fetchTypeName();
		System.out.println("Account Type ====>> "+Account_type);
		
		//Get the Industry
		String Account_industy=oip.fetchIndustryName();
		System.out.println("Account_industy ====>> "+Account_industy);		
		
		// Verify confirmation Message
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(confirmation_message.contains(orgName));
		
		//verify AccountType
		sa.assertTrue(Account_type.equals(type));
		
		//Verify Industry		
		sa.assertTrue(Account_industy.equals(industry));
		
		//mandatory statement for softAssert
		sa.assertAll();
	
	}

}
