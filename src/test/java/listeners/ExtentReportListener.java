package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ExtentReportListener implements ITestListener
{
	//extent reporter
	private ExtentReports extent;
	private ExtentTest test;
	
	public ExtentReportListener() {}
	
	@Override
	public void onStart(ITestContext context)
	{
		String reportPath = System.getProperty("user.dir") + "/src/test/resources/reports/extentReport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		//set system environment info
		extent.attachReporter(sparkReporter); // attach the spark reporter
		extent.setSystemInfo("Tester", "Asiya");
        extent.setSystemInfo("Sprint", "Sprint-4");
        extent.setSystemInfo("Middle Layer Testing", "RestAssured API Testing");
    }
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		test.info(">>>Test created : " + result.getMethod().getMethodName() ); //test info
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.pass(">>>Test passed : " + result.getMethod().getMethodName()); // test pass info
	}
	
	@Override 
	public void onTestFailure(ITestResult result)
	{
		test.fail(">>>Test failed : " + result.getMethod().getMethodName()); // test fail info
		test.fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.skip(">>>Test skipped : " + result.getMethod().getMethodName()); // test fail info
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}