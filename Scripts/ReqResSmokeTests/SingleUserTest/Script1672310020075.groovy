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
import com.fasterxml.jackson.databind.ObjectMapper as ObjectMapper

Result = WS.sendRequest(findTestObject('ResReqServices/Single User'))

WS.verifyResponseStatusCode(Result, GlobalVariable.successCode, FailureHandling.STOP_ON_FAILURE)

HashMap<String, Object> responseText = new ObjectMapper().readValue(Result.getProperties().get('responseText'), HashMap.class)

WS.verifyEqual(true, responseText.containsKey('data'), FailureHandling.STOP_ON_FAILURE)

WS.verifyEqual(true, responseText.containsKey('support'), FailureHandling.STOP_ON_FAILURE)

WS.verifyElementPropertyValue(Result, 'data.id', '2')

WS.verifyElementPropertyValue(Result, 'data.email', 'janet.weaver@reqres.in')

WS.verifyElementPropertyValue(Result, 'data.first_name', 'Janet')

WS.verifyElementPropertyValue(Result, 'data.last_name', 'Weaver')

WS.verifyElementPropertyValue(Result, 'support.url', GlobalVariable.supportUrl)

WS.verifyElementPropertyValue(Result, 'support.text', GlobalVariable.supportText)

