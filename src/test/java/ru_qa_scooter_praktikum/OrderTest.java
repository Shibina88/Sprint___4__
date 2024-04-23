package ru.qa.scooter.praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooter.praktikum.page.MainPage;
import ru.qa.scooter.praktikum.page.OrderPage;
import ru.qa.scooter.praktikum.page.RentPage;

import static org.junit.Assert.assertTrue;

public class OrderTest {
private WebDriver webDriver;
       @Before
    public void setup (){
      webDriver=new ChromeDriver();
     webDriver.get("https://qa-scooter.praktikum-services.ru/");

    }

     @Test // проверка несуществующего заказа
    public void orderNotFound(){
      MainPage mainPage=new MainPage(webDriver);
      mainPage.cookieCloseWind();// приняли куки, закрыли сообщение о куки
      mainPage.clickOrderStatusBtn();
      mainPage.enterOrderNumber("122322585225");
      mainPage.clickGoBtn();
      assertTrue(mainPage.notFoundImgIsDisplayed());
     // закрывает текущую вкладку, а quit - все вкладки и сам драйвер
    }
        @Test // кнопка Заказать в верхнем блоке
       public void createOrder() {
            MainPage mainPage = new MainPage(webDriver); //
            mainPage.cookieCloseWind();// приняли куки, закрыли сообщение о куки
            mainPage.clickCreateOrder();//нажали на кнопку заказать

            OrderPage orderPage = new OrderPage(webDriver);
            orderPage.fillCustomerInfo("Имя", "Фамилия", "Адрес", "Арбатская", "+79663225623");
            orderPage.clickNextBtn();

            RentPage rentPage = new RentPage(webDriver);
            rentPage.fillRentInfo("25.05.2025", "сутки");
            rentPage.createOrderBtn();
        }


    @After
    public void tearDown(){

           webDriver.quit();
    }
}

