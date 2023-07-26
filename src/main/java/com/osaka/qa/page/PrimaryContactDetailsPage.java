package com.osaka.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.osaka.qa.base.BaseClass;

public class PrimaryContactDetailsPage extends BaseClass {
	
	@FindBy(id="AdmissionFor")
	static WebElement admissionFor;
	
	@FindBy(id="FatherFirstName1")
	static WebElement firstName;
	
	@FindBy(name="FatherLastName")
	static WebElement lastName;
	
	@FindBy(name="FatherEmailAddress")
	static WebElement emailAddress;
	
	@FindBy(name="FatherhMobileNumber")
	static WebElement phoneNumber;
	
	@FindBy(name="RelationWithStudent")
	static WebElement relationWithStudent;
	
	@FindBy(xpath="//input[@type='radio' and @value='Father']")
	static WebElement parentPriority;
	
	@FindBy(id="SaveAndContinueButtonPageOne")
	static WebElement submitPageOne;
	
	
	public PrimaryContactDetailsPage()
	{
		PageFactory.initElements(d, this);
	}
	
	public String pageTitle()
	{
		return d.getTitle();
	}
	
	public void fillFirstStepInfo()
	{
		Select admFor= new Select(admissionFor);
	    admFor.selectByVisibleText("2023-2024");
	    
	    firstName.clear();
	    firstName.sendKeys("Testmozo");
	    
	    lastName.clear();
	    lastName.sendKeys("Father");
	    
	    emailAddress.clear();
	    emailAddress.sendKeys("virendra@giftechnologie.com");
	    
	    phoneNumber.clear();
	    phoneNumber.sendKeys("9923896859");
	    
	    Select relationType = new Select(relationWithStudent);
	    relationType.selectByVisibleText("Father");
	    
	    parentPriority.click();
	    
	    submitPageOne.click();        
	
	}
	

}
