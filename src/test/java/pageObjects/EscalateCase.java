package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EscalateCase extends Login{
	
	 public EscalateCase(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	 
	 
		@FindBy(xpath = "//td[@id='topButtonRow']//input[@title='escalate']")
		WebElement btn_escalate;
		
		@FindBy(id  = "cas28")
		WebElement txt_parent;
		
		@FindBy(id="cas7")
		WebElement btn_Status;
		
		@FindBy(id="cas11")
		WebElement btn_Caseorigin;
		
		@FindBy(id="00NF9000007oAby")
		WebElement btn_SLA;
		
		@FindBy(id="cas14")
		WebElement txt_Subject;
		
	    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
		WebElement btn_save;
	    
	    @FindBy(xpath = "//*[@title=\"Working\"]")
		WebElement verify;
		

	  
		
	    public void clickEscalate()
	    {
	    	btn_escalate.click();
	    }
	    
	    public void getParent(String parent) 
	    {
	    	driver.switchTo().frame("itarget");
	    	txt_parent.sendKeys(parent);
	    }
	    
		public void click_Status() 
		{
			Select sc=new Select(btn_Status);
			sc.selectByVisibleText("Working");
		}
		
		public void click_Caseorigin() 
		{
			Select sc=new Select(btn_Caseorigin);
			sc.selectByVisibleText("Phone");
		}
		
		public void clickSLA() 
		{
			Select sc=new Select(btn_SLA);
			sc.selectByVisibleText("Yes");
		}
		
		public void getSubject(String subject)
		{
			txt_Subject.sendKeys(subject);
		}
	    
	    public void clickSave()
	    {
	    	btn_save.click();
	    }
	    
	    public String checkStatus()
	    {
	    	String exp=verify.getText();
	    	return exp;	
	    }
	    
	   
	    

	    
		
		
	    
}
