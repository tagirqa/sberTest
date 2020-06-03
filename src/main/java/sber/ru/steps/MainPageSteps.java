package sber.ru.steps;

import io.qameta.allure.Step;
import sber.ru.pages.MainPage;

public class MainPageSteps {

    @Step("в верхнем меню выбрать пункт Ипотека")
    public MainPageSteps selectMenu(){
        MainPage mainPage = new MainPage();
        mainPage.moveElement(mainPage.menuBarIpoteka);
        return this;
    }

    @Step("выбрать 'Ипотека на готовое жилье'")
    public void selectIpoteka(){
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.ipotekaForReadyHouse);
    }
}
