package ru_qa_scooter_praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
public class RentPage {
    private final WebDriver webDriver;
    private final By dateInputLoc=By.xpath("//input[@placeholder='* Когда привезти самокат']"); // локатор поля даты доставки самоката
    private final By rentPeriodInputLoc=By.xpath("//div[text()='* Срок аренды']"); //локатор поля Срок аренды
    private final String  rentPeriodInputItonLoc="//div[text()='%s']"; //локатор длительности аренды
    private final  By createOrderBtnLoc=By.xpath("//div[contains(@class,'Buttons')]/button[text()='Заказать']"); //локатор кнопки заказать

    private final  By arrangeYesBtnLoc=By.xpath("//div[contains(@class,'Buttons')]/button[text()='Да']"); //локатор на кнопку Да в окне Хотите оформить заказ?
    private final By viewOrderStatusBtnLoc=By.xpath("//div[contains(@class,'Order_NextButton')]/button[text()='Посмотреть статус']"); //локатор кнопки Посмотреть статус в окне Заказ оформлен

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
        public void createOrder(){ //нажали на Заказать
        WebElement createOrderBtn=webDriver.findElement(createOrderBtnLoc);
        createOrderBtn.click();

        }
        public void arrangeYes(){ //нажали Да в окне Хотите оформить заказ

        WebElement  arrangeYesBtn=webDriver.findElement(arrangeYesBtnLoc);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(arrangeYesBtn));

        arrangeYesBtn.click();

        }
        public void viewOrderStatus(){ //нажали на Посмотреть статус в окне Заказ оформлен

        WebElement  viewOrderStatusBtn=webDriver.findElement(viewOrderStatusBtnLoc);
        new WebDriverWait(webDriver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(viewOrderStatusBtn));

        viewOrderStatusBtn.click();

        }
    }


