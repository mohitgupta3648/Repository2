package eupchaar.ui.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.io.Files;

import eupchaar.ui.automation.Enums.LocatorType;

public class DO {
	
	static WebDriver driver = Driver.getInstace();
	static WebElement ele = null;
	private static long defaultTimeOutInSeconds = 5;
	private static By by;
	
	private static By getBy(Locator loc)
	{
		
		if(loc.getType().equals("xpath"))
		{
			by = By.xpath(loc.getValue());
		}
		if(loc.getType().equals("id"))
		{
			by = By.id(loc.getValue());
		}
		if(loc.getType().equals("name"))
		{
			by = By.name(loc.getValue());
		}
		if(loc.getType().equals("linkText"))
		{
			by = By.linkText(loc.getValue());
		}
		if(loc.getType().equals("partialLinkText"))
		{
			by = By.partialLinkText(loc.getValue());
		}
		if(loc.getType().equals("className"))
		{
			by = By.className(loc.getValue());
		}
		if(loc.getType().equals("cssSelector"))
		{
			by = By.cssSelector(loc.getValue());
		}
		return by;
	}
	
	private static void waitForElementToPresent(Locator loc)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, defaultTimeOutInSeconds);			
		

		try{
			Locator loc_ = new Locator("//*[@id=\"dekstopRefreshAnimationDiv\"]/table/tbody/tr/td", LocatorType.XPATH, "Loading Image");
			if(driver.findElement(getBy(loc_)).isDisplayed())
			{
				Logger.log("Waiting for Loading Image to disappear");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy(loc_)));
			}
		}catch(Exception e)
		{
			// Do nothing
			
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(getBy(loc)));
				
	}	
	
	public static void waitForPageToLoad(long waitInSeconds)
	{
		new WebDriverWait(driver, waitInSeconds).until(
		          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}
	
	public static void getScreenshot()
	{
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                File reportDirectory = new File(System.getProperty("user.dir") + "/test-output/failure_screenshots/");
                if(!reportDirectory.exists())
                	reportDirectory.mkdirs();                
                File destFile = new File(reportDirectory.getAbsolutePath() + "/" + formater.format(calendar.getTime())+".png");
                Files.copy(scrFile, destFile);
                String img = "<a href='"+ destFile.getAbsolutePath() + "'  target='_blank'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>";
                Logger.log(img);   
                
                
            } catch (IOException e) {
                e.printStackTrace();
            }
                
	}
	
	public static WebElement getWebElement(Locator loc)
	{
		return driver.findElement(getBy(loc));
	}
	
	private static List<WebElement> getWebElements(Locator loc)
	{
		return driver.findElements(getBy(loc));
	}
	
	public static void getURL(String url)
	{
		Logger.log("Opening URL: " + url);
		driver.get(url);
	}
	
	public static void enterText(String text, Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Entering text : \"" + text + "\" in : " + loc.getDesc());		
		driver.findElement(getBy(loc)).sendKeys(text);
		
	}
	
	public static void click(Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Clicking on: " + loc.getDesc());		
		driver.findElement(getBy(loc)).click();
	}
	
	public static String getText(Locator loc)
	{
		
		waitForElementToPresent(loc);
		String text = driver.findElement(getBy(loc)).getText();
		
		Logger.log("Got Text : " + text + " from : " + loc.getDesc());
		return text;
	}
	
	public static Boolean clickAnItemFromCollectionByText(String text, Locator loc)
	{
		
		Boolean found = false;
		waitForElementToPresent(loc);
		Logger.log("Clicking on the Item : \"" + text + "\" From : " + loc.getDesc());
		
		List<WebElement> li = driver.findElements(getBy(loc));
		
		for(WebElement ele : li)
		{
			
			if(ele.getText().equals(text))
			{
				ele.click();
				found = true;
				break;
			}
			
		}
		
		if(!found)
		{
			Logger.log("Didn't find the Item to click with Text : \"" + text + "\"");
		}
		
		return found;
	}
	
	public static Boolean clickAnItemFromCollectionByAttribute(String attributeName, String matchText, Locator loc)
	{
		
		Boolean found = false;
		
		waitForElementToPresent(loc);
		Logger.log("Clicking on the Item : \"" + matchText + "\" From : " + loc.getDesc());		
	
		List<WebElement> li = driver.findElements(getBy(loc));
		
		for(WebElement ele : li)
		{
			
			if(ele.getAttribute(attributeName) != null)
			{
				if(ele.getAttribute(attributeName).equals(matchText))
				{
					ele.click();
					found = true;
					break;
				}
			}
			
		}
		
		if(!found)
		{
			Logger.log("Didn't find the Item to click with Attribute "+ attributeName +" : \"" + matchText + "\"");
		}
		
		return found;
	}
	
	public static void pressKey(CharSequence keys, int noOfTimesToPress, Locator loc)
	{
		for(int i=0; i< noOfTimesToPress;i++)
		{
			driver.findElement(getBy(loc)).sendKeys(keys);
		}
	}
	
	public static void pressKey(CharSequence keys, int noOfTimesToPress)
	{
		for(int i=0; i< noOfTimesToPress;i++)
		{
			new Actions(driver).sendKeys(keys).build().perform();
		}
	}
	
	public static void selectFromDropdownByVisibleText(String text, Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Text : \"" + text + "\" from Dropdown : " + loc.getDesc());
	
		Select sel = new Select(driver.findElement(getBy(loc)));
		sel.selectByVisibleText(text);
	}
	
	public static void selectFromDropdownByVisibleText(String text, Locator loc, WebElement ele)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Text : \"" + text + "\" from Dropdown : " + loc.getDesc());
	
		Select sel = new Select(ele.findElement(getBy(loc)));
		sel.selectByVisibleText(text);
	}
	
	public static void selectFromDropdownByValue(String text, Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Value : \"" + text + "\" from Dropdown : " + loc.getDesc());
		
		Select sel = new Select(driver.findElement(getBy(loc)));
		sel.selectByValue(text);
	}
	
	public static void selectFromDropdownByValue(String text, Locator loc, WebElement ele)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Value : \"" + text + "\" from Dropdown : " + loc.getDesc());
		
		Select sel = new Select(ele.findElement(getBy(loc)));
		sel.selectByValue(text);
	}
	
	public static void selectFromDropdownByIndex(int index, Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Index : \"" + index + "\" from Dropdown : " + loc.getDesc());
		
		Select sel = new Select(driver.findElement(getBy(loc)));
		sel.selectByIndex(index);
	}
	
	public static void selectFromDropdownByIndex(int index, Locator loc, WebElement ele)
	{
		waitForElementToPresent(loc);
		Logger.log("Selecting By Index : \"" + index + "\" from Dropdown : " + loc.getDesc());
		
		Select sel = new Select(ele.findElement(getBy(loc)));
		sel.selectByIndex(index);
	}
	
	public static Boolean clickAnItemFromTableByText(String text, Locator loc)
	{
		waitForElementToPresent(loc);
		Logger.log("Clicking on the table item with text : " + text + " from " + loc.getDesc());
		Boolean isClicked = false;		
		
		WebElement table = driver.findElement(getBy(loc));
		
		List<WebElement> rows = table.findElements(By.tagName("tr")); 
		
		for(WebElement row: rows)
		{
			List<WebElement> elements = row.findElements(By.tagName("td"));
			for(WebElement element: elements)
			{
				if(element.getText().equals(text))
				{
					element.click();
					isClicked = true;
					break;
				}
			}
			
			if(isClicked)
				break;
			
		}
		
		return isClicked;
	}
	
	public static List<Hashtable<String, String>> getTableContentsForTableWithColumnNames(Locator loc)
	{
		WebElement resultTable = getWebElement(loc);
		List<Hashtable<String, String>> tableContents = new LinkedList<Hashtable<String, String>>();
		List<WebElement> rows = resultTable.findElements(By.tagName("tr"));
		boolean isFirstRow = true;
		
		Hashtable<String, String> columnNamesList = new Hashtable<String, String>();
		
		for(WebElement row : rows)
		{
			List<WebElement> columns;
			
			
			
			if(isFirstRow)
			{
				columns = row.findElements(By.tagName("th"));
				int keyCount=0;
				for(WebElement columnName : columns)
				{
					String value = columnName.getText();
					String key = Integer.toString(keyCount);
 					columnNamesList.put(key, value);
					keyCount++;
				}
				isFirstRow = false;
			}
			else
			{
				columns = row.findElements(By.tagName("td"));
			
				Hashtable<String, String> rowDetails = new Hashtable<String, String>();
				int keyCount=0;
				for(WebElement columnData : columns)
				{
					String value = columnData.getText();
					String key_ = Integer.toString(keyCount);
					String key = columnNamesList.get(key_);
 					rowDetails.put(key, value);
					keyCount++;
				}
				
				tableContents.add(rowDetails);

			}
		}
		
		return tableContents;
	}
	
	public static String[] getAttributeValuesList(Locator loc, String attribute)
	{
		List<WebElement> eleList = getWebElements(loc);
		//List<String> attrLista = new LinkedList<String>();
		int len = eleList.size();
		String[] attrList = new String[len];
		
		//String dName = list.get(0).getAttribute("value");
		int index = 0;
		for(WebElement ele : eleList)
		{
			attrList[index] = ele.getAttribute("value");
			index++;
		}
		
		return attrList;
	}

}
