package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    /*
    driverPool is used for multi thread
    defaultWindowSize is used for arranging size
     */
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private static Dimension defaultWindowSize;

    /*
    This method is used for initialization of browser according to browser type
    given in the configurations.properties
    @return WebDriver
     */

    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Incorrect browser type, please check configuration.properties file\nSupported browser types: chrome, firefox, edge");
            }
            defaultWindowSize = driverPool.get().manage().window().getSize();
            maximizeWindow();
            Driver.timeout(10,"s");
        }
        return driverPool.get();
    }

    /*
    This method is used for initialization of browser according to browser type
    @param browser
    @return WebDriver
     */
    public static WebDriver getDriver(String browser){

        if(driverPool.get() == null){
            String browserType = browser;

            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Incorrect browser type, please check configuration.properties file\nSupported browser types: chrome, firefox, edge");
            }
            defaultWindowSize = driverPool.get().manage().window().getSize();
            maximizeWindow();
            Driver.timeout(10,"s");
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

    public static void maximizeWindow(){
        driverPool.get().manage().window().maximize();
        return;
    }

    public static void setDefaultWindowSize(){
        driverPool.get().manage().window().setSize(defaultWindowSize);
        return;
    }

    public static void timeout(long duration, String unitOfTime){
        switch (unitOfTime.toLowerCase()){
            case "ms":
                driverPool.get().manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
                break;
            case "s":
                driverPool.get().manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
                break;
            case "m":
                driverPool.get().manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
                break;
            case "h":
                driverPool.get().manage().timeouts().implicitlyWait(duration, TimeUnit.HOURS);
                break;
            case "d":
                driverPool.get().manage().timeouts().implicitlyWait(duration, TimeUnit.DAYS);
                break;
        }
        return;
    }


}
