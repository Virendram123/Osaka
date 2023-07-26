package com.osaka.qa.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.osaka.qa.base.BaseClass;

public class ParentInformationPage extends BaseClass {

	@FindBy(id = "referredById")
	WebElement referal;
	
	@FindBy(id="referralGroupId")
	WebElement groupName;
	
	

	public ParentInformationPage() {

		PageFactory.initElements(d, this);
	}
	
	public void fillParentInfo()
	{
		Select s1 = new Select (referal);
		List<WebElement> DropValues = s1.getOptions();
		for (WebElement a :DropValues )
		{
			System.out.println(a.getText());
			if (a.getText().equalsIgnoreCase((prop.getProperty("refeerralDropDownValue"))))
			{
				a.click();
				break;
		   }
		}
	}

}