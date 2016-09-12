package com.experiment.ios;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
public class TestAppium {
	
   public static AppiumDriver<?>DRIVER;
	
	public static void main(String[] args) throws Exception{	
		swipeOnTermsConditions();
	}
	
	public static void swipeOnTermsConditions() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);   
		
		WebElement hamburgerMenu = DRIVER.findElement(By.id("menu-button"));
		
		WebElement tAndCond = DRIVER.findElement(By.id("Terms & conditions"));
		
		hamburgerMenu.click();
		
		tAndCond.click();
		
		List<WebElement>termACond = (List<WebElement>) DRIVER.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAWebView[1]/*"));
		
		int size = termACond.size();
		
		WebElement lastElement = termACond.get(size-1);
		
		System.out.println(lastElement.getAttribute("name"));
		
		//System.out.println(lastElement.);
		
		Dimension screen = DRIVER.manage().window().getSize();
		
		int ycord = lastElement.getLocation().getY();
		
		System.out.println(ycord);
		
		int startx = (screen.width)/2;
		
		int starty = (screen.height)/2;
		
		System.out.println(starty);
		
		int endy = (int) (starty - (0.34*(screen.height)));
		
		int n = (int)((ycord - starty)/starty);
		
		System.out.println(n);
		
		int i = 0;
		
		while(i!=n){
			
		i = i + 1;
		
		DRIVER.swipe(startx,starty,startx,endy,1);
		
		System.out.println(i);
		
		}
		
		if(lastElement.isDisplayed()){
			System.out.println("Can see end of page");
		}
		
		//JavascriptExecutor executor = DRIVER;
		
		//do{
		//executor.executeScript(
		//	    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.3}, endOffset:{x:0.5, y:0.1}, duration:0.1});");
		//}while(!lastElement.isDisplayed());
		
	}
	
	public static void testSwipeOnStory() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);   
		
		WebElement storyArticle = DRIVER.findElement(By.id("Blogs And Other Things To Make 50 Characters Stuff"));
		
		storyArticle.click();
		
		WebElement shareButton = DRIVER.findElement(By.id("share-button"));
		
		List<WebElement>table = (List<WebElement>) DRIVER.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/*"));
		
		int size = table.size();
		
		WebElement lastElement = table.get(size-1);
		
		System.out.println(lastElement.getAttribute("name"));
		
		JavascriptExecutor executor = DRIVER;
		
		do{
		executor.executeScript(
			    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.3}, endOffset:{x:0.5, y:0.1}, duration:0.1});");
		}while(!lastElement.isDisplayed());
		
		do{
			executor.executeScript(
				    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.1}, endOffset:{x:0.5, y:0.3}, duration:0.1});");
			}while(!shareButton.isDisplayed());	
	}
	
	public static boolean hamburgerMenu() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);   
		
		boolean state = false;
		
		WebElement hamburgerMenu = DRIVER.findElement(By.id("menu-button"));
		
		hamburgerMenu.click();
		
		WebElement SkyNewsLogo = DRIVER.findElement(By.id("sky-news-logo"));
		
		WebElement sideDrawer = DRIVER.findElement(By.xpath("//UIAWindow[1]/UIATableView[1]"));
		
		List<WebElement> sideDrawerList = (List<WebElement>) DRIVER.findElements(By.xpath("//UIAWindow[1]/UIATableView[1]/*"));
		
		    if (!SkyNewsLogo.isDisplayed()){
			    state = false;
			    return state;
		    } else if(!sideDrawer.isDisplayed()){
		    	state = false;
			    return state;
		    }

       for (WebElement options: sideDrawerList){
    	  
    	  if ((options.getAttribute("name").equalsIgnoreCase("Digest")) && (options.isDisplayed())){
    		  
    		  System.out.println("Digest is displayed");
    		  state = true;
    		  
    	  } else if ((options.getAttribute("name").equalsIgnoreCase("Notifications")) && (options.isDisplayed())){
    		  
    		  System.out.println("Notifications is displayed");
    		  state = true;
    		  
    	  } else if ((options.getAttribute("name").equalsIgnoreCase("Terms & conditions")) && (options.isDisplayed())){
    		  
    		  System.out.println("Terms & conditions is displayed");
    		  state = true;
    		  
    	  } else if ((options.getAttribute("name").equalsIgnoreCase("Privacy notice")) && (options.isDisplayed())){
    		  
    		  options.click();
    		  
    		  //Add wait for Element
    		  DRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    		  
    		  WebElement SkyProvacyPolicy = DRIVER.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[5]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[13]"));
    		  
    		  if(!SkyProvacyPolicy.isDisplayed()){
    			  
    			  JavascriptExecutor executor = DRIVER;
    			  
    			  do{
    					executor.executeScript(
    						    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.3}, endOffset:{x:0.5, y:0.1}, duration:0.1});");
    					}while(!SkyProvacyPolicy.isDisplayed());
    			  
    			  if(SkyProvacyPolicy.isDisplayed()){
    				  System.out.println("Sky Privacy policy is displayed");
    				  state = true;
    			  } else if (!SkyProvacyPolicy.isDisplayed()){
    				  state = false;
    				  return state;
    			  } 
    		  }
    	
    		  
    	  } else if ((options.getAttribute("name").equalsIgnoreCase("Clear Digest Cache")) && (options.isDisplayed())){
    		  
    		  System.out.println("Clear Digest Cache is displayed");
    		  state = true;
    		  
    	  } else if ((options.getAttribute("name").equalsIgnoreCase("Show On Boarding")) && (options.isDisplayed())){
    		  
    		  System.out.println("Show On Boarding is displayed");
    		  state = true;
    		  
    	  }
       }
		return state;
		
		
	}
	
	public static void clickTest() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);  
		
		String text = "EE Fined Â£1m For Customer Complaint Failures";
		
		WebElement carItem = DRIVER.findElement(By.id("Business"));
		
		carItem.click();
		
		String text2 = text.replaceAll("([^\\p{L}\\p{N}])", "");
		
         List<WebElement>storyList = (List<WebElement>) DRIVER.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/*"));
		
		System.out.println(storyList.size());
		
		System.out.println(text2);
		
	 for (WebElement story:storyList ){
		 System.out.println(story.getAttribute("name").toString().replaceAll("([^\\p{L}\\p{N}])", ""));
		if(story.getAttribute("name").toString().replaceAll("([^\\p{L}\\p{N}])", "").equalsIgnoreCase(text2)){
			System.out.println("in if");
			story.click();
			break;
		}
		
	 }

}
	
	public static void verifyTimeOutBrain() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);  
		
		WebElement story = DRIVER.findElement(By.id("Apple Changes Tune After Swift Speaks Out"));
		
		story.click();
		
		//List<WebElement>list = (List<WebElement>) DRIVER.findElements(By.xpath("//*/UIATableView[@name = 'Story Level Table']/*"));
		
		Thread.sleep(3000);
		
		WebElement outbrain = DRIVER.findElement(By.id("OutbrainLogo"));
		
		WebElement promotedStories = DRIVER.findElement(By.id("Promoted Stories"));
	
		if (promotedStories==null){
			
		}else if (promotedStories!=null){
			System.out.println("Promoted stories are present");
		}
		
		while(!promotedStories.isDisplayed()) {
			
			JavascriptExecutor executor = DRIVER;						
					executor.executeScript(
						    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.5}, endOffset:{x:0.5, y:0.4}, duration:0.1});");
		}	
		
         if (outbrain.isDisplayed()){
        	 System.out.println("Outbrain logo is displayed");
        	 outbrain.click();
		}else if (!outbrain.isDisplayed()){
			System.out.println("Outbrain logo is displayed");
		}
	
    }
	
	public static void scrollToElement() throws Exception{
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "iOS");
		capability.setCapability("platformVersion", "9.3");
		capability.setCapability("deviceName", "iPhone 6");
		capability.setCapability("autoAcceptAlerts","true");
		capability.setCapability("app", "/Users/amayah/Library/Developer/Xcode/DerivedData/SkyNews-dngspbiskonxxudlllqsjqibpnvl/Build/Products/Debug-Dev-iphonesimulator/SkyNewsDev.app");
		
		DRIVER = new IOSDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);  
		
		WebElement story = DRIVER.findElement(By.id("Apple Changes Tune After Swift Speaks Out"));
		
		story.click();
		
		
		story.isDisplayed();
		
		WebElement promotedStories = DRIVER.findElement(By.id("Promoted Stories"));
		
		System.out.println(story.getLocation());
		
		System.out.println(promotedStories.getLocation());
		
		DRIVER.swipe(0, 0, 0, 2893, 3);
		
		
	}
}
