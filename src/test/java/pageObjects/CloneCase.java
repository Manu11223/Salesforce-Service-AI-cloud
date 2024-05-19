package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloneCase extends Login{
	
	 public CloneCase(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	 
	    @FindBy(xpath = "//span[normalize-space()='Details']")
		WebElement btn_Details;
	    
	    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Clone']")
		WebElement btn_Clone;
	    
	    @FindBy(xpath = " //div[@title='Clone Case']")
		WebElement verify;
	    
		@FindBy(id="cas14")
		WebElement txt_Subject;
		
		@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
		WebElement btn_save;
		

	    public void clickDetails()
	    {
	    	btn_Details.click();
	    }
	    
	    public void clickClone()
	    {
	    	btn_Clone.click();
	    }
	    
	    public void getSubclone(String subject)
		{
	    	txt_Subject.clear();
			txt_Subject.sendKeys(subject);
		}
	    
	    public void clickSave()
	    {
	    	btn_save.click();
	    }
	    
	    public boolean check()
	    {
	    	boolean exp=verify.isDisplayed();
	    	return exp;	
	    }
	    


}
