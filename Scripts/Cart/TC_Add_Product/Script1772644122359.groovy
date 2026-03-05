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
	findTestObject('Cart/Page_Swag Labs/input_Username'),
	10
)

// Login
WebUI.setText(
	findTestObject('Cart/Page_Swag Labs/input_Username'),
	username
)

WebUI.setEncryptedText(
	findTestObject('Cart/Page_Swag Labs/input_Password'),
	passwordEncrypted
)

WebUI.click(
	findTestObject('Cart/Page_Swag Labs/input_login-button')
)

// Wait inventory page
WebUI.waitForElementVisible(
	findTestObject('Cart/Page_Swag Labs/button_add-to-cart-sauce-labs-backpack'),
	10
)

// Add product to cart
WebUI.click(
	findTestObject('Cart/Page_Swag Labs/button_add-to-cart-sauce-labs-backpack')
)

// Open cart
WebUI.click(
	findTestObject('Cart/Page_Swag Labs/a_1')
)

// Verify product in cart
boolean productAdded = WebUI.verifyElementPresent(
	findTestObject('Cart/Page_Swag Labs/div_1Sauce Labs Backpackcarry.allTheThings() wit'),
	10,
	FailureHandling.OPTIONAL
)

// Conditional verification
if(productAdded){

	WebUI.comment("Product berhasil ditambahkan ke cart")

}else{

	WebUI.comment("Product gagal ditambahkan ke cart")

}

// Screenshot evidence
WebUI.takeScreenshot()

// Close browser
WebUI.closeBrowser()

