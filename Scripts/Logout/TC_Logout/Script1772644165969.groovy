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
	findTestObject('Logout/Page_Swag Labs/input_Username'),
	10
)

// Input username
WebUI.setText(
	findTestObject('Logout/Page_Swag Labs/input_Username'),
	username
)

// Input password
WebUI.setEncryptedText(
	findTestObject('Logout/Page_Swag Labs/input_Password'),
	passwordEncrypted
)

// Click login
WebUI.click(
	findTestObject('Logout/Page_Swag Labs/input_login-button')
)

// Wait inventory page
WebUI.waitForElementVisible(
	findTestObject('Logout/Page_Swag Labs/button_react-burger-menu-btn'),
	10
)

// Open burger menu
WebUI.click(
	findTestObject('Logout/Page_Swag Labs/button_react-burger-menu-btn')
)

// Click logout
WebUI.click(
	findTestObject('Logout/Page_Swag Labs/a_logout_sidebar_link')
)

// Verify kembali ke halaman login
boolean logoutSuccess = WebUI.verifyElementPresent(
	findTestObject('Logout/Page_Swag Labs/input_login-button'),
	10,
	FailureHandling.OPTIONAL
)

// Conditional logic
if(logoutSuccess){

	WebUI.comment("Logout berhasil - kembali ke halaman login")

}else{

	WebUI.comment("Logout gagal - user masih login")

}

// Screenshot evidence
WebUI.takeScreenshot('Logout/Page_Swag Labs/button_react-burger-menu-btn')
WebUI.takeScreenshot('Logout/Page_Swag Labs/a_logout_sidebar_link')

// Close browser
WebUI.closeBrowser()