package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CalendarBookingPage {

    private WebDriver driver;

    public CalendarBookingPage(WebDriver driver){
        this.driver = driver;
    }


    public void selectCalendarDate(String date){
        String splitDate[] = date.split("-");
        String day = splitDate[2];

        List<WebElement> days = driver.findElements(By.className("BookingCalendar-day"));

        for(WebElement d :  days){
            if (d.getText().equals(day)){
                d.click();
            }
        }
    }

    public void setTime(String time){
        List<WebElement> timeSlots = driver.findElements(By.className("SlotPicker-time"));

        for(WebElement t : timeSlots){
            if(t.getText().equals(time))
                t.click();
        }
    }

    public void selectContinue(){
        driver.findElement(By.name("button")).click();
    }
}

