package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.NoSuchElementException;

// Everything that is common among we can go here
// Top menu appears on every single page
public class BasePage {

    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loadermask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;


    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * While this loading screen present html code a little bit different
     * Some elements can be missing, also yo dont able to interact with any elements
     * Waits until loader mask disappears
     * @return true if loader mask gone, false if something went wrong
     */
    public boolean waitUntilLoaderMaskDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown']")));
            return true;
        } catch (NoSuchElementException e){
            System.out.println("Loader mask not found");
            System.out.println(e.getMessage());
            return true; //no loader mask, all good, return true
        } catch (WebDriverException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * This method stands for navigator in vytrack application
     * provide moduleName, for example "Fleet" as String
     * provide subModuleName, for example "Vehicles" as String
     * @param subModuleName
     * @param moduleName
     * normalize-space() same like .trim() in java
     */
    public void navigateTo(String moduleName, String subModuleName){
        Actions actions = new Actions(Driver.get());
        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class = 'title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='"+subModuleName+"' and @class = 'title title-level-2']";

        WebDriverWait wait = new WebDriverWait(Driver.get(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

        WebElement module = Driver.get().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));

        waitUntilLoaderMaskDisappear();

        BrowserUtils.clickWithWait(module); // if click is not working well
        WebElement submodule = Driver.get().findElement(By.xpath(subModuleLocator));
        if(!submodule.isDisplayed()){
            actions.doubleClick(module).doubleClick().build().perform();
            try{
                wait.until(ExpectedConditions.visibilityOf(submodule));
            } catch (Exception ex){
                ex.printStackTrace();
                BrowserUtils.clickWithJS(module);
            }
        }

        BrowserUtils.clickWithWait(submodule);
        BrowserUtils.waitForPageToLoad(10);
    }

    public String getPageSubTitle(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }

    public String getUserName(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForVisibility(userName,5);
        return userName.getText();
    }

    public void logOut(){
        BrowserUtils.wait(2);
        BrowserUtils.clickWithJS(userName);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public void goToMyUser(){
        waitUntilLoaderMaskDisappear();
        BrowserUtils.waitForClickablility(userName,5).click();
        BrowserUtils.waitForClickablility(myUser,5).click();
    }

    public void waitForPageSubTitle(String pageSubtitleText) {
        new WebDriverWait(Driver.get(), 15).until(ExpectedConditions.textToBe(By.cssSelector("h1[class='oro-subtitle']"), pageSubtitleText));
    }

}
