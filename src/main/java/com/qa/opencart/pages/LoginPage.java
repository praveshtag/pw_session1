package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
private Page page;

//1. String Locators - OR 
private String emailId = "#input-email";
private String password = "#input-password";
private String loginButton = "//input[@value='Login']";
private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

//2. page constructor
	public LoginPage(Page page) {
		this.page = page;		
	}

//3. page actions/ methods;
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String appUserName, String appPassword ) throws InterruptedException {
		
		System.out.println("App Login Details: " + appUserName + " : " + appPassword);
		page.fill(emailId, appUserName);
		page.fill(password, appPassword);
		page.click(loginButton);
		Thread.sleep(5000);
		if(page.isVisible(logoutLink)) {
			System.out.println("User is logged in successfully!!!!!!!!");
			return true;
		} else
		{
			return false;
		}
		
		
	}
}

