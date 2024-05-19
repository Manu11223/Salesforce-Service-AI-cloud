package testCases;
import org.testng.annotations.Test;
import pageObjects.CaseDetails;
import pageObjects.CasesObject;
import pageObjects.CloneCase;
import pageObjects.CloseCase;
import pageObjects.EmailCase;
import pageObjects.EscalateCase;
import pageObjects.Login;
import testBase.TestBase;
import utilities.dataProviders;

import org.testng.Assert;

public class ServiceTest extends TestBase{
	
	Login sb;
	CasesObject co;
	CaseDetails cd;
	CloneCase cc;
	EscalateCase ec;
	EmailCase em;
	CloseCase end;
	
	
	@Test(priority = 1)
	public void login()
	{
		sb=new Login(driver);
		sb.setUserName(p.getProperty("username"));
		sb.setPassword(p.getProperty("password"));
		sb.clickLogin();
	} 
	
	
    @Test(priority = 2)
    void cases()
    {
    	co=new CasesObject(driver);
    	co.clickCases();
    	co.clickNew();
    	co.recordType();
    	co.clickContinue();
    }  
    
    
    @Test(priority = 3,dataProvider="acc",dataProviderClass=dataProviders.class)
    void casedetails(String subject,String desc) throws InterruptedException
    {
    	cd=new CaseDetails(driver);
    	cd.click_Status();
    	cd.click_Caseorigin();
    	cd.getSubject(subject);
    	cd.getDescription(desc);
    	cd.clickAccountname();
    	cd.clickSearch("Manohar");
    	cd.clickGo();
    	cd.clickAname();
    	cd.clickSave();    	   	
    } 
    
    
    @Test(priority = 4)
    void cloneCase()
    {
    	cc=new CloneCase(driver);
    	cc.clickDetails();
    	cc.clickClone();
    	cc.getSubclone(p.getProperty("Clone"));
    	cc.clickSave();	
    }  
    
    
    @Test(priority = 5)
    void checkclone()
    {
    	Assert.assertEquals(true,cc.check());
    		
    } 
    
    
    @Test(priority = 6)
    void Escalate() 
    {
    	ec=new EscalateCase(driver);
    	ec.clickEscalate();
     	ec.getParent(p.getProperty("parent"));
    	ec.click_Caseorigin();
    	ec.click_Status();
    	ec.clickSLA();
    	ec.getSubject(p.getProperty("escalate"));
    	ec.clickSave();	
    }  
    @Test(priority = 7)
    void checkStatus()
    {
    	Assert.assertEquals("Working",ec.checkStatus());

    } 
    
    
    @Test(priority = 8)
    void email()
    {
    	em= new EmailCase(driver);
    	em.intoCases();
    	em.clickClone();
    	em.clickDetails();
    	em.clickEmail();
    	em.clickTo();
    	em.clickSearch(p.getProperty("to"));
    	em.clickGo();
    	em.clickAname();
    	em.clickTemplate();
    	em.selectTemp();
    	em.clickAttach();
    	em.clickfile();
    	em.clickAttachMail();
    	em.clickDone();   
    	em.clickSend();
    } 
    
    @Test(priority = 9)
    void SLA()
    {
    	end=new CloseCase(driver);
    	end.clickEdit();
    	end.changeStatus();
    	end.clickSave();
    }
    
}
