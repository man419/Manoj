package myPack;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Manoj {
@Test
public static void VerifyLogin() {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aswini\\Desktop\\Manu Selenium 2020\\Softwares"
			+ "\\Selenium_3.11\\Browser_Drivers\\chromedriver_win32\\chromedriver.exe");
			
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://apps.qaplanet.in/hrm/login.php");
			
			//login
			driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
			driver.findElement(By.name("txtPassword")).sendKeys("lab1");
			driver.findElement(By.name("Submit")).click();
			
			//verify title page
			if(driver.getTitle().equals("orangeHRM")) 
			{
			System.out.println("Test case passed..");
			}else 
			{
			System.out.println("Test case failed!!");
			}
			
			//click logout link and close
			driver.findElement(By.linkText("Logout")).click();
			driver.close();
			
            }

@Test
public static void AddEmp() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aswini\\Desktop\\Manu Selenium 2020\\Softwares"
	    		+ "\\Selenium_3.11\\Browser_Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
	    driver.get("http://apps.qaplanet.in/hrm/login.php");
	    
	    //login
	    driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	    driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	    driver.findElement(By.name("Submit")).click();
	    
	    
	    String lastname="Mcdonalds";
	    String firstname="Antony";
	    
	    //click on add button by switching on to frame
	    driver.switchTo().frame("rightMenu");
	    
	    //clicking on the add button
	    driver.findElement(By.xpath("//*[@id=\"standardView\"]/div[3]/div[1]/input[1]")).click();
	    
	    //add employee details
	    driver.findElement(By.id("txtEmpLastName")).sendKeys("Mcdonalds");
	    driver.findElement(By.id("txtEmpFirstName")).sendKeys("Antony");
	    driver.findElement(By.xpath("//*[@id=\"btnEdit\"]")).click();
	    
	    //verify the employee name just entered ....in the personal page
	    Thread.sleep(5000);
		//click the edit button
		driver.findElement(By.xpath("//*[@id='btnEditPers']")).click();
	    
		//fetch the inner text of both last name and first name fields
		
		String ln=driver.findElement(By.id("txtEmpLastName")).getAttribute(lastname);
	    String fn=driver.findElement(By.id("txtEmpFirstName")).getAttribute(firstname);
	    System.out.println("firstName :"+ ln);
		System.out.println("lastName : "+ fn);
		
		if(ln.equals(firstname)&&(fn.equals(lastname))) 
		{
			System.out.println("Employee successfully added : TestCase Passed");
		}else 
		{
			System.out.println("Add employee failed : TestCase Failed");
		}
		        //switch back to the parent frame
				//driver.switchTo().defaultContent();
				driver.switchTo().parentFrame();
				Thread.sleep(2000);
				
				//click the logout link
				driver.findElement(By.xpath("html/body/div[3]/ul/li[3]/a")).click();
				
				//close the browser
				Thread.sleep(2000);
				driver.close();	
}
@Test
public static void EditEmp() {
	System.out.println("Edit employee success....");
}
@Test
public static void DeleteEmp() {
	System.out.println("Delete employee success....");
}

}

