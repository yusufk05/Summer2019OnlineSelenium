package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalenderEvent;

    public void clickToCreateCalendarEvent(){
        BrowserUtils.waitForVisibility(createCalenderEvent, 5);
        BrowserUtils.waitForClickablility(createCalenderEvent,5);
        createCalenderEvent.click();
    }
}
