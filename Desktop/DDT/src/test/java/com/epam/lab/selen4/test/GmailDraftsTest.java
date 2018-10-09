package com.epam.lab.selen4.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.lab.selen4.ScreenShot;
import com.epam.lab.selen4.PageObject.GmailDraftPage;
import com.epam.lab.selen4.PageObject.GmailLoginPage;
import com.epam.lab.selen4.PageObject.LetterTypePage;

public class GmailDraftsTest {
	WebDriver driver;
	GmailLoginPage loginPage = new GmailLoginPage(driver);
	LetterTypePage letter = new LetterTypePage(driver);
	GmailDraftPage draftPage = new GmailDraftPage(driver);

	@BeforeMethod
	public void startChrome() {
		driver.get("https://www.gmail.com");
		loginPage.inputEmail();
		loginPage.inputPassword();
	}

	@AfterMethod
	public void logout() {
		loginPage.logout();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

	@BeforeClass
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testSendLetter() throws IOException {
		letter.clickNewLetter();
		letter.inputLetterEmail();
		letter.inputLetterTheme();
		letter.inputLetterText();

		draftPage.clicDraft();
		draftPage.openDraftLetter();
		draftPage.sendLetter();
		
		ScreenShot.takeScreenShot(driver);
		Assert.assertTrue(driver.findElement(By.cssSelector("div.vh")).isDisplayed());
	}
}
