package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {

	
	public static WebDriver driver;
	
	public Properties p;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		switch (br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case  "edge": driver=new EdgeDriver(); break;
		default:
			System.out.println("No Matching Browser");
			return;
		}
		FileReader file=new FileReader(".//src//test//resources//properties");
		p=new Properties();
		p.load(file);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();	
	}
	
	
    @AfterClass
    void TearDown()
    {
    	driver.quit();
    }

 
	
}
