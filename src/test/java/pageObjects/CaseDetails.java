package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CaseDetails extends Login{
	
	public static String MainWindowPage;
	
	 public CaseDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		//WebElements Locators+identification
				
		@FindBy(id="cas7")
		WebElement btn_Status;
		
		@FindBy(id="cas11")
		WebElement btn_Caseorigin;
		
		@FindBy(id="cas14")
		WebElement txt_Subject;
		
		@FindBy(id="cas15")
		WebElement txt_Description;
		
		@FindBy(xpath ="//img[@title='Account Name Lookup (New Window)']")
		WebElement btn_Accountname;
		
		@FindBy(id="lksrch")
		WebElement btn_Seacrh;
		
		
		@FindBy(xpath = "//input[@title='Go!']")
		WebElement btn_Go;
		
	    @FindBy(xpath ="//tr[@class='dataRow even first']//a[@class=' dataCell '][normalize-space()='Manohar']")
		WebElement btn_Aname;
	    
	    @FindBy(xpath = "//td[@id='topButtonRow']//input[@title='Save']")
		WebElement btn_save;

		
		//action Methods
		public void click_Status()
		{
			Select sc=new Select(btn_Status);
			sc.selectByVisibleText("New");
		}
		
		public void click_Caseorigin()
		{
			Select sc=new Select(btn_Caseorigin);
			sc.selectByVisibleText("Email");
		}
		
		public void getSubject(String subject)
		{
			txt_Subject.sendKeys(subject);
		}
		
		public void getDescription(String desc)
		{
			txt_Description.sendKeys(desc);
		}
		
	
		public void clickAccountname()  {

		       MainWindowPage=driver.getWindowHandle();

		    	btn_Accountname.click();

		    	Set<String> AllWindowHandles=driver.getWindowHandles();

		    	for(String LookupWindow:AllWindowHandles) {

		    		if(! LookupWindow.equals(MainWindowPage)) {

		    		driver.switchTo().window(LookupWindow);

		    		//System.out.println("Lookup page Title"+driver.getTitle());
		          }
		   }
		}
		
		public void clickSearch(String Aname) {
	    	driver.switchTo().frame("searchFrame");
	    	btn_Seacrh.sendKeys(Aname);
	    }
		
	    public void clickGo() {
	    	btn_Go.click();
	    	driver.switchTo().defaultContent();
	    }
	    public void clickAname() {
	    	
	    	driver.switchTo().frame("resultsFrame");
	    
	    	btn_Aname.click();
	    	try {
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().window(MainWindowPage);
	    		
	    	}
	    	catch(Exception e) {
	    		driver.switchTo().window(MainWindowPage);
	    	}
	    	
	    }
	    
	    public void clickSave()
	    {
	    	btn_save.click();
	    }
	    



}
