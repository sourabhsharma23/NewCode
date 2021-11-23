package com.qait.automation;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.mashape.unirest.http.Unirest;
import com.qait.automation.utils.PropFileHandler;

import ru.yandex.qatools.allure.annotations.Attachment;

public class BaseAnnotation_Test implements IHookable{
	
	public TestSessionInitiator test;
	
	public BaseAnnotation_Test(){
		TestSessionInitiator._getSessionConfig();
	}
	
	
	@BeforeMethod
	public void getMethodName(Method methodName){
		System.out.println();
		Reporter.log("*********** Method Started : "+methodName.getName()+"***********************",true);
		System.out.println();
	}


	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {

		callBack.runTestMethod(testResult);
		if (testResult.getThrowable() != null) {
			try {
				takeScreenShot(testResult.getMethod().getMethodName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Attached Screenshot in Allure reporting
	 * @param methodName
	 * @return
	 * @throws IOException
	 */
	@Attachment(value = "Failure in method {0}", type = "image/png")
	private byte[] takeScreenShot(String methodName) throws IOException {
		return test.takescreenshot.takeScreenshotInBytes();
	}
	
	@SuppressWarnings("static-access")
	@AfterSuite
	public void generateEnvironmentReport() throws IOException{
		File file = new File(System.getProperty("user.dir")+File.separator+"target"+File.separator+"allure-results"+File.separator+"environment.properties");
		PropFileHandler prop = new PropFileHandler(file);
		prop.writeToFile(test.configSettings);
		FileUtils.copyFile(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata"+File.separator+"categories.json"),
				
				new File(System.getProperty("user.dir")+File.separator+"target"+File.separator+"allure-results"+File.separator+"categories.json"));
	}
	
	@AfterMethod
	public void LoogedUsedAnnotation(Method methodName){
		for(Annotation an : methodName.getDeclaredAnnotations()){
			System.out.println(an.annotationType());
		}
}
	
	//@AfterMethod
	public void closeConnection(){
		try {
			Unirest.shutdown();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Not able to clear session : - ");
			e.printStackTrace();
		}
	}
	
}
