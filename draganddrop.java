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
		  System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		  driver= new ChromeDriver();
		  
   //Open The jquerui.com
		  driver.get("https://jqueryui.com/droppable/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  @Test
  
  //Perform Drag And Drop
  public void drag() throws InterruptedException {
	  Thread.sleep(3);
	  
  //Switch To Frame
	  driver.switchTo().frame(0);
	  WebElement drag= driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
	  WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
	  Actions ac = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  ac.dragAndDrop(drag, drop).build().perform();
	 
  }
  @AfterTest
  
  //Close The Browser
	  public void close()
	  {
		driver.close();  
	  }
  }


