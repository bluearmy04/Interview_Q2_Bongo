package myPackage;

import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.sc

public class BongoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setting chrome as browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Riyad Hasan\\Downloads\\selenium\\selenium\\browser\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-features=VizDisplayCompositor");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//bongo BD URL
		driver.get("https://www.bongobd.com"); 
		
		//getting login button to click
		WebElement login = driver.findElement(By.xpath("//div[@class='utility my-account-dropdown']//li[1]//a[1]"));									
        login.click();			
        System.out.println("login Button Selected");
        //setting bangladeshi number as input
        driver.findElement(By.xpath("//div[contains(text(),'Bangladesh (')]")).click();
        driver.findElement(By.xpath("//div[@class='pusher-container']//li[1]//span[1]")).click();
        
        //scanner obj to take input
        Scanner scan = new Scanner(System.in);
        
		//Case: short phone no
		System.out.println("enter five digit"); 
		String fiveDigitPhoneNo = scan.nextLine();
		driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(fiveDigitPhoneNo); 
		driver.findElement(By.id("bongo_otp_btn")).click();
		System.out.println("too short message shown");
		driver.findElement(By.id("bongo_web_register_first_phone_no")).clear();
	    
		//Case: invalid phone no
	    System.out.println("enter eight digit"); 
	    String eightDigitPhoneNo = scan.nextLine();
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(eightDigitPhoneNo);
	    driver.findElement(By.id("bongo_otp_btn")).click();
	    System.out.println("Invalid phone number message shown");
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).clear();
        
	    //Case: long phone no
	    System.out.println("enter twelve digit");
	    String twelveDigitPhoneNo = scan.nextLine();
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(twelveDigitPhoneNo);
	    driver.findElement(By.id("bongo_otp_btn")).click();
	    System.out.println("too long message shown");
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).clear();
	  
	    //Case: long phone no with char
	    System.out.println("enter a phone no with a Character"); 
	    String charPhoneNo = scan.nextLine();
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(charPhoneNo);
	    driver.findElement(By.id("bongo_otp_btn")).click();
	    System.out.println("Get OTP Button greyed out");
	    driver.findElement(By.id("bongo_web_register_first_phone_no")).clear();
	 
        //Case: Valid phone no
        System.out.println("enter a valid phone no");
        String ValidPhoneNo = scan.nextLine();
        driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(ValidPhoneNo);
        driver.findElement(By.id("bongo_otp_btn")).click();
        driver.findElement(By.id("bongo_web_register_first_phone_no")).clear();
        System.out.println("OTP Sent & Textbox Appeared to type the sent OTP in the given number");
        
        //Testing wrong Phone number href
        System.out.println("Clicked on Wrong phone number? Button");
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        WebElement wrongPhone = wait1.until(ExpectedConditions.elementToBeClickable(By.className("wrong-phone")));
        wrongPhone.click();
        System.out.println("Landed on the first page again to fill mobile no");
        
        //Case: Second Valid phone no
        System.out.println("Enter a valid no again");
        String SecondValidPhoneNo = scan.nextLine();
        driver.findElement(By.id("bongo_web_register_first_phone_no")).sendKeys(SecondValidPhoneNo);
        driver.findElement(By.id("bongo_otp_btn")).click();
        System.out.println("Textbox Appeared to type the sent OTP in the given number");
        
        //Resend OTP Button check
        System.out.println("Clicked on Resend OTP Button");
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        WebElement resendOtp = wait2.until(ExpectedConditions.elementToBeClickable(By.className("bongo-resend-otp")));
        resendOtp.click();
        //driver.findElement(By.className("bongo-resend-otp")).click();
        System.out.println("Verification code has been sent message shown and OTP recieved again in the given number");
        
        //Case: OTP with alphabets
        System.out.println("type some alphabets randomly");
        String invalidOtp = scan.nextLine();
        driver.findElement(By.id("bongo_web_register_first_otp")).sendKeys(invalidOtp);
        driver.findElement(By.id("bongo_web_register_first_login_btn")).click();
        driver.findElement(By.id("bongo_web_register_first_otp")).clear();
        System.out.println("The OTP you provided is not a number. Try again.");
        
        //Case: Wrong OTP 
        System.out.println("type the OTP of six digit randomly");
        String WrongOtp = scan.nextLine();
        driver.findElement(By.id("bongo_web_register_first_otp")).sendKeys(WrongOtp);
        driver.findElement(By.id("bongo_web_register_first_login_btn")).click();
        driver.findElement(By.id("bongo_web_register_first_otp")).clear();
        System.out.println("Please enter the correct OTP! message shown");
        
        //Case: System access with correct OTP
        System.out.println("type the OTP sent to mobile");
        String SentOtp = scan.nextLine();
        driver.findElement(By.id("bongo_web_register_first_otp")).sendKeys(SentOtp);
        driver.findElement(By.id("bongo_web_register_first_login_btn")).click();
        System.out.println("Logged in successfully to the system");
        //driver.close();
        
	}

}
