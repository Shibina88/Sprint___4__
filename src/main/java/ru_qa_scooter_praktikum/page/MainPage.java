package ru_qa_scooter_praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;
    private By cookiesBtnLoc=By.xpath("//button[text()='да все привыкли']"); // локатор кнопки принятия куки
    private By clickCreateOrderBtnLoc=By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']"); //кнопка Заказать верхнего блока
    private By clickFooterCreateOrderBtnLoc= By.xpath("//div[contains(@class,'Home')]/button[text()='Заказать']"); //кнопка заказать в нижнем блоке
    private final String questionLoc="accordion__heading-%s"; //локатор для вопроса в Выпадающем списке
    private final String answerLoc="//div[contains(@id,'accordion__panel')][.='%s']"; //локатор ответа на вопрос в выпадающем списке

    public MainPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public void clickCreateOrder(){ // метод на верхнюю кнопку
    WebElement createOrderBtn=webDriver.findElement(clickCreateOrderBtnLoc);
            createOrderBtn.click();
    }

    public void clickFooterCreateOrder(){ // метод на верхнюю кнопку
        WebElement clickFooterCreateOrderBtn=webDriver.findElement(clickFooterCreateOrderBtnLoc);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();",clickFooterCreateOrderBtn);
        clickFooterCreateOrderBtn.click();
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




