package com.experiment.ios;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
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
		
		JavascriptExecutor executor = DRIVER;
		
		do{
		executor.executeScript(
			    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.8}, endOffset:{x:0.5, y:0.1}, duration:0.8});");
		}while(!lastElement.isDisplayed());
		
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
			    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.8}, endOffset:{x:0.5, y:0.1}, duration:0.8});");
		}while(!lastElement.isDisplayed());
		
		do{
			executor.executeScript(
				    "target.frontMostApp().mainWindow().dragInsideWithOptions({startOffset:{x:0.5, y:0.1}, endOffset:{x:0.5, y:0.8}, duration:0.8});");
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
    		  
    		  System.out.println("Privacy notice is displayed");
    		  state = true;
    		  
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
	
	
	

}
