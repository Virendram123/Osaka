package com.osaka.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver d;
	public static Properties prop;
	public static ChromeOptions chromeOpt;
	public static FirefoxOptions firefoxOpt;
	
	public static FileInputStream fis;

	public BaseClass() {
		prop = new Properties();
		try {

			fis = new FileInputStream(new File(
					"C:\\Users\\Virendra\\eclipse-workspace\\Osaka\\src\\main\\java\\com\\osaka\\qa\\config\\config.properties"));

			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initalization() {
		
		String browserName=prop.getProperty("browser");
		
        if(browserName.contains("Chrome"))
        {
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().clearDriverCache();
			chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("--disable-infobars");
			chromeOpt.addArguments("--remote-allow-origins=*");
			chromeOpt.setAcceptInsecureCerts(true);
			d = new ChromeDriver(chromeOpt);
        }
        
		d.manage().window().maximize();
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
		d.get(prop.getProperty("url"));
	}

}
