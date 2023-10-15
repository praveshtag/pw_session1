package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void loginPageNavigationTest() throws InterruptedException {
		loginPage = homePage.navigateToLoginPage();
		String actLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Actual Login Page Title : " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
		Thread.sleep(2000);		
	}
	
	@Test(priority = 2)
	public void ForgetPasswordLinkExistTest() {
	Assert.assertTrue(loginPage.isForgotPwdLinkExist());		
	}
	
	@Test(priority = 3)
	public void appLoginTest() throws InterruptedException {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim()));
		Thread.sleep(5000);
	}
}

