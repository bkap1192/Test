import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Sample1 
{

	
	public WebDriver driver;
	
	
	
	
	public  WebDriver fn_LaunchBrowser(String BrowserType) throws Exception {

        WebDriver Driver_Object = null;
        if (BrowserType.equalsIgnoreCase("FF")
                || BrowserType.equalsIgnoreCase("Firefox")) {
            Driver_Object = new FirefoxDriver();
        } else if (BrowserType.equalsIgnoreCase("Safari")) {
            Driver_Object = new SafariDriver();
        } else if (BrowserType.equalsIgnoreCase("chrome")|| BrowserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver",".\\Resources\\Drivers\\chromedriver.exe");
        	
        	//System.setProperty("webdriver.chrome.driver","C:\\Users\\qa\\Downloads\\chromedriver_win32\\chromedriver.exe");
        	
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--test-type");
            LoggingPreferences loggingprefs = new LoggingPreferences();
            loggingprefs.enable(LogType.BROWSER, Level.ALL);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
            capabilities.setCapability("chrome.binary", ".\\Resources\\Drivers\\chromedriver.exe");
            
           // capabilities.setCapability("chrome.binary", "C:\\Users\\qa\\Downloads\\chromedriver_win32\\chromedriver.exe");
            
            
            capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            Driver_Object = new ChromeDriver(capabilities);
        } else if (BrowserType.equalsIgnoreCase("IE")|| BrowserType.equalsIgnoreCase("InternetExplorer")) {
            System.setProperty("webdriver.ie.driver",".\\Resources\\Drivers\\IEDriverServer.exe");
            InternetExplorerDriverService.Builder service = new InternetExplorerDriverService.Builder();
            service = service.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
            service = service.withLogFile(new File("d:\\logs\\selenium.log"));
            //    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            //    ieCapabilities.setCapability("requireWindowFocus", true);
            //.setCapability("ie.ensureCleanSession", true);
            //ieCapabilities.setCapability("nativeEvents", false);
            //            ieCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Internet Explorer");
            //            ieCapabilities.setCapability(CapabilityType.VERSION, "8");
            //        ieCapabilities.setCapability("ie.forceCreateProcessApi", true);
            //            ieCapabilities.setCapability("ie.browserCommandLineSwitches","-private");

            // ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
            // true);
            Driver_Object = new InternetExplorerDriver(service.build());
            // Driver_Object = new InternetExplorerDriver();
        } else if (BrowserType.equalsIgnoreCase("remote")) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName("chrome");
            Driver_Object = new RemoteWebDriver(new URL(
                    "http://localhost:4446/wd/hub"), cap);
        }
        // DO NOT DELETE IT
        /*
         * else if(BrowserType.equalsIgnoreCase("bmp")){ ProjectSnappyProxy
         * objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
         * System.setProperty("webdriver.chrome.driver",
         * ".\\Resources\\chromedriver.exe"); Driver_Object=new
         * ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));
         *
         * }
         */
//        else {
//
//            logger.info("Provided Browser Type is invalid, please check");
//        }
        Driver_Object.manage().window().maximize();
        Driver_Object.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);
        driver=Driver_Object;
        return Driver_Object;
    }

	
	
	
	
	
}
