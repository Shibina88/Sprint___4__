package ru.qa.scooter.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;
    private By cookiesBtnLoc=By.xpath("//button[text()='да все привыкли']");
    private By orderStatusLoc=By.xpath("//button[text()='Статус заказа']");
    private By enterOrderNumberLoc=By.xpath("//input[@placeholder='Введите номер заказа']");
    private By clickGoBtnLoc=By.xpath("//button[contains(text(),='Go!')]");
    private By notFoundImgIsDisplayedLoc=By.xpath("//img[@alt='Not found']");
private By clickCreateOrderBtnLoc=By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']"); //кнопка Заказать верхнего блока
private final String questionLoc="accordion__heading-%s";
private final String answerLoc="//div[contains(@id,'accordion__panel')][.='%s']";



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStatusBtn() {

        WebElement orderStatusButton = webDriver.findElement(orderStatusLoc); // *** нашли кнопку Статус заказа//выбор локатора, в первую очередь id, by name, link  текст,
        orderStatusButton.click();
    } // нажали на кнопку

    public void enterOrderNumber(String orderNumber) {
        WebElement orderInput = webDriver.findElement(enterOrderNumberLoc); //поле ввода номера заказа
        orderInput.sendKeys(orderNumber); // ввели несуществующий номер заказа
    }

    public void clickGoBtn() {
        WebElement goButton = webDriver.findElement(clickGoBtnLoc); // нашли кнопку гоу
        new WebDriverWait(webDriver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(goButton));

        goButton.click(); //нажали на кнопку гоу
    }
    public boolean notFoundImgIsDisplayed() {
     return webDriver.findElement(notFoundImgIsDisplayedLoc).isDisplayed();
        // проверили отображается ли картинка
    }

    public void clickCreateOrder(){ // метод на верхнюю кнопку
    WebElement createOrderBtn=webDriver.findElement(clickCreateOrderBtnLoc);
            createOrderBtn.click();
    }
public void cookieCloseWind(){
        WebElement cookieCloseButton = webDriver
        .findElement(cookiesBtnLoc); // *** нашли кнопку Статус заказа//выбор локатора, в первую очередь id, by name, link  текст,
    cookieCloseButton.click();
    }
    public void dropQuestion(int index) {
         WebElement element= webDriver
                .findElement(By.id(String.format(questionLoc, index)));

        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",element);
        new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }
    public boolean answerIsDisplayed(String expectedAnswer) {
       WebElement element= webDriver
                .findElement(By.xpath(String.format(answerLoc, expectedAnswer)));
       return element.isDisplayed();
    }
    }




