import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// Test Data
String username = "standard_user"
String passwordEncrypted = "qcu24s4901FyWDTwXGr6XA=="

// Open browser
WebUI.openBrowser('')
WebUI.maximizeWindow()

// Navigate to SauceDemo
WebUI.navigateToUrl('https://www.saucedemo.com/')

// Wait login page
WebUI.waitForElementVisible(
	findTestObject('Login_Valid/Page_Swag Labs/input_Username'),
	10
)

// Input username
WebUI.setText(
	findTestObject('Login_Valid/Page_Swag Labs/input_Username'),
	username
)

// Input password
WebUI.setEncryptedText(
	findTestObject('Login_Valid/Page_Swag Labs/input_Password'),
	passwordEncrypted
)

// Click login
WebUI.click(
	findTestObject('Login_Valid/Page_Swag Labs/input_login-button')
)

// Verification login success
boolean loginSuccess = WebUI.verifyElementPresent(
	findTestObject('Login_Valid/Page_Swag Labs/div_Swag Labs'),
	10,
	FailureHandling.OPTIONAL
)

// Conditional check
if(loginSuccess){

	WebUI.comment("Login berhasil - user masuk ke halaman inventory")

}else{

	WebUI.comment("Login gagal")

}

// Screenshot evidence
WebUI.takeScreenshot()

// Close browser
WebUI.closeBrowser()