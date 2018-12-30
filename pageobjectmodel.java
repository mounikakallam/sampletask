package sampletask;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageobjectmodel {
  public Menu menu=null;
  public pageobjectmodel(WebDriver driver)
  
//Create PageObject for Amazon User LogIn  
	{
       menu=PageFactory.initElements(driver,Menu.class);

	}
    @FindBy(xpath="//*[@id=\"ap_email\"]")
       WebElement email;
    @FindBy(xpath="//*[@id=\"ap_password\"]")
       WebElement password;
    @FindBy(xpath="//*[@id=\"signInSubmit\"]")
       WebElement button;
//perform login operation On Amazon WebPage
     public void login(String u,String p)
     {
	     email.sendKeys(u);
	     password.sendKeys(p);
	     button.click();
	     }
}
