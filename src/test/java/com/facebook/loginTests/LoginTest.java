package com.facebook.loginTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.facebook.base.BaseTest;
import com.facebook.loginPages.LoginPage;
import com.facebook.utilities.PropertiesReader;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	PropertiesReader propertiesReader;
	
	@BeforeSuite
	public void startsSuites() {
		System.out.println("Running suies");
	}
	
	@AfterSuite
	public void afterSuites() {
		System.out.println("End Suites");
	}
	@BeforeMethod(groups={"Smoke","Regression"})
	public void openFacebook() {
		openApp();
			}

	@Test(priority=0)
	public void loginTest() {
		propertiesReader=new PropertiesReader();
		loginPage = new LoginPage(driver);
		loginPage.userNameMethod(propertiesReader.getUserName());
		loginPage.passWordMethod(propertiesReader.getPassword());
		loginPage.logingButton();
				
	}
	
	@Test(priority=1, groups="Regression")
	public void loginTest1() {
		propertiesReader=new PropertiesReader();
		loginPage = new LoginPage(driver);
		loginPage.userNameMethod(propertiesReader.getUserName());
		loginPage.passWordMethod(propertiesReader.getPassword());
		loginPage.logingButton();
		Assert.assertEquals("hello", "hello");
				
	}
	
	@AfterMethod(groups={"Smoke","Regression"})
	public void closeFacebook() {
		closeApp();
	}
	

}
