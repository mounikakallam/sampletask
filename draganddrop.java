	package sampletask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class draganddrop {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		
	//Open The ChromeBrowser
		System.out.println("TestCase 2:");
        System.out.println("open the chromedriver");
		  System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		  driver= new ChromeDriver();
		  
   //Open The jquerui.com
		  System.out.println("navigate to Jqueryui page");
		  driver.get("https://jqueryui.com/droppable/");
		  System.out.println("maximize the window");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  
  //Perform Drag And Drop
  public void drag() throws InterruptedException {
	  Thread.sleep(3);
	  System.out.println("TestCase 2:");
  //Switch To Frame
	  System.out.println("Switch to frame");
	  driver.switchTo().frame(0);
	  System.out.println("find the drag element");
	  WebElement drag= driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
	  System.out.println("find the drop element");
	  WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
	  System.out.println("Perform The drag aand drop operation on mouse hover element");
	  Actions ac = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  ac.dragAndDrop(drag, drop).build().perform();
	 
  }
  @AfterTest
  
  //Close The Browser
	  public void close()
	  {
	  System.out.println("close the browser");
		driver.close();  
	  }
  }


