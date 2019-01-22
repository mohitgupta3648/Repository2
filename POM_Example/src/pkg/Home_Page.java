package pkg;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_Page //Guru99HomePage Old Class Name
{
	 WebDriver driver = new ChromeDriver();

    By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    public Home_Page(WebDriver driver)
    {

        this.driver = driver;

    }
    //Get the User name from Home Page

        public String getHomePageDashboardUserName(){

         return    driver.findElement(homePageUserName).getText();

        }

}
