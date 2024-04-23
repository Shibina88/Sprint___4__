package ru.qa.scooter.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameInputLoc= By.xpath("//input[@placeholder='* Имя']"); //локатор поля ввода имени
    private final By lastnameInputLoc= By.xpath("//input[@placeholder='* Фамилия']"); // локатор поля ввода фамилии
    private final By addressInputLoc=By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");// локатор поля ввода адреса
    private final By subwayInputLoc=By.xpath("//input[@placeholder='* Станция метро']"); // локатор выпадающего списка Матро
    private final By phoneInputLoc= By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); //локатор поля ввода телефона
    private final String stationMenuItenLoc="//div[text()='%s']"; //локатор ввода наименования станции
    private final By nextBtnLoc =By.xpath("//button[text()='Далее']"); //локатор кнопки Далее
    public OrderPage(WebDriver webDriver){
this.webDriver=webDriver;
}
public void fillCustomerInfo(String name, String lastname, String address, String subwaytitle,String phone) {

     WebElement nameInput=webDriver.findElement(nameInputLoc);
            nameInput.sendKeys(name);
    WebElement lastnameInput=webDriver.findElement(lastnameInputLoc);
            lastnameInput.sendKeys(lastname);
    WebElement addressInput=webDriver.findElement(addressInputLoc);
        addressInput.sendKeys(address);
    WebElement subwayInput=webDriver.findElement(subwayInputLoc);
        subwayInput.click(); // кликаем на выпадающий список
    WebElement arbatskayaStationMenu=webDriver.findElement(By.xpath(String.format(stationMenuItenLoc,subwaytitle)));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",arbatskayaStationMenu);
         arbatskayaStationMenu.click();
    WebElement phoneInput=webDriver.findElement(phoneInputLoc);
        phoneInput.sendKeys(phone);
    }
    public void clickNextBtn(){
    WebElement nextButton=webDriver
            .findElement(nextBtnLoc);
    nextButton.click();
    }

}
