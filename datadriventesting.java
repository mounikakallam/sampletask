package sampletask;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class datadriventesting {
	FirefoxProfile fp;
	FirefoxDriver driver1;
	ProfilesIni pr;
	FileInputStream fso;
	XSSFWorkbook wbo;
	XSSFSheet wso;
	FileOutputStream fo;
	WebDriver driver;
	Row r;
	
	@BeforeTest
	  public void beforeTest() throws Throwable {
		
		//launch the ChromeBrowser
		    System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		    driver= new ChromeDriver();
		  
	   //Navigate to the Amazon WebPage
		    driver.get("https://www.amazon.com");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
	  }
  @Test
  
  
 //Perform DataDrivenTesting
     public void datadrivenandmousehover() throws IOException,FileNotFoundException, InterruptedException {
	
	    WebElement value= driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"));
	    Boolean expected= value.isDisplayed();
	  
  //checking for WebElement is display or not  
	  
	        if(expected == true)
	         {
		         value.click();
   //open the ExcelFile
		        fso = new FileInputStream("D:\\eclipse-workspace2\\Task\\src\\com\\data\\Amazon Login Data Driven.xlsx");
		        System.out.println("File open Suceesfully");
		        wbo=new XSSFWorkbook(fso);
		        wso=wbo.getSheet("Login");
		        Thread.sleep(1000);
		        int rowc=wso.getLastRowNum();
		        System.out.println("no of rows are"+"   "+rowc);
	       for(int i=1;i<=rowc;i++)
		          {
			 
			    r= wso.getRow(i);
			    pageobjectmodel page = PageFactory.initElements(driver, pageobjectmodel.class);
			    page.login(r.getCell(0).getStringCellValue(), r.getCell(1).getStringCellValue());
			    String expectedurl = r.getCell(2).getStringCellValue();
			    Thread.sleep(3);
			    String actual = driver.getCurrentUrl();
			    r.createCell(3).setCellValue(actual);
			  if(expectedurl.equals(actual))
			       {
			
				  r.createCell(4).setCellValue("pass");
				  System.out.println(" values are pass");
   //Close and save the file				  
				  fo = new FileOutputStream("D:\\eclipse-workspace2\\Task\\src\\com\\data\\Amazon Login Data Driven.xlsx");
				  wbo.write(fo);
   //Mouse Move to element					  
				  WebElement move = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"));
   		          Actions ac = new Actions(driver);
				  ac.moveToElement(move).build().perform();
				  driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span")).click();
			  }
			  else
			  {
				  r.createCell(4).setCellValue("Fail");
				  System.out.println("values are fail");
	//close and save the file			  
				  fo = new FileOutputStream("D:\\eclipse-workspace2\\Task\\src\\com\\data\\Amazon Login Data Driven.xlsx");
				  wbo.write(fo);  
			  }  
		  }
   //Close the browser	   
		  driver.close();  
	  }	   
  }
}

