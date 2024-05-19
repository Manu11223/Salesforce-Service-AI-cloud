package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CloseCase extends Login{
	
	 public CloseCase(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	 

	    
	    @FindBy(xpath  = "//td[@id='topButtonRow']//input[@title='Edit']")
		WebElement btn_edit;
	    
		@FindBy(id="cas7")
		WebElement btn_Status;
		
	    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
		WebElement btn_save;

	    
        
        
        public void clickEdit()
        {
        	btn_edit.click();
        }
        
		public void changeStatus()
		{
			Select sc=new Select(btn_Status);
			sc.selectByVisibleText("Escalated");
		}
		
	    public void clickSave()
	    {
	    	btn_save.click();
	    }
        

}
