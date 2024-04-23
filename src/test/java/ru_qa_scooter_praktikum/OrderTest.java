package ru_qa_scooter_praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru_qa_scooter_praktikum.page.MainPage;
import ru_qa_scooter_praktikum.page.OrderPage;
import ru_qa_scooter_praktikum.page.RentPage;



public class OrderTest {
private WebDriver webDriver;
       @Before
    public void setup (){
      webDriver=new ChromeDriver();
     webDriver.get("https://qa-scooter.praktikum-services.ru/");

    }

          @Test // кнопка Заказать в верхнем блоке
       public void createOrderHead() {
            MainPage mainPage = new MainPage(webDriver); //
            mainPage.cookieCloseWind();// приняли куки, закрыли сообщение о куки
            mainPage.clickCreateOrder();//нажали на кнопку заказать

            OrderPage orderPage = new OrderPage(webDriver);
            orderPage.fillCustomerInfo("Имя", "Фамилия", "Адрес", "Арбатская", "+79663225623"); // Заполнили форму Для кого самокат
            orderPage.clickNextBtn(); //кнопка перехода на форму Про аренду

            RentPage rentPage = new RentPage(webDriver);
            rentPage.fillRentInfo("25.05.2025", "сутки"); //заполнили форму Про Аренду
            rentPage.createOrder(); //нажали Создать заказ (кнопка Заказать)
            rentPage.arrangeYes(); //в окне Хотите оформить заказ нажали Да
            rentPage.viewOrderStatus(); // к оне Заказ оформлен нажали Посмотреть статус

       }
    @Test // кнопка Заказать в нижнем блоке
    public void createOrderFooter() {
        MainPage mainPage = new MainPage(webDriver); //
        mainPage.cookieCloseWind();// приняли куки, закрыли сообщение о куки

        mainPage.clickFooterCreateOrder();//нажали на кнопку заказать в нижнем блоке

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo("Имя", "Фамилия", "Адрес", "Арбатская", "+79663225623"); // Заполнили форму Для кого самокат
        orderPage.clickNextBtn(); //кнопка перехода на форму Про аренду

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentInfo("25.05.2025", "сутки"); //заполнили форму Про Аренду
        rentPage.createOrder(); //нажали Создать заказ (кнопка Заказать)
        rentPage.arrangeYes(); //в окне Хотите оформить заказ нажали Да
        rentPage.viewOrderStatus(); // в окне Заказ оформлен нажали Посмотреть статус

    }

    @After
    public void tearDown(){

           webDriver.quit();
    }
}

