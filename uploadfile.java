
package sampletask;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class uploadfile {
	WebDriver driver;
	@BeforeTest
	  public void openbrowser() {
    //Launch The ChromeBrowser	
		System.out.println("TestCase 3:");
        System.out.println("open the chromedriver");
		  System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		  driver= new ChromeDriver();
   //Open The Amazon WebPage
		  System.out.println("navigate to Amazon page");
		  driver.get("https://www.amazon.com");
		  System.out.println("maximize the window");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	@Test
	
  //Perform FileUpload 
      public void upload() throws InterruptedException, AWTException, Exception {
		System.out.println("TestCase 3:");
		System.out.println("Click on Account&Login");
		WebElement value= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"));
		System.out.println("Checking for Account&Login Webelement is display or not");
		Boolean expected= value.isDisplayed();
	  if(expected == true)
	  {
		  value.click();
		  Thread.sleep(5);
  //Using PageObjectModel  For User Login
		  System.out.println("Send the values are email and password from excel to sigin ");
		  pageobjectmodel page = PageFactory.initElements(driver, pageobjectmodel.class);
		  page.login("mounikapoluri16@gmail.com", "radhakrishna");
		  Thread.sleep(1000);
 //Perform Mouse Move To Element		  
		  WebElement move = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"));
		  System.out.println("Mouse Move to Account&login Element");
		  Actions ac = new Actions(driver);
		  ac.moveToElement(move).build().perform();
		  System.out.println("click on amazon drive");
		  System.out.println("It will navigate to the amazon drive page");
		  driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[12]/span")).click();
		  System.out.println("click on upload");
		  driver.findElement(By.xpath("//*[@id=\"list-page\"]/nav/div[3]/div[1]/div/button/span")).click();
		  System.out.println("click on File Under the upload");
		  driver.findElement(By.xpath("//*[@id=\"list-page\"]/nav/div[3]/div[1]/div/nav/ul/li[1]/button")).click();
 
 //Upload file by using Robot Class
		  System.out.println("Upload file by using Robot class");
		  Robot rb = new Robot();
		  rb.setAutoDelay(2000);
		  
		  StringSelection selection = new StringSelection("fileupload.txt");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		  
		  rb.setAutoDelay(1000);
		  
		  rb.keyPress(KeyEvent.VK_CONTROL);
		  rb.keyPress(KeyEvent.VK_V);
		  
		  rb.keyRelease(KeyEvent.VK_CONTROL);
		  rb.keyRelease(KeyEvent.VK_V);
		  
		  rb.setAutoDelay(1000);
		  
		  rb.keyPress(KeyEvent.VK_ENTER);
		  rb.keyRelease(KeyEvent.VK_ENTER);
		  System.out.println("file uploaded successfully");
		  System.out.println("Click on Add to all button");
		  driver.findElement(By.xpath("//*[@id=\"dialog-container\"]/div[1]/aside/footer/div/button[1]")).click();
		  driver.findElement(By.xpath("//*[@id=\"primary-header\"]/div[2]/div[2]/button/span")).click();
		  System.out.println("click on signout");
		  driver.findElement(By.xpath("//*[@id=\"primary-header\"]/div[2]/div[2]/nav/ul/li[7]/a/span")).click();
		  
//Handle The Alert Message	
		  System.out.println("Switch to alert");
		  Alert alert = driver.switchTo().alert();
		  System.out.println("Alert accepteds");
		  alert.accept();
		
	  }
	  else
	  {
		  System.out.println("file uploaded fails");
	  }	
	  
//Close The Browser	  
	  driver.close();
  }
	
  }

