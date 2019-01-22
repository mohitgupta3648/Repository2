package eupchaar.ui.automation.PageModels;

import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Locator;

public class OPDConsultationPage {
	

	Boolean isPatientFound = false;
	
	private Locator waitingListIcon = new Locator("featureTD1315",LocatorType.ID, "Waiting");
	private Locator waitingListTable = new Locator("//*[@id=\"worklistTaskTbl\"]/tbody",LocatorType.XPATH, "Waiting List Table");
	
	public void clickOnWaiting()
	{

		DO.click(waitingListIcon);
		
	}
	
	public void selectPatientFromWaitingList(String UHID)
	{

		DO.clickAnItemFromTableByText(UHID, waitingListTable);
		
	}
	
	/*public void completeConsulation() throws InterruptedException
	{
		DO.waitForPageToLoad(10);
		Thread.sleep(2000);
		driver.findElement(By.id("newProblemDesc")).sendKeys("This is a test problem");
		new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		List<WebElement> folders = driver.findElements(By.id("folder"));
		Hashtable<String, WebElement> table = new Hashtable<String, WebElement>();
		for(WebElement folder : folders)
		{
			String key = folder.getAttribute("title");
			table.put(key, folder);
		}
		
		Thread.sleep(2000);
		// Enter Diagnosis
		table.get("Diagnosis").click();
		Thread.sleep(2000);
		List<WebElement> diagFavs = driver.findElements(By.name("diagnosisRIDChkBx"));
		diagFavs.get(0).click();
		//diagFavs.get(1).click();
		
		Thread.sleep(5000);
		// Enter Notes
		DO.waitForPageToLoad(10);
		table.get("Notes").click();
		driver.findElement(By.id("visitNote_3")).sendKeys("This is a test Notes");
		
		Thread.sleep(1000);
		// Enter Investigations
		table.get("Lab").click();  //Investigations/Orders
		List<WebElement> invstFavs = driver.findElements(By.id("investigationchkbox"));
		invstFavs.get(0).click();
		invstFavs.get(1).click();
		
		
		// Enter prescriptions
		table.get("Prescriptions").click();
		Thread.sleep(1000);

		driver.findElement(By.id("drugName")).sendKeys("PARACETAMOL");
		new Actions(driver).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("mini_pr_daily_qtyOPD")).sendKeys("10");
		driver.findElement(By.id("dosageSearch")).sendKeys("Thrice in a day");
		driver.findElement(By.id("forOPD")).sendKeys("3");
		driver.findElement(By.id("forOPD")).click(); 

		driver.findElement(By.id("drugName")).sendKeys("para");
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		String medToSelect= "Paracetamol Tablet 500 Mg";
		
		
		//wait.until(ExpectedConditions.visibilityOf(autoSuggMed));
		Boolean isMedFound = false;
		int i = 9;
		//String id = "ui-id-";
		while(!isMedFound)
		{
			WebElement autoSuggMed;
			try{
			
				System.out.println("Trying for the value: " + i);
				autoSuggMed = driver.findElement(By.id("ui-id-" + i));
				i++;
			}catch(Exception e)
			{
				Logger.log("Caught Exception while searching in the auto suggestions");
				break;
			}
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//WebElement ele = driver.findElement(By.id("saveButton"));
			//js.executeScript("arguments[0].scrollIntoView(true);", ele);
		List<WebElement> optionsToSelect = autoSuggMed.findElements(By.tagName("li"));
		System.out.println("Size of array: " + optionsToSelect.size());
			if(optionsToSelect.size() != 0)
			{
				int index = 1;
				for(WebElement option : optionsToSelect)
				{
					System.out.println("Option Text: " + option.getText());
					if(option.getText().equals(medToSelect))
					{
						Logger.log("Selected medicine from auto suggestions: " + medToSelect);
						System.out.println("Index :" + index);
						//option.click();
						js.executeScript("arguments[0].click();", option);
						//driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]/li[" + index + "]/a")).click();
						isMedFound = true;
						break;
					}
					index++;
				}
			}
		}
		
		
		
		//try
		//{
		new Actions(driver).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		//} catch(Exception e)
		//{
			Alert alert = driver.switchTo().alert();
			if(alert != null)
			{
				alert.accept();
			}
			
			Thread.sleep(3000);
			
			alert = driver.switchTo().alert();
			if(alert != null)
			{
				alert.accept();
			}
		//}
		
		
		Thread.sleep(4000);
		// Consultaioin Done
		new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//driver.navigate().refresh();
		
		List<WebElement> li = driver.findElements(By.className("cursorPoint"));
		for(WebElement ele : li)
		{
			if(ele.getAttribute("value") != null)
			{
				System.out.println(ele.getAttribute("value"));
				if(ele.getAttribute("value").equals("Consultation Done"))
					//ele.click();
				{
					System.out.println("This is where I am closing consultation");
					js.executeScript("arguments[0].click();", ele);
				}
				break;
			}
		}
		
		//new Actions(driver).sendKeys(Keys.ENTER).build().perform();
		
		
	}
*/
}
