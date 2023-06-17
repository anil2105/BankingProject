package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");

		lp.setPassword(password);
		logger.info("Entered password");

		lp.clickSubmit();
		logger.info("Clicked on submit button");

		boolean res = driver.getPageSource().contains("Guru99 Bank Manager HomePage");

		try {
			if (res = true) {
				Assert.assertTrue(true);
				logger.info("Login test passed...");

			} else {
				captureScreenshot(driver, "LoginTest");
				Assert.assertTrue(false);
				logger.info("Login test failed....");
			}

		} catch (Exception e) {
			captureScreenshot(driver, "verifyLoginPage");
			logger.info("Verify login page scenario failed.. exception --> " + e.getMessage());
			Assert.assertTrue(false);
		}

	}
}
