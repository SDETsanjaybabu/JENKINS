package Day_1_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericUtility.BaseClass;
import com.crm.autodesk.genericUtility.IPathConstant;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.autodesk.genericUtility.ListenerImplementation.class)
public class ForExtentReportTest {
	
	@Test
	public void method1() {
	System.out.println("method 1");
	}
	
	@Test
	public void method2() {
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 BaseClass.sdriver=driver;
		driver.get("https://www.facebook.com/");
		Assert.fail();
		
	}
	
	@Test(dependsOnMethods = "method2")
	public void method3() {
		System.out.println("Method3");
	}

}
