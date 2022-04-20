package com.crm.autodesk.contactsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericUtility.BaseClass;



@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateContactsTest extends BaseClass {
	
	@Test(groups="smokeSuite", retryAnalyzer = com.crm.autodesk.genericUtility.RetryAnalyser.class)
	public void createContactsTest() throws Throwable {

		//get random Number
		int randomNumber = jLib.getRandomNum();

		//Fetch the data from Properties
		String testdata = eLib.getDataFromExcel("Sheet1", 1, 2)+randomNumber;
		
		//Navigate to Contacts Tab
		HomePage hp = new HomePage(driver);
		hp.clickContactsLink();

		//click on Create Contact
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContactLookupImg();
Assert.fail("Failed in 32nd Line");
		//Enter the details and click on save
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(testdata);

		//Get the Confirmation Message
		ContactInfoPage cip=new ContactInfoPage(driver);
		String confirmation_message=cip.fetchConfirmationMessage();


		//Verify the Confirmation Message
		Assert.assertTrue(confirmation_message.contains(testdata));
		//Reporter.log("Contact Created", true);
      
	}

}
