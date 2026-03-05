import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// Test Data
String username = "standard_user"
String wrongPassword = "wrong_password"

// Open browser
WebUI.openBrowser('')
WebUI.maximizeWindow()

// Navigate to SauceDemo
WebUI.navigateToUrl('https://www.saucedemo.com/')

// Wait login page
WebUI.waitForElementVisible(
	findTestObject('Login_Invalid/Page_Swag Labs/input_Username'),
	10
)

// Input username
WebUI.setText(
	findTestObject('Login_Invalid/Page_Swag Labs/input_Username'),
	username
)

// Input wrong password
WebUI.setText(
	findTestObject('Login_Invalid/Page_Swag Labs/input_Password'),
	wrongPassword
)

// Click login
WebUI.click(
	findTestObject('Login_Invalid/Page_Swag Labs/input_login-button')
)

// Verify error message
boolean errorDisplayed = WebUI.verifyElementPresent(
	findTestObject('Login_Invalid/Page_Swag Labs/h3_Epic sadface_ Username and password do not ma'),
	10,
	FailureHandling.OPTIONAL
)

// Conditional check
if(errorDisplayed){

	WebUI.comment("Login gagal sesuai expected result")

}else{

	WebUI.comment("Login berhasil padahal password salah (BUG)")

}

// Screenshot evidence
WebUI.takeScreenshot('Login_Invalid/Page_Swag Labs/input_Password')

// Close browser
WebUI.closeBrowser()