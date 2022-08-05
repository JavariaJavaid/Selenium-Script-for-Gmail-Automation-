
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;

public class GmailTest {

public static void main(String[] args) throws InterruptedException {


//Set chrome driver path
System.setProperty("webdriver.chrome.driver","D:\\PSEB\\SETUP\\chromedriver\\chromedriver.exe");


//declaration and instantiation of objects/variables
WebDriver driver = new ChromeDriver();
String baseUrl = "https://www.gmail.com";

//driver will get the value of base url
driver.get(baseUrl);

//implicite wait
WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));

//Steps for login into gmail 

//step 1
/*
driver.findElement(By.id("Email")).sendKeys("automation5566@gmail.com");
driver.findElement(By.name("password")).click();
driver.findElement(By.name("password")).sendKeys("Auto1234*");
driver.findElement(By.id("submit")).click();
*/
/*
* driver.findElement(By.id("Email")).sendKeys("nasirsultan985@gmail.com");
* driver.findElement(By.id("next")).click();
* driver.findElement(By.id("password")).sendKeys("admin123");
* driver.findElement(By.id("submit")).click();
*/




//for extra screen if appear
/*
driver.findElement(By.xpath("//input[@type='email']")).sendKeys("automation5566@gmail.com");
WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
next.click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
driver.findElement(By.xpath("//span[text()='Next']")).click();
driver.findElement(By.xpath("//a[text()='Sign in']")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//span[text()='Try again']")).click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//a[text()='Sign in']")).click();
*/


//for validation 

/*
String expectedTitle = "Gmail";
String actualTitle = "";

// launch Chrome and direct it to the Base URL
driver.get(baseUrl);

// get the actual value of the title
actualTitle = driver.getTitle();

//compare the actual title of the page with the expected one and print the result as "Passed" or "Failed"

if (actualTitle.contentEquals(expectedTitle)){
System.out.println("Test Passed!");
} else {
System.out.println("Test Failed");
}

*/


//implicite wait
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//Gmail Inbox Page
//Compose Email


//WebElement compose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div")));
WebElement compose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Compose']")));
compose.click();

driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		

//get the xpath of all element
WebElement emailto = driver.findElement(By.name("to"));
WebElement subject = driver.findElement(By.name("subjectbox"));
WebElement body = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));

emailto.sendKeys("automation5566@gmail.com");

subject.sendKeys("Test Subject 11");


//String ExpectedSubject = driver.findElement(By.xpath("//input[@value='Test Subject']")).getAttribute("value").toString();
String ExpectedSubject1 = subject.getAttribute("value").toString();
System.out.println("Expected Subject: "+ ExpectedSubject1);

body.sendKeys("This is the body of test email");
String ExpectedBody = body.getText();
System.out.println("Expected body: "+ ExpectedBody);

//String ExpectedEmail = emailto.getText();

//Social label
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//WebElement moreoptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tooltip='More options']")));
//moreoptions.click();
driver.findElement(By.xpath("//div[@data-tooltip='More options']")).click();
driver.findElement(By.xpath("//div[text()='Label']")).click();
driver.findElement(By.xpath("(//div[text()='Social'])[last()]")).click();

//send email
driver.findElement(By.xpath("//div[text()='Send']")).click();

Thread.sleep(30000);

//social tab click
driver.findElement(By.xpath("//div[@aria-label='Social']")).click();

//code for starred
//driver.findElement(By.xpath("(//span[text()='Test Subject 11']/../../../../../..//td[3]//span[@title='Not starred'])[2]")).click();

Thread.sleep(5000);
//code of opening email recieved
driver.findElement(By.xpath("(//span[text()='Test Subject 11'])[2]")).click();

Thread.sleep(5000);

String ActualEmail = driver.findElement(By.xpath("//span[text()='automation5566@gmail.com']")).getText();
String ActualSubject = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[1]/div[2]/div[1]/h2")).getText();
String ActualBody = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]/div[2]/div[3]/div[3]/div/div[1]")).getText();

//conditials to verify
/*
if(ActualEmail.contentEquals(ExpectedEmail))
{
	System.out.println("Email Matched Sucessfully!");
}
else
{
	System.out.println(ActualSubject + " Doesn't Matches the expected Email which is: " + ExpectedEmail);
}
*/

if(ActualSubject.contentEquals(ExpectedSubject1))
{
	System.out.println("Subject Matched Sucessfully!");
}
else
{
	System.out.println(ActualSubject + " Doesn't Matches the expected subject which is: " + ExpectedSubject1);
}


if(ActualBody.contentEquals(ExpectedBody))
{
	System.out.println("Email Body Matched Sucessfully!");
}
else
{
	System.out.println(ActualBody + " | Doesn't Matches the expected body which is: " + ExpectedBody);
}


/*
* compare the actual title of the page with the expected one and print
* the result as "Passed" or "Failed"
*/
/*if (actualTitle.contentEquals(expectedTitle)){
System.out.println("Test Passed!");
} else {
System.out.println("Test Failed");
}*/

//close Chromedriver
driver.close();


}

}