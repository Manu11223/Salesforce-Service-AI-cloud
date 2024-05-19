package pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailCase extends Login{
	
	public static String MainWindowPage;

	
	 public EmailCase(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
	 
	    @FindBy(xpath = "//a[normalize-space()='Cases']")
		WebElement into_Cases;
	    
	    @FindBy(xpath = "//a[contains(text(),'00001054')]")
		WebElement btn_clone;
	    
	    @FindBy(xpath = "//span[normalize-space()='Details']")
		WebElement btn_Details;
	    
	    @FindBy(xpath = "//input[@title='Send an Email']")
		WebElement btn_email;
	    
	    @FindBy(xpath = "//img[@title='To Lookup (New Window)']")
		WebElement btn_to;
	    
	    @FindBy(id="lksrch")
		WebElement btn_Seacrh;
	    
	    @FindBy(xpath = "//input[@title='Go!']")
		WebElement btn_Go;
	    
	    @FindBy(xpath = "//tr[@class='dataRow even first']//a[@class=' dataCell '][normalize-space()='kiran ram']")
		WebElement btn_acc;
	    
	    @FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Select Template (New Window)']")
		WebElement btn_template;
	    
	    @FindBy(xpath = "//a[normalize-space()='Support: Case Assignment Notification']")
		WebElement btn_Selecttemp;
	    
	    @FindBy(xpath = "//*[@name=\"attach\"]")
		WebElement btn_attach;
	    
	    @FindBy(id = "file")
		WebElement btn_file;
	    
	    @FindBy(xpath  = "//input[@title='Attach To Email (New Window)']")
		WebElement btn_AttachToMail;
	    
	    @FindBy(xpath  = "//input[@title='Done']")
		WebElement btn_Done;
	    
	    @FindBy(xpath  = "//td[@id='bottomButtonRow']//input[@title='Send']")
		WebElement btn_Send;

	    
	    
	    public void intoCases()
	    {
	    	driver.switchTo().defaultContent();
	    	into_Cases.click();
	    }
	    
	    public void clickClone()
	    {
	    	btn_clone.click();
	    }
	    
	    public void clickDetails()
	    {
	    	btn_Details.click();
	    }
	    
	    public void clickEmail()
	    {
	    	btn_email.click();
	    }

	    
		public void clickTo()  {

		       MainWindowPage=driver.getWindowHandle();

		       btn_to.click();
		       
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
	    
	    	btn_acc.click();
	    	try {
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().window(MainWindowPage);
	    		
	    	}
	    	catch(Exception e) {
	    		driver.switchTo().window(MainWindowPage);
	    	}
	    	
	    }
	    
	    
		public void clickTemplate()  {

		       MainWindowPage=driver.getWindowHandle();

		       btn_template.click();

		    	Set<String> AllWindowHandles=driver.getWindowHandles();

		    	for(String LookupWindow:AllWindowHandles) {

		    		if(! LookupWindow.equals(MainWindowPage)) {

		    		driver.switchTo().window(LookupWindow);

		    		//System.out.println("Lookup page Title"+driver.getTitle());
		          }
		   }
		}
		
		public void selectTemp()
		{
			btn_Selecttemp.click();
			try {
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().window(MainWindowPage);
	    		
	    	}
	    	catch(Exception e) {
	    		driver.switchTo().window(MainWindowPage);
	    	}
		}
	    
 
		public void clickAttach()  {

		       MainWindowPage=driver.getWindowHandle();

		    	btn_attach.click();

		    	Set<String> AllWindowHandles=driver.getWindowHandles();

		    	for(String LookupWindow:AllWindowHandles) {

		    		if(! LookupWindow.equals(MainWindowPage)) {

		    		driver.switchTo().window(LookupWindow);

		          }
		   }
		}
		
		public void clickfile() {
	    	driver.switchTo().frame("resultsFrame");
	    	btn_file.sendKeys("C:\\Users\\2321802\\Downloads\\Day34.txt");	  
	    	}
		
		public void clickAttachMail() {
			
			btn_AttachToMail.click();
	    	}
		
		public void clickDone() {
			
			btn_Done.click();
	    	try {
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().window(MainWindowPage);
	    		
	    	}
	    	catch(Exception e) {
	    		driver.switchTo().window(MainWindowPage);
	    	}
	    	}
		
        public void clickSend() {
			
        	btn_Send.click();
	    	}
		

		
		
		
	    
}




