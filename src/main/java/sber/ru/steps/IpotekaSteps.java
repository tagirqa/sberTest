package sber.ru.steps;


import io.qameta.allure.Step;

import static org.junit.Assert.assertEquals;
import sber.ru.pages.IpotekaPage;
import sber.ru.utils.AllureUtils;

public class IpotekaSteps {

    @Step("Заполяем поля значениями")
    public IpotekaSteps inputFields() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage.scrollToElement(ipotekaPage.iframeIpoteka);
        ipotekaPage.waitClickable(ipotekaPage.iframeIpoteka);
        BaseSteps.getDriver().switchTo().frame(ipotekaPage.iframeIpoteka);


        return this;
    }

    @Step("Заполняем поле 'Стоимость недвижимости'")
    public IpotekaSteps fieldCost() {
        IpotekaPage ipotekaPage = new IpotekaPage();

        ipotekaPage
                .waitFieldAndInput(ipotekaPage.estateCost, "5 180 000")
                .waitRefreshing(ipotekaPage.realEstateCost, "4 403 000 ₽");
        return this;
    }

    @Step("Заполняем поле 'Первоначальный взнос'")
    public IpotekaSteps fieldFirstMoney() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage
                .waitFieldAndInput(ipotekaPage.initialFee, "3 058 000")
                .waitRefreshing(ipotekaPage.realEstateCost, "2 122 000 ₽");

        return this;
    }

    @Step("Заполняем поле 'Срок кредита'")
    public IpotekaSteps fieldAgePushMoney() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage
                .waitFieldAndInput(ipotekaPage.creditTerm, "30")
                .waitRefreshing(ipotekaPage.realMonthlyPayment, "16 317 ₽")
                .scrollToElement(ipotekaPage.creditTerm);
        return this;
    }


    @Step("Убираем галочку 'Есть зарплатная Карта'")
    public IpotekaSteps checkboxPaidToCard() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage.clickElement(ipotekaPage.paidToCard);
        return this;
    }

    @Step("Ждем появления пункта 'Есть возможность подтвердить доход справкой и жмем'")
    public IpotekaSteps waitCheckBoxCanConfirmIncome() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage.clickElement(ipotekaPage.canConfirmIncome);
        return this;
    }

    @Step("Выставляем галочку 'Молодая Семья'")
    public IpotekaSteps checkboxYoungFamilyDiscount() {
        IpotekaPage ipotekaPage = new IpotekaPage();
        ipotekaPage.clickElement(ipotekaPage.youngFamilyDiscount);

        ipotekaPage.waitRefreshing(ipotekaPage.rate, "8,9 %");
        ipotekaPage.waitRefreshing(ipotekaPage.realMonthlyPayment, "16 922 ₽");
        return this;
    }

    @Step("Проверка суммы кредита = {value}")
    public IpotekaSteps checkTextSumCredit(String value){
        IpotekaPage ipotekaPage = new IpotekaPage();

        assertEquals("Суммы не равны!", ipotekaPage.realEstateCost.getText(), value);

        return this;
    }

    @Step("Проверка ежемесячного платежа = {value}")
    public IpotekaSteps checkTextFirstMoney(String value){

        IpotekaPage ipotekaPage = new IpotekaPage();

        assertEquals("Суммы не равны!", ipotekaPage.realMonthlyPayment.getText(), value);
        return this;
    }

    @Step("Проверка необходимого дохода = {value}")
    public IpotekaSteps checkTextInCome(String value){
        IpotekaPage ipotekaPage = new IpotekaPage();

        assertEquals("Суммы не равны!", ipotekaPage.requiredIncome.getText(), value);
        return this;
    }

    @Step("Проверка нпроцентной ставки = {value}")
    public IpotekaSteps checkTextRate(String value){
        IpotekaPage ipotekaPage = new IpotekaPage();
        AllureUtils.takeScreenshot();

        assertEquals("ставки не равны!", ipotekaPage.rate.getText(), value);
        return this;
    }



}
