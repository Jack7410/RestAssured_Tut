package api.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class ExtentReport extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;

	@Override
	public void onTestSuccess(ITestResult tr) {
		test= reports.createTest("Test Passed"+" : "+ tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test=reports.createTest("Test Failed"+" : "+ tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test=reports.createTest("Test Skipped"+" : "+ tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onStart(ITestContext testContext) {
		String timestand= new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(new Date());
		String reportname="Report"+timestand+".html";
		File file= new File(System.getProperty("user.dir")+"//Reports//"+reportname);
		
		htmlReporter= new ExtentHtmlReporter(file);
		htmlReporter.config().setDocumentTitle("Rest API");
		htmlReporter.config().setReportName("QA&E Automation Project");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Host", "Local Host");
		reports.setSystemInfo("Environment", "QE&A");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Date_Time", timestand);
		reports.setSystemInfo("Tester", "Jack");
		
		
	}

	@Override
	public void onFinish(ITestContext testContext) {
		reports.flush();
	}
}
