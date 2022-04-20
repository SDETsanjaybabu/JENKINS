package com.crm.autodesk.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.NewTemplate;
import com.crm.autodesk.genericUtility.BaseClass;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class CreateMailMergeTemplateWithModuleOrganization extends BaseClass {

	@Test(groups="regressionSuite")
	public void createMailMergeTemplateWithModuleOrganization() throws Throwable {
		
		//Get the test data from Excel file
		String path_testdoc = eLib.getDataFromExcel("Sheet2", 1, 0);


		//Step3 ==>> Place the mouse cursor and click on "Contact" Link
		HomePage hp = new HomePage(driver);
		hp.clickContactsLink();

		//Step4 ==>> Navigate to contact module and click on create mail merge templates
		ContactsPage cp=new ContactsPage(driver);
		cp.clickCreateMailMergeTemplatesLink();


		//Step5 ==>> choose template file click on choose files
		
		NewTemplate nt=new NewTemplate(driver);
		nt.uploadTemplateFile(path_testdoc, "Organizations");
		
		Assert.assertTrue(driver.getTitle().contains("Settings"));
		
			
	}

}
