package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	

	  public WebDriver driver;
	  
	  public Login(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this); 
	  }


		//WebElements Locators+identification
	  
	  @FindBy(id="username")
		WebElement txt_userName;
		
		@FindBy(id="password")
		WebElement txt_passWord;
		
		@FindBy(id="Login")
		WebElement btn_login;
		
		
		//action Methods
		public void setUserName(String username)
		{
			txt_userName.sendKeys(username);
		}
		
		public void setPassword(String password)
		{
			txt_passWord.sendKeys(password);
		}
		
		public void clickLogin()
		{
			btn_login.click();
		}
	}


