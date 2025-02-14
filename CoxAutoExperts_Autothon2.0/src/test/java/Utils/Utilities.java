//Author Emp Id:3151410
//Author Name: Siddharth Gaur
//Company Name:Nagarro Software
package Utils;
import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

public class Utilities {

    //Format Date TimeStamp
    public static String formattedDate(LocalDateTime time){
        String formattedTime=time.toString().replace(":","-").replace("T","Time");
        return formattedTime;
    }

    //Create extent report,load its config file and create folder for execution reports
    public static ExtentReports InitiateExtentReporting(ExtentReports eReport, Properties prop,LocalDateTime time){
        eReport = new ExtentReports(System.getProperty("user.dir")+prop.getProperty("TestResultFolderName")+"/"+Utilities.formattedDate(time)+"/"+Utilities.formattedDate(time)+"-.html",false);
        eReport.loadConfig(new File(System.getProperty("user.dir")+prop.getProperty("ExtentReportPath")));
        return eReport;
    }
    //webdriver instance creation
    public static WebDriver InitiateBrowser(String browserName, Logger log, WebDriver driver){
        if (browserName.equalsIgnoreCase("firefox")) {
            log.info("**********Starting Firefox browser**********");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            log.info("**********Starting Chrome browser**********");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            log.info("**********Starting Edge browser**********");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        return driver;
    }
}
