package com.actiTime.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class GenerateReport extends TestListenerAdapter{
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext rv) {
		String date = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
		String repname = "Snap"+date+".html";
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"//ExtentReports//"+repname);
		reporter.config().setDocumentTitle("Execution");
		reporter.config().setReportName("Build 1");
		reporter.config().setTheme(Theme.STANDARD);
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "ram");
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("OS", "WIN-7");
		
		System.out.println("............batch execution started.............");
	}

	public void onFinish(ITestContext r) {
		extent.flush();
		System.out.println(".............batch execution finished!!!!!!!!");
	}

	public void onTestStart(ITestResult rv) {
		System.out.println("............Test execution started..........");

	}

	public void onTestSuccess(ITestResult r) {
		
		System.out.println("------------successfully executed the test case-------------");
	test=extent.createTest(r.getName());
	String s=r.getName();
	System.out.println(s);
	test.log(Status.PASS, MarkupHelper.createLabel("the test is successful", ExtentColor.GREEN));
	}

	public void onTestSkipped(ITestResult r) {
		System.out.println("-----------unfortunately skipped... try@gain....");
	}

	public void onTestFailure(ITestResult r) {
		test=extent.createTest(r.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("test is failed", ExtentColor.RED));
		String date = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
		EventFiringWebDriver e = new EventFiringWebDriver(Base.driver);
		File f1 = e.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir") + "/screenshots/" + date +".jpg";
		File f2 = new File(System.getProperty("user.dir")+"/screenshots/"+date +".jpg");
		try {
			FileUtils.copyFile(f1, f2);
			test.addScreenCaptureFromPath(path,r.getName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("--------------TEST FAILED----CALL SOS--------------");
	}
}
