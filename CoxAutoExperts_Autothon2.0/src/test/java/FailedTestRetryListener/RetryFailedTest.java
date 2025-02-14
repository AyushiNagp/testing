package FailedTestRetryListener;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryFailedTest  implements IRetryAnalyzer{
    int counter = 0;
    int retryLimit = 3;

    @Override
    public boolean retry(ITestResult result) {

        if(!result.isSuccess()){
            if(counter < retryLimit)
            {
                counter++;
                result.setStatus(ITestResult.FAILURE);
                return true;
            }
        }
        else {
            result.setStatus(ITestResult.SUCCESS);
        }
            return false;
    }
}
