package baseClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//flaky test - failed test case rerun and check.//if we feel test flaky we will spcify in that method - retryAnalyzer=Retry.class
public class Retry implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count < maxTry) {
			count ++;
			return true;
		}
		return false;
	}

}
