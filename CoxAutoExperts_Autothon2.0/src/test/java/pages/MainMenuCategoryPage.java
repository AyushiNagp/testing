//Author Emp Id:3151410
//Author Name: Siddharth Gaur
//Company Name:Nagarro Software
package src.test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainMenuCategoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//ul[contains(@style,'block')]")
    @CacheLookup
    private WebElement SubMenuItem;

    public MainMenuCategoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15, 50);
    }

    //Hover on main menu item based on category name sent as parameter
    public boolean HoverOnCategoryAndVerifySubMenuDisplay(String categoryName){
        String pathToElement="//a[@title='"+categoryName+"']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pathToElement)));
        Actions a= new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath(pathToElement))).perform();
        wait.until(ExpectedConditions.visibilityOf(SubMenuItem));
        return SubMenuItem.isDisplayed();
    }

    public void ClickMainMenuItem(String categoryName){
        String pathToElement="//a[@title='"+categoryName+"']";
        List<WebElement> menuItemsList=driver.findElements(By.xpath(pathToElement));
        if(menuItemsList.size()>1){
            wait.until(ExpectedConditions.visibilityOf(menuItemsList.get(1)));
            menuItemsList.get(1).click();
        }
        else {
            wait.until(ExpectedConditions.visibilityOf(menuItemsList.get(0)));
            menuItemsList.get(0).click();
        }
    }
}
