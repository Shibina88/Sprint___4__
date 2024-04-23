package ru.qa.scooter.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentPage {
    private final WebDriver webDriver;
    private final By dateInputLoc=By.xpath("//input[@placeholder='* Когда привезти самокат']"); // локатор поля даты доставки самоката
    private final By rentPeriodInputLoc=By.xpath("//div[text()='* Срок аренды']"); //локатор поля Срок аренды
    private final String  rentPeriodInputItonLoc="//div[text()='%s']"; //локатор длительности аренды
    private final  By createOrderBtnLoc=By.xpath("//button[text()='Заказать']"); //локатор кнопки заказать

    public RentPage (WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public void fillRentInfo(String date, String period) {

        WebElement dateInput = webDriver.findElement(dateInputLoc);
        dateInput.sendKeys(date, Keys.ENTER);
        WebElement rentPeriodInput = webDriver.findElement(rentPeriodInputLoc);
        rentPeriodInput.click();
        WebElement rentPeriodInputIton = webDriver.findElement(By.xpath(String.format(rentPeriodInputItonLoc, period)));
        rentPeriodInputIton.click();
    }
    public void createOrderBtn(){
        WebElement createOrderBtn=webDriver.findElement(createOrderBtnLoc);
        createOrderBtn.click();
    }
}

