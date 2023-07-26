package com.osaka.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.osaka.qa.base.BaseClass;
import com.osaka.qa.page.ParentInformationPage;
import com.osaka.qa.page.PrimaryContactDetailsPage;

public class ParentAdmissionFormTest extends BaseClass {

	PrimaryContactDetailsPage pc;
	ParentInformationPage pi;
	
	
	public ParentAdmissionFormTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initalization();
	}
	
	@Test(priority=0)
	public void verifyPageTitle()
	{
		SoftAssert softAssert= new SoftAssert();
		pc = new PrimaryContactDetailsPage();
		softAssert.assertEquals(pc.pageTitle(), "Admission Form");
		softAssert.assertAll();
	}
	
	@Test(priority=1)
	public void fillFirstInfo() throws Throwable
	{
		pc = new PrimaryContactDetailsPage();
		pc.fillFirstStepInfo();
		Thread.sleep(10000);
	}
	
	@Test(priority=2)
	public void fillParInfo()
	{
		pi = new ParentInformationPage();
		pi.fillParentInfo();
	}
	
}
