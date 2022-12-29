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

Result = WS.sendRequest(findTestObject('ResReqServices/Update 2'))

WS.verifyResponseStatusCode(Result, GlobalVariable.successCode)

Name = WS.getElementPropertyValue(Result, 'name')

Job = WS.getElementPropertyValue(Result, 'job')

UpdatedAt = WS.getElementPropertyValue(Result, 'updatedAt')

println('name is: ' + Name)

println('name is: ' + Job)

println('name is: ' + UpdatedAt)

println('updatedAt is: ' + UpdatedAt)

GlobalVariable.name = Name

GlobalVariable.job = Job

GlobalVariable.updatedAt = UpdatedAt

WS.verifyElementPropertyValue(Result, 'name', GlobalVariable.name)

WS.verifyElementPropertyValue(Result, 'job', GlobalVariable.job)

WS.verifyElementPropertyValue(Result, 'updatedAt', GlobalVariable.updatedAt)

